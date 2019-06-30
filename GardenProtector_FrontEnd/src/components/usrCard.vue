<template>
    <div id="usrCard">
        <el-card class="box-card">
            <!-- <div slot="header" class="clearfix" :data="usrData">
                <img src="">
                <span>作者</span>
                <el-button type="success" icon="el-icon-star-off" round plain>关注</el-button>
            </div>
            <div class="text item">
                <span>原创</span>
                <span>粉丝</span>
                <span>喜欢</span>
                <span>评论</span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </div> -->
            <h2 style="color:white;">广告招商位</h2>
            <hr>
            <p style="color:white;">期待您的加入</p>
        </el-card>
    </div>
</template>

<script>
    export default{
      data(){
        return{
          usrData:[],
        }
      }
    }
</script>

<style scoped>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 230px;
    margin-top: 20px;
    background-color: #879b6f;
  }
</style>