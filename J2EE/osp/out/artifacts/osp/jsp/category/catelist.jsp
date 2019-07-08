<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>课程类型列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/plugin/layui/css/layui.css">
</head>
<body>
<table id="demo" lay-filter="test"></table>
<script src="${pageContext.request.contextPath}/static/plugin/layui/layui.js"></script>
<script>
    layui.use(['layer', 'table', 'jquery'], function () {
        var layer = layui.layer
            , table = layui.table
            , $ = layui.jquery;
        table.render({
                         elem: '#demo'
                         , height: 312
                         , toolbar: '#toolbarDemo'
                         , url: '${pageContext.request.contextPath}/category/all' //数据接口
                         , page: true //开启分页
                         , cellMinWidth: 80
                         , cols: [[ //表头
                {field: 'categoryId', title: 'ID', sort: true, fixed: 'left', unresize: true}
                , {field: 'category', title: '课程类型', unresize: true}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', unresize: true}
            ]]
                     });
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del')
                layer.confirm('真的删除行么', function (index) {
                    $.ajax({
                               url: '${pageContext.request.contextPath}/category/delete',
                               data: {id: data.categoryId},
                               type: 'post',
                               dataType: 'JSON',
                               success: function (d) {
                                   if (d.code === 10000)
                                       layer.msg("操作成功", {
                                           time: 2000,
                                           end: function () {
                                               location.reload();
                                           }
                                       });
                                   else
                                       layer.msg("操作失败", {
                                           time: 2000,
                                           end: function () {
                                               location.reload();
                                           }
                                       });
                               },
                               complete: function () {
                                   layer.close(index);
                               }
                           });
                });
            else if (obj.event === 'edit')
                layer.open({
                               type: 2,
                               title: '类别信息',
                               shadeClose: true,
                               offset: '10%',
                               area: ['60%', '80%'],
                               content: '${pageContext.request.contextPath}/category/query?id='
                                        + data.categoryId
                           })
        });
        table.on('toolbar(test)', function (obj) {
            if (obj.event === 'add')
                layer.open({
                               type: 2,
                               title: '增加课程类别',
                               shadeClose: true,
                               offset: '10%',
                               area: ['60%', '80%'],
                               content: '${pageContext.request.contextPath}/category/insert'
                           })
        });
    });
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">增加课程类别</button>
    </div>
</script>
</body>
</html>
