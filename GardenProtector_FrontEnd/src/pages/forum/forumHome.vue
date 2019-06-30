<template>
    <div class="forunHome">
        <el-card class="box-card">
            <div class="text item">
                <!-- 轮播 -->
                <div class="block">
                    <el-carousel :interval="4000" type="card" height="400px">
                    <el-carousel-item v-for="item in urls" :key="item.url">
                        <img :src="item.url">
                    </el-carousel-item>
                    </el-carousel>
                </div>
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
                <!-- 帖子 -->
                <div id="blogs">
                    <ul :data="forumData.slice((currentPage-1)*pagesize,currentPage*pagesize)">
                            <li v-for="(item,index) in forumData.slice((currentPage-1)*pagesize,currentPage*pagesize)" :key="index" @click="getarticleId(index)">
                                <div>
                                    <router-link to="blogDetails">
                                        <h4>{{item.title}}</h4>
                                        <p>{{item.abstract}}</p>
                                    </router-link>
                                    <div>
                                        <i class="el-icon-user-solid"></i>
                                        <span>{{item.author}}</span>
                                        <span>{{item.type}}</span>
                                        <i class="el-icon-date"></i>
                                        <span>{{item.createtime}}</span>
                                        <!-- <i class="el-icon-view"></i> -->
                                        <!-- <span prop="viewNo">{{item.viewNo}}</span> -->
                                        <i class="el-icon-star-on" @click="like(index)"></i>
                                        <span>{{item.liked}}</span>
                                    </div>
                                </div>
                            </li>
                    </ul>
                </div>
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
import eventBus from '../../eventBus'
    export default{
        data(){
            return{
                urls:[
                    {url:require('../../assets/向日葵.jpg')},
                    {url:require('../../assets/康乃馨.jpg')},
                    {url:require('../../assets/黄花.jpg')},
                    {url:require('../../assets/雏菊.jpg')},
                ],
                viewNo:'',
                forumData:[],
                // 搜索
                searchTitle:'',
                //点赞
                // flag:[],
                //分页
                pagesize: 5,
                currentPage: 1,
                total: 0,
            }
        },
        methods:{
            //分页
            current_change(currentPage){
                this.currentPage = currentPage;
            },
            // 帖子列表
            getarticleId:function(index){
                let self=this
                let postData = self.$qs.stringify({
                    // bug:只有id为5时可以_原因是数据库字段不完整
                    "articleIdStr":self.forumData[index].id,
                });
                axios({
                        method:'post',
                        url:'http://47.103.10.220:8001/article/getArticleAndComment',
                        // url:'http://localhost:8001/article/getArticleAndComment',
                        data:postData
                })
                .then(function (response) {
                    // 注意this指向
                    // 发送的是数组
                    
                    eventBus.$emit('ariticledetails',response.data[0]);

                    const temp=response.data[0]
                    const ariticle_id=temp[0].id
                    // console.log("文章id"+ariticle_id)
                    eventBus.$emit('ariticleid',ariticle_id);
                    // const d=JSON.stringify(response.data[0])
                    // localStorage.setItem("ariticleData",d)
                    eventBus.$emit('comment',response.data[1]);
                    // const c=JSON.stringify(response.data[1])
                    // localStorage.setItem("comments",c)
                    // console.log(response.data[1])
                })
                .catch(function (error) {
                    console.log(error);
                });
            },

            // 搜索
            search:function(){
                let self=this
                let data=self.$qs.stringify({
                    "keyStr":self.searchTitle
                })
                axios({
                    method:'post',
                    url:'http://47.103.10.220:8001/article/queryArticleTitle',
                    // url:'http://localhost:8001/article/queryArticleTitle',
                    data:data,
                }).then(function(response){
                    self.forumData = response.data;
                }).catch(function(error){
                    console.log(error);
                })

            },

            // 点赞
            like:function(index){
                let self=this
                    let data=qs.stringify({
                        "articleIdStr":self.forumData[index].id,
                        "articleLikedStr":self.forumData[index].liked,
                    })
                    axios({
                        method:'post',
                        url:'http://47.103.10.220:8001/article/getArticleLike',
                        data:data
                    }).then(function(response){
                        self.$set(self.forumData,index,response.data[0])
                        console.log(response.data[0])
                    }).catch(function(error){
                        console.log(error)
                    })
                
            }//liked end

        },//methods end

        created(){
            // 获取帖子列表
            axios({
                method: "get",
                url: "http://47.103.10.220:8001/article/listAllArticle",
                // url:'http://localhost:8001/article/listAllArticle',
                cache: false,
            }).then(resolve => {
                this.forumData = resolve.data;
                this.total=resolve.data.length
                // console.log("文章title"+resolve.data[1].id);
            }, reject => {
                console.log("失败",reject);
            })
        },

    }
</script>

<style scoped>
    .blogs{
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
