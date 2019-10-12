<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>选课记录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/plugin/layui/css/layui.css">
</head>
<body>
<table id="demo" lay-filter="selected"></table>
<script src="${pageContext.request.contextPath}/static/plugin/layui/layui.js"></script>
<script>
    layui.use(['layer', 'table', 'jquery'], function () {
        var layer = layui.layer
            , table = layui.table
            , $ = layui.jquery;
        table.render({
                         elem: '#demo'
                         , height: 'full'
                         , url: '${pageContext.request.contextPath}/record/query_all'
                         , page: true //开启分页
                         , limit: 10
                         , cellMinWidth: 80
                         , cols: [[ //表头
                {
                    field: 'id', title: '序号', sort: true,
                    fixed: 'left', templet: '<div>{{d.LAY_TABLE_INDEX+1}}</div>', unresize: true
                }
                , {
                    field: 'username', title: '用户名',sort:true,
                    templet: '<div>{{d.user.username}}</div>', unresize: true
                }
                , {
                    field: 'courseName', title: '课程名',sort:true,
                    templet: '<div>{{d.course.courseName}}</div>', unresize: true
                }
                , {
                    field: 'category', title: '类别',sort:true,
                    templet: '<div>{{d.course.category.category}}</div>', unresize: true
                }
                , {
                    field: 'introduction', title: '简介',
                    templet: '<div>{{d.course.introduction}}</div>', unresize: true
                }
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', unresize: true}
            ]]
                     });
        table.on('tool(selected)', function (obj) {
            var data = obj.data;
            if (obj.event === 'unselect_course')
                layer.confirm('确定删除么', function (index) {
                    $.ajax({
                               url: '${pageContext.request.contextPath}/record/unselect',
                               data: {userId: data.user.userId, courseId: data.course.courseId},
                               type: 'post',
                               dataType: 'JSON',
                               success: function (d) {
                                   if (d.code === 10000)
                                       layer.msg("退选成功", {
                                           time: 1000,
                                           end: function () {
                                               location.reload();
                                           }
                                       });
                                   else
                                       layer.msg("退选失败", {
                                           time: 1000,
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
        });
    });
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="unselect_course">退选</a>
</script>
</body>
</html>
