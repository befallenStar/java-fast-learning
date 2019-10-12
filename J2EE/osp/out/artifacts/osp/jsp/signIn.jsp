<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/signIn.css"/>
    <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
    />
    <script  src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<script >
    $(document).ready(function () {
        var msg = "${msg}";
        if (msg !== "") {
            alert(msg);
        }
    });
</script>
<div class="signin-box">
    <form class="signin-form" method="POST" action="${pageContext.request.contextPath}/login">
        <h1>欢迎进入</h1>
        <input class="txtb" type="text" id="signin-usr" name="username" placeholder="Username"/>
        <input class="txtb" type="password" id="signin-pwd" name="password" placeholder="Password"/>
        <input class="signin-btn" type="submit" id="signin-btn" value="登录"/>
        <a href="${pageContext.request.contextPath}/signUp">
            <div class="show-signup-btn">
                <i class="fas fa-sign-in-alt"></i>
                点击注册
            </div>
        </a>
    </form>
</div>
</body>
</html>
