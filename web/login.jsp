<%--
  Created by IntelliJ IDEA.
  User: CC
  Date: 2020/3/26
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function refreshCode() {
            var checkcode = document.getElementById("check");
            checkcode.src="${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
        }

    </script>
</head>
<body>
    <div class="container" style="width: 400px;">
        <h3 style="text-align: center">管理员登录</h3>
        <div class="row col-sm-12" style="float:left;padding-bottom: 5px;" >
            <form action="${pageContext.request.contextPath}/loginServlet" method="post">
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" name="username" class="form-control" id="username" >
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" name="password" class="form-control" id="password" >
                </div>
                <div class="form-group row">
                    <div class="col-md-4">
                        <label for="checkcode">验证码</label>
                        <input type="text" name="checkcode" class="form-control" id="checkcode" style="width: 120px ">
                    </div>
                    <div style="padding-top: 20px" class="col-md-4">
                        <a href="javascript:refreshCode();">
                        <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="check"/>
                    </a>

                    </div>
                </div>
                <hr/>
                <div class="form-group" style="text-align: center;">
                    <input class="btn btn btn-primary" type="submit" value="登录">
                </div>
            </form>

            <!-- 出错显示的信息框 -->
            <div class="alert alert-warning alert-dismissible row col-md-12" role="alert" >
                <button type="button" class="close" data-dismiss="alert" >
                    <span>&times;</span>
                </button>
                <strong>${login_msg}</strong>
            </div>
        </div>

    </div>

</body>
</html>
