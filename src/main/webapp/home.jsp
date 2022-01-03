<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 1/2/2022
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/home.js"></script>
    <title>Home Page</title>
</head>
<body>
<jsp:include page="/nav.jsp" flush="true"/>
<table class="table">
    <thead>
    <tr>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${quizzes}" var="p">
        <tr>
            <td><a href="/getquizscreen?id=${p.id}"> <c:out value="${p.name}"></c:out></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
