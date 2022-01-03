<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 1/1/2022
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Quiz Page</title>
</head>
<body>
<div class="container">
<form:form action="/createResult" method="post" modelAttribute="quizscreens">
    <c:forEach items="${quizscreens.qlist}" var="p" varStatus="status">

        <h3>${status.index + 1}.<c:out value="${p.description}"></c:out></h3>

        <c:forEach items="${p.clist}" var="choice" varStatus="cStatus">
            <form:input path="isChoose" type="radio" name="${p.id}" value="${choice.id}">(${cStatus.index +1}).${choice.description}</input>
        </c:forEach>
    </c:forEach>
    <input type="submit" value="Submit">
</form:form>
</div>
</body>
</html>
