<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>资源上传</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/plugin/layui/css/layui.css">
</head>
<body>
<div class="layui-upload-drag" id="test10">
    <i class="layui-icon"></i>
    <p>点击上传，或将文件拖拽到此处</p>
</div>
<script src="${pageContext.request.contextPath}/static/plugin/layui/layui.js"
        charset="utf-8"></script>
<script>
    layui.use('upload', function () {
        var $ = layui.jquery
            , upload = layui.upload;
        function getQueryVariable(variable) {
            var query = window.location.search.substring(1);
            var vars = query.split("&");
            for (var i = 0; i < vars.length; i++) {
                var pair = vars[i].split("=");
                if (pair[0] === variable)
                    return pair[1];
            }
            return (false);
        }
        var courseId = getQueryVariable("courseId");
        upload.render({
                          elem: '#test10',
                          url: '${pageContext.request.contextPath}/resource/upload?courseId='
                               + courseId,
                          accept: 'file',
                          done: function (res) {
                              if (res.code === 10000) //上传成功
                                  layer.msg("上传成功", ({
                                      time: 1000,
                                      end: function () {
                                          window.parent.location.reload();
                                      }
                                  }));
                              else
                                  layer.msg("上传失败", ({
                                      time: 1000,
                                      end: function () {
                                          window.close();
                                      }
                                  }));
                          },
                          error: function () {
                              layer.msg("上传失败,不支持该格式文件的上传", ({
                                  time: 1000,
                                  end: function () {
                                      window.close();
                                  }
                              }));
                          }
                      });
    });
</script>

</body>