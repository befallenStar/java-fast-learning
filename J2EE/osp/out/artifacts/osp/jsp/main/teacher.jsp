<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>教师界面</title>
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
                    <a href="${pageContext.request.contextPath}/jsp/course/list.jsp" target="subframe">课程</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/jsp/record/manage.jsp"
                               target="subframe">选课管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/jsp/course/chart.jsp"
                               target="subframe">课程分析</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/jsp/remark/list.jsp"
                               target="subframe">课程评价</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/jsp/category/catelist.jsp" target="subframe">课程类别管理</a>
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
