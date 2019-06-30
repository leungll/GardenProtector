<template>
    <div id="commentCard">
        <!-- 评论区 -->
        <el-card class="box-card">
            <div class="text item">
                <!-- 写评论 -->
                <div class="comment-edit-box">
                    <h3>发表评论</h3>
                    <b v-if="type">你回复&nbsp;{{name}}</b>
                    <el-input
                    type="textarea"
                    :rows="2"
                    placeholder="请输入评论"
                    v-model="commentText">
                    </el-input>
                    <el-button type="success" plain @click="addComment">发布</el-button> 
                    <el-button type="info" plain @click="cancleComment">取消</el-button> 
                </div>
                <div>
                    <h3>评论</h3>
                    <p v-if="comment.length==0">暂无评论，我来发表第一篇评论！</p>
                    <div v-else>
                        <div class="comment" v-for="(item,index) in comment" :key="index" >
                            <p>{{item.author}}<span>{{item.createtime}}</span></p>
                            <b @click="changeCommenter(item,index)">{{item.content}}</b>
                            <span class="seeReply" @click="getReply(item,index)">查看回复</span>
                            <span v-show="delcom[index]" @click="deleteComment(item,index)">删除评论</span>
                            <div>
                                <div v-show="flag[index]" class="reply" v-for="(it,i) in reply[index]" :key="i">
                                    <span>{{it.author}}&nbsp;&nbsp;回复&nbsp;&nbsp;{{item.author}}<span>时间：{{it.createtime}}</span></span>
                                    <!-- <p @click="changeCommenter(it.author,index)">{{it.content}}</p> -->
                                    <p>{{it.content}}</p>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </el-card>
    </div>
</template>

<script>
import eventBus from '../eventBus'
import axios from 'axios'
import qs from 'qs'
import {setCookie,getCookie} from '../../src/assets/js/cookie'
    export default{
        data(){
            return{
                //原有的评论
                comment:[],
                //被选中的评论的index
                chosedIndex: -1,
                //textarea里的
                commentText:"",
                //用户回复的评论作者
                name:"",
                //回复类型
                type:"",
                //回复
                reply:[],
                //是否显示回复
                flag:[],
                //文章id
                ariticleid:"",
                //每条评论的回复数量
                replyNo:[],
                //cookie里的用户名
                username:'',
                //删除评论
                delcom:[],
            }
        },
        mounted(){
            let self=this
            eventBus.$on('comment',(comment)=>{
                // console.log(comment)
                self.comment=comment
            })
            //设置flag数组
            let commentNum=self.comment.length
            for (let index = 0; index < commentNum; index++) {
                self.flag[index] = false  
            }
            //是否显示 删除 （一级评论）
            for (let index = 0; index < commentNum; index++) {
                self.delcom[index] = false
                // if (self.comment[index].author==self.username) {
                //     self.delcom[index]=true
                // }
            }
            console.log(self.delcom)
            //获取文章id（必须在mounted里）
            eventBus.$on('ariticleid',(ariticleid)=>{
                self.ariticleid=ariticleid
            })
            //本地存储的方法
            // const strc=localStorage.getItem("comments")
            // const objc=JSON.parse(strc)
            // self.comment=objc

            //获取cookie里用户名
            self.username=getCookie('username')
            
            
        },
        methods:{
            //得到每一条评论的回复
            getReply:function(item,index){
                let self=this
                this.flag[index]=true
                // console.log(self.flag)
                let data=qs.stringify({
                    "replyCommentIdStr":item.id,
                })
                axios({
                    method:'post',
                    url:'http://47.103.10.220:8001/reply/listAllReply',
                    data:data
                }).then(function(response){
                    // console.log(response.data)
                    // self.reply[index]=response.data
                    // 动态改变数组值
                    self.$set(self.reply,index,response.data)
                }).catch(function(error){
                    console.log(error)
                })
            },
            //评论区 评论
            changeCommenter: function(item,index) {
                this.name=item.author
			    this.chosedIndex = index;
			    this.type = 1;
            },
            //写评论 添加评论
            addComment:function(index){
                let self=this
                    if(self.type == 0) {
                        let data=qs.stringify({
                            "articleIdStr":self.ariticleid,
                            "authorStr":getCookie('username'),
                            "contentStr":self.commentText
                        })
                        axios({
                            method:'post',
                            url:'http://47.103.10.220:8001/comment/addComment',
                            data:data
                        }).then(function(response){
                            self.comment=response.data
                        }).catch(function(error){
                            console.log(error)
                        })
                        //服务器端变
                    }else if(self.type == 1){
                        // this.comment[this.chosedIndex].reply.push({
                        //     responder: 'session',
                        //     reviewers:this.comment[this.chosedIndex].name,
                        //     time: getTime(),
                        //     content: data
                        // });
                        
                        let data=qs.stringify({
                            // "authorStr":self.comment[self.chosedIndex].author,
                            // "replyCommentIdStr":self.comment[self.chosedIndex].id,
                            "replyCommentIdStr":self.comment[this.chosedIndex].id,
                            "contentStr":self.commentText
                        })
                        axios({
                            method:'post',
                            url:'http://47.103.10.220:8001/reply/addReply',
                            data:data
                        }).then(function(response){
                            self.reply.splice(index,1)
                            self.$set(self.reply,index,response.data)
                            console.log("该评论的回复"+self.reply[index])
                        }).catch(function(error){
                            console.log(error)
                        })
                        this.type = 0;
                    }
			    self.commentText = "";
            },
            //写评论 取消评论
            cancleComment:function(){
			this.commentText = "";
            },
            // 删除评论
            deleteComment:function(item,index){
                
            },
            //格式化时间
             getTime:function() {
                var now = new Date();
                var year = now.getFullYear();
                var month = now.getMonth()+1;
                var day = now.getDate();
                month.length < 2 ?  "0" + month : month;
                day.length < 2 ?  "0" + day : day;
                return year+"-"+month+"-"+day;
            }
        }
    }
</script>

<style scoped>
    .box-card{
        text-align: left;
    }
    .comment{
        width: 100%;
        border-bottom: 1px solid #879b6f;
        padding-bottom: 5px;
    }
    .reply{
        margin-left: 20px;
        padding-left: 5px;
        width: 100%;
        /* height: 30px; */
        border-left: 2px solid #879b6f;
    }
    .seeReply{
        font-size:14px;
        color: #879b6f;
    }
    .seeReply:hover{
        color: red;
        cursor: pointer;
    }
</style>
