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

        <!-- 栅格布局 -->
        <div id="middle">
            <!-- 帖子、问答、寄养   +   个人资料-->
            <el-row :gutter="5">
                <!-- :span 中的值24即为最大 -->
                <el-col :span="16" id="navi">
                    <el-card id="navi_inner">
                        <el-menu :default-active="active" mode="horizontal" id="navi_menu">
                            <el-menu-item index="1" 
                            @click="poster = true; foster = false;">
                                帖子
                            </el-menu-item>
                            <el-menu-item index="2"
                            @click="poster = false; foster = true;">
                                寄养
                            </el-menu-item>
                        </el-menu>
                    </el-card>
                </el-col>
                <el-col :span="8" id="personCard">
                    <el-card id="personCard_inner">
                        <el-row id="personCard_head">
                            <el-col :span="5" id="userhead">
                                <img :src="url" width="70px" height="70px" />
                            </el-col>
                            <el-col :span="4" id="username">
                                <h4>{{ username }}</h4>
                            </el-col>
                            <el-col :span="14" id="change">
                                <a href="javascript:void(0);" @click="changeInfor=true">
                                    <img src="../../assets/changeInfor.png" width="30px" height="30px" />
                                    <h6>修改资料</h6>
                                </a>
                            </el-col>
                        </el-row>
                        <el-row class="introduce">
                            <img src="../../assets/address.png" width="25px" height="25px" />
                            <h6>{{ useraddress }}</h6>
                        </el-row>
                        <el-row class="introduce">
                            <img src="../../assets/job.png" width="25px" height="25px" />
                            <h6>{{ userjob }}</h6>
                        </el-row>
                    </el-card>
                </el-col>
            </el-row>

            <!-- 帖子、问答、寄养 详情 -->
            <!-- 帖子 -->
            <el-card id="navi_detail_post" v-show="poster">
                <el-card shadow="hover" v-for="(item,index1) in post" :key="index1" class="navi_detail_inner" >
                    <h1>{{item.title}}</h1>
                    <div style="text-align:left;
                                margin-bottom: 2%;">{{item.content}}</div>
                    <el-row>
                        <el-col :span="24" class="time">
                            <el-button type="danger" 
                                        icon="el-icon-delete" 
                                        title="删除" 
                                        circle 
                                        plain 
                                        @click="deletPost(index1)">
                            </el-button>
                        </el-col>
                    </el-row>
                    
                </el-card>
            </el-card>
            <!-- 问答 -->
            <!-- <el-card id="navi_detail_question" v-show="question">
                <el-card shadow="hover" v-for="(item,index2) in questionAnswer" :key="index2" class="navi_detail_inner">
                    <h2 style="text-align:left;">Q：{{item.question}}</h2>
                    <pre style="text-align:left;
                                margin-bottom: 2%;"><span>{{item.answerUserName}}：</span><span>{{item.answerContent}}</span></pre>
                    <el-row>
                        <el-col :span="12" class="read">{{item.read}}次阅读</el-col>
                        <el-col :span="12" class="time">{{item.time}}</el-col>
                    </el-row>
                </el-card>
            </el-card> -->
            <!-- 寄养 -->
            <el-card id="navi_detail_foster" v-show="foster">
                <el-card shadow="hover" v-for="(item,index3) in fosterInfor" :key="index3" class="navi_detail_inner">
                    <div slot="header">
                        <span>寄养详情</span>
                    </div>
                    <div style="text-align:left;
                                margin-bottom: 2%;">
                        <pre>寄养号：{{item.id}}</pre>
                        <pre>城市：{{item.city}}</pre>
                        <pre>品种：{{item.types}}</pre>
                        <pre>状态：{{item.status}}</pre>
                        <pre>详情：{{item.detail}}</pre>
                        <pre>寄养日期：{{item.note}}</pre>
                    </div>
                    <!-- <pre>要求：{{item.require}}</pre> -->
                    <el-row>
                        <!-- <el-col :span="12" class="read">{{item.read}}次阅读</el-col> -->
                        <!-- <el-col :span="12" class="time">{{item.time}}</el-col> -->
                        <el-col :span="24" class="time">
                            <a title="修改寄养信息" 
                                href="javascript:void(0);" 
                                @click="changeFosterInfor=true; changeFoster(index3)"
                                style="
                                margin-right: 2%;
                                ">
                                <img src="../../assets/changeInfor.png" width="30px" height="30px" />
                            </a>
                            <el-button type="danger" 
                                        icon="el-icon-delete" 
                                        title="删除" 
                                        circle 
                                        plain 
                                        @click="deletFoster(index3)">
                            </el-button>
                        </el-col>
                    </el-row>
                </el-card>
            </el-card>
        </div>
        
        <!-- 修改资料遮罩层 -->
        <el-dialog title="修改个人资料" v-model="changePersonInfor" :visible.sync="changeInfor" :close-on-click-modal="false">
            <el-form id="changeDetail" :model="changeDetailInfor" ref="changeDetailInfor" label-width="150px">
                <el-row>
                    <el-col :span="9" class="cannotChange">
                        <el-form-item id="id" label="ID：">
                            <!-- <h4>ID：</h4> -->
                            <h4>{{userid}}</h4>
                        </el-form-item>
                    </el-col>
                    <el-col :span="13" id="changeUserHead">
                        <!-- 头像修改->需要改 -->
                        <el-upload
                        action="http://47.103.10.220:8001/user/updateUser"
                        ref="upload"
                        :on-change="beforeUpload"
                        :auto-upload="false">
                            <img 
                            :src="url" 
                            title="修改头像" 
                            style="width: 70px; height: 70px; border-radius: 35px; margin-left: 5%;">
                            <el-button slot="trigger" 
                                        size="small" 
                                        title="修改头像" 
                                        type="success" plain>选取文件</el-button>
                        </el-upload>
                    </el-col>
                </el-row>
                <el-form-item label="昵称：" prop="userName">
                    <el-col :span="8">
                        <el-input v-model="changeDetailInfor.userName"></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="实名：" prop="realName">
                    <el-col :span="8">
                        <el-input v-model="changeDetailInfor.realName"></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="性别：" prop="userSex">
                    <el-col :span="8">
                        <el-select v-model="changeDetailInfor.userSex">
                            <!-- key作为 value 唯一标识的键名，绑定值为对象类型时必填 -->
                            <el-option v-for="item in sex" :key="item.value" :label="item.label" :value="item.value"></el-option>
                        </el-select>
                    </el-col>
                </el-form-item>
                <el-form-item label="生日：" prop="birth">
                    <el-col :span="8">
                        <el-date-picker
                            v-model="changeDetailInfor.birth"
                            type="date"
                            placeholder="选择生日"
                            value-format="yyyy-MM-dd">
                        </el-date-picker>
                    </el-col>
                </el-form-item>
                <el-form-item label="地区：" prop="address">
                    <el-col :span="8">
                        <el-select v-model="choseProvince1" @change="Provincechose1" placeholder="请选择省">
                            <el-option v-for="item in province" :key="item.id" :label="item.value" :value="item.id"></el-option>
                        </el-select>
                    </el-col>
                    <el-col :span="8">
                        <el-select v-model="choseCity" placeholder="请选择市">
                            <el-option v-for="item in city" :key="item.id" :label="item.value" :value="item.id"></el-option>
                        </el-select>
                    </el-col>
                </el-form-item>
                <el-form-item label="职业：" prop="job">
                    <el-col :span="10">
                        <el-input v-model="changeDetailInfor.job"></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="个性签名：" prop="introduce">
                    <el-col :span="20">
                        <el-input 
                            v-model="changeDetailInfor.introduce" 
                            type="textarea" 
                            placeholder="请编辑个性签名"
                            size="medium">
                        </el-input>
                    </el-col>
                </el-form-item>
                <el-form-item id="slotBtn">
                    <el-button type="success" icon="el-icon-check" @click="changeInfor=false; submitChange()">确认修改</el-button>
                    <el-button type="primary" icon="el-icon-refresh-right" @click="reset('changeDetailInfor')">重置</el-button>
                    <el-button type="danger" icon="el-icon-close" @click="changeInfor=false; reset('changeDetailInfor')">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>

        <!-- 修改寄养信息 -->
        <el-dialog title="修改寄养信息" v-model="changeFOSTERInfor" :visible.sync="changeFosterInfor" :close-on-click-modal="false">
            <el-form id="changeFoster" :model="changeFosterDetailInfor" ref="changeFosterDetailInfor" label-width="150px">
                <el-row>
                    <el-col :span="9" class="cannotChange">
                        <el-form-item id="id" label="寄养号：">
                            <h4>{{fosterId}}</h4>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-form-item label="省市：" prop="city">
                    <el-col :span="8">
                        <el-select v-model="choseProvince2" @change="Provincechose2" placeholder="请选择省">
                            <el-option v-for="item in province" :key="item.id" :label="item.value" :value="item.id"></el-option>
                        </el-select>
                    </el-col>
                </el-form-item>
                <el-form-item label="品种：" prop="fosterKind">
                    <el-col :span="8">
                        <el-input v-model="changeFosterDetailInfor.fosterKind"></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="状态：" prop="fosterStatus">
                    <el-col :span="3">
                        <span>{{changeFosterDetailInfor.fosterStatus}}</span>
                    </el-col>
                </el-form-item>
                <el-form-item label="详情：" prop="fosterDetail">
                    <el-col :span="20">
                        <el-input 
                            v-model="changeFosterDetailInfor.fosterDetail" 
                            type="textarea" 
                            placeholder="请编辑寄养详情"
                            size="medium">
                        </el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="寄养日期：" prop="fosterNote">
                    <el-col :span="8">
                        <el-date-picker
                            v-model="changeFosterDetailInfor.fosterNote"
                            type="date"
                            placeholder="选择想被寄养的时间"
                            value-format="yyyy-MM-dd">
                        </el-date-picker>
                    </el-col>
                </el-form-item>
                <el-form-item id="slotBtn">
                    <el-button type="success" icon="el-icon-check" @click="changeFosterInfor=false; submitFosterChange()">确认修改</el-button>
                    <el-button type="primary" icon="el-icon-refresh-right" @click="reset('changeFosterDetailInfor')">重置</el-button>
                    <el-button type="danger" icon="el-icon-close" @click="changeFosterInfor=false; reset('changeFosterDetailInfor')">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
import {setCookie,getCookie} from '../../assets/js/cookie'
export default {
    data() {
        return {
            //用户
            // USER: [],
            userid: '',
            username: '',
            useraddress: '',
            userjob: '',

            //导航激活页
            active: '1',
            //帖子
            post: [],
            //问答
            questionAnswer: [],
            //寄养
            fosterInfor: [],
            //关注  notice:一定要使用require() 才能使得图片被请求到

            //导航详情
            //帖子
            poster: true,
            //问答
            question: false,
            //寄养
            foster: false,
            // 修改个人资料遮罩层
            changePersonInfor: false,
            changeInfor: false,
            //头像
            fileList: [],
            headVisible: true,
            url: '',
            headeImgName: '',
            //资料
            changeDetailInfor: {
                userName: '',
                realName: '',
                userSex: '',
                birth: '',
                address: '',
                job: '',
                introduce: '',
            },

            //省市
            choseProvince1: [],
            choseCity: [],
            province: [],
            city: [],
            changedProvince: '',
            //sex
            sex: [
                {
                    value: '1',
                    label: '男'
                },
                {
                    value: '2',
                    label: '女'
                }
            ],

            //修改寄养信息
            changeFOSTERInfor: false,
            changeFosterInfor: false,
            changeFosterDetailInfor: {
                city: '',
                fosterKind: '',
                fosterStatus: '未完成',
                fosterDetail: '',
                fosterNote: '',
            },
            fosterId: '',
            //省
            choseProvince2: [],
            changedFosterProvince: '',
        }
    },
    methods: {
        //头像上传
        handleRemove(file, fileList) {
            console.log(file, fileList);
        },
        handlePreview(file) {
            console.log(file.name);
        },
        beforeUpload(file, fileList) {
            console.log(file);
            this.headeImgName = file.name;
        },

        //重置
        reset(formdate) {
            this.$refs[formdate].resetFields();
        },

        //省市
        Provincechose1(change) {
            for(let province in this.province){
                if(change === this.province[province].id){
                    //changedProvince用来判断省市是否被修改
                    this.changedProvince = this.province[province].value;
                    // console.log(this.changedProvince);
                    this.city = this.province[province].children;
                    this.choseCity = this.province[province].children[0].value;
                }
            }
        },
        
        //删除帖子
        deletPost(index) {
            this.$ajax({
                method: "post",
                url: "http://47.103.10.220:8001/article/delArticle",
                data: {
                    articleIdStr: this.Post[index].id,
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
                // this.post = resolve.data;
                console.log(resolve);
                this.$ajax({
                    method: "post",
                    url: "http://47.103.10.220:8001/user/listUserArticle",
                    dataType: "json",
                    crossDomain: true,
                    cache: false
                }).then(resolve => {
                    this.post = resolve.data;
                    // console.log(resolve);
                }, reject => {
                    console.log("post failed request!");
                });
            }, reject => {
                console.log("删除帖子");
            });
        },

        //确认修改
        submitChange() {
            // console.log(this.changeDetailInfor.userName);
            // console.log(this.changeDetailInfor.realName);
            // console.log(this.changeDetailInfor.userSex);
            // console.log(this.changeDetailInfor.birth);
            // // console.log(this.choseProvince.value);
            // console.log(this.choseProvince);
            // console.log(this.changedProvince);
            // console.log(this.changeDetailInfor.job);
            // console.log(this.changeDetailInfor.introduce);
            //性别
            let changedsex;
            if(this.changeDetailInfor.userSex == 1) {
                changedsex = "男";
            }
            else if(this.changeDetailInfor.userSex == 2) {
                changedsex = "女";
            }
            else {
                changedsex = this.changeDetailInfor.userSex;
            }
            // console.log(changedsex);
            //省份
            let changingProvince;
            if(this.changedProvince != ''){
                changingProvince = this.changedProvince;
            }
            else {
                changingProvince = this.choseProvince1;
            }
            console.log(this.headeImgName);
            console.log(changingProvince);
            console.log(this.changeDetailInfor.birth);
            this.$ajax({
                method: "post",
                url: "http://47.103.10.220:8001/user/updateUser",
                dataType: "json",
                data: {
                    usernameStr: this.changeDetailInfor.userName,
                    imageStr: this.headeImgName,
                    birth: this.changeDetailInfor.birth,
                    sex: changedsex,
                    locate: changingProvince,
                    job: this.changeDetailInfor.job,
                    introduction: this.changeDetailInfor.introduce,
                },
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
                // this.post = resolve.data.post;
                console.log(resolve.data[0].image);
                this.url = resolve.data[0].image;
                // this.imageUrl = resolve.data[0].image;
                this.$ajax({
                    method: "post",
                    url: "http://47.103.10.220:8001/user/listUserById",
                    dataType: "json",
                    crossDomain: true,
                    cache: false
                }).then(resolve => {
                    //个人信息栏
                    this.userid = resolve.data[0].id;
                    this.username = resolve.data[0].username;
                    this.url = resolve.data[0].image;
                    this.useraddress = resolve.data[0].locate;
                    this.userjob = resolve.data[0].job;
                    console.log(resolve.data[0]);
                    // console.log(this.USER.id);
                    //修改信息栏
                    this.changeDetailInfor.userName = resolve.data[0].username;
                    // this.changePersonInfor.realName = resolve.data[0].
                    this.changeDetailInfor.userSex = resolve.data[0].sex
                    this.changeDetailInfor.birth = resolve.data[0].birth;
                    this.choseProvince = resolve.data[0].locate;
                    this.changeDetailInfor.job = resolve.data[0].job;
                    this.changeDetailInfor.introduce = resolve.data[0].introduction;
                }, reject => {
                    console.log("post failed request!");
                });
            }, reject => {
                console.log("failed request!");
            });
        },
        //寄养信息删除
        deletFoster(index) {
            console.log(index);
            console.log(this.fosterInfor[index].id);
            this.$ajax({
                method: "post",
                url: "http://47.103.10.220:8001/adoption/delAdoption",
                data: {
                    idStr: this.fosterInfor[index].id,
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
                // this.post = resolve.data;
                console.log(resolve);
                this.$ajax({
                    method: "get",
                    url: "http://47.103.10.220:8001/adoption/listAdoption",
                    dataType: "json",
                    crossDomain: true,
                    cache: false
                }).then(resolve => {
                    this.fosterInfor = resolve.data;
                    console.log(resolve.data);
                }, reject => {
                    console.log("foster failed request!");
                });
            }, reject => {
                console.log("删除寄养信息");
            });
        },

        //寄养信息的修改
        changeFoster(index3) {
            console.log(index3);
            console.log(this.fosterInfor[index3]);
            this.fosterId = this.fosterInfor[index3].id;
            this.choseProvince2 = this.fosterInfor[index3].city;
            this.changeFosterDetailInfor.fosterKind = this.fosterInfor[index3].types;
            this.changeFosterDetailInfor.fosterStatus = this.fosterInfor[index3].status;
            this.changeFosterDetailInfor.fosterDetail = this.fosterInfor[index3].detail;
            // this.changeFosterDetailInfor.fosterNote = this.fosterInfor[index3].note;
        },
        //省市修改
        Provincechose2(change) {
            for(let province in this.province){
                if(change === this.province[province].id){
                    //changedProvince用来判断省市是否被修改
                    this.changedFosterProvince = this.province[province].value;
                }
            }
        },
        //提交修改
        submitFosterChange() {
            let changingFosterProvince;
            if(this.changedFosterProvince != ''){
                changingFosterProvince = this.changedFosterProvince;
            }
            else {
                changingFosterProvince = this.choseProvince2;
            }
            console.log(this.fosterId, changingFosterProvince, this.changeFosterDetailInfor.fosterKind, this.changeFosterDetailInfor.fosterDetail, this.changeFosterDetailInfor.fosterNote)
            this.$ajax({
                method: "post",
                url: "http://47.103.10.220:8001/adoption/updateAdoption",
                dataType: "json",
                data: {
                    adoptionIdStr: this.fosterId,
                    city: changingFosterProvince,
                    types: this.changeFosterDetailInfor.fosterKind,
                    detail: this.changeFosterDetailInfor.fosterDetail,
                    note: this.changeFosterDetailInfor.fosterNote,
                },
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
                // this.post = resolve.data.post;
                console.log(resolve);
                this.$ajax({
                    method: "get",
                    url: "http://47.103.10.220:8001/adoption/listAdoption",
                    dataType: "json",
                    crossDomain: true,
                    cache: false
                }).then(resolve => {
                    this.fosterInfor = resolve.data;
                    console.log(resolve.data);
                }, reject => {
                    console.log("foster failed request!");
                });
                }, reject => {
                console.log("failed request!");
            });
        }
    },
    created() {
        //用户信息
        this.$ajax({
            method: "post",
            url: "http://47.103.10.220:8001/user/listUserById",
            dataType: "json",
            crossDomain: true,
            cache: false
        }).then(resolve => {
            //个人信息栏
            this.userid = resolve.data[0].id;
            this.username = resolve.data[0].username;
            this.url = resolve.data[0].image;
            this.useraddress = resolve.data[0].locate;
            this.userjob = resolve.data[0].job;
            console.log(resolve.data[0]);
            // console.log(this.USER.id);
            //修改信息栏
            this.changeDetailInfor.userName = resolve.data[0].username;
            // this.changePersonInfor.realName = resolve.data[0].
            this.changeDetailInfor.userSex = resolve.data[0].sex
            this.changeDetailInfor.birth = resolve.data[0].birth;
            this.choseProvince = resolve.data[0].locate;
            this.changeDetailInfor.job = resolve.data[0].job;
            this.changeDetailInfor.introduce = resolve.data[0].introduction;
        }, reject => {
            console.log("post failed request!");
        });
        //帖子
        this.$ajax({
            method: "post",
            url: "http://47.103.10.220:8001/user/listUserArticle",
            dataType: "json",
            crossDomain: true,
            cache: false
        }).then(resolve => {
            this.post = resolve.data;
            // console.log(resolve);
        }, reject => {
            console.log("post failed request!");
        });
        // //问答
        // this.$ajax({
        //     method: "get",
        //     url: "../../../static/question.json",
        //     dataType: "json",
        //     crossDomain: true,
        //     cache: false
        // }).then(resolve => {
        //     this.questionAnswer = resolve.data.questionAnswer;
        //     // console.log(resolve);
        // }, reject => {
        //     console.log("question failed request!");
        // });
        // //寄养
        this.$ajax({
            method: "get",
            url: "http://47.103.10.220:8001/adoption/listAdoption",
            dataType: "json",
            crossDomain: true,
            cache: false
        }).then(resolve => {
            this.fosterInfor = resolve.data;
            console.log(resolve.data);
        }, reject => {
            console.log("foster failed request!");
        });
        //城市联动
        this.$ajax({
            method: "get",
            url: "../../../static/ProvinceCity.json",
            dataType: "json",
            crossDomain: true,
            cache: false
        }).then(resolve => {
            // console.log(resolve.data);
            //分省、市
            for(let item in resolve.data){
                //province
                if(item.match(/0000$/)){
                    this.province.push({id: item, value: resolve.data[item], children: []});
                    // console.log(this.province);
                }
                //city
                else if(item.match(/00$/)){
                    this.city.push({id: item, value: resolve.data[item]});
                    // console.log(item, resolve.data[item]);
                }
            }
            //省市连接
            for(let province in this.province){
                for(let city in this.city){
                    if(this.province[province].id.slice(0,2) === this.city[city].id.slice(0,2)){
                        // console.log(province, this.province[province]);
                        this.province[province].children.push(this.city[city]);
                    }
                }
            }
        }, reject => {
            console.log("failed requiring!")
        })
    },
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

    /* middle */
    #middle {
        /* border: 1px solid red; */
        margin-top: 1%;
        padding: 1% 2% 1% 2%;
        position: relative;
    }
    #middle h6 {
        margin-block-end: 0;
        margin-block-start: 0;
    }
    #middle img, h6 {
        display: inline-block;
    }

    /* 导航 */
    #navi {
        /* border: 1px solid blue; */
        border-radius: 10px;
    }
    #navi_inner {
        border: 1px solid white;
        border-radius: 10px;
        background-image: url(../../assets/plants1.jpg);
        background-size: 100% 100%;
    }
    #navi_menu {
        width: 100%;
        height: 100%;
        background-color: rgba(255,255,255,0.5);
    }
    #navi_menu .el-menu-item {
        /* border: 1px solid red; */
        width: 50%;
    }
    #navi_menu .el-menu-item {
        text-align: center;
    }

    /* 个人名片卡 */
    #personCard_inner img {
        border-radius: 35px;
    }
    #personCard_head {
        /* border: 1px solid red; */
        height: 100px;
    }
    #username {
        text-align: center;
    }
    #change {
        text-align: right;
        height: 50px;
        line-height: 50px;
    }
    #change a{
        color: black;
        text-decoration: none;
    }
    #change img {
        vertical-align: middle;
    }
    .introduce {
        text-align: left;
        /* border: 1px solid blue; */
        height: 30px;
        padding-left: 3%;
        line-height: 30px;
    }
    .introduce img {
        vertical-align: middle;
    }
    #fence_follow {
        text-align: center;
        /* border: 1px solid; */
        margin-top: 10%;
    }
    /* #fence_follow .el-col img, h6 {
        display: block;
    } */

    /* 修改遮罩 */
    #inforHead {
        padding-left: 5%;
        padding-right: 2%;
    }
    /* #cannotChange {
        text-align: 50%;
    } */
    #id {
        /* border: 1px solid red; */
        margin-bottom: 0;
    }
    /* #fenceAccount {
        
    } */
    #id h4 {
        margin-block-start: 0;
        margin-block-end: 0;
    }
    #fenceAccount h4 {
        margin-block-start: 0;
        margin-block-end: 0;
    }
    /* #cannotChange {
        border: 1px solid red;
        text-align: center;
    } */
    #changeUserHead {
        /* border: 1px solid red; */
        text-align: right;
        padding-left: 15%;
    }
    #slotBtn {
        text-align: right;
    }

    /* 帖子、问答、寄养详情 */
    #navi_detail_post, #navi_detail_question, #navi_detail_foster {
        position: absolute;
        top: 55%;
        width: 63.5%;
    }
    #navi_detail_post h1 {
        font-size: 20px;
    }
    #navi_detail_question h2{
        font-size: 16px;
    }
    /* #detail_inner {
        width: 100%;
    } */
    .read {
        text-align: left;
    }
    .time {
        text-align: right;
    }
    .navi_detail_inner {
        margin-bottom: 1%;
    }
</style>
