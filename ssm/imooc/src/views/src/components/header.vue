<template>
  <div class="header-container">
    <div class="logo">
      <a href="http://www.diecolor.com">
        <img :src="logo" alt="码雀网" />
      </a>
    </div>
    <ul class="nav-item">
      <li>
        <router-link to="/about">免费项目</router-link>
      </li>
      <li>
        <router-link to="/about">精品项目</router-link>
      </li>
      <li>
        <router-link to="/about">源码</router-link>
      </li>
      <li>
        <router-link to="/about">文档</router-link>
      </li>
      <li>
        <router-link to="/about">视频</router-link>
      </li>
    </ul>
    <!-- 搜索框 -->
    <div class="search-warp clearfix">
      <div class="search-area">
        <input
          class="search-input"
          @focus="change(true)"
          @blur="change(false)"
          data-suggest-trigger="suggest-trigger"
          placeholder="请输入关键字..."
          type="text"
          autocomplete="off"
          v-model="keyword"
        />
        <div class="hotTags" style="display: block;">
          <a href="/search?keyword=Vue" class>Vue</a>
          <a href="/search?keyword=Python" class="last">Python</a>
        </div>
        <!-- <div class="search-area-result nav-search-box js-search-wrap" v-show="onfous">
          <div class="hot">
            <h2>热搜</h2>
            <div class="hot-box">
              <a href="/search" @click.stop="change(false)" class="hot-item js-history-search">Vue</a>
              <a href="javascript:void(0)" class="hot-item js-history-search">Python</a>
              <a href="javascript:void(0)" class="hot-item js-history-search">Java</a>
              <a href="javascript:void(0)" class="hot-item js-history-search">flutter</a>
              <a href="javascript:void(0)" class="hot-item js-history-search">springboot</a>
              <a href="javascript:void(0)" class="hot-item js-history-search">docker</a>
              <a href="javascript:void(0)" class="hot-item js-history-search">React</a>
              <a href="javascript:void(0)" class="hot-item js-history-search">小程序</a>
            </div>
          </div>
          <div class="history" style="display: none;">
            <ul data-suggest-result="suggest-result"></ul>
          </div>
        </div>-->
      </div>
      <a class="showhide-search" data-show="no" :href="'/search?keyword='+keyword">
        <i class="el-icon-search"></i>
      </a>
    </div>
    <!-- 搜索框END -->
    <!-- 登录信息 -->
    <div class="login-area">
      <ul class="isLogined">
        <li class="shop-cart" v-if="isLogined">
          <a
            href="/cart"
            class="shop-cart-icon"
            @mouseover="showcart(true)"
            @mouseout="showcart(false)"
          >
            <i class="el-icon-shopping-cart-1"></i>
            购物车
            <el-badge class="mark" :value="projects.length" />
          </a>
          <div class="my-cart" v-show="iscart" @mouseover="oncartcard" @mouseout="outcartcard">
            <div class="cart-title-box clearfix">
              <h2 class="l">我的购物车</h2>
              <h5 class="r">
                已加入
                <span class="js-incart-num">{{projects.length}}</span>门课程
              </h5>
            </div>
            <div class="cart-wrap">
              <div class="cart-wrap-box" id="js-card-ul" v-if="projects.length>0">
                <ul>
                  <li class="clearfix js-item" v-for="(item,index) in projects" :key="index">
                    <a :href="'/project/detail?id='+item.project_id">
                      <img
                        class="l"
                        :src="$store.state.server_baseurl+item.project_cover"
                        :alt="item.project_title"
                      />
                    </a>
                    <div class="content-box l">
                      <a :href="'/project/detail?id='+item.project_id">
                        <h3>{{item.project_title}}</h3>
                      </a>
                      <p class="clearfix">
                        <span class="price l">￥{{item.project_price}}</span>

                        <span class="del r js-close" @click="deletePorject(item.project_id)">删除</span>
                      </p>
                    </div>
                  </li>
                </ul>
              </div>
              <div class="clear-cart" v-else>
                <span class="cartIcon icon-shopping-cart"></span>
                <h3>购物车里空空如也</h3>
                <div class="text">
                  快去
                  <a href="/search">这里</a> 选购你中意的项目
                </div>
              </div>
            </div>
            <!-- <div class="more-box clearfix">
              <div class="l show-box">
                <span class="text">
                  <a href target="_blank">我的订单中心</a>
                </span>
              </div>
              <a href target="_blank" class="r moco-btn moco-btn-red go-cart">去购物车</a>
            </div>-->
          </div>
        </li>
        <!-- 未登录 -->
        <li class="header-signin" v-if="!isLogined">
          <router-link to="/login" id="js-signin-btn">登录</router-link>/
          <router-link to="/login?islogin=1" id="js-signin-btn">注册</router-link>
        </li>
        <!-- 头像 -->
        <li class="set_btn user-card-box" id="header-user-card" v-if="isLogined">
          <a
            id="header-avator"
            @mouseover="showuser(true)"
            @mouseout="showuser(false)"
            class="user-card-item js-header-avator"
            action-type="my_menu"
            href="/mine?activaName=my"
            target="_self"
          >
            <img
              width="40"
              height="40"
              :src="$store.state.server_baseurl+current_user.img"
              :alt="current_user.nickname"
            />
          </a>
          <div class="g-user-card" v-if="isuser" @mouseover="onusercard" @mouseout="outusercard">
            <div class="card-inner">
              <div class="card-top clearfix">
                <a class="l" href="/mine?activeName=my">
                  <img
                    :src="$store.state.server_baseurl+current_user.img"
                    :alt="current_user.nickname"
                  />
                </a>
                <div class="card-top-right-box l">
                  <a href="/mine?activeName=first">
                    <span class="name text-ellipsis">{{current_user.nickname}}</span>
                  </a>
                </div>
              </div>
              <div class="user-center-box">
                <ul class="clearfix">
                  <li class="l">
                    <a href="/mine?activeName=my">
                      <i class="el-icon-s-platform"></i>
                      我的项目
                    </a>
                  </li>
                  <li class="l">
                    <a href="/cart">
                      <i class="el-icon-s-goods"></i>
                      购物车
                    </a>
                  </li>
                  <li class="l">
                    <a href="/mine?activeName=purchase_history">
                      <i class="el-icon-s-finance"></i>
                      购买记录
                    </a>
                  </li>
                  <li class="l">
                    <a href="/mine?activeName=download_history">
                      <i class="el-icon-download"></i>
                      下载记录
                    </a>
                  </li>
                </ul>
              </div>
              <div class="card-history">
                <div>
                  <i class="el-icon-key"></i>
                  做人如果没梦想,那跟咸鱼有什么分别？
                </div>
                <div></div>
              </div>
              <div class="card-sets clearfix">
                <a href="/" @click="logout">安全退出</a>
              </div>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'

export default {
  data() {
    return {
      logo: require("../assets/maque_logo200.png"),
      onfous: false,
      iscart: false,
      oncard: false,
      t1: {},
      t2: {},
      isuser: false,
      onuser: false,
      t3: {},
      t4: {},
      isLogined: false,
      keyword: ""
    };
  },
  created() {
    this.getSessionUser();
    this.loadProjects();
  },
  computed: {
    current_user() {
      return this.$store.state.current_user;
    },
    projects() {
      return this.$store.state.projects;
    }
  },
  methods: {
    search() {},
    deletePorject(projectId) {
      this.axios
        .get("/shopping_cart/delete/" + projectId)
        .then(res => {
          console.log(res.data);
          if ("12138" == res.data.code) {
            this.$store.commit("saveProjects", res.data.data);
            this.$message({
              message: "删除成功",
              type: "success"
            });
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    loadProjects() {
      if(this.current_user!=null){
      this.axios
        .get("/shopping_cart/my")
        .then(res => {
          console.log(res.data);
          this.$store.commit("saveProjects", res.data.data);
        })
        .catch(error => {
          console.log(error);
        });
      }
    },
    getSessionUser() {
      this.axios
        .get("/imooc_user/session")
        .then(res => {
          // this.$store.state.current_user = res.data.data;
          // this.current_user = this.$store.state.current_user;
          this.$store.commit("saveUser", res.data.data);
          if (this.current_user) this.isLogined = true;
        })
        .catch(error => {
          console.log(error);
        });
    },
    change(flag) {
      this.onfous = flag;
    },
    showcart(flag) {
      if (!flag) {
        this.t1 = setTimeout(() => {
          if (!this.oncard) {
            this.iscart = flag;
          }
        }, 300);
      } else {
        clearTimeout(this.t1);
        clearTimeout(this.t2);
        this.iscart = flag;
      }
    },
    //放入到面板时
    oncartcard() {
      clearTimeout(this.t1);
      clearTimeout(this.t2);
      this.oncard = true;
      this.iscart = true;
    },
    outcartcard() {
      this.oncard = false;
      this.t2 = setTimeout(() => {
        this.iscart = false;
      }, 300);
    },
    showuser(flag) {
      if (!flag) {
        this.t3 = setTimeout(() => {
          if (!this.onuser) {
            this.isuser = flag;
          }
        }, 300);
      } else {
        clearTimeout(this.t3);
        clearTimeout(this.t4);
        this.isuser = flag;
      }
    },
    //放入到面板时
    onusercard() {
      clearTimeout(this.t3);
      clearTimeout(this.t4);
      this.onuser = true;
      this.isuser = true;
    },
    outusercard() {
      this.onuser = false;
      this.t4 = setTimeout(() => {
        this.isuser = false;
      }, 300);
    },
    logout() {
      // this.$store.state.current_user = "";
      // this.$store.commit("saveUser", "");
      this.axios
        .get("/imooc_user/loginOut")
        .then(res => {
          this.$message({
            message: "注销成功",
            type: "success"
          });
        })
        .catch(error => {
          console.log(error);
        });
      this.isLogined = false;
    }
  },
  components: {}
};
</script>

<style>
body,
div,
dl,
dt,
dd,
ul,
ol,
li,
h1,
h2,
h3,
h4,
h5,
h6,
pre,
code,
form,
fieldset,
legend,
input,
button,
textarea,
p,
blockquote,
th,
td {
  margin: 0;
  padding: 0;
}
ol,
ul {
  list-style: none;
}
a {
  text-decoration: none;
}

a,
a:visited {
  color: #07111b;
}
a:hover {
  color: teal;
}
html,
body {
  height: 100%;
  width: 100%;
  min-width: 1200px;
  font: 14px/1.5 "PingFang SC", "微软雅黑", "Microsoft YaHei", Helvetica,
    "Helvetica Neue", Tahoma, Arial, sans-serif;
  color: #1c1f21;
}
body {
  background: #f8fafc !important;
  overflow-y: scroll;
  padding-top: 0;
  -webkit-transition: -webkit-transform 0.3s ease;
  transition: transform 0.3s ease;
}
#app .el-header {
  padding: 0px 0px;
  height: 72px;
}
.fix-header {
  position: fixed;
  top: 0;
  width: 100%;
  z-index: 900;
  box-shadow: 0 4px 8px 0 rgba(7, 17, 27, 0.1);
}
.header-container {
  width: auto;
  padding-right: 10px;
  z-index: 900;
  box-shadow: 0 4px 8px 0 rgba(7, 17, 27, 0.1);
  position: relative;
  background-color: #fff !important;
  height: 72px;
}
.logo {
  float: left;
}
.logo a {
  display: block;
  width: 160px;
  height: 72px;
}
.logo img {
  height: 72px;
}
.nav-item {
  float: left;
  list-style: none;
}
.nav-item li {
  float: left;
}
.nav-item li a {
  padding: 0 20px;
  display: block;
  color: #4d555d !important;
  text-align: center;
  font-size: 16px;
  height: 72px;
  line-height: 72px;
  -webkit-transition: background-color 0.3s;
  -moz-transition: background-color 0.3s;
  transition: background-color 0.3s;
  position: relative;
  text-decoration: none;
}

.search-warp {
  min-width: 32px;
  height: 72px;
  position: relative;
  float: left;
  margin-left: 10px;
}
.search-area {
  width: 300px;
  float: left;
  position: relative;
  height: 40px;
  padding-right: 40px;
  border-bottom: 1px solid rgba(255, 255, 255, 0.4);
  zoom: 1;
  background: #e9e9e9;
  border-radius: 8px;
  margin: 16px 0;

  box-sizing: border-box;
  font-size: 0;
  -webkit-transition: width 0.3s;
  -moz-transition: width 0.3s;
  transition: width 0.3s;
}

.search-area .hotTags {
  display: block;
  position: absolute;
  top: 0;
  right: 40px;
}
.search-area .hotTags a {
  display: inline-block;
  padding: 4px 8px;
  height: 16px;
  font-size: 14px;
  color: #545c63;
  line-height: 16px;
  margin-top: 8px;
  max-width: 60px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  text-decoration: none;
}
.search-area .hotTags a:hover {
  color: teal;
}
.search-area .search-area-result {
  /* position: absolute; */
  /* left: 0; */
  top: 57px;
  width: 300px;
  margin-bottom: 20px;
  border-top: none;
  background-color: #fff;
  box-shadow: 0 8px 16px 0 rgba(7, 17, 27, 0.2);
  font-size: 12px;
  overflow: hidden;
  z-index: 800;
  border-bottom-right-radius: 8px;
  border-bottom-left-radius: 8px;
}
.search-area .search-area-result .hot {
  padding: 12px 0 8px 12px;
  box-sizing: border-box;
}
.search-area .search-area-result h2 {
  font-size: 12px;
  color: #1c1f21;
  line-height: 12px;
  margin-bottom: 8px;
  font-weight: 700;
}
.search-area .search-area-result .hot .hot-item {
  background: rgba(84, 92, 99, 0.1);
  border-radius: 12px;
  padding: 4px 12px;
  line-height: 16px;
  margin-right: 4px;
  margin-bottom: 4px;
  display: inline-block;
  cursor: pointer;
  font-size: 12px;
  color: #545c63;
}
.search-area .search-input {
  padding: 8px 12px;
  font-size: 14px;
  color: #a6a6a6;
  line-height: 24px;
  height: 40px;
  width: 100%;
  float: left;
  border: 0;
  -webkit-transition: background-color 0.3s;
  -moz-transition: background-color 0.3s;
  transition: background-color 0.3s;
  background-color: transparent;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  -ms-box-sizing: border-box;
  box-sizing: border-box;
}
.search-area .search-input:focus {
  outline: 0px;
}
.search-warp .showhide-search {
  width: 20px;
  height: 24px;
  text-align: right;
  position: absolute;
  display: inline-block;
  right: 0;
  bottom: 24px;
  padding: 0 8px;
  border-radius: 18px;
}
.search-warp .showhide-search i {
  display: block;
  height: 24px;
  color: #545c63;
  cursor: pointer;
  font-size: 20px;
  line-height: 24px;
  width: 20px;
}
.icon-search:before {
  content: "\e610";
}
/* 购物车 */
.login-area {
  position: absolute;
  right: 0px;
}
.login-area .isLogined > li {
  float: left;
  position: relative;
}
.login-area .shop-cart {
  height: 36px;
  line-height: 36px;
  margin: 18px 0;
}

.login-area .shop-cart .shop-cart-icon {
  display: inline-block;
  padding: 0 18px;
  width: auto;
  box-sizing: border-box;
  border: 1px solid #d9dde1 !important;
  border-radius: 18px;
  height: 36px;
  line-height: 34px;
  color: #787d82;
  text-align: center;
}
.login-area .shop-cart .shop-cart-icon:hover {
  color: teal;
}

.login-area .shop-cart .my-cart {
  top: 54px;
}
.shop-cart .my-cart {
  /* display: none; */
  width: 344px;
  padding: 0 16px;
  position: absolute;
  right: 0;
  background: #fff;
  box-sizing: border-box;
  z-index: 99999;
  box-shadow: 0 8px 16px 0 rgba(28, 31, 33, 0.2);
  border-bottom-right-radius: 8px;
  border-bottom-left-radius: 8px;
}
.shop-cart .my-cart .cart-title-box {
  padding: 13px 12px;
  border-bottom: 1px solid #d3d6d9;
}
.shop-cart .my-cart .cart-title-box h2 {
  font-weight: bold;
  font-size: 14px;
  color: #1c1f21;
}
.shop-cart .my-cart .cart-title-box h5 {
  font-size: 12px;
  color: #9199a1;
}
.shop-cart .my-cart .cart-title-box h2,
.shop-cart .my-cart .cart-title-box h5 {
  height: 24px;
  line-height: 24px;
}
.l {
  float: left;
}
.r {
  float: right;
}
.shop-cart .my-cart .cart-wrap .cart-wrap-box {
  height: 284px;
  overflow-y: scroll;
}
.shop-cart .my-cart .cart-wrap .cart-wrap-box ul {
  width: 100%;
}
.shop-cart .my-cart .cart-wrap .cart-wrap-box ul li {
  padding: 12px;
  box-sizing: border-box;
}
.shop-cart .my-cart .cart-wrap .cart-wrap-box ul li a {
  width: auto;
  height: auto;
}
.shop-cart .my-cart .cart-wrap .cart-wrap-box ul li img {
  width: 100px;
  height: 56px;
  margin-right: 10px;
}
.shop-cart .my-cart .cart-wrap .cart-wrap-box ul li .content-box {
  width: 160px;
}
.shop-cart .my-cart .cart-wrap .cart-wrap-box ul li .content-box h3 {
  font-size: 12px;
  color: #07111b;
  line-height: 16px;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}
.shop-cart .my-cart .cart-wrap .cart-wrap-box ul li .content-box p {
  margin-top: 8px;
  height: 16px;
}
.shop-cart .my-cart .cart-wrap .cart-wrap-box ul li .content-box p span {
  font-size: 12px;
  line-height: 16px;
}
.shop-cart .my-cart .cart-wrap .cart-wrap-box ul li .del {
  /* display: none; */
  cursor: pointer;
}
.shop-cart .my-cart .more-box {
  padding: 16px 12px;
  border-top: 1px solid #d3d6d9;
}
.shop-cart .my-cart .more-box .show-box {
  height: 32px;
  line-height: 32px;
  font-size: 12px;
}
.shop-cart .my-cart .more-box .show-box .text {
  color: #93999f;
}
.shop-cart .my-cart .more-box .show-box .text a {
  color: #93999f;
}
.shop-cart .my-cart .more-box .go-cart {
  text-align: center;
  font-weight: bold;
  width: 86px;
  color: #fff;
  font-size: 12px;
  line-height: 16px;
  padding: 8px 16px;
  background: rgba(240, 20, 20, 0.8);
  border-radius: 16px;
  border: none;
}
.shop-cart .my-cart .cart-wrap .cart-wrap-box ul li:hover {
  background: #f8fafc;
}
.clearfix:after {
  content: "\0020";
  display: block;
  height: 0;
  clear: both;
  visibility: hidden;
}
.login-area .isLogined > li > a {
  display: block;
  width: 80px;
  height: 72px;
  line-height: 72px;
  color: #787d82;
  text-align: center;
  -webkit-transition: background-color 0.2s;
  -moz-transition: background-color 0.2s;
  transition: background-color 0.2s;
}

.user-card-box .user-card-item img {
  width: 32px;
  height: 32px;
  border-color: #4d5559;
  margin-top: -5px;
}
.set_btn img {
  border-radius: 50%;
  vertical-align: middle;
  display: inline-block;
  border: 0;
  /* background: url(/static/img/menu_icon.png) no-repeat 0 0; */
}
.user-card-box .g-user-card {
  /* visibility: hidden; */
  position: absolute;
  right: 0;
  top: 100%;
  z-index: 1000;
  width: 306px;
  padding: 24px;
  background-color: #fff;
  box-shadow: 0 8px 16px 0 rgba(7, 17, 27, 0.2);
  border-bottom-right-radius: 8px;
  border-bottom-left-radius: 8px;
  box-sizing: border-box;
}

.user-card-box .g-user-card .card-top {
  color: #93999f;
  position: relative;
}
.user-card-box .g-user-card .card-top a {
  display: inline-block;
  color: #93999f;
}
.user-card-box .g-user-card .card-top a img {
  float: left;
  width: 72px;
  height: 72px;
  border-radius: 50%;
  border: 2px solid #fff;
  margin-right: 12px;
}
.user-card-box .g-user-card .card-top .card-top-right-box {
  margin-top: 14px;
}
.user-card-box .g-user-card .card-top .name {
  display: inline-block;
  font-size: 16px;
  color: #07111b;
  width: 170px;
  line-height: 20px;
}
.text-ellipsis {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.user-card-box .g-user-card .user-center-box {
  margin-top: 16px;
  margin-bottom: 14px;
}
.user-card-box .g-user-card .user-center-box ul li {
  position: relative;
  width: 127px;
  background: #f8fafc;
  border-radius: 2px;
  color: #4d555d;
  margin: 0 2px 2px 0;
}
.user-card-box .g-user-card .user-center-box ul li a {
  width: 100%;
  height: 36px;
  line-height: 36px;
  padding-left: 12px;
  text-align: left;
  box-sizing: border-box;
  color: #1c1f21;
  font-size: 16px;
}
.user-card-box .g-user-card .user-center-box ul li .user-center-icon {
  position: relative;
  top: 3px;
  font-size: 16px;
  margin-right: 8px;
}
.user-card-box .g-user-card .card-sets {
  margin-top: 16px;
  font-size: 16px;
  line-height: 12px;
  height: 12px;
  text-align: center;
}
.user-card-box .g-user-card .card-sets a {
  color: #93999f;
}
.user-card-box .g-user-card .card-sets a:hover {
  color: #4d5559;
}
.user-card-box .g-user-card .user-center-box ul li:hover {
  background: #d9dde1;
}
.user-card-box .g-user-card .card-history {
  padding-bottom: 16px;
  margin-bottom: -1px;
  border-bottom: 1px solid #edf1f2;
  color: #787d82;
  font-size: 14px;
  padding: 7px 0px;
}
.nav-item li a:hover,
.login-area .isLogined > li > a:hover {
  color: teal !important;
}
.header-signin {
  padding: 0px 15px;
}

.login-area .isLogined .header-signin a {
  color: #4d555d !important;
  display: inline;
}
.login-area .isLogined .header-signin a:hover {
  color: teal !important;
}
</style>
