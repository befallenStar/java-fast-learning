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
<form action="/user/regaction" method="post" enctype="multipart/form-data">
    姓名：<input type="text" name="username"/><br/>
    电话：<input type="text" name="phone"/><br/>
    生日：<input type="date" name="birthday"/><br/>
    头像：<input type="file" name="headimg"/><br/>
    简介：<textarea name="description" cols="30" rows="5"></textarea><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
