<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
</head>
<body>
<div id="app">
    <el-form ref="user" :model="user" label-width="80" style="width:600px">
        <el-form-item label="姓名">
            <el-input v-model="user.username"></el-input>
        </el-form-item>
        <el-form-item label="电话">
            <el-input v-model="user.phone"></el-input>
        </el-form-item>
        <el-form-item label="生日">
            <el-date-picker type="date" placeholder="选择日期" v-model="user.birthday"
                            style="width: 100%;"></el-date-picker>
        </el-form-item>
        <el-form-item>
            <el-image :src="src" style="height: 100px"></el-image>
        </el-form-item>
        <el-form-item label="简介">
            <el-input type="textarea" v-model="user.description"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">确定</el-button>
        </el-form-item>
    </el-form>
</div>
<!-- import Vue before Element -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<%-- import axios --%>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<%-- import qs --%>
<script src="https://cdn.bootcss.com/qs/6.9.1/qs.min.js"></script>
<script>
    var app = new Vue({
                          el: "#app",
                          data() {
                              return {
                                  user: {},
                                  id: 0,
                                  src: '',
                              }
                          },
                          created() {
                              let tempid = '${id}';
                              console.log(tempid);
                              this.id = tempid;
                              this.getData();
                              console.log(this.id);
                          },
                          methods: {
                              onSubmit() {
                                  let self = this;
                                  axios.post("<%=basePath%>user/update/json",
                                             Qs.stringify(this.user)).then(res => {
                                      if (res.data.code === "12138") {
                                          self.$message({
                                                            message: '恭喜你，更新成功',
                                                            type: 'success'
                                                        });
                                          setTimeout(() => {
                                                         window.location.href = " <%=basePath%>user/list";
                                                     },
                                                     2000);
                                      } else {
                                          self.$message.error('更新失败：' + res.data.msg);
                                      }
                                  });
                              },

                              getData() {
                                  let self = this;
                                  axios.get("<%=basePath%>user/get/json", {
                                      params: {
                                          id: self.id
                                      }
                                  }).then(res => {
                                      self.user = res.data;
                                      self.src = "<%=basePath%>" + self.user.img;
                                  })
                              }
                          },
                      });
</script>
</body>
</html>
