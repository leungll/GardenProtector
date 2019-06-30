<template>
    <div id="header">
        <el-card class="box-card">
            <div class="text item">
                <!-- 导航 -->
                <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" active-text-color="#879b6f" @select="handleSelect">
                    <router-link to="forumHome" class="el-menu-item">
                        <el-menu-item index="1">论坛</el-menu-item>
                    </router-link>
                    <router-link to="index" class="el-menu-item">
                        <el-menu-item index="2">首页</el-menu-item>
                    </router-link>
                    <router-link to="adoption" class="el-menu-item">
                        <el-menu-item index="3" >我要寄养</el-menu-item>
                    </router-link>
                </el-menu>
                <!-- 头像：是否登陆 -->
                <div class="logined" v-if="login">
                    <el-row>
                        <el-col :span="8" class="pos">
                            <!-- 写帖子 -->
                            <router-link to="writeBlogs">
                               <i class="el-icon-edit"></i><span>编辑博客</span>
                            </router-link>
                        </el-col>
                        <el-col :span="8" class="pos">
                            <!-- 退出登录 -->
                            <div class="signout">
                                <router-link to="forumHome">
                                    <span @click="signout">退出登录</span>
                                </router-link>
                            </div>
                        </el-col>
                        <el-col :span="8">
                            <!-- 头像 -->
                            <router-link to="/personHome">
                                <el-image
                                style="width: 60px; height: 60px;"
                                :src="url"></el-image>
                                <!-- <p @click="jump">跳转</p> -->
                            </router-link>
                        </el-col>
                    </el-row>
                </div>
                <div class="tologin" v-else>
                    <router-link to="login">
                        <el-button type="success">登陆</el-button>
                    </router-link>
                </div>
            </div>
        </el-card>

    </div>
</template>

<script>
import eventBus from '../eventBus'
import { getCookie } from '../assets/js/cookie';
import axios from 'axios'
import qs from 'qs'
    export default{
        data() {
            return {
                activeIndex: '1',
                url:require('../assets/2.jpg'),
                // url:'',
                //是否登陆
                login:false,
                //用户名
                username:'',
            };
        },//data结束

        mounted() {
            let self=this
            // eventBus.$on('url',(url)=>{
            //     self.url=url
            //     console.log("啊啊"+self.url)
            // })

            self.username=getCookie('username')
            console.log(self.username)
            if (self.username="") {
                self.login=false
            }else{
                self.login=true
            }

        },//mounted结束

        methods: {
            //判断是否为管理员
            // jump:function(){
            //     let self=this
            //     console.log(self.username)
            //     if (self.username=='admin') {
            //         self.$router.replace({
            //             path:'/admin',
            //             name:'admin',
            //         })
            //     }else{
            //         self.$router.replace({
            //             path:'/personHome',
            //             name:'personHome',
            //         })
            //     }
            // },

            //导航栏index
            handleSelect(key, keyPath) {
            console.log(key, keyPath);
            },

            //退出登录
            signout:function(){
                let self=this
                axios({
                    method:'get',
                    url:'http://47.103.10.220:8001/user/exit',
                }).then(function(response){
                    console.log("退出登录")
                    self.login=false
                })
            }

        },//methods结束
    }
</script>

<style scoped>
    a{
        text-decoration: none;
        color: #879b6f;
    }
    a:hover{
        color:red;
    }
  .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card {
    width:100%;
    height: 100px;
  }
  .el-menu-demo {
      width: 500px;
      float: left;
  }
  .el-menu-item{
      width: 100px;
  }
/* 登陆 */
  .logined{
      height: 100px;
      width: 250px;
      position: relative;
      top: -80px;
      left: 70%;
  }
  .el-button--info{
      margin-top: 10px;
  }
  .el-button--success{
      margin-top: 17px;
  }
  .pos{
      margin-top: 40px;
  }
/* 未登录 */
  .tologin{
    height: 100px;
    width: 100px;
    position: relative;
    left: 80%;
    top: -90px;      
  }
</style>
