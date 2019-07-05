<%@ page import="com.junenatte.jdbc.dao.ICategoryDao" %>
<%@ page import="com.junenatte.jdbc.dao.DaoFactory" %>
<%@ page import="com.junenatte.jdbc.bean.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="com.junenatte.jdbc.dao.IBookDao" %>
<%@ page import="com.junenatte.jdbc.bean.Book" %>
<%@ page import="com.junenatte.jdbc.mysql.MysqlCategoryDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <tfoot>
<tr>
    <th colspan="3">哈哈哈哈哈哈哈</th>
</tr>
    </tfoot>
</table>
</body>
</html>
