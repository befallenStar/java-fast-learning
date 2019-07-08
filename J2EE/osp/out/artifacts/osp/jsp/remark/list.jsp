<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>种类</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/plugin/layui/css/layui.css">
</head>
<body>
<a href="/remark/insert?userId=${loginResult.userId}" id="submit" class="layui-btn">我要评价</a>
<table id="list" class="layui-table"></table>
<script src="${pageContext.request.contextPath}/static/plugin/layui/layui.js"></script>
<script>
    layui.use(['layer', 'table', 'jquery'], function () {
        var layer = layui.layer
            , table = layui.table
            , $ = layui.jquery;
        table.render({
                         elem: '#list'
                         , height: 'full'
                         , url: '${pageContext.request.contextPath}/remark/query_all' //数据接口
                         , page: true //开启分页
                         , limit: 10
                         , cellMinWidth: 80
                         , cols: [[ //表头
                {
                    field: 'userId',
                    title: '用户ID',
                    templet: '<div>{{d.user.userId}}</div>',
                    sort: true,
                    fixed: 'left',
                    unresize: true
                }
                , {
                    field: 'userName',
                    title: '用户名',
                    templet: '<div>{{d.user.username}}</div>',
                    unresize: true
                }
                , {
                    field: 'courseId',
                    title: '课程ID',
                    templet: '<div>{{d.course.courseId}}</div>',
                    sort: true,
                    unresize: true
                }
                , {
                    field: 'courseName',
                    title: '课程名',
                    templet: '<div>{{d.course.courseName}}</div>',
                    unresize: true
                }
                , {field: 'content', title: '课程评价'}
                , {
                    field: 'time', title: '评价时间', templet: function (d) {
                        var str = new Date(d.time);
                        return str.getFullYear() + '-' + (str.getMonth() + 1) + '-' + str.getDate();
                    }, unresize: true
                }
            ]]
                     });
    });
</script>
</body>
</html>
