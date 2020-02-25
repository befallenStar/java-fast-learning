<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/regaction" modelAttribute="user" method="post" enctype="multipart/form-data">
    姓名：<input type="text" name="userName" value="张三"/>
    <form:errors path="userName"></form:errors><br/>
    电话：<input type="text" name="phone" value="12312312312"/><br/>
    生日：<input type="date" name="birthday" value="2020-02-24"/><br/>
    头像：<input type="file" name="headimg"/><br/>
    坐标：<input type="text" name="point" value="123,234"/><br/>
    简介：<textarea name="description" cols="30" rows="5">内容</textarea><br/>
    <input type="submit" value="注册"/>
</form:form>
</body>
</html>
