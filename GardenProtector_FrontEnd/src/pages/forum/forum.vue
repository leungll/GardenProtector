<template>
    <div id="layout">
        <el-container>
            <!--侧边栏容器-->
            <el-aside width="150px">
                <Navigation/>
            </el-aside>
            <el-container>
                <!--上边栏容器-->
                <el-header height="110px">
                    <Header/>
                </el-header>
                <!--内容栏容器-->
                <el-main>
                    <router-view></router-view>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import Navigation from '@/components/navigation';
import Header from '@/components/header';

export default{
     name:'Layout',
     components:{
         Navigation,
         Header
     }
 }

</script>

<style scoped>
</style>