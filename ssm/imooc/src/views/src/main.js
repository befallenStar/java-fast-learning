import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import vueswiper from 'vue-awesome-swiper'
import 'swiper/dist/css/swiper.css'
import axios from './plugins/axios.js'
import VueAxios from 'vue-axios'

// axios.defaults.baseURL = '/api'

Vue.use(vueswiper)
Vue.use(VueAxios, axios)
Vue.config.productionTip = false
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')