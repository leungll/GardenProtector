<template>
    <div id="writeBlogs">
        <!-- 头部 -->
        <el-header height="110px;">
          <Header/>
        </el-header>
        <!-- <div id="header">
          <div id="header_inner_text">
            <a href="http://localhost:8080/#/index">
              <h1>护草使者</h1>
              <span>GARDEN PROTECTOR.com</span>
            </a>
          </div>
            <router-link to="" id="photo">
                <el-image
                style="width: 40px; height: 40px;margin:0 10px;"
                ></el-image>
            </router-link >
        </div> -->
        <!-- 写博客 -->
        <el-card class="box-card">
            <div class="text item">
                <el-row style="width:80%;margin-left:130px">
                  <el-col :span="22">
                    <el-input placeholder="请输入文章标题" @input="limit" v-model="title"></el-input>
                  </el-col>
                  <el-col :span="2">
                    <p style="margin-top:10px">{{this.title.length}}/100</p>
                  </el-col>
                </el-row>
                <!-- 富文本编辑器 -->
                <div class="components-container">
                    <!-- <div class="info">
                        UE编辑器示例<br>
                        需要使用编辑器时，调用UE公共组件即可。
                        可设置填充内容defaultMsg，配置信息config(宽度和高度等)，
                        可调用组件中获取内容的方法。
                    </div> -->
                    <!-- <button @click="getUEContent()">获取内容</button> -->
                    <div class="editor-container">
                        <mh-ue :defaultMsg=defaultMsg :config=config ref="ue"></mh-ue>
                    </div>
                </div>
                <div class="msg-container">
                  <el-row>
                    <el-col :span="13">
                      <el-select v-model="types" placeholder="请选择文章类型">
                          <el-option
                          v-for="item in options"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                          </el-option>
                      </el-select>
                    </el-col>
                    <el-col :span="11">
                      <el-button type="success" plain id="upload" @click="submit">发布</el-button>
                    </el-col>
                  </el-row>
                </div>
            </div>
        </el-card>
    </div>
</template>

<script>
import mhUe from '../../components/ueditor'
import axios from 'axios'
import qs from 'qs'
import Header from '@/components/header'
  export default {
    components: {
      mhUe,
      Header,
    },
    data() {
      return {
        defaultMsg: '这里是UE测试',
        config: {
          initialFrameWidth: null,
          initialFrameHeight: 350
        },

        //文章类型
        types:'',
        //下拉框选型
        options: [{
          value: '花卉',
          label: '花卉'
        }, {
          value: '草木',
          label: '草木'
        }, {
          value: '医治',
          label: '医治'
        }, {
          value: '园林',
          label: '园林'
        }, {
          value: '盆景',
          label: '盆景'
        }],
        //文章标题
        title:'',

      }
    },
    methods: {
      getUEContent() {
        let content = this.$refs.ue.getUEContent();
        // this.$notify({
        //   title: '获取成功，可在控制台查看！',
        //   message: content,
        //   type: 'success'
        // });
        console.log(content)
      },
    //限制标题长度
    limit:function(){
        if (this.title.length>100) {
            this.title=this.title.substring(0,100)
            this.$notify.error({
            title: '错误',
            message: '标题最多100字！',
            type: 'warning'
            })
        }
    },
    submit:function(){
        let self=this
        let content = self.$refs.ue.getUEContent();
        //添加博客信息到后台
        let data=qs.stringify({
            "titleStr":self.title,
            "contentStr":content,
            "typesStr":self.types,
        })
        axios({
            method:'post',
            url:'http://47.103.10.220:8001/article/addArticle',
            data:data
        }).then(function(response){
          //注意this指向改变
            self.$notify({
              title: '发布成功！',
              message: '你已成功发布一篇文章',
              type: 'success'
            });
            console.log(response.data)
        }).catch(function(error){
            console.log(error)
        })


      },
    }
  };
</script>
 
<style lang="scss" scoped="" type="text/css">
    .info{
        border-radius: 10px;
        line-height: 20px;
        padding: 10px;
        margin: 10px;
        background-color: #ffffff;
    }
    h1{
        text-align: left;
        margin-left: 100px;
    }
    #upload{
        position: absolute;
        top:5px;
        right:100px;
    }
    #photo{
        position: absolute;
        top:5px;
        right: 180px;
    }
    #writeBlogs{
        width: 100%;
    }
    // #header{
    //     margin: 0 auto;
    //     position: relative;
    // }
    #editor{
        margin: auto;
    }
    /* header */
    // #header {
    //     text-align: center;
    //     background-color: #879b6f;
    //     padding: 0.6%;
    // }
    // #header_inner_text h1 {
    //     font-size: 24px;
    //     color: white;
    // }
    // #header_inner_text span {
    //     font-size: 15px;
    // }
    // #header_inner_text {
    //     width: 18%;
    //     line-height: 75%;
    //     /* border: 1px solid red; */
    // }
    // #header_inner_text a {
    //     color: white;
    //     text-decoration: none;
    // }
  // 信息发布容器
  .msg-container{
    width: 30%;
    margin-left: 130px;
    margin-top: 30px;
  }
</style>