<template>
    <div id="layoutForDetails">
        <el-container>
            <!--上边栏容器-->
            <el-header height="110px">
                <Header/>
            </el-header>
            <el-container>
                <!--侧边栏容器-->
                <el-aside width="250px">
                    <usrCard/>
                </el-aside>
                <!--内容栏容器-->
                <el-main>
                    <blogCard/>
                    <commentCard/>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import usrCard from '@/components/usrCard';
import Header from '@/components/header';
import blogCard from '@/components/blogCard';
import commentCard from '@/components/commentCard';

export default{
     name:'Layout',
     components:{
         Header,
         usrCard,
         blogCard,
         commentCard
     }
 }

</script>

<style scoped>
    
</style>