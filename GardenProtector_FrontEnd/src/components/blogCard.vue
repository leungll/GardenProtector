<template>
    <div id="blogCard">
        <!-- 帖子区 -->
        <el-card class="box-card">
            <!-- 帖子详情 -->
            <div class="text item" :blogData="blogData">
                <h1>{{blogData.title}}</h1>
                <span>{{blogData.createtime}}</span>
                <span>{{blogData.author}}</span>
                <!-- <span>阅读数:123{{blogData.readNo}}</span> -->
                <div v-html="blogData.content">
                    <!-- {{blogData.content}} -->
                </div>
            </div>
        </el-card>
    </div>
</template>

<script>
import axios from 'axios'
import qs from 'qs'
import eventBus from '../eventBus'
    export default{
        data(){
            return{
                blogData:{},
            }
        },
        mounted(){
            //博客信息
            // eventBus.$on('ariticledetails',(ariticledetails)=>{
                // localStorage解决刷新问题
                // 序列化
                // const d=JSON.stringify(ariticledetails[0])
                // localStorage.setItem("ariticleData",d)
                // const strd=localStorage.getItem("ariticleData")
                // 逆序列化
                // var objd=JSON.parse(strd)

                // self.blogData=objd
                // console.log("文章标题"+objd.title)
                // localStorage.removeItem("ariticleData")
            // })

            let self=this
            eventBus.$on('ariticledetails',(ariticledetails)=>{
                self.blogData=ariticledetails[0]
            })

            // const d=JSON.stringify(self.blogData)
            // localStorage.setItem("ariticleData",d)
            
            //本地存储的方法
            // var strd=localStorage.getItem("ariticleData")
            // var objd=JSON.parse(strd)
            // self.blogData=objd[0]
        },

    }
</script>