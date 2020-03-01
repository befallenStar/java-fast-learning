<template>
  <div class="login">
    <div id="head" class="sig-head">
      <a href="/" target="_self" class="sig-img">码雀网</a>
    </div>
    <div class="login_main">
      <div class="login_warp">
        <!-- 登录表单 -->
        <div id="signin" class="rl-modal" v-if="islogin">
          <div class="rl-modal-header">
            <h1>
              <span class="active-title">登录</span>
              <span data-fromto="signin:signup" class="xa-showSignup" @click="islogin=false">注册</span>
            </h1>
          </div>
          <div class="rl-modal-body js-loginWrap">
            <div class="clearfix">
              <form id="signup-form" autocomplete="off">
                <div class="rlf-group pr">
                  <input
                    type="text"
                    v-model="phone"
                    maxlength="37"
                    name="phone"
                    autocomplete="off"
                    class="xa-emailOrPhone ipt ipt-email js-own-name"
                    placeholder="请输入登录手机号"
                  />
                  <p class="rlf-tip-wrap errorHint color-red" data-error-hint="请输入正确的手机号"></p>
                </div>
                <div class="rlf-group pr">
                  <a
                    href="javascript:void(0)"
                    hidefocus="true"
                    :class="showpwd==false?'proclaim-btn js-proclaim imv2-visibility_off is-pwd':'proclaim-btn js-proclaim imv2-visibility is-pwd'"
                    tabindex="-1"
                    @click="showpwd=(showpwd==false?true:false)"
                  ></a>
                  <input
                    :type="showpwd==false?'password':'text'"
                    name="password"
                    data-validate="require-password"
                    class="ipt ipt-pwd js-loginPassword js-pass-pwd"
                    placeholder="请输入密码"
                    maxlength="16"
                    autocomplete="off"
                    v-model="password"
                  />
                  <p
                    class="rlf-tip-wrap errorHint color-red"
                    data-error-hint="请输入6-16位密码,区分大小写,不能用空格"
                  ></p>
                </div>

                <div class="rlf-group clearfix form-control js-verify-row" style="display: block;">
                  <input
                    type="text"
                    name="verify"
                    class="ipt ipt-verify l"
                    data-validate="require-string"
                    data-callback="checkverity"
                    maxlength="4"
                    data-minlength="4"
                    placeholder="请输入验证码"
                    v-model="loginCode"
                  />
                  <a
                    href="javascript:void(0)"
                    hidefocus="true"
                    class="verify-img-wrap js-verify-refresh"
                  >
                    <img class="verify-img" :src="img_code_url" @click="changecode" />
                  </a>
                  <p class="rlf-tip-wrap errorHint color-red" data-error-hint="请输入正确验证码"></p>
                </div>
                <div class="rlf-group rlf-appendix form-control clearfix">
                  <div class="rlf-line r"></div>
                  <a
                    href="/imooc_user/resetPwd"
                    class="rlf-forget r"
                    target="_blank"
                    hidefocus="true"
                  >忘记密码？</a>
                </div>
                <p class="rlf-tip-globle color-red" id="signin-globle-error"></p>
                <div class="rlf-group clearfix">
                  <input
                    type="button"
                    value="登录"
                    hidefocus="true"
                    class="moco-btn moco-btn-red moco-btn-lg btn-full xa-login"
                    @click="login"
                  />
                </div>
              </form>
            </div>
            <div class="rl-model-footer">
              <div class="pop-login-sns clearfix">
                <span class="l">其他方式登录：</span>
                <a
                  href="javascript:void(0)"
                  hidefocus="true"
                  data-login-sns="/passport/user/tplogin?tp=weixin"
                  class="pop-sns-weixin r"
                >
                  <i class="imv2-weixin"></i>
                </a>
              </div>
            </div>
          </div>
          <div class="rl-model-footer">
            <div class="privacy_tip">
              登录即同意码雀网
              <a href="privacy.html" target="_blank">《隐私政策》</a>
            </div>
            <div class="erweima xa-showQrcode"></div>
          </div>
        </div>
        <!-- 登录表单结束 -->
        <!-- 注册表单 -->
        <div id="signup" class="rl-modal rl-model-signup" v-if="!islogin">
          <div class="rl-modal-header">
            <h1>
              <span data-fromto="signup:signin" class="xa-showSignin" @click="islogin=true">登录</span>
              <span class="active-title">注册</span>
            </h1>
          </div>
          <div class="rl-modal-body js-modal-body js-registerWrap">
            <form id="signup-form pr">
              <div class="rlf-group pr">
                <input
                  type="text"
                  maxlength="37"
                  v-model="phone"
                  name="email"
                  data-callback="checkusername"
                  data-validate="require-mobile-phone"
                  autocomplete="off"
                  class="ipt ipt-phone"
                  placeholder="请输入注册手机号"
                />
                <p class="rlf-tip-wrap errorHint color-red" data-error-hint="请输入正确的手机号"></p>
              </div>
              <div class="rlf-group clearfix form-control">
                <input
                  type="text"
                  maxlength="37"
                  v-model="msgCode"
                  name="email"
                  data-callback="checkusername"
                  data-validate="require-mobile-phone"
                  autocomplete="off"
                  class="ipt ipt-phone"
                  placeholder="请输入手机收到的验证码"
                />
                <a
                  href="javascript:void(0)"
                  hidefocus="true"
                  class="verify-msg-wrap js-verify-refresh"
                >获取验证码</a>
                <p class="rlf-tip-wrap errorHint color-red" data-error-hint="请输入正确的验证码"></p>
              </div>
              <div class="rlf-group clearfix form-control">
                <input
                  type="text"
                  v-model="loginCode"
                  name="verify"
                  class="ipt ipt-verify js-emailverify l"
                  data-validate="require-string"
                  data-callback="checkverity"
                  autocomplete="off"
                  maxlength="4"
                  data-minlength="4"
                  placeholder="请输入验证码"
                />
                <a
                  href="javascript:void(0)"
                  hidefocus="true"
                  class="verify-img-wrap js-verify-refresh"
                >
                  <img class="verify-img" :src="img_code_url" @click="changecode" />
                </a>
                <a
                  href="javascript:void(0)"
                  hidefocus="true"
                  class="icon-refresh js-verify-refresh"
                ></a>
                <p class="rlf-tip-wrap errorHint color-red" data-error-hint="验证码错误"></p>
              </div>
              <div class="rlf-group rlf-appendix form-control clearfix" style="margin-bottom:0">
                <label for="signup-protocol" class="rlf-autoin l" hidefocus="true">
                  <input type="checkbox" class="auto-cbx" id="signup-protocol" />同意
                  <a
                    class="ipt-agreement"
                    target="_blank"
                    href="https://www.diecolor.com"
                  >《码雀网注册协议》</a>&amp;
                  <a
                    href="https://www.diecolor.com/privacy.html"
                    class="ipt-agreement"
                    target="_blank"
                  >《隐私政策》</a>
                </label>
                <p
                  class="rlf-tip-wrap errorHint color-red rlf-tip-globle"
                  id="signup-globle-error"
                  data-error-hint="请同意码雀网注册协议"
                ></p>
              </div>
              <div class="rlf-group clearfix">
                <a
                  href="javascript:void(0)"
                  id="signup-btn"
                  hidefocus="true"
                  class="moco-btn moco-btn-red moco-btn-lg btn-full btn r"
                >注册</a>
              </div>
            </form>
          </div>
          <div class="rl-model-footer">
            <div class="pop-login-sns clearfix">
              <span class="l">其他方式登录：</span>
              <a
                href="javascript:void(0)"
                hidefocus="true"
                data-login-sns="/passport/user/tplogin?tp=weixin"
                class="pop-sns-weixin r"
              >
                <i class="imv2-weixin"></i>
              </a>
            </div>
          </div>
        </div>
        <!-- 注册表单结束 -->
      </div>
    </div>
    <div class="vright">
      <img draggable="false" class="moco-emoji" alt="©" :src="require('../assets/a9.png')" /> 2020 diecolor.com All Rights Reserved 苏ICP备13030149号
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      islogin: true,
      showpwd: false,
      phone: "15651002285",
      password: "123123",
      loginCode: "",
      msgCode:"",
      img_code_url: this.$store.state.server_baseurl + "/code"
    };
  },
  created() {
    this.changecode();
  },
  methods: {
    changecode() {
      this.img_code_url =
        this.$store.state.server_baseurl + "/code" + "?time=" + new Date();
    },
    login() {
      var self = this;
      const url = "/imooc_user/login";
      this.axios
        .post(url, {
          phone: this.phone,
          password: this.password,
          loginCode: this.loginCode
        })
        .then(resp => {
          if (resp.data.code == "12138") {
            self.$router.replace("/");
          }
          console.log(JSON.stringify(resp.data));
        });
    }
  }
};
</script>
<style>
@font-face {
  font-family: "imv2";
  src: url("../assets/fonts/imv2.ttf");
  font-weight: normal;
  font-style: normal;
}

/* .login{
   min-width: 480px;
    background-color: #f8fafc;
   
    padding-top: 0;
    -webkit-transition: -webkit-transform .3s ease;
    transition: transform .3s ease;
} */
.sig-head {
  height: 120px;
  text-align: center;
}
.sig-img {
  display: inline-block;
  width: 384px;
  height: 46px;
  background: url(../assets/login/login_logo.png) no-repeat center center;
  text-indent: 100%;
  white-space: nowrap;
  overflow: hidden;
  margin-top: 50px;
}
.login_main {
  min-height: auto;
  padding: 20px 0;
  width: 384px;
  margin: 0 auto;
}

.rl-modal {
  /* position: fixed; */
  background: #fff;
  z-index: 100000;
  width: 384px;
  padding-top: 10px;
  padding-bottom: 20px;
  /* left: 50%;
    top: 50%; */
  /* margin: -192px 0 0 -192px; */
  box-shadow: 0 12px 24px 0 rgba(28, 31, 33, 0.1);
  border-radius: 12px;
  transition: all 0.2s;
  -webkit-transition: all 0.2s;
  -moz-transition: all 0.2s;
  -o-transition: all 0.2s;
}

.login-wrap .rl-modal {
  position: relative;
  margin: 0 auto;
  left: 0;
  top: 0;
  z-index: 0;
}

.rl-modal-header {
  position: relative;
  padding: 0 20px 25px;
}
.rl-modal-header h1 {
  font-size: 16px;
  line-height: 49px;
  font-weight: 700;
  height: 49px;
  color: #787d82;
}
.rl-modal-header h1 span {
  float: left;
  width: 80px;
  text-align: center;
  height: 49px;
  line-height: 49px;
  cursor: pointer;
}

.rl-modal-header .active-title,
.rl-modal-header span:hover {
  color: #f20d0d;
}
.rl-modal-header .active-title:after,
.rl-modal-header span:hover:after {
  content: " ";
  width: 16px;
  height: 4px;
  line-height: 4px;
  background: #f20d0d;
  border-radius: 2px;
  display: block;
  margin: 0 auto;
}
.rl-modal-body {
  padding: 0 32px;
}
.clearfix {
  *zoom: 1;
}
.clearfix:after {
  content: "\0020";
  display: block;
  height: 0;
  clear: both;
  visibility: hidden;
}
.pr {
  position: relative;
}

.rl-modal .ipt {
  width: 100%;
  height: 48px;
  line-height: 20px;
  box-sizing: border-box;
  padding: 14px;
  box-shadow: 2px 0 5px 0 #fff;
  background: rgba(28, 31, 33, 0.06);
  border-radius: 8px;
  border: 0;
}
.color-red {
  color: #ef1300 !important;
}
.errorHint {
  height: 25px;
  line-height: 20px;
  font-size: 12px;
  color: #f01414;
}
.rlf-tip-wrap {
  font-size: 12px;
  height: 20px;
  clear: both;
}
.rl-modal .proclaim-btn {
  font-size: 23px;
  color: #b5b9bc;
  position: absolute;
  top: 12px;
  right: 14px;
}
[class^="imv2-"],
[class*=" imv2-"] {
  font-family: "imv2" !important;
  font-style: normal;
  font-weight: normal;
  font-variant: normal;
  text-transform: none;
  line-height: 1;
  letter-spacing: 0;
  -webkit-font-feature-settings: "liga";
  -moz-font-feature-settings: "liga=1";
  -moz-font-feature-settings: "liga";
  -ms-font-feature-settings: "liga" 1;
  font-feature-settings: "liga";
  -webkit-font-variant-ligatures: discretionary-ligatures;
  font-variant-ligatures: discretionary-ligatures;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
.imv2-visibility_off:before {
  content: "\e8f5";
}
.imv2-visibility:before {
  content: "\e8f4";
}
.rl-modal .form-control {
  position: relative;
}
.verify-msg-wrap {
  position: absolute;
  right: 2px;
  top: 8px;
  width: 84px;
  height: 32px;
  font-size: 16px;
}
.verify-img-wrap {
  position: absolute;
  right: 2px;
  top: 8px;
  width: 84px;
  height: 32px;
}
.rl-modal .verify-img {
  width: 80px;
  height: 32px;
}

.rlf-appendix .rlf-autoin,
.rlf-appendix .rlf-forget {
  color: #9199a1;
}
.rl-modal .rlf-tip-error {
  height: 30px;
  line-height: 30px;
}
.moco-btn {
  position: relative;
  display: inline-block;
  margin-bottom: 0;
  text-align: center;
  vertical-align: middle;
  touch-action: manipulation;
  text-decoration: none;
  box-sizing: border-box;
  background-image: none;
  border-radius: 0;
  -webkit-appearance: none;
  white-space: nowrap;
  outline: none;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  border-style: solid;
  border-width: 1px;
  cursor: pointer;
  -weibkit-transition: all 0.3s;
  -moz-transition: all 0.3s;
  transition: all 0.3s;
  color: #545c63;
  background-color: transparent;
  border-color: #9199a1;
  opacity: 1;
  padding: 7px 16px;
  font-size: 14px;
  line-height: 1.42857143;
  border-radius: 18px;
}
.moco-btn-red {
  border-style: solid;
  border-width: 1px;
  cursor: pointer;
  -weibkit-transition: all 0.3s;
  -moz-transition: all 0.3s;
  transition: all 0.3s;
  color: #fff;
  background-color: #f20d0d;
  border-color: #f20d0d;
  opacity: 1;
}
.moco-btn-lg {
  padding: 11px 32px;
  font-size: 16px;
  line-height: 24px;
  border-radius: 24px;
}
.btn-full {
  width: 100%;
  box-sizing: border-box;
}
.rl-model-footer {
  padding: 20px 30px 4px;
}
.pop-login-sns {
  text-align: center;
  font-size: 14px;
  margin-bottom: 6px;
}
.pop-login-sns .rlf-other {
  margin-left: 30px;
  margin-right: 24px;
  padding-right: 24px;
  display: inline-block;
  font-size: 14px;
  color: #f20d0d;
  text-align: left;
  line-height: 24px;
  border-right: 1px solid #1a1c1f21;
  cursor: pointer;
}
.l {
  float: left;
}
.privacy_tip {
  font-size: 12px;
  color: #717a84;
  text-align: center;
}
.privacy_tip a {
  font-size: 12px;
  color: #37f;
}
.privacy_tip a:visited {
  font-size: 12px;
  color: #37f;
}
.vright {
  text-align: center;
  color: #b5b9bc;
  font-size: 12px;
  line-height: 50px;
}
.moco-emoji {
  display: inline !important;
  margin: 0 !important;
}

.pop-login-sns a {
  font-size: 14px;
  margin-right: 21px;
  height: 20px;
  line-height: 20px;
  color: #c8cdd2;
  transition: color 0.2s;
}
.pop-login-sns i {
  font-size: 24px;
  vertical-align: -3px;
  transition: color 0.2s;
  color: #b5b9bc;
}
.imv2-weixin:before {
  content: "\e63e";
}
.imv2-weibo:before {
  content: "\e911";
}
.imv2-qq:before {
  content: "\e63b";
}
.rlf-tip-globle {
  font-size: 14px;
  height: 20px;
  line-height: 20px;
}

.rlf-appendix .auto-cbx {
  margin-right: 10px;
  vertical-align: -1px;
}

.rlf-appendix .ipt-agreement {
  color: #37f;
}
.rlf-tip-globle {
  font-size: 14px;
  height: 20px;
  line-height: 20px;
  clear: both;
}
.rl-model-footer span {
  color: #9199a1;
}
</style>