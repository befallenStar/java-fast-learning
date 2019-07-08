<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>课程列表</title>
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
                         , height: 500
                         , url: '${pageContext.request.contextPath}/course/all' //数据接口
                         , toolbar: '#toolbarDemo'
                         , page: true //开启分页
                         , limit: 10
                         , cellMinWidth: 40
                         , cols: [[ //表头
                {field: 'courseId', title: 'ID', sort: true, fixed: 'left', unresize: true},
                {field: 'courseName', title: '课程名', unresize: true}, {
                    field: 'category',
                    title: '类别',
                    sort: true,
                    templet: '<div>{{d.category.category}}</div>', unresize: true
                }, {
                             field: 'stuNum', title: '选课人数',sort:true, unresize: true
                }, {
                    field: 'state',
                    title: '状态',
                    sort:true,
                    templet: "<div>{{d.state==0?'未开课':'已开课'}}</div>", unresize: true
                }, {fixed: 'right', title: '操作', toolbar: '#barDemo', unresize: true, width: '40%'}
            ]]
        });
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                layer.confirm('真的要删除么', function (index) {
                    $.ajax({
                               url: '${pageContext.request.contextPath}/course/delete',
                               data: {id: data.courseId},
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
            } else if (obj.event === 'edit') {
                layer.open({
                               type: 2,
                               title: '类别信息',
                               shadeClose: true,
                               offset: '10%',
                               area: ['60%', '80%'],
                               content: '${pageContext.request.contextPath}/course/query?id='
                                        + data.courseId
                           })

            } else if (obj.event === 'resource_manage') {
                layer.open({
                               type: 2,
                               title: '资源管理',
                               shadeClose: true,
                               offset: '10%',
                               area: ['60%', '80%'],
                               content: '${pageContext.request.contextPath}/resource/managePage?courseId='
                                        + data.courseId
                           });
            } else if (obj.event === 'resource_download') {
                layer.open({
                               type: 2,
                               title: '资源下载',
                               shadeClose: true,
                               offset: '10%',
                               area: ['60%', '80%'],
                               content: '${pageContext.request.contextPath}/resource/downloadPage?courseId='
                                        + data.courseId
                           });
            }else if(obj.event==='video_upload'){
                layer.open({
                               type: 2,
                               title: '资源下载',
                               shadeClose: true,
                               offset: '10%',
                               area: ['60%', '80%'],
                               content: '${pageContext.request.contextPath}/video/uploadPage?courseId='
                                        + data.courseId
                           });
            }
        });
        table.on('toolbar(test)', function (obj) {
            if (obj.event === 'add') {
                layer.open({
                               type: 2,
                               title: '增加课程',
                               shadeClose: true,
                               offset: '10%',
                               area: ['60%', '80%'],
                               content: '${pageContext.request.contextPath}/course/insertquery'
                           });
            }
        });
    });
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-xs" lay-event="resource_manage">资源管理</a>
    <a class="layui-btn layui-btn-xs" lay-event="resource_download">资源下载</a>
    <a class="layui-btn layui-btn-xs" lay-event="video_upload">视频上传</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">增加课程</button>
    </div>
</script>
</body>
</html>
