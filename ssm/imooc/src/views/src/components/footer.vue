<template>
  <div class="footer-container">
    <div class="footer-wrap idx-width">
      <div class="footer-sns clearfix">
        <div class="l">
          <a href="javascript:void(0);" class="footer-sns-weixin" target="_blank" title="微信">
            <i class="footer-sns-weixin-expand"></i>
          </a>
          <p>官方公众号</p>
        </div>
        <div class="l">
          <a
            href="http://weibo.com/u/3306361973"
            class="footer-sns-weibo hide-text"
            target="_blank"
            title="新浪微博"
          >新浪微博</a>
          <p>官方微博</p>
        </div>
      </div>
    </div>
    <div class="footer-link">
      <!-- <a href="/about/us" target="_blank" title="关于我们">关于我们</a> -->
      <a href="/index/companytrain" target="_blank" title="企业合作">企业合作</a>
      <a href="/about/job" target="_blank" title="人才招聘">人才招聘</a>
      <a href="/about/contact" target="_blank" title="联系我们">联系我们</a>
      <a href="/help" target="_blank" title="帮助中心">帮助中心</a>
      <a href="/user/feedback" target="_blank" title="意见反馈">意见反馈</a>
      <a href="/about/friendly" target="_blank" title="友情链接">友情链接</a>
    </div>
    <div class="footer-copyright">
      <p>
        <img draggable="false" class="moco-emoji" alt="©" src="../assets/a9.png" />
        &nbsp;2020&nbsp;diecolor.com&nbsp;&nbsp;苏ICP备13030149号-1
        <a
          href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=32010202010179"
          target="_blank"
          style="color:#93999F;font-size:12px;margin:0 5px !important;"
        >
          <i class="beian"></i>苏公网安备32010202010179号
        </a>
      </p>
    </div>
  </div>
</template>
<style scoped>
.footer a {
  display: inline-block;
  font-size: 14px;
  color: #4d555d;
  line-height: 28px;
  margin: 0;
  margin-right: 36px;
}
.footer-container {
  position: relative;
  width: 1152px;
  margin: 0 auto;
  margin-bottom: 20px;
}
.footer .footer-wrap {
  position: absolute;
  width: auto;
  right: 0;
  bottom: 0;
}
.idx-width {
  width: 1200px;
  margin: 0 auto;
}
.footer .footer-sns {
  padding: 0;
}
.footer-sns {
  padding-top: 30px;
  text-align: center;
}
.clearfix:after {
  content: "\0020";
  display: block;
  height: 0;
  clear: both;
  visibility: hidden;
}
.footer .footer-sns > div:first-child {
  margin-right: 32px;
}
.l {
  float: left;
}
.footer-sns a {
  display: inline-block;
  height: 32px;
  width: 32px;
  vertical-align: middle;
  background-image: url(../assets/idx-btm.png);
  background-repeat: no-repeat;
  margin: 0 9px;
}
.footer-sns-weixin i {
  position: absolute;
  display: none;
  width: 172px;
  height: 212px;
  left: -77px;
  bottom: 40px;
  background: url(../assets/elevator.png) no-repeat 0 0;
}
.footer .footer-sns p {
  font-size: 12px;
  color: #4d555d;
  line-height: 24px;
  margin-top: 4px;
}

.footer-sns-weibo {
  background-position: 0 -221px;
}
.hide-text {
  text-indent: 100%;
  white-space: nowrap;
  overflow: hidden;
}
.footer-sns-weixin {
  position: relative;
  background-position: -52px -221px;
}
.footer .footer-link {
  text-align: left;
  border: none;
  padding: 0;
}

.footer-link a {
  margin: 0 10px;
  color: #99a1a6;
}
.footer-copyright {
  color: #99a1a6;
}

.footer .footer-link a:hover {
  color: #07111b;
}
.moco-emoji {
  /* width: 18px;
  height: 18px; */
  display: inline !important;
  margin: 0 !important;
}
.footer .beian {
  background: url(../assets/beianicon.png) no-repeat 0 0;
  width: 16px;
  height: 16px;
  vertical-align: middle;
  background-size: cover;
  display: inline-block;
  margin-right: 4px;
  margin-top: -4px;
}
.footer .footer-sns a:hover {
  color: #b7bbbf;
}
.footer-sns-weixin:hover {
  background-position: -52px -262px;
}
.footer-sns-weixin:hover i {
  display: block;
}
.footer-sns-weibo:hover {
  background-position: 0 -262px;
}
</style>