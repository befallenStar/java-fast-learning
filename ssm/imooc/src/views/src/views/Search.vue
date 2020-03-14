<template>
  <div class="search-main">
    <div class="search-header js-search-header">
      <div class="search-form">
        <input
          type="text"
          class="search-form-ipt js-search-ipt l"
          v-model="keyword"
          placeholder="请输入想搜索的内容"
        />
        <el-button @click="search" type="primary" style="height:48px;background-color:teal;">搜索</el-button>
        <el-checkbox v-model="ambiguous" style="margin-top:12px;">模糊搜索</el-checkbox>
        <div class="search-tips-area js-search-tips"></div>
      </div>
    </div>
    <div class="search-body">
      <div class="search-content">
        <div class="search-classify">
          <div class="all_content">
            <!-- 全站结果，课程内容 -->
            <a href="/search/?words=Vue" class="active">
              全站结果
              <span>（{{result.total}}）</span>
            </a>
          </div>
          <div class="tab_con">
            <!-- tab选项 -->
            <!-- <a href="/search/?words=Vue" class="tab-item active">全部</a>
            <a href="/search/?type=course&amp;words=Vue" class="tab-item">项目</a>
            <a href="/search/?type=column&amp;words=Vue" class="tab-item">源码</a>
            <a href="/search/wenda?words=Vue" class="tab-item">视频</a>
            <a href="/search/article?words=Vue" class="tab-item">文档</a>-->
            <span>找到相关内容 {{result.total}} 个</span>
          </div>
        </div>
        <div class="search-course-list">
          <div
            class="search-item js-search-item clearfix"
            v-for="(item,index) in result.list"
            :key="index"
          >
            <a :href="'/detail?id='+item.id" class="js-zhuge-allResult js-result-item item-img l">
              <img :src="$store.state.server_baseurl+item.projectCover" />
            </a>
            <div class="item-detail l">
              <a
                :href="'/detail?id='+item.id"
                class="js-zhuge-allResult item-title js-result-item js-item-title"
              >{{item.projectTitle}}</a>
              <br />
              <p
                class="js-zhuge-allResult item-subtitle js-result-item js-item-subtitle"
              >{{item.projectSubtitle}}</p>
              <p class="item-desc">{{item.projectDesc}}</p>
              <div class="item-classify">
                <span>{{item.projectKeywords}}</span>
                <i class="imv2-set-sns"></i>
                <span>浏览量：{{item.browseCount}}</span>
                <span>下载量：{{item.downloadCount}}</span>
              </div>
            </div>
          </div>
        </div>
        <div class="page">
          <el-pagination
            background
            layout="prev, pager, next"
            :total="result.total"
            :page-size="result.pageSize"
            :current-page="currentPage"
            @current-change="currentChange"
          ></el-pagination>
        </div>
      </div>
      <div class="search-recommend r">
        <div class="hot-search search-labels">
          <div class="title">热搜关键词</div>
          <div class="labels-con js-zhuge-searchHot">
            <a href="/search?keyword=Vue" class="label">Vue</a>
            <a href="/search?keyword=Python" class="label">Python</a>
            <a href="/search?keyword=Java" class="label">Java</a>
            <a href="/search?keyword=flutter" class="label">flutter</a>
            <a href="/search?keyword=springboot" class="label">springboot</a>
            <a href="/search?keyword=docker" class="label">docker</a>
            <a href="/search?keyword=React" class="label">React</a>
            <a href="/search?keyword=小程序" class="label">小程序</a>
          </div>
        </div>
        <div class="jiuyeban-recommend">
          <div class="title">金职位</div>
          <div class="direct-con js-zhuge-searchRecommend">
            <a class="direct" target="_blank" href="//class.imooc.com/sale/newfe">
              <div
                class="img"
                :style="'background-image:url('+require('../assets/search/fe.png')+')'"
              ></div>
              <div class="text">
                <div>Web前端攻城狮</div>
                <p>踏入IT行业从此开始</p>
              </div>
            </a>
            <a class="direct" target="_blank" href="//class.imooc.com/sale/newjava">
              <div
                class="img"
                :style="'background-image:url('+require('../assets/search/java.png')+')'"
              ></div>
              <div class="text">
                <div>Java攻城狮</div>
                <p>全球3大编程语言之一</p>
              </div>
            </a>
            <a class="direct" target="_blank" href="//class.imooc.com/sale/newandroid">
              <div
                class="img"
                :style="'background-image:url('+require('../assets/search/android.png')+')'"
              ></div>
              <div class="text">
                <div>Android攻城狮</div>
                <p>5G物联网通万物</p>
              </div>
            </a>
            <a class="direct" target="_blank" href="//class.imooc.com/sale/php">
              <div
                class="img"
                :style="'background-image:url('+require('../assets/search/php.png')+')'"
              ></div>
              <div class="text">
                <div>PHP攻城狮</div>
                <p>打通前后端一步到位</p>
              </div>
            </a>
            <a class="direct" target="_blank" href="//class.imooc.com/sale/python">
              <div
                class="img"
                :style="'background-image:url('+require('../assets/search/python.png')+')'"
              ></div>
              <div class="text">
                <div>Python攻城狮</div>
                <p>爬虫大数据抢占先机</p>
              </div>
            </a>
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
      keyword: "",
      ambiguous: false,
      size: 10,
      result: "",
      createUser: "",
      currentPage: 1
    };
  },
  created() {
    this.keyword = this.$route.query.keyword;
    this.search();
  },
  methods: {
    currentChange(val) {
      this.currentPage = val;
      this.search();
    },
    search() {
      let self = this;
      let param = {
        keyword: this.keyword,
        index: this.currentPage,
        size: this.size
      };
      if (this.ambiguous) param.param = this.keyword;
      this.axios
        .get("/project/find", param)
        .then(res => {
          self.result = res.data.data;
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
};
</script>
<style>
.search-main {
  padding-top: 0;
  background: #f3f5f6;
  overflow: hidden;
  padding-bottom: 28px;
}

.search-main .search-header {
  height: 120px;
  width: 100%;
  padding-top: 24px;
  box-sizing: border-box;
  background: #fff;
  box-shadow: 0 2px 4px 0 rgba(28, 31, 33, 0.06);
}
.search-main .search-header .search-form {
  height: 48px;
  width: 840px;
  margin: 0 auto;
  position: relative;
}

.search-main,
.search-main input {
  font-family: "Microsoft YaHei", "Helvetica Neue", "微软雅黑", Tahoma, Arial,
    sans-serif;
}
.search-main .search-header .search-form .search-form-ipt {
  font-size: 16px;
  color: #93999f;
  width: 736px;
  line-height: 48px;
  height: 48px;
  padding: 12px;
  background: #f1f1f1;
  box-sizing: border-box;
  border-top-left-radius: 4px;
  border-bottom-left-radius: 4px;
}

.search-main .search-body {
  margin: 0 auto;
  width: 1168px;
  padding-top: 16px;
  box-sizing: border-box;
}
.search-main .search-body .search-content {
  float: left;
  width: 800px;
}
.search-main .search-body .search-content .search-classify {
  background: #fff;
}

.search-main .search-body .search-content .search-classify .all_content {
  font-size: 0;
  padding: 20px 32px;
  border-bottom: 1px solid #f3f5f6;
}
.search-main .search-body .search-content .search-classify .all_content a {
  display: inline-block;
  font-size: 16px;
  color: #545c63;
  text-align: center;
  line-height: 40px;
  font-weight: 700;
  margin-right: 40px;
}
.search-main
  .search-body
  .search-content
  .search-classify
  .all_content
  a.active {
  color: teal;
}
.search-main .search-body .search-content .search-classify .all_content a span {
  font-size: 12px;
  color: #9199a1;
  text-align: center;
  line-height: 40px;
  font-weight: 700;
}

.search-main .search-body .search-content .search-classify .tab_con {
  display: -webkit-flex;
  display: flex;
  position: relative;
  align-items: center;
  padding: 16px 32px;
  border-bottom: 1px solid #f3f5f6;
}

.search-main .search-body .search-content .search-classify .tab_con .tab-item {
  height: 22px;
  font-size: 14px;
  color: #545c63;
  text-align: center;
  line-height: 22px;
  margin-right: 8px;
  padding: 0 12px;
  border: 1px solid transparent;
  border-radius: 12px;
  transition: all 0.3s;
  -moz-transition: all 0.3s;
  -webkit-transition: all 0.3s;
  -o-transition: all 0.3s;
}

.search-main
  .search-body
  .search-content
  .search-classify
  .tab_con
  .tab-item.active {
  border: 1px solid teal;
  color: teal;
}

.search-main
  .search-body
  .search-content
  .search-classify
  .tab_con
  .tab-item:hover {
  color: teal;
}

.search-course-list {
  width: 800px;
  box-sizing: border-box;
  background: #fff;
  border-bottom-left-radius: 8px;
  border-bottom-right-radius: 8px;
  overflow: hidden;
  padding-bottom: 16px;
}

.search-item {
  width: 800px;
  margin-left: 0;
  background: #fff;
  padding: 16px 32px;
  box-sizing: border-box;
  position: relative;
  border-bottom: 1px solid rgba(43, 51, 59, 0.1);
  line-height: 1;
}
.search-item .item-img {
  display: inline-block;
  width: 160px;
  height: 120px;
  margin-right: 32px;
  border-radius: 4px;
  position: relative;
  overflow: hidden;
}
.search-item .item-img img {
  width: 160px;
  height: 120px;
  border-radius: 4px;
}

.search-item .item-img .type {
  position: absolute;
  top: 0;
  left: 0;
  width: 60px;
  height: 22px;
  line-height: 22px;
  font-size: 12px;
  color: #fff;
  text-align: center;
  background: #545c63;
  border-radius: 0 0 4px 0;
}
.search-item .item-detail {
  width: 484px;
}
.search-item .item-detail .item-title {
  font-size: 16px;
  line-height: 32px;
  font-weight: 700;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  display: inline-block;
  color: #1c1f21;
}
.search-item .item-detail .item-title:hover {
  color: teal;
}
.search-item .item-detail .item-subtitle {
  font-size: 14px;
  line-height: 28px;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  display: inline-block;
  color: #1c1f21;
}
.search-item .item-detail .item-desc {
  max-height: 48px;
  color: #4d555d;
  font-size: 12px;
  line-height: 24px;
  text-overflow: ellipsis;
  word-break: break-all;
  word-wrap: break-word;
  overflow: hidden;
  text-overflow: -o-ellipsis-lastline;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}
.search-item .item-detail .item-classify {
  margin-top: 4px;
}
.search-item .item-detail .item-classify span {
  line-height: 24px;
  color: #4d555d;
  font-size: 12px;
  padding-right: 24px;
  vertical-align: middle;
}
.search-item .item-detail .item-classify span a {
  color: #4d555d;
  font-size: 12px;
  vertical-align: initial;
  transition: all 0.3s;
  -moz-transition: all 0.3s;
  -webkit-transition: all 0.3s;
  -o-transition: all 0.3s;
}
.search-item .item-detail .item-classify span:last-child {
  padding-right: 12px;
}
.page {
  margin: 25px 0 auto;
  overflow: hidden;
  clear: both;
  text-align: center;
}
.page span,
.page-disabled {
  display: inline-block;
  padding: 0 4px;
  min-width: 24px;
  height: 32px;
  line-height: 32px;
  font-size: 14px;
  color: #c8cdd2;
  text-align: center;
}
.page span,
.page-disabled {
  display: inline-block;
  padding: 0 4px;
  min-width: 24px;
  height: 32px;
  line-height: 32px;
  font-size: 14px;
  color: #c8cdd2;
  text-align: center;
}
.page a {
  display: inline-block;
  margin: 0 8px;
  padding: 0 4px;
  min-width: 24px;
  line-height: 32px;
  font-size: 14px;
  color: #4d555d;
  text-align: center;
  border-radius: 16px;
  -webkit-transition: border-color 0.2s;
  -moz-transition: border-color 0.2s;
  transition: border-color 0.2s;
}
.search-item:last-child {
  border-bottom: none;
}
.page a.text-page-tag.active {
  background: #4d555d;
  color: #fff;
}
.search-main .search-body .search-recommend {
  width: 320px;
}
.search-main .search-body .search-recommend .search-labels {
  margin-bottom: 16px;
}
.search-main .search-body .search-recommend .search-labels .title {
  margin-bottom: 12px;
  font-size: 16px;
  font-weight: 700;
  color: #07111b;
}
.search-main .search-body .search-recommend .search-labels .labels-con {
  display: -webkit-flex;
  display: flex;
  flex-wrap: wrap;
}

.search-main .search-body .search-recommend .search-labels .labels-con .label {
  margin-right: 8px;
  margin-bottom: 8px;
  padding: 4px 8px;
  font-size: 12px;
  color: #646b71;
  line-height: 16px;
  background: #fff;
  border-radius: 12px;
  transition: all 0.3s;
  -moz-transition: all 0.3s;
  -webkit-transition: all 0.3s;
  -o-transition: all 0.3s;
}
.search-main
  .search-body
  .search-recommend
  .search-labels
  .labels-con
  .label:hover {
  color: teal;
}
.search-main .search-body .search-recommend .jiuyeban-recommend {
  margin-bottom: 24px;
}
.search-main .search-body .search-recommend .jiuyeban-recommend .title {
  margin-bottom: 12px;
  font-size: 16px;
  font-weight: 700;
  color: #07111b;
}
.search-main .search-body .search-recommend .jiuyeban-recommend .direct-con {
  margin-bottom: 12px;
}
.search-main
  .search-body
  .search-recommend
  .jiuyeban-recommend
  .direct-con
  .direct {
  display: -webkit-flex;
  display: flex;
  cursor: pointer;
  margin-bottom: 12px;
  height: 88px;
  box-sizing: border-box;
  padding: 19px 20px;
  background: #fff;
  border-radius: 8px;
  transition: all 0.3s;
  -moz-transition: all 0.3s;
  -webkit-transition: all 0.3s;
  -o-transition: all 0.3s;
}

.search-main
  .search-body
  .search-recommend
  .jiuyeban-recommend
  .direct-con
  .direct
  .img {
  width: 50px;
  height: 50px;
  margin-right: 18px;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
}
.search-main
  .search-body
  .search-recommend
  .jiuyeban-recommend
  .direct-con
  .direct
  .text
  div {
  font-size: 16px;
  color: #1c1f21;
  font-weight: 700;
  margin-bottom: 2px;
}
.search-main
  .search-body
  .search-recommend
  .jiuyeban-recommend
  .direct-con
  .direct
  .text
  p {
  font-size: 12px;
  color: #1c1f21;
}
</style>