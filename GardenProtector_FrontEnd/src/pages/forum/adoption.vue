<template>
    <div id="adoption">
        <el-card class="box-card">
            <div class="text item">
                <el-form ref="form" :rules="rules" :model="form" label-width="80px">
                    <el-form-item label="用户名" prop="username" style="width:300px;">
                        <el-input v-model="form.username" ></el-input>
                    </el-form-item>
                    <el-form-item label="地址" prop="city" style="width:300px;">
                        <el-input v-model="form.city"></el-input>
                    </el-form-item>
                    <el-form-item label="类型" prop="types" style="width:300px;">
                        <el-input v-model="form.types"></el-input>
                    </el-form-item>
                    <el-form-item label="详情" prop="detail" style="width:800px;">
                        <el-input type="textarea" v-model="form.detail"></el-input>
                    </el-form-item>
                    <el-form-item label="注意事项" prop="note" style="width:800px;">
                        <el-input type="textarea" v-model="form.note"></el-input>
                    </el-form-item>
                    <el-form-item style="width:270px;">
                        <el-button type="success" @click="onSubmit">立即申请</el-button>
                        <el-button @click="resetForm('form')">重置</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </el-card>
    </div>
</template>

<script>
import qs from 'qs'
import axios from 'axios'
import {setCookie,getCookie} from '../../assets/js/cookie'
import { required, between, sameAs } from 'vuelidate/lib/validators'
    export default{
        data(){
            return{
                form:{
                    username:'',
                    city:'',
                    types:'',
                    detail:'',
                    note:'',
                    //验证登陆
                    name:'',
                },
                //验证
                rules: {
                    username: [
                        { required: true, message: '请寄养方用户名', trigger: 'blur' },
                    ],
                    city:[
                        {required:true,message:'请输入详细地址',trigger:'blur'}
                    ],
                    types:[
                        {required:true,message:'请输入植被类型',trigger:'blur'}
                    ],
                    detail:[
                        {required:true,message:'请输入详细信息',trigger:'blur'}
                    ]
                },
            }
        },
        mounted(){
            getCookie(this.form.username)
            this.name=getCookie(this.form.username)
            // if(this.name==undefined){
            //     this.$notify({
            //         title:'警告',
            //         message:'请注意登陆！',
            //         type:'warning'
            //     })
            // }
        },
        methods:{
        onSubmit:function(form){
            let self=this
            // 注意表名一致
            self.$refs.form.validate((valid) => {
                if (valid) {
                    let data=qs.stringify({
                        "city":self.form.city,
                        "types":self.form.types,
                        "detail":self.form.detail,
                        "note":self.form.note
                    })
                    axios({
                        method:'post',
                        url:'http://47.103.10.220:8001/adoption/addAdoption',
                        data:data,
                    }).then(function(response){
                        console.log(1)
                        console.log("寄养申请"+response)
                        self.$notify({
                            title: '成功',
                            message: '恭喜您申请成功！',
                            type: 'success'
                        });
                    }).catch(function(error){
                        console.log(error)
                    })
                }else{
                    this.$notify({
                        title: '失败',
                        message: '请注意完善信息！',
                        type: 'error'
                    });
                }
            })
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },
    }
    }
</script>

<style scoped>
  .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card {
    width: 100%;
    margin: 0 auto;
  }
</style>