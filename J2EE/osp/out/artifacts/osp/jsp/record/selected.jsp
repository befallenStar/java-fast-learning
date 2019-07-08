<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>已选课程</title>
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
                         url: '${pageContext.request.contextPath}/record/query_selected?userId=${loginResult.userId}',
                         page: true, //开启分页
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
                                 field: 'username', title: '用户名',
                                 templet: '<div>{{d.user.username}}</div>', unresize: true
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
                                 field: 'introduction', title: '简介', width: '35%',
                                 templet: '<div>{{d.course.introduction}}</div>', unresize: true
                             }
                             , {fixed: 'right', title: '操作', toolbar: '#barDemo',width:'30%', unresize: true}
                         ]]
                     });
        table.on('tool(selected)', function (obj) {
            var data = obj.data;
            if (obj.event === 'course_study')
                location.href =
                    "${pageContext.request.contextPath}/video/study_course?courseId="
                    + data.course.courseId;
            else if (obj.event === 'resource_download')
                location.href =
                    "${pageContext.request.contextPath}/resource/downloadPage?courseId="
                    + data.course.courseId;
        });
    });
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="course_study">开始学习</a>
    <a class="layui-btn layui-btn-xs" lay-event="resource_download">下载资源</a>
</script>
</body>
</html>
