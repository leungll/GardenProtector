<template>
    <div>
        <el-card class="box-card">
            <div class="text item">
                <el-row class="tac">
                    <el-col >
                        <h2 style="color:#879b6f">护草使者</h2>
                        <el-menu
                        default-active="2"
                        class="el-menu-vertical-demo"
                        active-text-color="#879b6f"
                        >
                        <!-- <router-link to="follow">
                            <el-menu-item index="1">
                                <i class="el-icon-grape"></i>
                                <span slot="title">关注</span>
                            </el-menu-item>
                        </router-link> -->
                        <!-- <router-link to="recommand">
                            <el-menu-item index="2">
                                <i class="el-icon-star-off"></i>
                                <span slot="title">推荐</span>
                            </el-menu-item>
                        </router-link> -->
                        <!-- <router-link to="classification">
                            <el-menu-item index="3">
                                <i class="el-icon-lollipop"></i>
                                <span slot="title">专题</span>
                            </el-menu-item>
                        </router-link> -->
                        <router-link to="flower">
                            <el-menu-item index="4">
                                <i class="el-icon-cherry"></i>
                                <span slot="title">花卉</span>
                            </el-menu-item>
                        </router-link>
                        <router-link to="grass">
                            <el-menu-item index="5">
                                <i class="el-icon-apple"></i>
                                <span slot="title">草木</span>
                            </el-menu-item>
                        </router-link>
                        <router-link to="heal">
                            <el-menu-item index="6">
                                <i class="el-icon-first-aid-kit"></i>
                                <span slot="title">医治</span>
                            </el-menu-item>
                        </router-link>
                        <router-link to="garden">
                            <el-menu-item index="7">
                                <i class="el-icon-sunny"></i>
                                <span slot="title">园林</span>
                            </el-menu-item>
                        </router-link>
                        <router-link to="bansai">
                            <el-menu-item index="8">
                                <i class="el-icon-cloudy"></i>
                                <span slot="title">盆景</span>
                            </el-menu-item>
                        </router-link>
                        </el-menu>
                    </el-col>
                </el-row>
            </div>
        </el-card>
    </div>
</template>

<script>
  export default {
    methods: {
      
    }
  }
</script>

<style scoped>
    a{
        text-decoration: none;
    }
    .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }
</style>