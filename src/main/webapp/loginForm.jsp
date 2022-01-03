<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 1/1/2022
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<jsp:include page="/nav.jsp" flush="true"/>
<form:form action="/login" method="POST" modelAttribute="user">
    <form:label path="username">Username</form:label>
    <form:input type="text" path="username"/>
    <br/>
    <form:label path="password">Password</form:label>
    <form:input type="text" path="password"/>
    <button type="submit">submit</button>
</form:form>

</body>
</html>
