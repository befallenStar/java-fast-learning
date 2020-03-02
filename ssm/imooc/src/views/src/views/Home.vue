<template>
  <div class="home">
    <div class="bgfff banner-box" style="padding-top:30px;">
      <div class="g-banner pr">
        <div class="menuwrap"></div>
        <div class="menuContent">
          <div class="item" v-for="(item,index) of tags_page" :key="index" data-id="item.tagnum">
            <a :href="item.tagurl">
              <span class="group">{{item.tagtext}}</span>
              <i class="imv2-arrow1_r"></i>
            </a>
          </div>
        </div>

        <div class="g-banner-content">
          <div class="g-banner-box">
            <swiper :options="swiperOption" class="mouse-hover">
              <swiper-slide v-for="(slide, index) in swiperSlides" :key="index">
                <img :src="require('../assets/'+slide.imgpath+'.jpg')" height="382px" :title="slide.imgtext" />
              </swiper-slide>
              <div class="swiper-button-prev" slot="button-prev"></div>
              <div class="swiper-button-next" slot="button-next"></div>
              <div class="news-slider__pagination swiper-pagination" slot="pagination"></div>
            </swiper>
          </div>
        </div>
      </div>

      <div class="container-types container-recommend clearfix">
        <h3 class="types-title clearfix">
          <span>零基础就业</span>
          <span class="intro">零基础快速就业</span>
        </h3>
        <div class="path-list clearfix">
          <a href target="_blank" data-track="ljtj-1-1">
            <i class="i-web"></i>
            <p class="tit">Web前端攻城狮</p>
            <p class="desc">从未接触编程也可以学好</p>
          </a>
          <a href target="_blank" data-track="ljtj-1-3">
            <i class="i-java"></i>
            <p class="tit">Java攻城狮</p>
            <p class="desc">综合就业排名第一</p>
          </a>
          <a href target="_blank" data-track="ljtj-1-5">
            <i class="i-python"></i>
            <p class="tit">Python攻城狮</p>
            <p class="desc">应用领域最为广泛</p>
          </a>
          <a href target="_blank" data-track="ljtj-1-4">
            <i class="i-android"></i>
            <p class="tit">Android攻城狮</p>
            <p class="desc">移动市场份额第一</p>
          </a>
          <a href target="_blank" data-track="ljtj-1-2">
            <i class="i-php"></i>
            <p class="tit">PHP攻城狮</p>
            <p class="desc">Web开发首选语言</p>
          </a>
        </div>
      </div>
      <div class="container-types container-recommend clearfix">
        <h3 class="types-title clearfix">
          <span>职场提升</span>
          <span class="intro">1年以上开的经验</span>
        </h3>
        <div class="recommend-box">
          <a href target="_blank">
            <div class="recommend l box-java1"></div>
          </a>
          <a href target="_blank">
            <div class="recommend l box-fe"></div>
          </a>
          <a href target="_blank">
            <div class="recommend l box-java2"></div>
          </a>
        </div>
      </div>
    </div>
    <!-- 精品项目 -->
    <div class="bg000">
      <div class="container-types clearfix">
        <h3 class="types-title clearfix">
          <span>精品项目</span>
          <span class="intro">精品项目值得拥有</span>
        </h3>
        <div class="clearfix types-content">
          <div
            v-for="(item,index) in projects_hot"
            :key="index"
            class="index-card-container course-card-container container"
          >
            <a target="_blank" class="course-card" href>
              <div class="course-stat new">新课</div>
              <div class="course-card-top hashadow">
                <img class="course-banner" :src="item.img" />
                <div class="course-label">
                  <label v-for="(item1,index1) in item.tags" :key="index1+100">{{item1}}</label>
                </div>
              </div>
              <div class="course-card-content">
                <h3 class="course-card-name">{{item.title}}</h3>
                <div class="clearfix course-card-bottom">
                  <div class="course-card-info">
                    <span>中级</span>
                    <span>
                      <i class="imv2-set-sns"></i>
                      {{item.downs}}
                    </span>
                    <span class="r js-hover-evaluation">14人评价</span>
                  </div>
                  <div class="course-card-price sales" data-costprice="266.00">
                    ￥{{item.price}}
                    <span class="sales-tip">
                      限时优惠
                      <i class="sales-timer js-sales-end-timer" data-timer="1314054"></i>
                    </span>
                  </div>
                </div>
              </div>
            </a>
          </div>
        </div>
      </div>
    </div>
    <!-- 上新项目 -->
    <div class="bgfff">
      <div class="container-types container-path clearfix">
        <h3 class="types-title clearfix">
          <span>项目上新</span>
          <span class="intro">上新项目有惊喜</span>
        </h3>
        <div class="clearfix types-content js-path-content">
          <div v-for="(item,index) in projects_new" :key="index" class="course-path-container">
            <a target="_blank" href>
              <div class="course-banner">
                <div class="img-up" :style="'background-image: url('+item.img+');'"></div>
                <div class="img-mid" :style="'background-image: url('+item.img+');'"></div>
                <div class="img-down" :style="'background-image: url('+item.img+');'"></div>
              </div>
              <h4>{{item.title}}</h4>
              <p>{{item.desc}}</p>
              <div class="course-path-info">
                <span>￥{{item.price}}</span>
                <span style="margin-left:33px;">
                  <i class="el-icon-sold-out"></i>
                  {{item.downs}}
                </span>
              </div>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: "home",
  components: {},
  mounted() {
    // setInterval(() => {
    //     console.log('simulate async data')
    //     if (this.swiperSlides.length < 10) {
    //       this.swiperSlides.push(this.swiperSlides.length + 1)
    //     }
    //   }, 3000)
  },
  computed: {},
  data() {
    return {
      tags_page: [],
      swiperOption: {
        pagination: {
          el: ".news-slider__pagination",
          clickable: true
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev"
        },
        loop: true
      },
      swiperSlides: [],
      projects_hot: [
        {
          img: require("../assets/home/project/1.jpg"),
          title: "TypeScript 系统入门到项目实战 趁早学习提高职场竞争力",
          desc: "TypeScript 系统入门到项目实战 趁早学习提高职场竞争力",
          tags: ["Java", "Spring", "Mybatis"],
          price: 226.0,
          downs: 114
        },
        {
          img: require("../assets/home/project/2.jpg"),
          title: "TypeScript 系统入门到项目实战 趁早学习提高职场竞争力",
          tags: ["Java", "Spring", "Mybatis"],
          price: 226.0,
          downs: 114
        },
        {
          img: require("../assets/home/project/3.jpg"),
          title: "TypeScript 系统入门到项目实战 趁早学习提高职场竞争力",
          tags: ["Java", "Spring", "Mybatis"],
          price: 226.0,
          downs: 114
        },
        {
          img: require("../assets/home/project/4.jpg"),
          title: "TypeScript 系统入门到项目实战 趁早学习提高职场竞争力",
          tags: ["Java", "Spring", "Mybatis"],
          price: 226.0,
          downs: 114
        }
      ],
      projects_new: [
        {
          img: require("../assets/home/project/11.jpg"),
          title: "TypeScript 系统入门到项目实战 ",
          desc:
            "TypeScript 系统入门到项目实战 趁早学习提高职场竞争力趁早学习提高职场竞争力",
          tags: ["Java", "Spring", "Mybatis"],
          price: 226.0,
          downs: 114
        },
        {
          img: require("../assets/home/project/22.png"),
          title: "TypeScript 系统入门到项目实战 ",
          desc:
            "TypeScript 系统入门到项目实战 趁早学习提高职场竞争力趁早学习提高职场竞争力",
          tags: ["Java", "Spring", "Mybatis"],
          price: 226.0,
          downs: 114
        },
        {
          img: require("../assets/home/project/33.jpg"),
          title: "TypeScript 系统入门到项目实战 ",
          desc:
            "TypeScript 系统入门到项目实战 趁早学习提高职场竞争力趁早学习提高职场竞争力",
          tags: ["Java", "Spring", "Mybatis"],
          price: 226.0,
          downs: 114
        },
        {
          img: require("../assets/home/project/1.jpg"),
          title: "TypeScript 系统入门到项目实战 ",
          desc:
            "TypeScript 系统入门到项目实战 趁早学习提高职场竞争力趁早学习提高职场竞争力",
          tags: ["Java", "Spring", "Mybatis"],
          price: 226.0,
          downs: 114
        }
      ]
    };
  },
  created() {
    // console.log(window.location);
    this.loadPage();
  },
  methods: {
    loadPage() {
      let self = this;
      this.axios
        .get("/tags_page/findall")
        .then(res => {
          self.tags_page = res.data.data;
        })
        .catch(error => {
          console.log(error);
        });
      this.axios
        .get("/banner/findall")
        .then(res => {
          self.swiperSlides = res.data.data;
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
};
</script>
<style>
.bgfff {
  box-shadow: 0 2px 8px 0 rgba(7, 17, 27, 0.06);
  background-color: #fff !important;
  padding-bottom: 44px;
}
/* 零基础入门项目 */
.container-types.container-recommend {
  padding-top: 46px;
  padding-bottom: 0px;
}
.container-types {
  width: 1152px;
  margin-left: auto;
  margin-right: auto;
  position: relative;
  padding: 36px 0 38px;
}
.container-types .types-title {
  position: relative;
  font-size: 24px;
  color: #1c1f21;
  letter-spacing: 0px;
  line-height: 32px;
}
.container-types .types-title span {
  float: left;
  font-weight: bold;
}
.container-types .types-title .intro {
  margin-top: 6px;
  margin-left: 12px;
  font-weight: normal;
  font-size: 14px;
  color: #545c63;
  line-height: 20px;
}
.path-list {
  margin-top: 24px;
}
.path-list > a:first-child {
  margin-left: 0;
}
.path-list > a {
  float: left;
  margin-left: 18px;
  font-size: 0;
  display: block;
  width: 216px;
  padding-top: 15px;
  height: 65px;
  overflow: hidden;
  transition: all 0.3s;
  background: #f3f5f6;
  border-radius: 8px;
}
.path-list .i-web {
  background-position: center 0;
}
.path-list i {
  float: left;
  width: 50px;
  height: 50px;
  background: url(../assets/home/path-2019-9.png) no-repeat;
  background-size: 100%;
  margin-left: 12px;
  margin-right: 10px;
}
.path-list .tit {
  font-size: 16px;
  font-weight: bold;
  color: #1c1f21;
  letter-spacing: 1px;
  margin-top: 4px;
}
.path-list .desc {
  font-size: 12px;
  color: #1c1f21;
  line-height: 16px;
  margin-top: 2px;
  font-weight: 400;
}

.path-list .i-java {
  background-position: center -50px;
}

.path-list .i-python {
  background-position: center -100px;
}
.path-list .i-android {
  background-position: center -150px;
}
.path-list .i-php {
  background-position: center -200px;
}

.path-list > a:hover {
  box-shadow: 0px 4px 8px #0000001f;
}
/* 1年 */
.container-types .recommend-box {
  margin-top: 24px;
  margin-left: 0px;
}

.container-types .recommend-box .recommend {
  width: 368px;
  height: 90px;
  margin-right: 24px;
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}

.box-java1 {
  background: url("../assets/home/box-java1.png");
}
.box-fe {
  background: url("../assets/home/box-fe.png");
}
.box-java2 {
  background: url("../assets/home/box-java2.png");
}
.container-types .recommend-box a:last-child .recommend {
  margin-right: 0;
}
/* end */
.g-banner {
  height: 382px;
  margin-bottom: 44px;
  background-color: #93999f;
  box-shadow: 0 12px 24px 0 rgba(7, 17, 27, 0.2);
  position: relative;
  overflow: hidden;
  width: 1152px;
  margin: auto;
  border-radius: 8px;
}

.menuwrap {
  background-color: rgba(7, 17, 27, 0.5);
  opacity: 0.502;
  position: absolute;
  left: 0px;
  top: 0px;
  width: 216px;
  height: 382px;
  z-index: 1;
}
.menuContent {
  position: relative;
  float: left;
  width: 216px;
  height: 382px;
  z-index: 2;
  padding-top: 17px;
  box-sizing: border-box;
  background: #2b333b;
  border-bottom-left-radius: 4px;
  font-weight: 400;
}
.menuContent .item {
  height: 50px;
  line-height: 50px;
  font-size: 12px;
  cursor: pointer;
  padding-left: 12px;
  position: relative;
}
.menuContent .item:hover {
  color: #fff;
  background: #93999f;
}

.menuContent .item > a {
  display: block;
  color: rgba(255, 255, 255, 0.6);
  padding: 0 16px;
  border-top-left-radius: 4px;
  border-bottom-left-radius: 4px;
  /* border-bottom: 1px solid rgba(255,255,255,0.2); */
  height: 50px;
  transition: all 0.1s;
}
.menuContent .item:hover > a {
  color: #fff;
}

.menuContent .item .group {
  font-size: 14px;
}
/* 轮播改造 */

.home .swiper-button-next,
.home .swiper-button-prev {
  top: 40%;
  background-color: rgba(210, 210, 210, 0.6);
  background-size: 15px 15px;
  border-radius: 50%;
  width: 52px;
  height: 52px;
  transition: all 0.5s;
  outline: none;
  opacity: 0;
}
.home .mouse-hover .swiper-button-next,
.home .mouse-hover .swiper-button-prev {
  opacity: 1;
}
.home .swiper-button-next:hover,
.home .swiper-button-prev:hover {
  background-color: rgba(210, 210, 210, 0.8);
}
.home .swiper-button-next {
  background-image: url("data:image/svg+xml;charset=utf-8,%3Csvg%20xmlns%3D'http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg'%20viewBox%3D'0%200%2027%2044'%3E%3Cpath%20d%3D'M27%2C22L27%2C22L5%2C44l-2.1-2.1L22.8%2C22L2.9%2C2.1L5%2C0L27%2C22L27%2C22z'%20fill%3D'%23ffffff'%2F%3E%3C%2Fsvg%3E");
  right: 20px;
}
.home .swiper-button-prev {
  background-image: url("data:image/svg+xml;charset=utf-8,%3Csvg%20xmlns%3D'http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg'%20viewBox%3D'0%200%2027%2044'%3E%3Cpath%20d%3D'M0%2C22L22%2C0l2.1%2C2.1L4.2%2C22l19.9%2C19.9L22%2C44L0%2C22L0%2C22L0%2C22z'%20fill%3D'%23ffffff'%2F%3E%3C%2Fsvg%3E");
  left: 20px;
}
/* .swiper-container .swiper-button-next.swiper-button-disabled, .swiper-container .swiper-button-prev.swiper-button-disabled {
	opacity: 0;
} */

.news-slider__pagination {
  text-align: center;
  margin-top: 50px;
}
.news-slider__pagination .swiper-pagination-bullet {
  width: 13px;
  height: 10px;
  display: inline-block;
  background: #fff;
  opacity: 0.2;
  margin: 0 5px;
  border-radius: 20px;
  transition: opacity 0.5s, background-color 0.5s, width 0.5s;
  transition-delay: 0.5s, 0.5s, 0s;
}
.news-slider__pagination .swiper-pagination-bullet-active {
  opacity: 1;
  background: #ffffff;
  width: 100px;
  transition-delay: 0s;
}

.g-banner .g-banner-content {
  position: relative;
  float: left;
  width: 936px;
}
.g-banner .g-banner-content .g-banner-box {
  height: 382px;
}
.g-banner .g-banner-content .g-banner-box {
  position: relative;
  height: 316px;
}
/* 轮播END */
/* 上新 */
.bg000 {
  box-shadow: 0 2px 4px 0 rgba(7, 17, 27, 0.06);
}
.container-types .types-content {
  margin-top: 24px;
  margin-left: -24px;
}
.container-types .index-card-container {
  float: left;
  margin-left: 24px;
  border-radius: 4px;
  margin-bottom: 12px;
}
.course-card-container {
  width: 270px;
  height: 268px;
  position: relative;
  transition: 0.3s all linear;
}
.container {
  margin: 0 auto;
}
.course-card-container .course-stat.new {
  background-color: #ffaa00;
  background-image: linear-gradient(90deg, #ffaa00 17%, #f76b1c 100%);
}
.course-card-container .course-stat {
  position: absolute;
  border: 2px solid #ffffff;
  border-radius: 12px;
  top: 8px;
  left: -8px;
  z-index: 4;
  font-family: "dincondm";
  font-size: 12px;
  color: #ffffff;
  line-height: 20px;
  padding: 0 8px;
}
.course-card-container .course-card-top.hashadow {
  overflow: hidden;
}
.course-card-container .course-card-top {
  width: 270px;
  height: 148px;
  position: relative;
  border-radius: 8px;
  transition: all 0.3s;
}
.course-card-container .course-card-top .course-banner {
  width: 100%;
  height: 100%;
  background-color: #f3f5f7;
  border-radius: 8px;
}
.course-card-container .course-card-top .course-label {
  position: absolute;
  bottom: 6px;
  left: 8px;
  font-size: 12px;
  color: #ffffff;
  line-height: 16px;
}
.course-card-container .course-card-top .course-label label {
  display: inline-block;
  background: rgba(28, 31, 33, 0.6);
  border-radius: 4px;
  padding: 4px 8px;
  margin-right: 4px;
  margin-bottom: 2px;
  font-weight: 200;
}
label {
  cursor: default;
}
.course-card-container .course-card-content {
  padding: 8px;
}
.course-card-container .course-card-content .course-card-name {
  font-size: 16px;
  color: #07111b;
  line-height: 24px;
  word-wrap: break-word;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  transition: all 0.3s;
  font-weight: bold;
  height: 46px;
}
.course-card-container .course-card-content .course-card-bottom {
  position: relative;
}
.course-card-container .course-card-content .course-card-info {
  font-size: 12px;
  color: #9199a1;
  line-height: 18px;
  margin-top: 4px;
  font-weight: 400;
}
.course-card-container .course-card-content .course-card-info span {
  display: inline-block;
  margin-right: 12px;
}
.course-card-price {
  font-size: 12px;
  color: #545c63;
}
.course-card-price.sales {
  color: #f01414 !important;
  font-weight: bold;
}
.course-card-price .sales-tip {
  box-sizing: border-box;
  background: rgba(242, 13, 13, 0.08);
  border-radius: 2px;
  font-weight: 200;
  color: #f20d0d;
  padding: 0 4px;
  display: inline-block;
}
.course-card-container:hover .course-card-name {
  color: #f20d0d !important;
}

.container-path .types-content {
  margin-left: -24px;
}
.container-path .types-content .course-path-container {
  float: left;
  margin-left: 24px;
  margin-bottom: 24px;
  width: 564px;
  height: 148px;
}
.container-path .types-content .course-path-container .course-banner {
  float: left;
  position: relative;
  transition: all 0.3s;
  width: 140px;
  height: 140px;
  background-color: #f3f5f7;
  border-radius: 8px;
}

.container-path .types-content .course-path-container .course-banner .img-up,
.container-path .types-content .course-path-container .course-banner .img-mid,
.container-path .types-content .course-path-container .course-banner .img-down {
  margin: 0 auto;
  position: absolute;
  border-radius: 8px;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
  transition: all 0.3s;
  -moz-transition: all 0.3s;
  -webkit-transition: all 0.3s;
  -o-transition: all 0.3s;
}
.container-path .types-content .course-path-container .course-banner .img-up {
  left: 0px;
  top: 0;
  width: 140px;
  height: 140px;
  z-index: 3;
}
.container-path .types-content .course-path-container .course-banner .img-mid {
  top: 4px;
  left: 4px;
  width: 132px;
  height: 140px;
  opacity: 0.4;
  z-index: 2;
}
.container-path .types-content .course-path-container .course-banner .img-down {
  top: 8px;
  left: 8px;
  width: 124px;
  height: 140px;
  opacity: 0.2;
  z-index: 1;
}
.container-path .types-content .course-path-container h4 {
  margin: 8px 0;
  margin-left: 164px;
  font-size: 16px;
  color: #1c1f21;
  line-height: 20px;
  min-height: 20px;
  font-weight: bold;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}
.container-path .types-content .course-path-container p {
  margin-left: 164px;
  font-size: 14px;
  color: #545c63;
  letter-spacing: 0;
  line-height: 20px;
  height: 60px;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
}
.container-path .types-content .course-path-container .course-path-info {
  margin-left: 164px;
  font-size: 12px;
  color: #9199a1;
  height: 18px;
  line-height: 18px;
}

.container-path .types-content .course-path-container:hover h4 {
  color: #f20d0d;
}
.container-path
  .types-content
  .course-path-container:hover
  .course-banner
  .img-up {
  top: -5px;
  left: 0px;
}
.container-path
  .types-content
  .course-path-container:hover
  .course-banner
  .img-mid {
  top: 0px;
  left: 6px;
  width: 128px;
}
.container-path
  .types-content
  .course-path-container:hover
  .course-banner
  .img-down {
  top: 5px;
  left: 11px;
  width: 118px;
}
</style>
