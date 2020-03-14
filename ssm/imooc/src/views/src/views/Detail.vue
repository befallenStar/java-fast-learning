<template>
  <div class="details">
    <div
      class="course-infos-top"
      :style="'background:url('+$store.state.server_baseurl+project.projectCover+')'"
    >
      <div class="info-wrap">
        <div class="title-box">
          <h1>{{project.projectTitle}}</h1>
          <h2>{{project.projectSubtitle}}</h2>
        </div>
      </div>
      <div class="fixed-wrap" style="bottom:-64px">
        <div class="con">
          <div class="time-price clearfix">
            <div class="no-discount clearfix l">
              <div class="ori-price l">￥{{project.projectPrice}}</div>
            </div>
          </div>
          <div class="info-bar clearfix" style="margin-top:0px">
            <span>浏览量</span>
            <span class="nodistance">{{project.browseCount}}</span>
            &emsp;&emsp;
            <span>下载量</span>
            <span class="nodistance">{{project.downloadCount}}</span>
            &emsp;&emsp;
            <span>最后更新</span>
            <span class="nodistance">{{project.lastUpdate}}</span>
          </div>
          <div class="btns">
            <el-button type="primary" plain round @click="addShoppingCart">加入购物车</el-button>
          </div>
        </div>
      </div>
    </div>
    <!-- 介绍 -->
    <el-tabs
      v-model="activeName"
      style="  padding-top: 64px;overflow: hidden;width:1152px;left:50%;margin-left:-576px;position:absolute;"
    >
      <el-tab-pane label="项目介绍" name="production">
        <div
          class="info-video clearfix"
          style="background-image: url(//img.mukewang.com/szimg/5dc9048b099306cb18001000.jpg);"
        >
          <div class="video-dark-box l clearfix" style="display: block">
            <div id="videoInfo" class="l">
              <div
                class="slimScrollDiv"
                style="position: relative; overflow: hidden; width: auto; height: 312px; left: 80px;"
              >
                <div id="content" style="overflow: hidden; width: auto; height: 312px; left:60px;">
                  <div class="con">
                    <div class="info-name">{{project.projectSubtitle}}</div>
                    <div class="info-desc">{{project.projectDesc}}</div>
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
      </el-tab-pane>
      <el-tab-pane label="资源列表" name="material">
        <el-table :data="project.projectMaterialList" height="400px" border stripe>
          <el-table-column prop="id" label="id" width="80px" :resizable="false"></el-table-column>
          <el-table-column prop="materialTitle" label="材料名称" width="250px"></el-table-column>
          <el-table-column prop="materialCreateTime" label="上传时间" width="250px"></el-table-column>
          <el-table-column
            prop="projectMaterialType.typeName"
            label="材料类别"
            width="150px"
            :resizable="false"
          ></el-table-column>
          <el-table-column prop="materialSuffix" label="材料后缀" width="120px" :resizable="false"></el-table-column>
          <el-table-column label="操作" width="300px" fixed="right">
            <template slot-scope="scope">
              <el-button type="primary" round icon="el-icon-download" style="cursor:default">
                <a
                  :href="$store.state.server_baseurl+'project_material/download/'+scope.row.id"
                  style="color:white;"
                >下載</a>
              </el-button>
              <el-button type="danger" round icon="el-icon-delete">刪除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>
export default {
  data() {
    return {
      bgimg: require("../assets/detail/header_bg.png"),
      id: this.$route.query.id,
      project: "",
      activeName: "production"
    };
  },
  created() {
    this.loadData();
  },
  computed: {
    projects() {
      return this.$store.state.projects;
    }
  },
  methods: {
    refreshShoppingCart() {
      this.axios
        .get("/shopping_cart/my")
        .then(res => {
          console.log(res.data);
          this.$store.commit("saveProjects", res.data.data);
        })
        .catch(error => {
          console.log(error);
        });
    },
    addShoppingCart() {
      this.axios
        .get("/shopping_cart/insert/" + this.project.id)
        .then(res => {
          if ("12138" == res.data.code) {
            this.$message({
              message: "添加成功",
              type: "success"
            });
            this.refreshShoppingCart();
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    loadData() {
      let self = this;
      this.axios
        .get("/project/detail", {
          id: self.id
        })
        .then(res => {
          self.project = res.data.data;
        })
        .catch(error => {
          console.log(error);
        });
    }
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
.info-video {
  width: 1152px;
  height: 448px;
  box-sizing: border-box;
  margin-bottom: 48px;
  text-align: left;
  padding: 64px 0 72px 0;
  box-shadow: 0 4px 8px 0 rgba(7, 17, 27, 0.1);
  border-radius: 16px;
  display: block;
  background: #4d4d4d;
  background-size: cover;
  background-position: center;
}
.video-dark-box {
  width: 762px;
  height: 312px;
  box-sizing: border-box;
}
.video-dark-box .videoBtn {
  width: 96px;
  margin: 96px 100px 86px 100px;
  cursor: pointer;
}
.video-dark-box .videoBtn .sz-play {
  font-size: 96px;
  color: #fff;
  opacity: 0.3;
  animation: mymove 2s infinite;
  -moz-animation: mymove 2s infinite;
  -webkit-animation: mymove 2s infinite;
  -o-animation: mymove 2s infinite;
  transition: 0.3s;
}
.video-dark-box .videoBtn p {
  font-size: 16px;
  color: #fff;
  line-height: 24px;
  text-align: center;
  margin-top: 8px;
}
.video-dark-box #videoInfo {
  width: 764px;
  height: 100%;
  position: relative;
  overflow: hidden;
  box-sizing: border-box;
}
.video-dark-box #videoInfo #content {
  position: relative;
  padding-right: 155px;
  display: table;
}
.video-dark-box #videoInfo #content .con {
  display: table-cell;
  vertical-align: middle;
  text-align: center;
}
.video-dark-box #videoInfo #content .info-name {
  font-weight: 700;
  font-size: 24px;
  color: #fff;
  line-height: 36px;
  margin-bottom: 16px;
}
.video-dark-box #videoInfo #content .info-desc {
  font-size: 14px;
  color: #fff;
  line-height: 28px;
}
.video-dark-box #videoInfo #content .line {
  position: absolute;
  top: 0;
  right: 3px;
  width: 2px;
  height: 100%;
  background: rgba(255, 255, 255, 0.4);
}
.teacher-right-box {
  width: 272px;
  height: 312px;
  padding-top: 49px;
  position: relative;
}
.teacher-right-box .teacher {
  width: 160px;
  margin: 0 auto;
  position: relative;
  text-align: center;
}
.teacher-right-box .teacher .whiteBorder {
  width: 140px;
  height: 140px;
  border-radius: 50%;
  margin: 0 auto 12px auto;
  background: #fff;
}
.teacher-right-box .teacher .headPortrait {
  width: 132px;
  height: 132px;
  left: 14px;
  top: 5px;
  border-radius: 50%;
  overflow: hidden;
  position: absolute;
}
.teacher-right-box .teacher .headPortrait img {
  width: 100%;
  height: 100%;
}
.teacher-right-box .teacher .nickname {
  font-weight: 700;
  font-size: 20px;
  color: #fff;
  line-height: 30px;
  margin-bottom: 4px;
}
.teacher-right-box .teacher p {
  font-size: 14px;
  color: #fff;
  line-height: 22px;
}
.sz-play:before {
  content: "\e912";
}
.video-dark-box .videoBtn:hover .sz-play {
  opacity: 0.75;
}
</style>