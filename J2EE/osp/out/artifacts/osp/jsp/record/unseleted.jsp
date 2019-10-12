<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>可选课程</title>
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
                         elem: '#demo',
                         height: 'full',
                         url: '${pageContext.request.contextPath}/record/query_unselected?userId=${loginResult.userId}',
                         page: true,//开启分页
                         limit: 10,
                         cellMinWidth: 80,
                         cols: [[ //表头
                             {
                                 field: 'id',
                                 title: '课程id',
                                 sort: true,
                                 fixed: 'left',
                                 templet: '<div>{{d.course.courseId}}</div>',
                                 unresize: true
                             }
                             , {
                                 field: 'courseName', title: '课程名',
                                 templet: '<div>{{d.course.courseName}}</div>', unresize: true
                             }
                             , {
                                 field: 'category',
                                 title: '类别',
                                 templet: '<div>{{d.course.category.category}}</div>',
                                 unresize: true
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
            if (obj.event === 'select')
                layer.confirm('确定选择该课程吗?', function (index) {
                    $.ajax({
                               url: '${pageContext.request.contextPath}/record/select_course',
                               data: {userId:${loginResult.userId}, courseId: data.course.courseId},
                               type: 'post',
                               dataType: 'JSON',
                               success: function (d) {
                                   if (d.code === 10000)
                                       layer.msg("选课成功", {
                                           time: 1000,
                                           end: function () {
                                               window.location.reload();
                                           }
                                       });
                                   else
                                       layer.msg("选课失败", {
                                           time: 1000,
                                           end: function () {
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
    <a class="layui-btn layui-btn-xs" lay-event="select">选课</a>
</script>
</body>
</html>
