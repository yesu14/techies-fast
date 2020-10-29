<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="品名" prop="productName">
      <el-input v-model="dataForm.productName" placeholder="品名"></el-input>
    </el-form-item>
    <el-form-item label="货号" prop="productCode">
      <el-input v-model="dataForm.productCode" placeholder="货号"></el-input>
    </el-form-item>
    <el-form-item label="韩国链接" prop="koreanLink">
      <el-input v-model="dataForm.koreanLink" placeholder="韩国链接"></el-input>
    </el-form-item>
    <el-form-item label="中国链接" prop="chineseLink">
      <el-input v-model="dataForm.chineseLink" placeholder="中国链接"></el-input>
    </el-form-item>
    <el-form-item label="价格" prop="price">
      <el-input v-model="dataForm.price" placeholder="价格"></el-input>
    </el-form-item>
    <el-form-item label="图片" prop="picture">
      <el-upload
        class="avatar-uploader"
        :action="imgPath"
        :show-file-list="false"
        :on-success="successHandle"
        :before-upload="beforeUploadHandle">
        <img v-if="imageUrl" :src="imageUrl" class="avatar" >
        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-upload>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        imgPath: '',
        imageUrl: '',
        visible: false,
        dataForm: {
          id: 0,
          productName: '',
          productCode: '',
          koreanLink: '',
          chineseLink: '',
          price: '',
          picture: ''
        },
        dataRule: {
          productName: [
            { required: true, message: '品名不能为空', trigger: 'blur' }
          ],
          productCode: [
            { required: true, message: '货号不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.imgPath = this.$http.adornUrl(`/sys/oss/upload?token=${this.$cookie.get('token')}`)
        this.imageUrl = ''
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/trade/product/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.productName = data.product.productName
                this.dataForm.productCode = data.product.productCode
                this.dataForm.koreanLink = data.product.koreanLink
                this.dataForm.chineseLink = data.product.chineseLink
                this.dataForm.price = data.product.price
                this.dataForm.picture = data.product.picture
                let imgUrl = this.$http.adornUrl('/static/upload/product/')
                let token = this.$cookie.get('token')
                this.imageUrl = imgUrl + data.product.picture + '?token=' + token
              }
            })
          }
        })
      },
      // 上传之前
      beforeUploadHandle (file) {
        if (file.type !== 'image/jpg' && file.type !== 'image/jpeg' && file.type !== 'image/png' && file.type !== 'image/gif') {
          this.$message.error('只支持jpg、png、gif格式的图片！')
          return false
        }
        this.num++
      },
      // 上传成功
      successHandle (response, file) {
        if (response || response.code === 0) {
          this.imageUrl = URL.createObjectURL(file.raw)
          this.dataForm.picture = response.fileName
        } else {
          this.$message.error(response.msg)
        }
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/trade/product/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'productName': this.dataForm.productName,
                'productCode': this.dataForm.productCode,
                'koreanLink': this.dataForm.koreanLink,
                'chineseLink': this.dataForm.chineseLink,
                'price': this.dataForm.price,
                'picture': this.dataForm.picture
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
