<%--
  Created by IntelliJ IDEA.
  User: CC
  Date: 2020/3/19
  Time: 17:26
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
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id){
            if (confirm("确定删除该记录？")) {
                location.href="${pageContext.request.contextPath}/deleteUserServlet?id="+id;
            }
        }

        function deleteSelect() {
            if (confirm("是否删除选中记录？")) {
                var uids = document.getElementsByName("uid");
                var flag = false;
                for (var i = 0; i < uids.length; i++) {
                    var uid = uids[i];
                    if (uid.checked) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    document.getElementById("form").submit();
                }
            }
        }

        function allCheck() {
            var uids = document.getElementsByName("uid");
            for (var i = 0; i < uids.length; i++) {
                var uid = uids[i];
                uid.checked = document.getElementById("firstCheck").checked;
            }

        }

    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center; ">用户信息列表</h3>
    <div class="col-sm-12" style="float:left;padding-bottom: 5px;" >
        <div style="float: left">
            <form class="form-inline" action="${pageContext.request.contextPath}/userListByPageServlet" method="post">
                <div class="form-group">
                    <label for="Name">姓名</label>
                    <input type="text" class="form-control" value="${condition.name[0]}" name="name" id="Name">
                </div>
                <div class="form-group">
                    <label for="Gender">性别</label>
                    <input type="text" class="form-control" value="${condition.gender[0]}"name="gender" id="Gender">
                </div>
                <div class="form-group">
                    <label for="QQ">qq</label>
                    <input type="text" class="form-control"value="${condition.qq[0]}" name="qq" id="QQ">
                </div>
                <button type="submit" class="btn btn-default">查询</button>
            </form>
        </div>

        <div style="float: right; padding-right: 20px" >
            <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
            <a type="button" class="btn btn-primary" href="javascript:void(0)" onclick="deleteSelect()">删除选中联系人</a>
        </div>
    </div>

<div class="row col-sm-12" style="float:left;">
    <form action="${pageContext.request.contextPath}/deleteSelectServlet" id="form">
    <table class="table table-bordered table-hover table-striped" >
    <tr class="success">
        <th><input type="checkbox" id="firstCheck" onclick="allCheck()"></th>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>籍贯</th>
        <th>QQ</th>
        <th>邮箱</th>
        <th>操作</th>

    </tr>

    <c:forEach items="${pb.list}" var="user" varStatus="s">
        <tr>
            <td><input type="checkbox" name="uid" value="${user.id}"></td>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <td>${user.qq}</td>
            <td>${user.email}</td>
            <td>
                <a class="btn btn-default" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}" type="button">修改</a>&nbsp;
                <a class="btn btn-default" href="javascript:deleteUser(${user.id})" type="button">删除</a>
            </td>
        </tr>
    </c:forEach>
    </table>

    </form>
    </div>

    <div class="row col-sm-12" style="float:left;">
        <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pb.currentPage==1}">
                <li class="disabled">
            </c:if>
            <c:if test="${pb.currentPage!=1}">
                <li>
            </c:if>
                <a href="${pageContext.request.contextPath}/userListByPageServlet?currentPage=${pb.currentPage-1}&name=${condition.name[0]}&gender=${condition.gender[0]}&qq=${condition.qq[0]}"" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

            <c:forEach begin="1" end="${pb.totalPage}" var="i">
                <c:if test="${pb.currentPage==i}">
                    <li class="active">
                </c:if>
                <c:if test="${pb.currentPage!=i}">
                    <li>
                </c:if>
                <a href="${pageContext.request.contextPath}/userListByPageServlet?currentPage=${i}&name=${condition.name[0]}&gender=${condition.gender[0]}&qq=${condition.qq[0]}">${i}</a></li>
            </c:forEach>

            <c:if test="${pb.currentPage==pb.totalPage}">
            <li class="disabled">
                </c:if>
                <c:if test="${pb.currentPage!=pb.totalPage}">
            <li>
                </c:if>
                <a href="${pageContext.request.contextPath}/userListByPageServlet?currentPage=${pb.currentPage+1}&name=${condition.name[0]}&gender=${condition.gender[0]}&qq=${condition.qq[0]}"" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 25px; margin-left: 5px">
                查询到${pb.totalNumber}条记录，共${pb.totalPage}页。
            </span>
        </ul>
    </nav></div>
</div>
</body>
</html>