import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Detail from '../views/Detail.vue'
import Search from '../views/Search.vue'
import Index from '../views/Index.vue'
import Mine from '../views/Mine.vue'
import Cart from '../views/Cart.vue'

Vue.use(VueRouter)

const routes = [{
    path: '/',
    component: Index,
    children: [

      {
        path: '/',
        name: 'home',
        component: Home
      },
      {
        path: '/search',
        component: Search
      },
      {
        path: '/detail',
        component: Detail
      },
      {
        path: '/mine',
        component: Mine
      },
      {
        path: '/cart',
        component: Cart
      },
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import( /* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    } else {
      return {
        x: 0,
        y: 0
      }
    }
  }

})

export default router