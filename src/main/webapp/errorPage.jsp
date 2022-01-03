<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 1/1/2022
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="nav.jsp" %>
    <title>Error Page</title>
</head>
<body>
<div class="container">
    <h1>Error Page</h1>
    <h5>${exception}</h5>
    <h5>${url}</h5>
</div>
</body>
</html>