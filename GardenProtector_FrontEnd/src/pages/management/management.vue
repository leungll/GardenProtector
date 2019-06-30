<template>
    <div>
        <!-- header -->
        <el-header id="header">
            <div id="header_inner">
                <div id="header_inner_text">
                    <a href="http://localhost:8080/#/index">
                        <h1>护草使者</h1>
                        <span>GARDEN PROTECTOR.com</span>
                    </a>
                </div>
            </div>
        </el-header>

        <!-- 侧边栏(导航) -->
        <div id="aside">
            <!-- <el-aside id="el_aside"> -->
                <el-row>
                    <el-col :span="24">
                        <el-menu default-active="1" active-text-color="#879b6f">
                            <el-menu-item index="1" @click="peoShow = true; 
                                                            postShow = false; 
                                                            fosterShow = false">
                                <i class="el-icon-user"></i>
                                <span slot="title">人员管理</span>
                            </el-menu-item>
                            <el-menu-item index="2" @click="peoShow = false; 
                                                            postShow = true; 
                                                            fosterShow = false">
                                <i class="el-icon-tickets"></i>
                                <span slot="title">帖子管理</span>
                            </el-menu-item>
                            <el-menu-item index="3" @click="peoShow = false; 
                                                            postShow = false; 
                                                            fosterShow = true">
                                <i class="el-icon-school"></i>
                                <span slot="title">寄养管理</span>
                            </el-menu-item>
                        </el-menu>
                    </el-col>
                </el-row>
            <!-- </el-aside> -->
        </div>

        <!-- List -->
        <el-main id="List">
            <!-- 人员 -->
            <el-card v-show="peoShow">
                <el-table v-loading="peoLoading" :data="tableData1.slice((currentPage1-1)*pagesize,currentPage1*pagesize)" style="width: 100%" id="peoTable">
                    <el-table-column align="center" prop="id" label="序号"></el-table-column>
                    <el-table-column align="center" prop="username" label="用户名"></el-table-column>
                    <el-table-column align="center" label="操作">
                        <template slot-scope="scope">
                            <el-button type="danger" 
                                    icon="el-icon-delete" 
                                    title="删除" 
                                    circle 
                                    plain
                                    @click="deleteUser(scope.$index, scope.row)"></el-button>
                        </template>
                        <!-- <el-button type="danger" icon="el-icon-delete"  circle plain></el-button> -->
                        <!-- <el-button type="danger" icon="el-icon-delete" title="删除" @click="dele" plain>删除</el-button> -->
                    </el-table-column>
                </el-table>
                <div class="pagination">
                    <el-pagination background layout="prev, pager, next" :total="total1" @current-change="current_change1" class="paginate"></el-pagination>
                </div>
            </el-card>
            <!-- 帖子 -->
            <el-card v-show="postShow">
                <el-table v-loading="postLoading" :data="tableData2.slice((currentPage2-1)*pagesize,currentPage2*pagesize)" style="width: 100%" id="peoTable">
                    <el-table-column align="center" prop="id" label="序号"></el-table-column>
                    <el-table-column align="center" prop="title" label="标题"></el-table-column>
                    <el-table-column align="center" prop="author" label="作者"></el-table-column>
                    <el-table-column align="center" label="操作">
                        <template slot-scope="scope">
                            <el-button type="danger" 
                                    icon="el-icon-delete" 
                                    title="删除" 
                                    circle 
                                    plain
                                    @click="deletePoster(scope.$index, scope.row)"></el-button>
                        </template>
                        <!-- <el-button type="danger" icon="el-icon-delete" title="删除" @click="dele" plain>删除</el-button> -->
                    </el-table-column>
                </el-table>
                <div class="pagination">
                    <el-pagination background layout="prev, pager, next" :total="total2" @current-change="current_change2" class="paginate"></el-pagination>
                </div>
            </el-card>
            <!-- 寄养 -->
            <el-card v-show="fosterShow">
                <el-table v-loading="fosterLoading" :data="tableData3.slice((currentPage3-1)*pagesize,currentPage3*pagesize)" style="width: 100%" id="peoTable">
                    <el-table-column align="center" prop="id" label="寄养号"></el-table-column>
                    <el-table-column align="center" prop="user_id" label="用户ID"></el-table-column>
                    <el-table-column align="center" prop="city" label="城市"></el-table-column>
                    <el-table-column align="center" prop="types" label="植物类型"></el-table-column>
                    <el-table-column align="center" prop="status" label="状态"></el-table-column>
                    <el-table-column align="center" prop="operation" label="操作">
                        <template slot-scope="scope">
                            <el-button type="success" 
                                    icon="el-icon-edit" 
                                    title="切换状态" 
                                    circle 
                                    plain
                                    @click="changeStatus(scope.$index, scope.row)"></el-button>
                        </template>
                        <!-- <el-button type="danger" icon="el-icon-delete" title="删除" @click="dele" plain>删除</el-button> -->
                    </el-table-column>
                </el-table>
                <div class="pagination">
                    <el-pagination background layout="prev, pager, next" :total="total3" @current-change="current_change3" class="paginate"></el-pagination>
                </div>
            </el-card>
        </el-main>
    </div>
</template>

<script>
export default {
    data() {
        return {
            //一页表中的数据记录条数
            pagesize: 10,
            //人员管理
            tableData1: [],
            peoLoading: false,
            //分页
            currentPage1: 1,
            total1: 0,

            //帖子管理
            tableData2: [],
            postLoading: false,
            //分页
            currentPage2: 1,
            total2: 0,

            //寄养管理
            tableData3: [],
            fosterLoading: false,
            //分页
            currentPage3: 1,
            total3: 0,

            //各个el-card的显示
            peoShow: true,
            postShow: false,
            fosterShow: false,
        }
    },
    methods: {
        //分页
        current_change1(currentPage) {
            this.currentPage1 = currentPage;
        },
        current_change2(currentPage) {
            this.currentPage2 = currentPage;
        },
        current_change3(currentPage) {
            this.currentPage3 = currentPage;
        },
        //修改状态
        changeStatus(index, row) {
            console.log(row);
            this.$ajax({
                method: "post",
                url: "http://47.103.10.220:8001/adoption/updateAdoptionStatus",
                data: {
                    idStr: row.id,
                },
                dataType: "json",
                crossDomain: true,
                cache: false,
                transformRequest(obj){
                    var str = [];
                    for(var p in obj){
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    }
                    return str.join("&");
                },
            }).then(resolve => {
                this.$ajax({
                    method: "post",
                    url: "http://47.103.10.220:8001/adoption/listAllAdoption",
                    dataType: "json",
                    crossDomain: true,
                    cache: false,
                }).then(resolve => {
                    this.tableData3 = resolve.data;
                    //获取数组长度赋值给total
                    this.total3 = resolve.data.length;
                    // this.peoLoading = false;
                    console.log(this.total3);
                    console.log(resolve.data);
                }, reject => {
                    // this.peoLoading = true;
                    console.log(reject);
                })
            }, reject => {
                // this.peoLoading = true;
                console.log(reject);
            });
        },
        //删除人员
        deleteUser(index, row) {
            this.$ajax({
                method: "post",
                url: "http://47.103.10.220:8001/user/deleteUser",
                data: {
                    userIdStr: row.id,
                },
                dataType: "json",
                crossDomain: true,
                cache: false,
                transformRequest(obj){
                    var str = [];
                    for(var p in obj){
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    }
                    return str.join("&");
                },
            }).then(resolve => {
                this.$ajax({
                    method: "post",
                    url: "http://47.103.10.220:8001/user/listAllUser",
                    dataType: "json",
                    crossDomain: true,
                    cache: false,
                }).then(resolve => {
                    this.tableData1 = resolve.data;
                    //获取数组长度赋值给total
                    this.total1 = resolve.data.length;
                    // this.peoLoading = false;
                    console.log(this.total1);
                    console.log(resolve.data);
                }, reject => {
                    // this.peoLoading = true;
                    console.log(reject);
                })
            }, reject => {
                // this.peoLoading = true;
                console.log(reject);
            });
        },
        //删除帖子
        deletePoster(index, row) {
            this.$ajax({
                method: "post",
                url: "http://47.103.10.220:8001/article/delArticle",
                data: {
                    articleIdStr: row.id,
                },
                dataType: "json",
                crossDomain: true,
                cache: false,
                transformRequest(obj){
                    var str = [];
                    for(var p in obj){
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    }
                    return str.join("&");
                },
            }).then(resolve => {
                this.$ajax({
                    method: "post",
                    url: "http://47.103.10.220:8001/article/listAllArticle",
                    dataType: "json",
                    crossDomain: true,
                    cache: false,
                }).then(resolve => {
                    this.tableData2 = resolve.data;
                    //获取数组长度赋值给total
                    this.total2 = resolve.data.length;
                    // this.peoLoading = false;
                    console.log(this.total2);
                    console.log(resolve.data);
                }, reject => {
                    // this.peoLoading = true;
                    console.log(reject);
                });
            })
        }
    },
    created() {
        //人员管理
        this.$ajax({
            method: "post",
            url: "http://47.103.10.220:8001/user/listAllUser",
            dataType: "json",
            crossDomain: true,
            cache: false,
        }).then(resolve => {
            this.tableData1 = resolve.data;
            //获取数组长度赋值给total
            this.total1 = resolve.data.length;
            // this.peoLoading = false;
            console.log(this.total1);
            console.log(resolve.data);
        }, reject => {
            // this.peoLoading = true;
            console.log(reject);
        });
        //帖子管理
        this.$ajax({
            method: "post",
            url: "http://47.103.10.220:8001/article/listAllArticle",
            dataType: "json",
            crossDomain: true,
            cache: false,
        }).then(resolve => {
            this.tableData2 = resolve.data;
            //获取数组长度赋值给total
            this.total2 = resolve.data.length;
            // this.peoLoading = false;
            console.log(this.total2);
            console.log(resolve.data);
        }, reject => {
            // this.peoLoading = true;
            console.log(reject);
        });
        //寄养管理
        this.$ajax({
            method: "post",
            url: "http://47.103.10.220:8001/adoption/listAllAdoption",
            dataType: "json",
            crossDomain: true,
            cache: false,
        }).then(resolve => {
            this.tableData3 = resolve.data;
            //获取数组长度赋值给total
            this.total3 = resolve.data.length;
            // this.peoLoading = false;
            console.log(this.tota3);
            console.log(resolve.data);
        }, reject => {
            // this.peoLoading = true;
            console.log(reject);
        })
    }
}
</script>
<style scoped>
    /* header */
    #header {
        /* border: 1px solid #879b6f; */
        padding: 0;
    }
    #header_inner {
        text-align: center;
        background-color: #879b6f;
        padding: 0.6%;
    }
    #header_inner_text h1 {
        font-size: 24px;
        color: white;
    }
    #header_inner_text span {
        font-size: 15px;
    }
    #header_inner_text {
        width: 18%;
        line-height: 75%;
        /* border: 1px solid red; */
    }
    #header_inner_text a {
        color: white;
        text-decoration: none;
    }

    /* 侧边栏 */
    #aside {
        width: 13%;
        /* border: 1px solid; */
        margin-top: 3%;
    }

    /* 各个List */
    #List {
        width: 87%;
        position: absolute;
        right: 0;
        top: 13%;
    }

    /* 分页 */
    .pagination {
        text-align: center;
    }
    /* 背景颜色 */
    /* .el-pagination .el-pager li {
        background-color: #879b6f;
    } */
</style>
