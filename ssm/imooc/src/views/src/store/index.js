import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    server_baseurl: 'http://localhost:8888/',
    current_user: '',
    projects: '',
    default_img: 'user_default.jpg'
  },
  mutations: {
    saveUser(state, current_user) {
      state.current_user = current_user;
    },
    saveProjects(state, projects) {
      state.projects = projects;
    }
  },
  actions: {},
  modules: {}
})