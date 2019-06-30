<template>
    <div id="garden">
        <el-card class="box-card">
            <div  class="text item" >
                <!-- 搜索 -->
                <div style="width:340px;height:50px;margin-left:40px;">
                    <el-row>
                        <el-col :span="12">
                            <el-input 
                            v-model="searchTitle" 
                            placeholder="关键字搜索" 
                            style="width:200px;"
                            ></el-input>
                        </el-col>
                        <el-col :span="12">
                            <el-button
                            type="success" 
                            icon="el-icon-search" 
                            @click="search()" 
                            plain>检索</el-button>
                        </el-col>
                    </el-row>
                </div>
                <!-- 园林类型 -->
                <ul :data="gardenData">
                        <router-link to="blogDetails">
                            <li v-for="(item,index) in gardenData" :key="index" @click="getarticleId(index)">
                                <div>
                                    <h4>{{item.title}}</h4>
                                    <p>{{item.abstract}}</p>
                                    <div>
                                        <i class="el-icon-user-solid"></i>
                                        <span>{{item.author}}</span>
                                        <span>{{item.type}}</span>
                                        <i class="el-icon-date"></i>
                                        <span>{{item.createtime}}</span>
                                        <i class="el-icon-view"></i>
                                        <!-- <span prop="viewNo">{{item.viewNo}}</span> -->
                                    </div>
                                </div>
                            </li>
                        </router-link>
                    </ul>
                <!-- 分页 -->
                <el-pagination
                background
                layout="prev, pager, next"
                :page-size="pagesize"
                :total="total"
                @current-change="current_change" 
                >
                </el-pagination>
            </div>
        </el-card>
    </div>
</template>

<script>
import axios from 'axios'
import qs from 'qs'
    export default{
      data(){
        return{
          gardenData:[],
          searchTitle:'',
          //分页
            pagesize: 5,
            currentPage: 1,
            total: 0,
        }
      },
      mounted(){
        //获取 园林 帖子
        let self=this
        let data=qs.stringify({
            "types":"园林"
        })
        axios({
                method: "post",
                url: "http://47.103.10.220:8001/article/listArticleByTypes",
                data:data,
                cache: false,
            }).then(resolve => {
                this.gardenData = resolve.data;
                self.gardenData = resolve.data;
            }, reject => {
                console.log("失败",reject);
            })
      },
      methods:{
            // 搜索
            search:function(){
                let self=this
                let data=self.$qs.stringify({
                    "keyStr":self.searchTitle
                })
                axios({
                    method:'post',
                    url:'http://47.103.10.220:8001/article/queryArticleTitle',
                    data:data,
                }).then(function(response){
                    self.gardenData = response.data;
                }).catch(function(error){
                    console.log(error);
                })

            },
      }
    }
</script>

<style scoped>
    .flower{
        text-align: left;
    }
    ul{
        list-style: none;
        text-align: left;
    }
    li{
        border: 1px solid grey;
        border-radius: 10px;
        padding-left: 20px;
        padding-bottom: 10px;
        margin-bottom:10px;
    }
    a{
        color: black;
        text-decoration: none;
    }
    
</style>