<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-col type="flex" class="row-bg">
        <el-col :span="12">
          <el-form-item label="订单号" prop="orderNo">
            <el-input v-model="dataForm.orderNo" placeholder="订单号"></el-input>
          </el-form-item>
        </el-col>
      </el-col>
      <el-col type="flex" class="row-bg">
        <el-col :span="12">
          <el-form-item label="下单日期" prop="orderCreate">
            <el-input v-model="dataForm.orderCreate" placeholder="下单日期"></el-input>
          </el-form-item>
        </el-col>
      </el-col>


    <el-form-item label="产品名称" prop="productName">
      <el-input v-model="dataForm.productName" placeholder="产品名称"></el-input>
    </el-form-item>
      <el-form-item label="货号" prop="productCode">
        <el-input v-model="dataForm.productCode" placeholder="货号"></el-input>
      </el-form-item>
    <el-form-item label="中国链接" prop="chineseLink">
      <el-input v-model="dataForm.chineseLink" placeholder="中国链接"></el-input>
    </el-form-item>
    <el-form-item label="韩国链接" prop="koreanLink">
      <el-input v-model="dataForm.koreanLink" placeholder="韩国链接"></el-input>
    </el-form-item>
    <el-form-item label="价格" prop="price">
      <el-input v-model="dataForm.price" placeholder="价格"></el-input>
    </el-form-item>
    <el-form-item label="图片" prop="picture">
      <el-input v-model="dataForm.picture" placeholder="图片"></el-input>
    </el-form-item>
    <el-form-item label="颜色中文名称" prop="colorChinese">
      <el-input v-model="dataForm.colorChinese" placeholder="颜色中文名称"></el-input>
    </el-form-item>
    <el-form-item label="颜色韩文名称" prop="colorKorean">
      <el-input v-model="dataForm.colorKorean" placeholder="颜色韩文名称"></el-input>
    </el-form-item>
    <el-form-item label="大小" prop="size">
      <el-input v-model="dataForm.size" placeholder="大小"></el-input>
    </el-form-item>
    <el-form-item label="数量" prop="qty">
      <el-input v-model="dataForm.qty" placeholder="数量"></el-input>
    </el-form-item>
    <el-form-item label="运费" prop="fare">
      <el-input v-model="dataForm.fare" placeholder="运费"></el-input>
    </el-form-item>
    <el-form-item label="现况" prop="status">
      <el-input v-model="dataForm.status" placeholder="现况"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
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
        visible: false,
        dataForm: {
          id: 0,
          orderNo: '',
          orderCreate: '',
          productName: '',
          productCode: '',
          chineseLink: '',
          koreanLink: '',
          price: '',
          picture: '',
          colorChinese: '',
          colorKorean: '',
          size: '',
          qty: '',
          fare: '',
          status: '',
          remark: ''
        },
        dataRule: {
          orderNo: [
            { required: true, message: '订单号不能为空', trigger: 'blur' }
          ],
          orderCreate: [
            { required: true, message: '下单日期不能为空', trigger: 'blur' }
          ],
          productName: [
            { required: true, message: '产品名称不能为空', trigger: 'blur' }
          ],
          productCode: [
            { required: true, message: '货号不能为空', trigger: 'blur' }
          ],
          chineseLink: [
            { required: true, message: '中国链接不能为空', trigger: 'blur' }
          ],
          koreanLink: [
            { required: true, message: '韩国链接不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '价格不能为空', trigger: 'blur' }
          ],
          picture: [
            { required: true, message: '图片不能为空', trigger: 'blur' }
          ],
          colorChinese: [
            { required: true, message: '颜色中文名称不能为空', trigger: 'blur' }
          ],
          colorKorean: [
            { required: true, message: '颜色韩文名称不能为空', trigger: 'blur' }
          ],
          size: [
            { required: true, message: '大小不能为空', trigger: 'blur' }
          ],
          qty: [
            { required: true, message: '数量不能为空', trigger: 'blur' }
          ],
          fare: [
            { required: true, message: '运费不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '现况不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
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
                this.dataForm.chineseLink = data.order.chineseLink
                this.dataForm.koreanLink = data.order.koreanLink
                this.dataForm.price = data.order.price
                this.dataForm.picture = data.order.picture
                this.dataForm.colorChinese = data.order.colorChinese
                this.dataForm.colorKorean = data.order.colorKorean
                this.dataForm.size = data.order.size
                this.dataForm.qty = data.order.qty
                this.dataForm.fare = data.order.fare
                this.dataForm.status = data.order.status
                this.dataForm.remark = data.order.remark
              }
            })
          }
        })
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
                'productCode': this.dataForm.productCode,
                'chineseLink': this.dataForm.chineseLink,
                'koreanLink': this.dataForm.koreanLink,
                'price': this.dataForm.price,
                'picture': this.dataForm.picture,
                'colorChinese': this.dataForm.colorChinese,
                'colorKorean': this.dataForm.colorKorean,
                'size': this.dataForm.size,
                'qty': this.dataForm.qty,
                'fare': this.dataForm.fare,
                'status': this.dataForm.status,
                'remark': this.dataForm.remark
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
