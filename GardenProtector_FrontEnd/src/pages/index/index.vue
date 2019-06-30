<template>
    <div>
        <!-- 轮播 -->
        <div id="move">
            <!-- <img src="../../assets/banner3.jpg" width="100%" height="100%;" id="backimg" /> -->
            <div id="title">
                <a href="http://localhost:8080/#/index">
                    <h1>护草使者</h1>
                    <span>GARDEN PROTECTOR.com</span>
                </a>
                <div id="operation">
                    <el-button type="success" plain @click="toTalk()">论坛</el-button>
                    <el-button type="success" size="small" plain @click="toLogin()">登录</el-button>
                    <!-- <el-button type="success" size="small" plain>注册</el-button> -->
                </div>
            </div>
            <el-carousel height="460px" type="card" :autoplay="true" >
                <el-carousel-item v-for="item in dataimg" v-bind:key="item.index">
                    <div id="playCard">
                        <img :src="item.src" />
                        <div id="cardText">
                            <h1>{{ item.msg2 }}</h1>
                            <span>{{ item.msg3 }}</span>
                        </div>
                        <!-- <div id="detail">
                            <h1>{{ item.msg1 }}</h1>
                        </div> -->
                    </div>
                </el-carousel-item>
            </el-carousel>
        </div>

        <!-- welcome -->
        <div id="about_us">
            <h1>欢迎来到护草使者</h1>
            <span id="welcomeEnglish">WELCOME TO GARDEN PROTECTOR</span>
            <div id="about_us_box">
                <div id="about_us_left">
                    <span>WELCOME TO GARDEN PROTECTOR</span>
                    <p>在这里，你可以发表自己种植花草的经验</p>
                    <p>在这里，你将收获到别人的建议</p>
                    <p>在这里，你还可以寄养你的花草</p>
                </div>
                <div id="about_us_right">
                    <div>
                        <img src="../../assets/a1.jpg" />
                        <span>寄养花草</span>
                    </div>
                    <div>
                        <img src="../../assets/a2.jpg" />
                        <span>花届大事</span> 
                    </div>
                    <div>
                        <img src="../../assets/a3.jpg" />
                        <span>养花经验</span>
                    </div>
                    <div>
                        <img src="../../assets/a4.jpg" />
                        <span class="img_text">我们的花展</span>
                    </div>
                </div>
            </div>
        </div>

        <!-- 窗口 1-->
        <div id="window_one">
            <div id="window_one_white">
                <h1>快来发表你的种植经验吧！</h1>
            </div>
        </div>
        <!-- 主要功能 -->
        <div id="main_function">
            <h1>主要功能</h1>
            <div id="main_function_inner">
                <div id="function_one">
                    <div class="function_left">
                        <h3>发表经验帖</h3>
                    </div>
                    <div class="function_right">
                        <h2>01.</h2>
                    </div>
                    <p>你有什么种植经验快来与大家分享吧！</p>
                </div>
                <div id="function_two">
                    <div class="function_left">
                        <h3>大佬的帖子</h3>
                    </div>
                    <div class="function_right">
                        <h2>02.</h2>
                    </div>
                    <p>浏览“大佬”们的帖子，就好像他在手把手教你种植一样！</p>
                </div>
                <div id="function_three">
                    <div class="function_left">
                        <h3>寄养你的花草</h3>
                    </div>
                    <div class="function_right">
                        <h2>03.</h2>
                    </div>
                    <p>你放心去远行，我们已经为你的“小宝贝”打点好一切！</p>
                </div>
                <div id="function_four">
                    <div class="function_left">
                        <h3>园艺界重大消息</h3>
                    </div>
                    <div class="function_right">
                        <h2>04.</h2>
                    </div>
                    <p>护草使者让你足不出户知晓天下园艺事！</p>
                </div>
            </div>
        </div>
        <!-- 窗口2 -->
        <div id="window_two">
            <h1>我们的团队</h1>
            <div id="window_two_inner">
                <div class="team_staff">
                    <img src="../../assets/kong.jpg" width="80px" height="80px" />
                    <p>孔一言</p>
                    <p>Morbi non elit sed neque rhoncus maximus ac at enim. Praesent a nisi sit amet risus semper laoreet et nec eros.</p>
                </div>
                <div class="team_staff">
                    <img src="../../assets/lll.jpg" width="80px" height="80px" />
                    <p>梁莉莉</p>
                    <p>Morbi non elit sed neque rhoncus maximus ac at enim. Praesent a nisi sit amet risus semper laoreet et nec eros.</p>
                </div>
                <div class="team_staff">
                    <img src="../../assets/xu.jpg" width="80px" height="80px" />
                    <p>徐文晴</p>
                    <p>Morbi non elit sed neque rhoncus maximus ac at enim. Praesent a nisi sit amet risus semper laoreet et nec eros.</p>
                </div>
                <div class="team_staff">
                    <img src="../../assets/wu.jpg" width="80px" height="80px" />
                    <p>吴婷婷</p>
                    <p>Morbi non elit sed neque rhoncus maximus ac at enim. Praesent a nisi sit amet risus semper laoreet et nec eros.</p>
                </div>
            </div>
        </div>

        <!-- 花展 -->
        <div id="photo_gallery">
            <h1>用户的分享</h1>
            <div id="photo_gallery_inner">
                <div class="photos">
                    <img src="../../assets/g1.jpg" />
                </div>
                <div class="photos">
                    <img src="../../assets/g2.jpg" />
                </div>
                <div class="photos">
                    <img src="../../assets/g3.jpg" />
                </div>
                <div class="photos">
                    <img src="../../assets/g4.jpg" />
                </div>
                <div class="photos">
                    <img src="../../assets/g5.jpg" />
                </div>
                <div class="photos">
                    <img src="../../assets/g6.jpg" />
                </div>
                <div class="photos">
                    <img src="../../assets/g7.jpg" />
                </div>
                <div class="photos">
                    <img src="../../assets/g8.jpg" />
                </div>
                <div class="photos">
                    <img src="../../assets/g1.jpg" />
                </div>
            </div>
        </div>

        <!-- 最底 -->
        <div id="bottom">
            <div id="bottom_inner">
                <div id="bottom_inner_text">
                    <h2>如果你是贤士，如果你极具竞争力</h2>
                    <h1>欢迎你加入我们的开发团队！</h1>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'AboutUs',
		data() {
			return {
				dataimg: [
                    {
                        src: require('../../assets/index1.jpg'),
                        // msg1: '你放心去远行，我们已经为你的“小宝贝”打点好一切！',
                        msg2: '护草使者',
                        msg3: 'Garden Protector'
                    },
                    {
                        src: require('../../assets/index2.jpg'),
                        // msg1: '你将发表自己种植花草的经验，收获到别人的建议！',
                        msg2: '花草论坛',
                        msg3: 'Garden Forum'
                    },
                    {
                        src: require('../../assets/index3.jpg'),
                        // msg1: '浏览“大佬”们的帖子，就好像他在手把手教你种植一样！',
                        msg2: '大佬经验',
                        msg3: "Talent's Experience"
                    }
                ]
			}
        },
        methods: {
            // 论坛
            toTalk() {
                this.$router.push({ path:'/forumHome' });
            },
            //登录
            toLogin() {
                this.$router.push({ path:'/login' });
            }
        },
        created(){
            // this.$ajax({
            //     method: "get",
            //     url: "../../../static/slipe.json",
            //     dateType: "json",
            //     crossDomain: "true",
            //     cache: "false",
            // }).then(resolve => {
            //     // console.log(resolve);
            //     this.dataimg = resolve.data.slipe;
            //     console.log(this.dataimg);
            // },
            // reject => {
            //     console.log("失败");
            //     console.log(reject);
            // })
        }
    }
</script>

<style scoped>
    #operation {
        position: absolute;
        right: 3%;
        top: 3%;
    }
    /* 轮播 */
    #move {
        padding: 1.5%;
        position: relative;
        /* background-color: #99a9bf; */
        /* border: 0.5px solid #99a9bf;
        border-radius: 10px;
        box-shadow: 5px 5px 5px #777; */
        background-image: url(../../assets/plants2.jpg);
        background-repeat: no-repeat;
        background-size: 100% 100%;
        background-attachment: fixed;
    }
    #title{
        /* border: 1px solid red; */
        width: 20%;
        /* padding: 1%; */
        line-height: 50%;
        color: #879b6f;
        text-align: center;
    }
    #title a {
        color: #879b6f;
        text-decoration: none;
    }
    #playCard h1 {
        z-index: 1000;
    }
    #cardText {
        position: absolute;
        top: 0;
        left: 18%;
        /* line-height: 80%; */
    }
    #detail {
        position: absolute;
        top: 30%;
        text-align: center;
    }
    #backimg {
        position: absolute;
        opacity: 0.5;
        z-index: -1；
    }
    .el-carousel__item h1 {
        /* font-size: 14px; */
        /* line-height: 150px; */
        /* margin: 0; */
        color: white;
    }
    /* .el-carousel__item {
        background-color: rgba(211,220,230);
    } */
    .el-carousel__item--card {
        border-radius: 10px;
        /* border: 1px solid red; */
    }
    
    /* 关于我们 */
    #about_us h1{
        /* border:1px solid red ; */
        text-align: center;
        margin-top: 3%;
    }
    #welcomeEnglish {
        display: block;
        /* border: 1px solid red; */
        text-align: center;
    }
    #about_us_box {
        /* border: 1px solid red; */
        /* width: 65%; */
        height: 710px;
        /* margin: 0 auto; */
    }
    #about_us_box div {
        display: inline-block;
        /* float: left; */
        vertical-align: middle;
    }
    #about_us_left {
        text-align: right;
        width: 50%;
        /* border: 1px solid blue; */
    }
    #about_us_left p {
        color: #777;
    }
    #about_us_left span{
        color: #7aba1e;
    }
    #about_us_right {
        /* border: 1px solid yellow; */
        width: 40%;
        margin-left: 3%;
    }
    #about_us_right div {
        width: 210px;
        height: 260px;
        background-color: rgba(0,0,0);
    }
    #about_us_right div:nth-child(2n) {
        margin: 4em 0 0 1em;
    }
    #about_us_right div:nth-child(2n+1) {
        margin: 0.5em 0.1em 0 0;
    }
    #about_us_right img {
        width: 180px;
        height: 230px;
        border: 15px solid rgb(245,245,245);
    }
    #about_us_right img:hover {
        opacity: 0.5;
        transition: all 1s;
    }

    /* 窗口1 */
    #window_one {
        padding: 3%;
        /* border: 1px solid red; */
        height: 200px;
        background-image: url(../../assets/banner1.jpg);
        background-size: cover;
        /* background-repeat: no-repeat; */
        background-attachment:fixed;
        text-align: center;
        /* position: fixed; */
        /* z-index: -1; */
    }
    #window_one h1 {
        margin-top: 8%;
        font-size: 35px;
        color: white;
        letter-spacing: 10px;
    }

    /* 主要功能 */
    #main_function {
        /* border: 1px solid red; */
        height: 270px;
        padding: 2.5%;
    }
    #main_function h1 {
        font-size: 35px;
        text-align: center;
    }
    #main_function_inner {
        width: 95%;
        margin: 0 auto;
        /* border: 1px solid red; */
    }
    #function_one, #function_two, #function_three, #function_four {
        display: inline-block;
        width: 24%;
        height: 150px;
        margin-left: 0.7%;
        /* border: 1px solid blue; */
        position: relative;
    }
    #main_function_inner p {
        font-size: 14px;
        letter-spacing: 1px;
        color: #999;
        line-height: 2em;
    }
    .function_right {
        position: absolute;
        top: 0;
        right: 5%;
        /* border: 1px solid red; */
        color: #d0cfcf;
    }
    .function_right h2 {
        font-weight: 600;
        font-size: 30px;
    }
    /* 窗口2 */
    #window_two {
        padding: 3%;
        /* border: 1px solid red; */
        height: 550px;
        background-image: url(../../assets/banner.jpg);
        background-size: cover;
        background-attachment:fixed;
        /* background-repeat: no-repeat; */
        color: white;
    }
    #window_two h1 {
        text-align: center;
    }
    #window_two_inner {
        width: 100%;
        margin: 0 auto;
        text-align: center;
        margin-top: 10%;
    }
    #window_two_inner div {
        display: inline-block;
        width: 20%;
        /* height: 150px; */
        /* margin-left: 0.5%; */
        /* border: 1px solid blue; */
        padding: 2%;
        /* border: 1px solid rgba(211,211,211,0.8); */
    }
    .team_staff {
        background-color: rgba(0,0,0,0.5);
    }
    .team_staff img {
        border-radius: 40px;
    }

    /* 花展 */
    #photo_gallery {
        padding: 3%;
        margin-top: 2%;
        text-align: center;
    }
    #photo_gallery_inner {
        margin-top: 5%;
    }
    .photos {
        width: 30%;
        display: inline-block;
    }
    .photos img {
        width: 100%;
    }

    /* 最底 */
    #bottom {
        position: relative;
        text-align: center;
        height: 350px;
        background-image: url(../../assets/banner3.jpg);
        background-size: 100% 100%;
        background-attachment:fixed;
    }
    #bottom_inner {
        height: 100%;
        background-color: rgba(0,0,0,0.5);
        color: white;
    }
    #bottom_inner_text {
        position: absolute;
        margin: 0 auto;
        left: 0;
        right: 0;
        top: 25%;
    }
</style>
