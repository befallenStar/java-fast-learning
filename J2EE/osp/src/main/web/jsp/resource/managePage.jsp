<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>资源管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/plugin/layui/css/layui.css">
</head>
<body>
<table id="demo" lay-filter="resource"></table>
<script src="${pageContext.request.contextPath}/static/plugin/layui/layui.js"></script>
<script>
    layui.use(['layer', 'table', 'jquery'], function () {
        var layer = layui.layer
            , table = layui.table
            , $ = layui.jquery;

        function getQueryVariable(variable) {
            var query = window.location.search.substring(1);
            var vars = query.split("&");
            for (var i = 0; i < vars.length; i++) {
                var pair = vars[i].split("=");
                if (pair[0] === variable)
                    return pair[1];
            }
            return (false);
        }

        var courseId = getQueryVariable("courseId");
        table.render({
                         elem: '#demo',
                         height: 'full',
                         url: '${pageContext.request.contextPath}/resource/list?courseId='
                              + courseId, //数据接口
                         toolbar: '#toolbarDemo',
                         page: true, //开启分页
                         limit: 10,
                         cellMinWidth: 80,
                         cols: [[ //表头
                             {
                                 field: 'realName', title: '文件名', unresize: true, fixed: 'left'
                             }, {fixed: 'right', title: '操作', toolbar: '#barDemo', unresize: true}
                         ]]
                     });
        table.on('tool(resource)', function (obj) {
            var data = obj.data;
            if (obj.event === 'delete')
                layer.confirm('确定删除吗?', function (index) {
                    $.ajax({
                               url: '${pageContext.request.contextPath}/resource/delete',
                               data: {resourceId: data.resourceId},
                               type: 'post',
                               dataType: 'JSON',
                               success: function (d) {
                                   if (d.code === 10000)
                                       layer.msg("删除成功", {
                                           time: 2000,
                                           end: function () {
                                               obj.del();
                                               window.location.reload();
                                           }
                                       });
                                   else
                                       layer.msg("删除失败",{
                                           time:2000,
                                           end:function () {
                                               window.location.reload();
                                           }
                                       });
                               },
                               complete: function () {
                                   layer.close(index);
                               }
                           });
                });
        });
        table.on('toolbar(resource)', function (obj) {
            if (obj.event === 'upload')
                layer.open({
                               type: 2,
                               title: '上传资源',
                               shadeClose: true,
                               offset: '10%',
                               area: ['60%', '80%'],
                               content: '${pageContext.request.contextPath}/resource/uploadPage?courseId='
                                        + courseId
                           });
        });
    });
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="delete">删除</a>
</script>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="upload">资源上传</button>
    </div>
</script>
</body>
</html>


