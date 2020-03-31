<%--
  Created by IntelliJ IDEA.
  User: CC
  Date: 2020/3/27
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>修改用户数据</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<<h3 style="text-align: center">修改用户信息</h3>
<form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
    <div class="form-group">
        <input type="hidden" name="id" value="${requestScope.user.id}">
        <label for="name">姓名：</label>
        <input type="text" class="form-control" id="name" value="${requestScope.user.name}" name="name" readonly="readonly">
    </div>

    <div class="form-group">
        <label>性别：</label>

        <c:if test="${requestScope.user.gender == '男' }">
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </c:if>

        <c:if test="${requestScope.user.gender == '女' }">
            <input type="radio" name="gender" value="男" />男
            <input type="radio" name="gender" value="女" checked="checked"/>女
        </c:if>

    </div>

    <div class="form-group">
        <label for="age">年龄：</label>
        <input type="text" class="form-control" id="age" value="${requestScope.user.age}" name="age" placeholder="请输入年龄">
    </div>

    <div class="form-group">
        <label for="address">籍贯：</label>
        <select name="address" class="form-control" id="address">
            <c:if test="${requestScope.user.address == '南京'}">
                <option value="南京" selected="selected">南京</option>
                <option value="北京">北京</option>
                <option value="上海">上海</option>
            </c:if>
            <c:if test="${requestScope.user.address == '北京'}">
                <option value="南京" >南京</option>
                <option value="北京" selected="selected">北京</option>
                <option value="上海">上海</option>
            </c:if>
            <c:if test="${requestScope.user.address == '上海'}">
                <option value="南京" >南京</option>
                <option value="北京">北京</option>
                <option value="上海" selected="selected">上海</option>
            </c:if>
        </select>
    </div>

    <div class="form-group">
        <label for="qq">QQ：</label>
        <input type="text" class="form-control" value="${requestScope.user.qq}" id="qq" name="qq" placeholder="请输入QQ号码"/>
    </div>

    <div class="form-group">
        <label for="email">Email：</label>
        <input type="text" class="form-control" value="${requestScope.user.email}" id="email" name="email" placeholder="请输入邮箱地址"/>
    </div>

    <div class="form-group" style="text-align: center">
        <input class="btn btn-primary" type="submit" value="提交" />
        <input class="btn btn-default" type="reset" value="重置" />
        <a class="btn btn-default" type="button" href="${pageContext.request.contextPath}/userListServlet">返回</a>
    </div>
</form>
</div>
</body>
</html>
