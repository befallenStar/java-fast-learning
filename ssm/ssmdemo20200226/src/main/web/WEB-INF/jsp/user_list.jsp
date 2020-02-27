<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <el-link href="<%=basePath%>user/reg" type="primary">添加</el-link>
    <el-table
            :data="list"
            style="width: 100%">
        <el-table-column
                fixed
                prop="id"
                label="编号"
                width="80">
        </el-table-column>
        <el-table-column
                prop="username"
                label="姓名"
                width="180">
        </el-table-column>
        <el-table-column
                prop="phone"
                label="电话">
        </el-table-column>
        <el-table-column
                prop="birthday"
                label="生日">
        </el-table-column>
        <el-table-column
                prop="description"
                label="简介">
        </el-table-column>
        <el-table-column
                prop="option"
                label="操作">
        </el-table-column>
        <el-table-column
                fixed="right"
                label="操作"
                width="200">
            <template slot-scope="scope">
                <el-button @click="editById(scope.row.id)" type="primary" icon="el-icon-edit" plain
                           size="small">编辑
                </el-button>
                <el-button @click="deleteById(scope.row.id,scope.$index)" type="danger"
                           icon="el-icon-delete" plain size="small">删除
                </el-button>
            </template>
        </el-table-column>
    </el-table>
    <div style="text-align:center;padding:15px;">
        <el-pagination
                background
                layout="prev, pager, next"
                :total="total"
                :page-size="size"
                :current-page="index"
                @current-change="currentChange()"
        >
        </el-pagination>
    </div>
</div>
<!-- import Vue before Element -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<%-- import axios --%>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
    var app = new Vue({
                          el: '#app',
                          data() {
                              return {
                                  list: [],
                                  total: 0,
                                  size: 10,
                                  index: 1,
                              }
                          },
                          created() {
                              this.getData();
                          },
                          methods: {
                              editById(id) {
                                  window.location.href = "<%=basePath%>user/edit/" + id;
                              },
                              deleteById(id, index) {
                                  let self = this;
                                  axios.get("<%=basePath%>user/delete/json", {
                                      params: {
                                          id: id,
                                      }
                                  }).then(res => {
                                      if (res.data.code === "12138") {
                                          self.$message({
                                                            message: '恭喜你，删除成功',
                                                            type: 'success'
                                                        });
                                          self.list.splice(index, 1);

                                      } else {
                                          self.$message.error('删除失败：'+res.data.msg);
                                      }
                                  });
                              },
                              getData() {
                                  let self = this;
                                  let params = {
                                      'size': this.size,
                                      'index': this.index,
                                  };
                                  axios.get('<%=basePath%>user/json', {params}).then(res => {
                                      self.list = res.data.list;
                                      self.total = res.data.total;
                                  })
                              },
                              currentChange(page) {
                                  this.index = page;
                                  this.getData();
                              }
                          }
                      });
</script>
</body>

</html>
