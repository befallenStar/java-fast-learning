<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>资源下载</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugin/layui/css/layui.css">
</head>
<body>
<table id="demo" lay-filter="resource"></table>
<script src="${pageContext.request.contextPath}/static/plugin/layui/layui.js"></script>
<script>
    layui.use(['layer', 'table','jquery'], function(){
        var layer = layui.layer
            ,table = layui.table
            ,$ = layui.jquery;
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
            ,height: 312
            ,url: '${pageContext.request.contextPath}/resource/list?courseId='+courseId //数据接口
            ,page: true //开启分页
            ,limit: 10
            ,cellMinWidth:80
            ,cols: [[ //表头
                {field: 'num', title: '序号', sort: true, fixed: 'left',templet:'<div>{{d.LAY_TABLE_INDEX+1}}</div>',unresize:true}
                ,{field: 'realName', title: '文件名', sort: true,unresize:true}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo',unresize:true}
            ]]
        });
        table.on('tool(resource)', function(obj){
            var data = obj.data;
            if(obj.event === 'download')
                window.location.href="${pageContext.request.contextPath}/resource/download?resourceId="+data.resourceId;
        });
    });
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="download">下载</a>
</script>
</body>
</html>

