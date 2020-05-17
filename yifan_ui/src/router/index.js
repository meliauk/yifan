import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/index.vue'

Vue.use(VueRouter)

const routes = [
     {
        path: '/',
        name: 'Index',
        component: Index,
          children:[
              {
                  path:'/',
                  name:'blog',
                  component: () => import('../views/blog.vue'),
              },
              {
                  path:'timeRec',
                  name:'timeRec',
                  component: () => import('../views/timeRec.vue')
              },
              {
                  path:'ours',
                  name:'ours',
                  component: () => import('../views/ours.vue')
              },
              {
                  path:'message',
                  name:'message',
                  component: () => import('../views/message.vue')
              },
              {
                  path:'about',
                  name:'about',
                  component: () => import('../views/about.vue')
              },

          ]
    },
    {
        path:'/Info',
        name:'Info',
        component: () => import('../views/Info.vue'),
    },
    // 404page
    {
        path: '/error',
        name: 'error',
        component: () => import('../views/error.vue'),
    },
];

const router = new VueRouter({
    routes
});
router.beforeEach((to, from, next) => {
    console.log(to.matched.length)
    if (to.matched.length === 0) {  //如果未匹配到路由
        next('/error');
        // from.path? next({ path:from.path}) : next('/error');   //如果上级也未匹配到路由则跳转主页面，如果上级能匹配到则转上级路由
    } else {
        next();    //如果匹配到正确跳转
    }
});

export default router;
