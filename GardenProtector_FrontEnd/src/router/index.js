import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
//首页
import index from '@/pages/index'
//个人主页
import personHome from '@/pages/person/personHome'
//后台管理
import management from '@/pages/management/management'
//论坛
import forum from '@/pages/forum/forum'
import forumHome from '@/pages/forum/forumHome'
import writeBlogs from '@/pages/forum/writeBlogs'
import adoption from '@/pages/forum/adoption'
//论坛侧栏
import follow from '@/pages/forum/sideBar/follow'
import recommand from '@/pages/forum/sideBar/recommand'
import classification from '@/pages/forum/sideBar/classification'
import flower from '@/pages/forum/sideBar/flower'
import grass from '@/pages/forum/sideBar/grass'
import heal from '@/pages/forum/sideBar/heal'
import garden from '@/pages/forum/sideBar/garden'
import bansai from '@/pages/forum/sideBar/bansai'
//帖子详情
import blogDetails from '@/pages/forum/blogDetails'
// 登陆注册
import login from '@/pages/signin/login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'forum',
      component: forum,
      children:[
        // 论坛
        {
          path:'forumHome',
          name:'forumHome',
          component:forumHome
        },
        //寄养
        {
          path:'adoption',
          name:'adoption',
          component:adoption
        },
        //关注
        {
          path:'follow',
          name:'follow',
          component:follow
        },
        //推荐
        {
          path:'recommand',
          name:'recommand',
          component:recommand
        },
        //专题
        {
          path:'classification',
          name:'classification',
          component:classification
        },
        //花卉
        {
          path:'flower',
          name:'flower',
          component:flower
        },
        //草木
        {
          path:'grass',
          name:'grass',
          component:grass
        },
        //医治
        {
          path:'heal',
          name:heal,
          component:heal
        },
        //园林
        {
          path:'garden',
          name:'garden',
          component:garden
        },
        //盆景
        {
          path:'bansai',
          name:'bansai',
          component:bansai
        }
      ]
    },
    {
      path:'/writeBlogs',
      name:'writeBlogs',
      component:writeBlogs
    },
    {
      path:'/blogDetails',
      name:'blogDetails',
      component:blogDetails,
    },
    {
      path:'/login',
      name:'login',
      component:login,
    },
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/index',
      name: 'index',
      component: index
    },
    {
      path: '/personHome',
      name: 'personHome',
      component: personHome
    },
    {
      path: 'n',
      name: 'admin',
      component: management
    },
  ]
})
