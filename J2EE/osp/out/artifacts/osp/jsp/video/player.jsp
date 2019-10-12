<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>播放视频</title>
    <link href="https://vjs.zencdn.net/7.5.5/video-js.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/plugin/layui/layui.js"></script>
    <script src="https://vjs.zencdn.net/ie8/1.1.2/videojs-ie8.min.js"></script>
</head>
<body>
<video
        id="my-player"
        class="video-js vjs-big-play-centered"
        controls
        preload="auto"
        data-setup='{}'
        style="margin:auto;">
    <source id="video-source"
            src="${pageContext.request.contextPath}/static/video/${videoName}"
            type="video/mp4"
    />
    <p class="vjs-no-js">
        请开启Javascript脚本以便
        <a href="http://videojs.com/html5-video-support/" target="_blank">
            支持HTML5 video播放器
        </a>
    </p>
</video>
<script src='https://vjs.zencdn.net/7.5.5/video.js'></script>
<script>
    layui.use(['jquery'], function () {
        var $ = layui.jquery;
    });
</script>
</body>
</html>