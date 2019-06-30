<template>
  <div class="edit">
    <script id="editor" type="text/plain"></script>
  </div>
</template>
 
<script>
  import '../../static/ueditor.config'
  import '../../static/ueditor.all'
  import '../../static/lang/zh-cn/zh-cn'
  export default {
    name: 'UEditor',
    data () {
      return {
        editor: null
      }
    },
    props: {
      defaultMsg: {
        type: String
      },
      config: {
        type: Object
      }
    },
    mounted() {
      const _this = this;
      this.editor = UE.getEditor('editor', this.config); // 初始化UE
    },
    methods: {
      getUEContent() { // 获取内容方法
        return this.editor.getContent()
      }
    },
    destroyed() {
      this.editor.destroy();
    }
  }
</script>
 
<style lang="scss" scoped="" type="text/css">
  .edit{
    width: 1200px;
    margin: auto;
  }
</style>