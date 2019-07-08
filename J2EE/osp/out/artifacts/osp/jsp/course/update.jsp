<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课程信息</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/plugin/layui/css/layui.css"/>
</head>
<body>
<div style="margin: 25px 60px 0 0;">
    <form class="layui-form">
        <input type="hidden" name="courseId" value="${course.courseId}">
        <div class="layui-form-item">
            <label class="layui-form-label">课程名</label>
            <div class="layui-input-block">
                <input type="text" name="courseName" value="${course.courseName}" required
                       lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">课程类别</label>
            <div class="layui-input-block">
                <select name="categoryId" lay-verify="required">
                    <option value=""></option>
                    <c:forEach items="${categories}" var="category">
                        <c:if test="${category.categoryId==course.category.categoryId}">
                            <option value="${category.categoryId}"
                                    selected>${category.category}</option>
                        </c:if>
                        <c:if test="${category.categoryId!=course.category.categoryId}">
                            <option value="${category.categoryId}">${category.category}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">课程介绍</label>
            <div class="layui-input-block">
                <input type="text" name="introduction" value="${course.introduction}" required
                       lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">课程须知</label>
            <div class="layui-input-block">
                <input type="text" name="note" value="${course.note}" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">课程状态</label>
            <div class="layui-input-block">
                <c:if test="${course.state==null||course.state==0}">
                    <input type="radio" name="state" value="0" title="未开课" checked>
                    <input type="radio" name="state" value="1" title="已开课">
                </c:if>
                <c:if test="${course.state!=null&&course.state==1}">
                    <input type="radio" name="state" value="0" title="未开课">
                    <input type="radio" name="state" value="1" title="已开课" checked>
                </c:if>
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
                       url: '${pageContext.request.contextPath}/course/update_course',
                       data: {
                           courseId: data1.courseId, courseName: data1.courseName,
                           introduction: data1.introduction, note: data1.note,
                           categoryId: data1.categoryId, state: data1.state
                       },
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
