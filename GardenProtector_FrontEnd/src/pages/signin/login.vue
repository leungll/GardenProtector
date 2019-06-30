<template>
    <div id="login">
        <el-card class="box-card" id="container">
            <div class="text item">
                <!-- header -->
                <el-header id="header">
                    <div id="header_inner">
                        <div id="header_inner_text">
                            <a href="http://localhost:8080/#/index">
                                <h1>护草使者</h1>
                                <span>GARDEN PROTECTOR.com</span>
                            </a>
                        </div>
                    </div>
                </el-header>

                <!-- 轮播 -->
                <div class="block" style="width:500px">
                    <el-carousel :interval="4000" type="card" height="250px">
                    <el-carousel-item v-for="item in urls" :key="item.url">
                        <img :src="item.url" style="height:250px;weight:250px">
                    </el-carousel-item>
                    </el-carousel>
                </div>

                <el-card class="box-card" id="signin">
                    <div class="text item">

                        <!-- 登陆 -->
                        <div class="login-wrap" v-show="showLogin">
                            <h3>登录</h3>
                            <!-- <p v-show="showTishi">{{tishi}}</p> -->
                            <el-input prefix-icon="el-icon-user-solid" placeholder="请输入用户名" v-model="username"></el-input>
                            <el-input prefix-icon="el-icon-lock" type="password" placeholder="请输入密码" v-model="password"></el-input>
                            <button v-on:click="login">登录</button>
                            <span  v-on:click="ToRegister">没有账号？马上注册</span>
                        </div>

                        <!-- 注册 -->
                        <div class="register-wrap" v-show="showRegister">
                            <h3>注册</h3>
                            <!-- <p v-show="showTishi">{{tishi}}</p> -->
                            <el-input prefix-icon="el-icon-user-solid" type="text" placeholder="请输入用户名" v-model="newUsername"></el-input>
                            <el-input prefix-icon="el-icon-lock" type="password" placeholder="请输入密码" v-model="newPassword"></el-input>
                            <button v-on:click="register">注册</button>
                            <span v-on:click="ToLogin">已有账号？马上登录</span>
                        </div>

                    </div>
                </el-card>
                <div class="footer">
                    <p>你可以放心的来一次说走就走的旅行|你想要的养花宝典全在这里</p>
                    <span>©2019 护草使者 版权所有</span>
                </div>
            </div>
        </el-card>
    </div>
</template>


<script>
import eventBus from '../../eventBus'
import qs from 'qs'
import axios from 'axios'
import {setCookie,getCookie} from '../../assets/js/cookie'
export default{
        data(){
            return{
                urls:[
                    {url:require('../../assets/玫瑰花.jpg')},
                    {url:require('../../assets/黄花.jpg')},
                    {url:require('../../assets/粉花.jpg')},
                    {url:require('../../assets/雏菊2.jpg')},
                ],
                showLogin: true,
                showRegister: false,
                showTishi: false,
                tishi: '',
                username: '',
                password: '',
                newUsername: '',
                newPassword: ''
            }
        },//data end
        mounted(){
            /*页面挂载获取cookie，如果存在username的cookie，则跳转到主页，不需登录*/
            // if(getCookie('username')){
            //     this.$router.push('/home')
            // }
        },
        methods:{
            login(){
                if(this.username == "" || this.password == ""){
                    alert("请输入用户名或密码")
                }else{
                    let data = this.$qs.stringify({
                        'username':this.username,
                        'password':this.password
                        })
                    /*接口请求*/
                    axios.post('http://47.103.10.220:8001/user/login',data).then((res)=>{
                        console.log(res)
                    /*接口的传值是(-1,该用户不存在),(0,密码错误)，同时还会检测管理员账号的值*/
                    // if(res.data == -1){
                    //     this.tishi = "该用户不存在"
                    //     this.showTishi = true
                    // }else if(res.data == 0){
                    //     this.tishi = "密码输入错误"
                    //     this.showTishi = true
                    // }
                    // else if(res.data == 'admin'){
                    // /*路由跳转this.$router.push*/
                    //     this.$router.push('/main')
                    // }
                    // else{
                    //     this.tishi = "登录成功"
                    //     this.showTishi = true
                    //     setCookie('username',this.username,1000*60)
                    //     setTimeout(function(){
                    //         this.$router.push('/')
                    //     }.bind(this),1000)
                    // }
                    eventBus.$emit('url',res.data);
                    if(res.status ==200){
                        this.tishi = "登录成功"
                        this.showTishi = true
                        setCookie('username',this.username,1000*60)
                        setTimeout(function(){
                            if(this.username=='admin'){
                                this.$router.push('/admin')
                            }else{
                                this.$router.push('/forumHome')
                            }
                        }.bind(this),1000)
                    }else{
                        this.tishi = "登陆失败"
                        this.showTishi = true
                    }
                    //cookie
                    // setCookie(username,this.username,100000)
                })
            }
            },
            //切换
            ToRegister(){
                this.showRegister = true
                this.showLogin = false
            },
            ToLogin(){
                this.showRegister = false
                this.showLogin = true
            },
            //注册
            register(){
                if(this.newUsername == "" || this.newPassword == ""){
                    alert("请输入用户名或密码")
                }else{
                    let data = this.$qs.stringify({
                        'username':this.newUsername,
                        'password':this.newPassword
                        })
                    axios.post('http://47.103.10.220:8001/user/register',data).then((res)=>{
                        console.log(res)
                        console.log(data)
                        if(res.status == 200){
                            this.tishi = "注册成功"
                            this.showTishi = true
                            this.username = ''
                            this.password = ''
                            /*注册成功之后再跳回登录页*/
                            setTimeout(function(){
                                this.showRegister = false
                                this.showLogin = true
                                this.showTishi = false
                            }.bind(this),1000)
                        }
                    })
                }
            },

        },
    }
</script>

<style scoped>
    /* header */
    #header {
        width: 100%;
    }
    #header_inner {
        text-align: center;
        background-color: #879b6f;
        padding: 0.6%;
    }
    #header_inner_text h1 {
        font-size: 24px;
        color: white;
    }
    #header_inner_text span {
        font-size: 15px;
    }
    #header_inner_text {
        width: 18%;
        line-height: 75%;
        /* border: 1px solid red; */
    }
    #header_inner_text a {
        color: white;
        text-decoration: none;
    }
    button{
        display:block; 
        width:220px; 
        height:40px; 
        line-height: 40px; 
        margin:0 auto; 
        border:1px solid #879b6f; 
        border-radius: 10px;
        background-color:#879b6f; 
        color:#fff; 
        font-size:16px; 
        margin-bottom:5px;
        }
    span{cursor:pointer;}
    p:hover{color:#879b6f;}
    /* 解决高度无法100% */
    #login{
        height: 100%;
    }
    #container{
        height: 100%;
    }
    #signin{
        width: 400px;
        height: 300px;
        position: relative;
        left: 60%;
        margin-top: 70px;
        /* margin: 20px; */
    }
    /* 轮播 */
    .block{
        position: absolute;
        margin-top: 70px;
        margin-left: 100px;
    }
    .el-input{
        width: 220px;
        margin-bottom:10px; 
    }
    .el-input__inner{
        transition: border-color 0.2s cubic-bezier(0.65, 0.05, 0.36, 1);
    }
    .el-input__inner:click{
        border-color:#879b6f;
    }
    .login-wrap>span{
        position: relative;
        top: 40px;
    }
    .register-wrap>span{
        position: relative;
        top: 40px;
    }
    .footer{
        position: absolute;
        bottom: 5%;
        left: 35%;
        width: 30%;
    }
</style>