<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
id：${user.id}<br/>
姓名：${user.userName}<br/>
电话：${user.phone}<br/>
生日：
<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate><br/>
头像：<img src="<%=basePath%>${user.img}" alt="" height="100px"><br/>
简介：${user.description}<br/>
</body>
</html>
