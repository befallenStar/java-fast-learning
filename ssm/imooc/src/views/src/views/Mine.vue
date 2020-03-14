<template>
  <div id="main">
    <div class="settings-cont clearfix">
      <div class="setting-left l">
        <div class="avator-wapper">
          <div class="avator-mode">
            <el-upload
              class="avator-img"
              :show-file-list="true"
              width="92"
              height="92"
              action="/api/imooc_user/upload/img"
              :on-success="handleAvatarSuccess"
              name="img"
              :value="$store.state.current_user.img"
            >
              <img
                v-if="$store.state.current_user.img"
                :src="$store.state.server_baseurl+$store.state.current_user.img"
                class="avatar"
              />
              <img
                v-else
                :src="$store.state.server_baseurl+$store.state.current_user.img"
                class="avatar"
              />
            </el-upload>
          </div>
          <div class="des-mode">
            <p class="des-mode-info">{{$store.state.current_user.nickname}}</p>
            <p class="des-mode-info">账号：{{$store.state.current_user.phone}}</p>
            <p class="des-mode-info">注册时间：{{$store.state.current_user.createTime}}</p>
            <p class="des-mode-info">最后更新：{{$store.state.current_user.lastUpdate}}</p>
          </div>
        </div>
      </div>
      <div class="setting-right">
        <div class="setting-right-wrap wrap-boxes settings">
          <div class="right-container l">
            <div class="right-title" id="right-title">
              <el-tabs v-model="activeName">
                <el-tab-pane label="个人信息" name="first">
                  <div class="personal" id="personal">
                    <div class="common-title" style="wdith:100px;text-align:right;">
                      <a
                        href="javascript:void(0)"
                        style="display:block;"
                        v-show="!edit"
                        @click="edit=true"
                      >编辑</a>
                      <el-button v-show="edit" size="mini" type="primary" @click="updateuser">保存</el-button>
                      <el-button v-show="edit" size="mini" @click="edit=false">取消</el-button>
                    </div>
                    <div class="info-wapper">
                      <ul>
                        <li>
                          <div class="info-box clearfix">
                            <label class="pull-left c">昵称</label>
                            <div class="pull-left e">
                              <span v-show="!edit">{{$store.state.current_user.nickname}}</span>
                              <el-input
                                v-show="edit"
                                placeholder="请输入昵称"
                                v-model="$store.state.current_user.nickname"
                                clearable
                              ></el-input>
                            </div>
                          </div>
                        </li>
                        <li>
                          <div class="info-box clearfix">
                            <label class="pull-left c">性别</label>
                            <div class="pull-left e">
                              <span v-show="!edit">{{$store.state.current_user.sex}}</span>
                              <span v-show="edit">
                                <el-radio v-model="$store.state.current_user.sex" label="男">男</el-radio>
                                <el-radio v-model="$store.state.current_user.sex" label="女">女</el-radio>
                              </span>
                            </div>
                          </div>
                        </li>
                      </ul>
                    </div>
                  </div>
                </el-tab-pane>
                <el-tab-pane label="我的项目" name="my">
                  <el-card v-if="showMy">
                    <el-card v-for="(item,index) in my" :key="index">
                      <img :src="$store.state.server_baseurl+item.projectCover" />
                      <!-- 
                        .card-header{}
                        .card-header .title{}
                        .card-header .subtitle{}
                        .card-body{}
                        .card-body .keywords{}
                        .card-body .desc{}
                        .card-footer{}
                        .card-footer .footer-info{}
                      -->
                      <div class="card-header">
                        <div class="title">{{item.projectTitle}}</div>
                        <div class="subtitle">{{item.projectSubtitle}}</div>
                      </div>
                      <div class="card-body">
                        <div class="keywords">关键词：{{item.projectKeywords}}</div>
                        <div class="desc">简介：{{item.projectDesc}}</div>
                      </div>
                      <div class="card-footer">
                        <span class="footer-info">浏览数：{{item.browseCount}}</span>
                        &emsp;&emsp;&emsp;&emsp;
                        <span
                          class="footer-info"
                        >下载数：{{item.downloadCount}}</span>
                        &emsp;&emsp;&emsp;&emsp;
                        <span
                          class="footer-info"
                        >创建时间：{{item.createTime}}</span>
                        &emsp;&emsp;&emsp;&emsp;
                        <span
                          class="footer-info"
                        >最后更新：{{item.lastUpdate}}</span>
                      </div>
                    </el-card>
                  </el-card>
                  <span v-if="!showMy">你还没有创建项目哦</span>
                </el-tab-pane>
                <el-tab-pane label="我的订单" name="order">
                  <el-card v-if="showOrder">
                    <el-card v-for="(item,index) in order" :key="index"></el-card>
                  </el-card>
                  <span v-if="!showOrder">你还没有订单信息哦</span>
                </el-tab-pane>
                <el-tab-pane label="购买记录" name="purchase_history">
                  <el-card v-if="showPurchaseHistory">
                    <el-card v-for="(item,index) in purchase_history" :key="index"></el-card>
                  </el-card>
                  <span v-if="!showPurchaseHistory">你还没有购买项目哦</span>
                </el-tab-pane>
                <el-tab-pane label="下载记录" name="download_history">
                  <el-card v-if="showDownloadHistory">
                    <el-card v-for="(item,index) in download_history" :key="index"></el-card>
                  </el-card>
                  <span v-if="!showDownloadHistory">你还没有下载记录哦</span>
                </el-tab-pane>
              </el-tabs>
            </div>
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
      current_user: "",
      edit: false, //编辑状态
      tabPosition: "left",
      activeName: "first",
      isLogined: false,
      my: [],
      showMy: true,
      order: [],
      showOrder: true,
      purchase_history: [],
      showPurchaseHistory: true,
      download_history: [],
      showDownloadHistory: true
    };
  },
  created() {
    this.activeName = this.$route.query.activeName;
    this.loaddata();
  },
  methods: {
    handleAvatarSuccess(response, file, fileList) {
      // this.$store.state.current_user.img = URL.createObjectURL(file.raw);
      console.log(response);
    },
    updateuser() {
      let uploaduser = {
        id: this.current_user.id,
        nickname: this.current_user.nickname,
        sex: this.current_user.sex
      };

      this.axios.post("/imooc_user/update", uploaduser).then(resp => {
        if (resp.data.code == "12138") {
          this.$store.state.current_user = resp.data.data;
          this.current_user = resp.data.data;
          this.edit = false;
          this.$message({
            message: "保存成功",
            type: "success"
          });
        } else {
          this.$message.error(resp.data.msg);
        }
      });
    },

    onSubmit() {
      console.log("submit!");
    },
    loaddata() {
      this.current_user = this.$store.state.current_user;
      let self = this;
      this.axios
        .get("/project/my")
        .then(res => {
          self.my = res.data.data;
          if (null === self.my) self.showMy = false;
        })
        .catch(error => {
          console.log(error);
        });
      this.axios
        .get("/purchase_history/my")
        .then(res => {
          self.purchase_history = res.data.data;
          if (null === self.purchase_history) self.showPurchaseHistory = false;
        })
        .catch(error => {
          console.log(error);
        });
      this.axios
        .get("/download_history/my")
        .then(res => {
          self.download_history = res.data.data;
          if (null === self.download_history) self.showDownloadHistory = false;
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
};
</script>
<style scoped>
.pt15 {
  padding-top: 15px;
}
.course-action {
  position: absolute;
  top: 0;
  width: 200px;
  height: 100%;
  border-left: 1px solid #d9dde1;
  right: 0;
  text-align: center;
}
.course-money {
  width: 150px;
  height: 100%;
  padding-left: 24px;
  text-align: center;
  color: #93999f;
  font-size: 16px;
  box-sizing: border-box;
  line-height: 16px;
}
.del-box {
  margin-left: 16px;
  width: 340px;
}
.del-box .course-name {
  word-break: break-word;
  color: #07111b;
  font-size: 14px;
  margin-bottom: 8px;
  line-height: 22px;
}
.del-box .price-btn-box {
  font-size: 12px;
  line-height: 12px;
}
.del-box .price-btn-box .truepay-text {
  color: #93999f;
  margin-right: 5px;
}
.del-box .price-btn-box .course-little-price {
  color: #f01414;
}
.myOrder-course {
  position: relative;
  margin-top: 25px;
  margin-left: 40px;
}
.course-del {
  width: 520px;
  border-right: 1px solid #d9dde1;
  position: relative;
}

.l {
  float: left;
}
.myOrder-list li dd:first-child {
  border-top: none;
  margin-top: 0;
  padding-top: 0;
}
ol,
ul {
  list-style: none;
}
.myOrder {
  border-radius: 15px;
  width: 100%;
  height: 200px;
  background: #f8fafc;
}
.right-container .right-title h2 {
  margin-right: 24px;
  float: left;
  font-size: 16px;
  color: #07111b;
  line-height: 32px;
  font-weight: 700;
}
.right-container .right-title {
  margin-bottom: 24px;
  overflow: hidden;
}
.right-container {
  width: 992px;
}
.courseitem .info-box .catog-points .continute-btn {
  display: inline-block;
  position: absolute;
  right: 0;
  font-size: 14px;
  border: none;
  color: #fff;
  width: 104px;
  height: 36px;
  line-height: 36px;
  text-align: center;
  background: rgba(240, 20, 20, 0.6);
  border-radius: 18px;
}
.moco-ico-btn {
  position: absolute;
  right: 130px;
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
.courseitem .info-box .catog-points span {
  font-size: 14px;
  line-height: 36px;
  color: #4d555d;
  margin-right: 36px;
}
.courseitem .info-box .catog-points span i {
  color: #93999f;
  font-style: normal;
}
.courseitem .info-box .catog-points span a {
  color: #4d555d;
}
.courseitem .info-box .catog-points span {
  font-size: 14px;
  line-height: 36px;
  color: #4d555d;
  margin-right: 36px;
}
.courseitem .info-box .catog-points {
  display: flex;
  flex-direction: row;
  align-items: center;
}
.courseitem .info-box .study-info span {
  line-height: 24px;
  font-size: 14px;
  color: #4d555d;
  margin-right: 24px;
}
.courseitem .info-box .study-info span.i-left {
  color: #f20d0d;
}
.courseitem .info-box .study-info span {
  line-height: 24px;
  font-size: 14px;
  color: #4d555d;
  margin-right: 24px;
}
.courseitem .info-box .study-info {
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-bottom: 12px;
}
.courseitem .info-box .title .hd {
  font-size: 20px;
  color: #07111b;
  font-weight: 700;
  line-height: 36px;
  max-width: 315px;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
.courseitem .info-box .title span:first-child {
  background: #f5f7fa;
  border-radius: 2px;
  width: 62px;
  height: 20px;
  text-align: center;
  line-height: 20px;
  font-size: 12px;
  color: #9199a1;
  font-weight: 400;
  margin-right: 12px;
}
.courseitem .info-box .title {
  display: flex;
  flex-direction: row;
  align-items: center;
}
.courseitem .info-box {
  display: flex;
  flex-direction: column;
  position: relative;
  padding-bottom: 28px;
  width: 730px;
}
.imgs {
  width: 200px;
  height: 120px;
}
.courseitem .img-box {
  width: 200px;
  margin-right: 30px;
}
.courseitem {
  position: relative;
  display: flex;
  flex-direction: row;
  margin-top: 28px;
}
.allcourse-content {
  width: 100%;
  box-sizing: border-box;
}
.all-course-main {
  margin-top: 28px;
}
.c-tab {
  font-size: 16px;
  color: #545c63;
  height: 52px;
  line-height: 52px;
  margin-top: 18px;
}
.u-container {
  min-height: 589px;
}
.c {
  width: 120px;
  line-height: 20px;
  padding: 20px 0;
  text-align: center;
  background-color: #f3f5f7;
  color: #07111b;
  font-weight: 700;
}
.e {
  margin-left: 20px;
  width: 755px;
  height: 30px;
  padding-top: 15px;
  padding-bottom: 15px;
  line-height: 30px;
}

.pull-left {
  float: left;
}
.setting-profile .info-box div {
  width: 708px;
  margin-left: 8px;
  line-height: 20px;
  padding: 20px 0 20px 22px;
}
.setting-profile .info-box {
  margin-bottom: 12px;
}
.info-wapper li {
  margin-bottom: 10px;
}
.info-wapper {
  margin: 24px auto 24px 40px;
}
.settings-cont {
  width: 1200px;
  margin: 0 auto;
  padding: 30px 0;
}
.settings-cont .setting-left {
  width: 216px;
  background-color: #f8fafc;
}
.settings-cont .setting-left .avator-wapper {
  padding: 32px 0 24px;
}
.settings-cont .setting-left .avator-mode {
  position: relative;
  width: 100px;
  height: 100px;
  box-sizing: border-box;
  border: 4px solid #d9dde1;
  border-radius: 50px;
  margin: 0 auto;
  text-align: center;
  overflow: hidden;
}
img {
  width: 92px;
  height: 92px;
}
.settings-cont .setting-left .avator-mode .update-avator {
  font-size: 12px;
  position: absolute;
  width: 100%;
  left: 0;
  bottom: -30px;
  transition: bottom 0.3s;
  -moz-transition: bottom 0.3s;
  -webkit-transition: bottom 0.3s;
  -o-transition: bottom 0.3s;
}
.settings-cont .setting-left .des-mode {
  font-size: 14px;
  text-align: center;
}
.settings-cont .setting-left .des-mode .des-mode-info {
  margin-top: 30px;
  color: #9199a1;
}
.settings-cont .setting-left .list-wapper h2 {
  font-size: 16px;
  line-height: 24px;
  margin: 12px 24px;
  font-weight: 700;
}
.settings-cont .setting-left .list-wapper .line {
  height: 1px;
  background-color: #d9dde1;
  margin: 0 24px;
}
.settings-cont .setting-left .list-wapper .menu {
  padding: 10px 0 25px;
}
.settings-cont .setting-left .list-wapper .menu a {
  display: block;
  position: relative;

  height: 48px;
  line-height: 48px;
  transition: background-color 0.3s ease;
}
a:link,
a:visited {
  color: #1c1f21;
}
.settings-cont .setting-left .list-wapper .menu a.on {
  color: #fff;
  background-color: #f01414;
}
a.tt:hover {
  color: red;
  cursor: pointer;
}
.settings-cont .setting-right {
  float: left;
  margin-left: 48px;
  width: 936px;
  box-sizing: border-box;
  background-color: #fff;
}
.settings-cont .setting-right-wrap {
  min-height: 550px;
}
.common-title {
  line-height: 40px;
  font-size: 16px;
  font-weight: 700;
}
.common-title a {
  color: teal;
  font-weight: 400;
  font-size: 14px;
  margin-right: 20px;
}
.settings-cont .setting-right {
  float: left;
  margin-left: 48px;
  width: 936px;
  box-sizing: border-box;
  background-color: #fff;
}
.card-header {
  width: 60%;
}
.card-header .title {
  font-size: 24px;
}
.card-header .subtitle {
  font-size: 18px;
}
.card-body {
  width: 60%;
}
.card-body .keywords {
  font-size: 14px;
  color: #9199a1;
}
.card-body .desc {
  font-size: 14px;
  color: #9199a1;
}
.card-footer {
  width: 60%;
}
.card-footer .footer-info {
  font-size: 14px;
  color: #9199a1;
}
</style>