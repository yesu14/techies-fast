<template>
  <el-dialog
    width="100%"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-row type="flex" class="row-bg">
        <el-col :span="12">
          <el-form-item label="订单号" prop="orderNo">
            <el-input v-model="dataForm.orderNo" placeholder="订单号"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="选择产品" prop="productName">
            <el-input v-model="dataForm.productName" placeholder="选择产品"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="输入行" prop="count">
            <el-input v-model="dataForm.count" placeholder="输入行"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-button type="primary" @click="addUser" >添加</el-button>
        </el-col>
      </el-row>


      <el-row type="flex" class="row-bg">
        <el-col :span="12">
          <el-form-item label="图片" prop="picture">
            <el-upload
              class="avatar-uploader"
              :action="url"
              :show-file-list="false">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
        </el-col>
         <el-col :span="12">
          <el-form-item label="品名" prop="productName">
            <el-input v-model="dataForm.productName" placeholder="品名"></el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="货号" prop="productCode">
            <el-input v-model="dataForm.productCode" placeholder="货号"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="中国链接" prop="chineseLink">
            <el-input v-model="dataForm.chineseLink" placeholder="中国链接"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="韩国链接" prop="koreanLink">
            <el-input v-model="dataForm.koreanLink" placeholder="韩国链接"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价格" prop="price">
            <el-input v-model="dataForm.price" placeholder="价格"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="颜色中文名称" prop="colorChinese">
            <el-input v-model="dataForm.colorChinese" placeholder="颜色中文名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="颜色中文名称" prop="colorChinese">
            <el-input v-model="dataForm.colorChinese" placeholder="颜色中文名称"></el-input>
          </el-form-item>
        </el-col>
         <el-col :span="12">
           <el-form-item label="颜色韩文名称" prop="colorKorean">
             <el-input v-model="dataForm.colorKorean" placeholder="颜色韩文名称"></el-input>
           </el-form-item>
        </el-col>
         <el-col :span="12">
           <el-form-item label="大小" prop="size">
             <el-input v-model="dataForm.size" placeholder="大小"></el-input>
           </el-form-item>
        </el-col>
         <el-col :span="12">
           <el-form-item label="数量" prop="qty">
             <el-input v-model="dataForm.qty" placeholder="数量"></el-input>
           </el-form-item>
        </el-col>
         <el-col :span="12">
           <el-form-item label="运费" prop="fare">
             <el-input v-model="dataForm.fare" placeholder="运费"></el-input>
           </el-form-item>
        </el-col>
         <el-col :span="12">
           <el-form-item label="现况" prop="status">
             <el-input v-model="dataForm.status" placeholder="现况"></el-input>
           </el-form-item>
        </el-col>
         <el-col :span="12">
           <el-form-item label="备注" prop="remark">
             <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
           </el-form-item>
        </el-col>
      </el-row>

<!--  动态表单 start      -->
      <div class="moreRules">
        <div class="moreRulesIn" v-for="(item,index) in dataForm.moreProduct" :key="item.key">
          <el-row type="flex" class="row-bg">
            <el-col :span="12">
              <el-form-item label="图片" prop="picture">
                <el-upload
                  class="avatar-uploader"
                  :action="url"
                  :show-file-list="false">
                  <img v-if="imageUrl" :src="imageUrl" class="avatar">
                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="品名" prop="productName" :rules="moreProductRules.moreProductName">
                <el-input v-model="dataForm.productName" placeholder="品名"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="货号" prop="'moreProduct.'+index+'productCode'" :rules="moreProductRules.moreProductCode">
                <el-input v-model="item.productCode" placeholder="货号"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="中国链接" prop="chineseLink">
                <el-input v-model="dataForm.chineseLink" placeholder="中国链接"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="韩国链接" prop="koreanLink">
                <el-input v-model="dataForm.koreanLink" placeholder="韩国链接"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="价格" prop="price">
                <el-input v-model="dataForm.price" placeholder="价格"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="颜色中文名称" prop="colorChinese">
                <el-input v-model="dataForm.colorChinese" placeholder="颜色中文名称"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="颜色中文名称" prop="colorChinese">
                <el-input v-model="dataForm.colorChinese" placeholder="颜色中文名称"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="颜色韩文名称" prop="colorKorean">
                <el-input v-model="dataForm.colorKorean" placeholder="颜色韩文名称"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="大小" prop="size">
                <el-input v-model="dataForm.size" placeholder="大小"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="数量" prop="qty">
                <el-input v-model="dataForm.qty" placeholder="数量"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="运费" prop="fare">
                <el-input v-model="dataForm.fare" placeholder="运费"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="现况" prop="status">
                <el-input v-model="dataForm.status" placeholder="现况"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="备注" prop="remark">
                <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
              </el-form-item>
            </el-col>
            <el-button @click="deleteRules(item, index)">删除</el-button>
          </el-row>
        </div>
      </div>
<!--  动态表单 end      -->

    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">保存</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          orderNo: '',
          orderCreate: '',
          productName: '',
          productCode: '',
          count: '',
          moreProduct: [{
            productName: '',
            productCode: ''
          }]
        },
        dataRule: {
          orderNo: [
            { required: true, message: '订单号不能为空', trigger: 'blur' }
          ],
          orderCreate: [
            { required: true, message: '下单日期不能为空', trigger: 'blur' }
          ],
          productName: [
            { required: true, message: '品名不能为空', trigger: 'blur' }
          ],
          productCode: [
            { required: true, message: '货号不能为空', trigger: 'blur' }
          ]
        },
        moreProductRules: {
          moreProductName: [{required: true, message: '品名不能为空', trigger: 'blur'}],
          moreProductCode: [{required: true, message: '货号不能为空', trigger: 'blur'}]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.moreProduct = []
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/trade/order/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderNo = data.order.orderNo
                this.dataForm.orderCreate = data.order.orderCreate
                this.dataForm.productName = data.order.productName
                this.dataForm.productCode = data.order.productCode
              }
            })
          }
        })
      },
      addUser () {
        this.dataForm.moreProduct.push({
          productName: '',
          productCode: ''
        })
      },
      deleteRules (item, index) {
        this.index = this.dataForm.moreProduct.indexOf(item)
        if (index !== -1) {
          this.dataForm.moreProduct.splice(index, 1)
        }
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/trade/order/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderNo': this.dataForm.orderNo,
                'orderCreate': this.dataForm.orderCreate,
                'productName': this.dataForm.productName,
                'productCode': this.dataForm.productCode
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
