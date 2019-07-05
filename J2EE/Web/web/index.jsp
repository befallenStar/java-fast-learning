<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>目录</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>category</th>
        <th>remark</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.id}</td>
            <td>${category.category}</td>
            <td>${category.remark}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
