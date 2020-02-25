<%--
  Created by IntelliJ IDEA.
  User: yyang
  Date: 2/25/2020
  Time: 1:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show</title>
</head>
<body>
<h1>用户信息</h1>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
    </tr>
    <c:forEach items="${requestScope.list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>
                <c:if test="${user.gender == 1}">男</c:if>
                <c:if test="${user.gender == 0}">女</c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
