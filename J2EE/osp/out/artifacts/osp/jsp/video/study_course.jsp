<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>课程学习</title>
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
        function getQueryVariable(variable){
            var query = window.location.search.substring(1);
            var vars=query.split("&");
            for (var i=0;i<vars.length;i++){
                var pair = vars[i].split("=");
                if (pair[0]===variable)
                    return pair[1];
            }
            return (false);
        }
        var courseId = getQueryVariable("courseId");
        table.render({
                         elem: '#demo'
                         , height: 'full'
                         , url: '${pageContext.request.contextPath}/video/list?courseId='+courseId
                         , page: true //开启分页
                         , limit: 10
                         , cellMinWidth: 80
                         , cols: [[ //表头
                {
                    field: 'id', title: '序号', sort: true,
                    fixed: 'left', templet: '<div>{{d.LAY_TABLE_INDEX+1}}</div>', unresize: true
                }, {
                    field: 'courseName', title: '课程名',
                    templet: '<div>{{d.course.courseName}}</div>', unresize: true
                }, {
                    field: 'category', title: '类别',
                    templet: '<div>{{d.course.category.category}}</div>', unresize: true
                }, {
                    field: 'chapter', title: '章节', resize: true
                }, {
                    fixed: 'right', title: '操作', toolbar: '#barDemo', unresize: true
                }
            ]]
        });
        table.on('tool(selected)', function (obj) {
            var data = obj.data;
            if (obj.event === 'play')
                layer.open({
                               type: 2,
                               shade: false,
                               title: false,
                               skin: 'layui-layer-rim',
                               area: ['400px', '300px'],
                               offset: '150px',
                               content: '${pageContext.request.contextPath}/video/play?videoName='
                                        + data.videoName
                           });
        });
    });
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="play">播放</a>
</script>
</body>
</html>