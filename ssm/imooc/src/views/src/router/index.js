import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Detail from '../views/Detail.vue'
import Search from '../views/Search.vue'
import Index from '../views/Index.vue'

Vue.use(VueRouter)

const routes = [
  {
    path:'/',
    component:Index,
    children:[
      
      {
        path: '/',
        name: 'home',
        component: Home
      },
      {
        path:'/search',
        component: Search
      },
      {
        path:'/detail',
        component:Detail
      },
    ]
  },
  {
    path:'/login',
    name:'login',
    component:()=>import('../views/Login.vue')
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
   mode: 'history',
   base: process.env.BASE_URL,
  routes
})

export default router
