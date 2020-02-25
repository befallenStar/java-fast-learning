<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<%=basePath%>user/reg">添加</a>
<table>
    <tr>
    <th>#</th>
    <th>姓名</th>
    <th>电话</th>
    <th>生日</th>
    <th>头像</th>
    <th>简介</th>
    <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.username}</td>
            <td>${item.phone}</td>
            <fmt:formatDate value="${item.birthday}" var="birthday" pattern="yyyy-MM-dd"/>
            <td>${birthday}</td>
            <td><img src="<%=basePath%>${item.img}" height="100px"></td>
            <td>${item.description}</td>
            <td><a href="<%=basePath%>user/edit/${item.id}">编辑</a>|<a
                    href="<%=basePath%>user/delete/${item.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
