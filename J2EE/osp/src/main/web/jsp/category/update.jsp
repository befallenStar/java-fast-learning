<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课程类别信息</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/plugin/layui/css/layui.css"/>
</head>
<body>
<div style="margin: 25px 60px 0 0;">
    <form class="layui-form">
        <input type="hidden" name="categoryId" value="${category.categoryId}">
        <div class="layui-form-item">
            <label class="layui-form-label">课程类别名</label>
            <div class="layui-input-block">
                <input type="text" name="category" value="" required lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="form">提交</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/plugin/layui/layui.js"></script>
<script>
    layui.use(['layer', 'form', 'jquery'], function () {
        var form = layui.form,
            $ = layui.jquery,
            layer = layui.layer;
        form.on('submit(form)', function (data) {
            var data1 = data.field;
            var loading = layer.load(0, {shade: false});
            $.ajax({
                       url: '${pageContext.request.contextPath}/category/update_category',
                       data: {categoryId: data1.categoryId, category: data1.category},
                       type: 'post',
                       dataType: 'JSON',
                       success: function (res) {
                           layer.close(loading);
                           var index = parent.layer.getFrameIndex(window.name);
                           if (res.code === 10000)
                               layer.msg("更新成功", {
                                   time: 2000,
                                   end: function () {
                                       window.parent.location.reload();
                                   }
                               });
                           else
                               layer.msg("更新失败", {
                                   time: 2000,
                                   end: function () {
                                       window.parent.location.reload();
                                   }
                               });
                       }
                   });
            return false;
        });
    });
</script>
</body>
</html>
