<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>学生界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/plugin/layui/css/layui.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/iframe.css"/>
</head>
<body class="layui-layout-body" style="overflow: hidden">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">OSP在线学习平台</div>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree">
                <li class="layui-nav-item">
                    <a href="javascript:">课程</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/jsp/record/selected.jsp"
                               target="subframe">已选课程</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/jsp/record/unseleted.jsp"
                               target="subframe">可选课程</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/jsp/remark/list.jsp"
                               target="subframe">课程评价</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <iframe src="" name="subframe"></iframe>
    </div>
    <div class="layui-footer">
        © osp在线学习平台
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/plugin/layui/layui.js"></script>
<script>
    layui.use(['element'], function () {
        var element = layui.element;
    });
</script>
</body>
</html>
