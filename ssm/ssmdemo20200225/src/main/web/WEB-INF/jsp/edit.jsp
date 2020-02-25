<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/update" method="post" enctype="multipart/form-data">
    <input type="text" name="id" value="${user.id}" style="display:none"/>
    姓名：<input type="text" name="username" value="${user.username}"/><br/>
    电话：<input type="text" name="phone" value="${user.phone}"/><br/>
    <fmt:formatDate value="${user.birthday}" var="birthday" pattern="yyyy-MM-dd"></fmt:formatDate>
    生日：<input type="date" name="birthday" value="${birthday}"/><br/>
    头像：<input type="file" name="headimg" value="${user.img}" height="100px"/><br/>
    简介：<textarea name="description" cols="30" rows="5">${user.description}</textarea><br/>
    <input type="submit" value="确定"/>
</form>
</body>
</html>
