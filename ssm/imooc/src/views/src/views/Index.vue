<template>
  <el-container id="app" style="min-height:1000px;">
    <el-header class="fix-header" style="height:72px">
      <Header></Header>
    </el-header>
    <el-main class="main" style="padding:0px;">
      <router-view />
    </el-main>
    <el-footer class="footer">
      <Footer></Footer>
    </el-footer>
  </el-container>
</template>

<script>
import Header from "../components/header.vue";
import Footer from "../components/footer.vue";

export default {
  name: "app",
  components: {
    Header,
    Footer
  },
  data() {
    return {};
  },
  methods: {}
};
</script>
<style>
@font-face {
  font-family: "sz";
  src: url("../assets/fonts/sz.ttf");
  font-weight: normal;
  font-style: normal;
}
a,
button,
input {
  outline: 0;
}
input,
button,
textarea,
select {
  border: 0;
}
.main {
  margin-top: 72px;
  min-height: 400px;
  background-color: #fff !important;
  box-shadow: 0 2px 8px 0 rgba(7, 17, 27, 0.06);
  padding: 0px;
}

#app .footer {
  padding: 36px 0;
}
</style>