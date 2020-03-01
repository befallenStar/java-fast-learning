<template>
  <div class="details">
    <div class="course-infos-top" :style="'background-image:url('+bgimg+')'">
      <div class="info-wrap">
        <div class="extra">
          <div class="course-collect clearfix js-course-collect l" data-type="0" data-cid="401">
            <i class="el-icon-star-off"></i>
            <span>收藏</span>
          </div>
          <!-- 分销的分享不同于普通分享 -->
          <div
            class="share-action l bdsharebuttonbox bg bdshare-button-style0-16"
            data-bd-bind="1580643675794"
          >
            <a href="javascript:;" class="share sz-weixin" data-cmd="weixin" title="分享到微信"></a>
            <a href="javascript:;" class="share sz-weibo" data-cmd="tsina" title="分享到新浪微博"></a>
            <a href="javascript:;" data-cmd="qzone" class="share sz-qq" title="分享到QQ空间"></a>
          </div>
        </div>
        <div class="title-box">
          <h1>Vue Element＋Node.js开发企业通用管理后台系统</h1>
          <h2>慕课网首门基于Element的中后台课程，一套中小型企业通用的后台管理系统</h2>
        </div>
      </div>
      <div class="fixed-wrap" style="bottom:-64px">
        <div class="con">
          <div class="time-price clearfix">
            <div class="no-discount clearfix l">
              <div class="sale-timer l clearfix">
                <i class="name l">限时优惠</i>
                <div class="timer js-sale-timer l">截止至2月9日</div>
              </div>
              <div class="ori-price l">￥348.00</div>
              <div class="sale-price l">原价￥399.00</div>
            </div>
            <div class="can-huabei l">
              <a href target="_blank">花呗付款</a>
            </div>
            <div class="can-baitiao l">
              <a href target="_blank">京东白条</a>
            </div>
          </div>
          <div class="info-bar clearfix" style="margin-top:0px">
            <span>难度</span>
            <span class="nodistance">高级</span>
            <i class="imv2-dot_samll"></i>
            <span>时长</span>
            <span class="nodistance">17小时</span>
            <i class="imv2-dot_samll"></i>
            <span>学习人数</span>
            <span class="nodistance">751</span>
            <i class="imv2-dot_samll"></i>
            <span>综合评分</span>
            <span class="nodistance">10.00</span>
          </div>

          <div class="btns">
            <a
              href="javascript:;"
              class="js-buy-trigger red-btn gobuy"
              data-cid="401"
              data-pay="0"
              id="buy-trigger"
            >立即购买</a>
            <a href="javascript:;" class="js-addcart addcart" data-cid="401" data-type="1">加购物车</a>
          </div>
        </div>
      </div>
    </div>
    <div class="course-infos-t">
      <div class="comp-tab-t js-comp-tab">
        <ul class="clearfix">
          <li class="comp-tab-item-first comp-tab-item active">
            <a href="/class/401.html#Anchor">项目介绍</a>

            <div class="borderLine"></div>
          </li>

          <li class="comp-tab-item">
            <a
              href="javascript:void(0)"
              class="zhuge_chapter"
              data-href="/class/chapter/401.html#Anchor"
            >
              章节目录
              <img class="try-mark" src="/static/module/class/chapter/img/try-mark.png" alt />
            </a>
            <div class="borderLine"></div>
          </li>
          <li class="comp-tab-item">
            <a
              href="javascript:void(0)"
              class="zhuge_consult"
              data-href="/class/401.html#Prchor"
            >售前咨询</a>
            <span>51</span>
            <div class="borderLine"></div>
          </li>
          <li class="comp-tab-item">
            <a
              href="javascript:void(0)"
              class="zhuge_evaluate"
              data-href="/class/evaluation/401.html#Anchor"
            >用户评价</a>
            <span>151</span>
            <div class="borderLine"></div>
          </li>

          <li class="comp-tab-item">
            <a href="/class/401.html#Envir">环境参数</a>
          </li>
        </ul>
      </div>
      <!-- 介绍 -->
      <div
        class="info-video clearfix"
        style="background-image: url(//img.mukewang.com/szimg/5dc9048b099306cb18001000.jpg);"
      >
        <div class="video-dark-box l clearfix" style="display: block">
          <div class="js-video-btn videoBtn l">
            <div>
              <i class="sz-play js-enter-tryMedia"></i>
            </div>
            <p>观看试看视频</p>
          </div>
          <div id="videoInfo" class="l">
            <div
              class="slimScrollDiv"
              style="position: relative; overflow: hidden; width: auto; height: 312px;"
            >
              <div id="content" style="overflow: hidden; width: auto; height: 312px;">
                <div class="con">
                  <div class="info-name">Vue Element+Node.js开发企业通用管理后台系统</div>
                  <div
                    class="info-desc"
                  >综合应用 Vue 和 Node 技术，基于 Element-UI 组件库搭建“小慕读书“的管理后台，通过 Node 实现了电子书上传和解析功能以及权限管理。课程对 Vue 和 Node 有较为深入的应用，不仅会教大家如何实现功能，更会讲解技术背后的原理，帮助大家做到举一反三。课程面向中高级开发者，提供完整的开发文档和API支持，让大家可以快速上手实战</div>
                </div>

                <div class="line"></div>
              </div>
            </div>
          </div>
        </div>

        <div class="teacher-right-box r">
          <div class="teacher">
            <div class="whiteBorder"></div>
            <a href target="_blank">
              <div class="headPortrait">
                <img src="//img.mukewang.com/user/5b40c3d8000153d311101084-100-100.jpg" />
              </div>
              <div class="nickname">Sam</div>
            </a>
            <p>高级前端工程师</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      bgimg: require("../assets/detail/header_bg.png")
    };
  }
};
</script>
<style>
.course-infos-top {
  width: 100%;
  position: relative;
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}

.course-infos-top .info-wrap {
  width: 1152px;
  margin: 0 auto;
  padding-top: 72px;
  padding-bottom: 136px;
  position: relative;
}
.course-infos-top .info-wrap .extra {
  position: absolute;
  right: 0;
  top: 12px;
}
.course-infos-top .info-wrap .extra .course-collect {
  margin-right: 36px;
  cursor: pointer;
}
.course-infos-top .info-wrap .extra .course-collect span {
  font-size: 12px;
  margin-left: 4px;
}
.course-infos-top .info-wrap .extra .course-collect i {
  font-size: 20px;
}
.course-infos-top .info-wrap .extra .share-action {
  border-radius: 16px;
  padding-right: 14px;
  height: 32px;
  cursor: pointer;
  font-size: 0;
}
.bdshare-button-style0-16 {
  zoom: 1;
}
.course-infos-top .info-wrap .extra .share-action.bg {
  padding-left: 2px;
  /* background-color: #a1a1a1; */
  background-image: linear-gradient(
    90deg,
    rgba(255, 255, 255, 0.6) 0,
    rgba(255, 255, 255, 0.1) 100%
  );
}

.bdshare-button-style0-16 a,
.bdshare-button-style0-16 .bds_more {
  float: left;
  font-size: 12px;
  padding-left: 17px;
  line-height: 16px;
  height: 16px;
  background-image: url(../assets/detail/icons_0_16.png);
  background-repeat: no-repeat;
  cursor: pointer;
  margin: 6px 6px 6px 0;
}

.bdshare-button-style0-16 a:hover {
  color: #333;
  opacity: 0.8;
  filter: alpha(opacity=80);
}
.course-infos-top .info-wrap .extra .share-action .share {
  display: inline-block;
  float: none;
  padding: 0;
  line-height: 32px;
  margin: 0 0 0 12px;
  width: auto;
  height: auto;
  vertical-align: top;
  background-image: none;
  font-size: 20px;
  background-repeat: no-repeat;
  color: rgba(255, 255, 255, 0.8);
  transition: all 0.3s;
  -moz-transition: all 0.3s;
  -webkit-transition: all 0.3s;
  -o-transition: all 0.3s;
}
.course-infos-top .info-wrap .extra .share-action .share:hover {
  color: #fff;
}
.sz-weixin:before {
  content: "\e60a";
}
.sz-weibo:before {
  content: "\e609";
}
.sz-qq:before {
  content: "\e60b";
}
[class*=" sz-"],
[class^="sz-"] {
  font-family: sz !important;
  font-style: normal;
  font-weight: 400;
  font-variant: normal;
  text-transform: none;
  line-height: 1;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.course-infos-top .info-wrap .title-box {
  width: 1000px;
  margin: 0 auto;
}
h1,
h2,
h3,
h4,
h5,
h6 {
  font-size: 100%;
  font-weight: 400;
  font-family: "Microsoft YaHei";
}

.course-infos-top .info-wrap .title-box h1 {
  text-align: center;
  font-size: 40px;
  color: #fff;
  line-height: 48px;
  text-shadow: 0 2px 4px rgba(28, 31, 33, 0.6);
}
.course-infos-top .info-wrap .title-box h2 {
  text-align: center;
  font-size: 16px;
  color: #fff;
  line-height: 24px;
  text-shadow: 0 2px 4px rgba(28, 31, 33, 0.6);
  margin-top: 8px;
}

.course-infos-top .fixed-wrap {
  width: 1152px;
  min-height: 128px;
  position: absolute;
  left: 50%;
  margin-left: -576px;
  bottom: -64px;
  background-image: url(../assets/detail/fixed_bg.png);
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center;
  border-radius: 18px;
  box-shadow: 0 8px 16px 0 rgba(28, 31, 33, 0.1);
}

.course-infos-top .fixed-wrap .con {
  position: relative;
  width: 100%;
  height: 100%;
  padding: 32px 40px;
  box-sizing: border-box;
}

.course-infos-top .fixed-wrap .con .time-price .no-discount .ori-price {
  font-size: 32px;
  color: #f01414;
  line-height: 32px;
  font-weight: 700;
}

.course-infos-top .fixed-wrap .con .time-price .can-huabei {
  margin-top: 3px;
  margin-left: 12px;
  line-height: 12px;
  padding: 6px 10px;
  /* background-color: #6c61d3; */
  background-image: linear-gradient(90deg, #6c61d3 0, #53a0fd 100%);
  border-radius: 12px;
}
.course-infos-top .fixed-wrap .con .time-price a {
  font-size: 12px;
  color: #fff;
}
.course-infos-top .fixed-wrap .con .time-price .can-baitiao {
  margin-top: 3px;
  margin-left: 17px;
  line-height: 12px;
  padding: 6px 10px;
  background-image: linear-gradient(90deg, #ff323f 0, #f76469 100%);
  border-radius: 12px;
}

.course-infos-top .fixed-wrap .con .info-bar span {
  font-size: 12px;
  color: #545c63;
  line-height: 24px;
  font-weight: 700;
  padding-right: 8px;
}
.course-infos-top .fixed-wrap .con .info-bar span.nodistance {
  padding-right: 0;
  font-weight: 400;
}

.course-infos-top .fixed-wrap .con .info-bar i {
  font-size: 16px;
  color: #545c63;
  line-height: 16px;
  padding: 0 4px;
  vertical-align: middle;
}

.course-infos-top .fixed-wrap .con .btns {
  position: absolute;
  top: 40px;
  right: 40px;
  font-size: 0;
}
.course-infos-top .fixed-wrap .con .btns a {
  display: inline-block;
}
.course-infos-top .fixed-wrap .con .btns .red-btn {
  background: #f01414;
  border-radius: 24px;
  font-size: 16px;
  color: #fff;
  letter-spacing: 0;
  line-height: 24px;
  font-weight: 700;
  padding: 12px 48px;
  transition: all 0.3s;
  -moz-transition: all 0.3s;
  -webkit-transition: all 0.3s;
  -o-transition: all 0.3s;
}
.course-infos-top .fixed-wrap .con .btns .gobuy {
  margin-right: 16px;
}

.course-infos-top .fixed-wrap .con .btns .addcart {
  background: rgba(240, 20, 20, 0.1);
  border-radius: 24px;
  font-size: 16px;
  color: #f20d0d;
  letter-spacing: 0;
  line-height: 24px;
  font-weight: 700;
  padding: 12px 48px;
  position: relative;
  transition: all 0.3s;
  -moz-transition: all 0.3s;
  -webkit-transition: all 0.3s;
  -o-transition: all 0.3s;
}
.course-infos-top .info-wrap .extra .course-collect i,
.course-infos-top .info-wrap .extra .course-collect span {
  transition: all 0.3s;
  -moz-transition: all 0.3s;
  -webkit-transition: all 0.3s;
  -o-transition: all 0.3s;
  float: left;
  color: rgba(255, 255, 255, 0.4);
  line-height: 32px;
}
.course-infos-top .info-wrap .extra .course-collect:hover i,
.course-infos-top .info-wrap .extra .course-collect:hover span {
  color: #fff;
}

.course-infos-top .fixed-wrap .con .time-price .sale-timer {
  padding: 6px 12px;
  background-image: linear-gradient(
    90deg,
    rgba(255, 0, 105, 0.99) 0,
    #ff7a00 99%
  );
  border-radius: 16px;
}
.course-infos-top .fixed-wrap .con .time-price .sale-timer i {
  color: #fff;
  font-style: normal;
  padding: 0 1px;
}

.course-infos-top .fixed-wrap .con .time-price .sale-timer .name {
  font-size: 14px;
  font-weight: 700;
  color: #fff;
  line-height: 20px;
}
.course-infos-top .fixed-wrap .con .timer {
  font-size: 14px;
  color: #545c63;
  letter-spacing: 0;
  text-align: left;
  line-height: 22px;
  font-weight: 700;
}
.course-infos-top .fixed-wrap .con .time-price .sale-timer div {
  color: #fff;
  font-size: 14px;
  line-height: 20px;
  margin-left: 8px;
}

.course-infos-top .fixed-wrap .con .time-price .sale-price {
  font-size: 14px;
  color: #93999f;
  font-weight: 700;
  line-height: 32px;
  margin-left: 8px;
  margin-right: 2px;
  text-decoration: line-through;
}

.course-infos-t {
  padding-top: 64px;
  overflow: hidden;
}

.course-infos-t .comp-tab-t {
  padding: 28px 0 32px 0;
  text-align: center;
}

.course-infos-t .comp-tab-t ul {
  display: inline-block;
}
.course-infos-t .comp-tab-item {
  height: 40px;
  position: relative;
  font-size: 16px;
  line-height: 27px;
  float: left;
  margin-left: 60px;
}
.course-infos-t .comp-tab-item-first {
  margin-left: 0;
}
.course-infos-t .comp-tab-item a {
  font-weight: 700;
  font-size: 16px;
  line-height: 40px;
  color: #545c63;
  vertical-align: text-bottom;
}
.course-infos-t .comp-tab-item.active a {
  color: #f20d0d;
}

.course-infos-t .comp-tab-item .borderLine {
  display: none;
  position: absolute;
  width: 16px;
  height: 2px;
  top: 40px;
  left: 50%;
  margin-left: -8px;
  background: #f20d0d;
}

.course-infos-t .comp-tab-item.active .borderLine {
  display: block;
}

.course-infos-t .comp-tab-item:hover a {
  color: #f20d0d;
}

.course-infos-t .comp-tab-item:hover .borderLine {
  display: block;
}

.course-infos-t .comp-tab-item .sub-tag,
.course-infos-t .comp-tab-item .try-mark {
  position: absolute;
  top: 0;
  right: -30px;
  width: 30px;
  height: 18px;
}

.course-infos-t .comp-tab-item span {
  position: absolute;
  top: 0;
  left: 67px;
  font-size: 12px;
  color: #93999f;
}

.course-infos-t .info-video {
  width: 1152px;
  height: 448px;
  box-sizing: border-box;
  margin: 0 auto 48px auto;
  text-align: left;
  padding: 64px 0 72px 0;
  box-shadow: 0 4px 8px 0 rgba(7, 17, 27, 0.1);
  border-radius: 16px;
  display: block;
  background: #4d4d4d;
  background-size: cover;
  background-position: center;
}
.course-infos-t .video-dark-box {
  width: 862px;
  height: 312px;
  box-sizing: border-box;
}
.course-infos-t .video-dark-box .videoBtn {
  width: 96px;
  margin: 96px 100px 86px 100px;
  cursor: pointer;
}
.course-infos-t .video-dark-box .videoBtn .sz-play {
  font-size: 96px;
  color: #fff;
  opacity: 0.3;
  animation: mymove 2s infinite;
  -moz-animation: mymove 2s infinite;
  -webkit-animation: mymove 2s infinite;
  -o-animation: mymove 2s infinite;
  transition: 0.3s;
}
.course-infos-t .video-dark-box .videoBtn p {
  font-size: 16px;
  color: #fff;
  line-height: 24px;
  text-align: center;
  margin-top: 8px;
}
.course-infos-t .video-dark-box #videoInfo {
  width: 564px;
  height: 100%;
  position: relative;
  overflow: hidden;
  box-sizing: border-box;
}
.course-infos-t .video-dark-box #videoInfo #content {
  position: relative;
  padding-right: 95px;
  display: table;
}
.course-infos-t .video-dark-box #videoInfo #content .con {
  display: table-cell;
  vertical-align: middle;
}
.course-infos-t .video-dark-box #videoInfo #content .info-name {
  font-weight: 700;
  font-size: 24px;
  color: #fff;
  line-height: 36px;
  margin-bottom: 16px;
}
.course-infos-t .video-dark-box #videoInfo #content .info-desc {
  font-size: 14px;
  color: #fff;
  line-height: 28px;
}
.course-infos-t .video-dark-box #videoInfo #content .line {
  position: absolute;
  top: 0;
  right: 3px;
  width: 2px;
  height: 100%;
  background: rgba(255, 255, 255, 0.4);
}

.course-infos-t .teacher-right-box {
  width: 272px;
  height: 312px;
  padding-top: 49px;
  position: relative;
}
.course-infos-t .teacher-right-box .teacher {
  width: 160px;
  margin: 0 auto;
  position: relative;
  text-align: center;
}
.course-infos-t .teacher-right-box .teacher .whiteBorder {
  width: 140px;
  height: 140px;
  border-radius: 50%;
  margin: 0 auto 12px auto;
  background: #fff;
}
.course-infos-t .teacher-right-box .teacher .headPortrait {
  width: 132px;
  height: 132px;
  left: 14px;
  top: 5px;
  border-radius: 50%;
  overflow: hidden;
  position: absolute;
}
.course-infos-t .teacher-right-box .teacher .headPortrait img {
  width: 100%;
  height: 100%;
}
.course-infos-t .teacher-right-box .teacher .nickname {
  font-weight: 700;
  font-size: 20px;
  color: #fff;
  line-height: 30px;
  margin-bottom: 4px;
}
.course-infos-t .teacher-right-box .teacher p {
  font-size: 14px;
  color: #fff;
  line-height: 22px;
}
.sz-play:before {
  content: "\e912";
}
.course-infos-t .video-dark-box .videoBtn:hover .sz-play {
  opacity: 0.75;
}
</style>