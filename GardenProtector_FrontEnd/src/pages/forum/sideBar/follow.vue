<template>
    <div id="follow">
        <el-card class="box-card">
            <div  class="text item" :blogData="followData">
                <h1>{{followData.title}}</h1>
                <span>{{followData.createtime}}</span>
                <span>{{followData.author}}</span>
                <!-- <span>阅读数:123{{followData.readNo}}</span> -->
                <div>
                    {{followData.content}}
                </div>
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
          followData:[],
        }
      },
      mounted(){
        //获取 关注 帖子
        let self=this
        let data=self.$qs.stringify({
                    "type":"follow"
                });
        axios({
                method: "post",
                url: "http://localhost:8080/article/listAllArticle",
                data:data,
                //保证每次请求得到的数据都是最新的而不是缓存的数据
                cache: false,
            }).then(resolve => {
                this.followData = resolve.data;
                console.log(resolve.data);
            }, reject => {
                console.log("失败",reject);
            })
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
    width: 480px;
  }
</style>