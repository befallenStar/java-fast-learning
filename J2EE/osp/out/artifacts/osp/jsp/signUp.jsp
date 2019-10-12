<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/signUp.css"/>
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
<div class="signup-box">
    <form class="signup-form" method="POST" action="${pageContext.request.contextPath}/signUp">
        <h1>欢迎进入</h1>
        <input
                class="txtb"
                type="text"
                id="signup-usr"
                placeholder="Username"
                name="username"
        />
        <input
                class="txtb"
                type="password"
                id="signup-pwd"
                placeholder="Password"
                name="password"
        />
        <input
                class="txtb"
                type="password"
                id="signup-cpwd"
                placeholder="Confirm Password"
                name="reInputPwd"
        />
        <input class="signup-btn" type="submit" value="注册"/>
    </form>
</div>
</body>
</html>
