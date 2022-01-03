<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 1/1/2022
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="../js/quiz.js"></script>
    <title>Quiz Result</title>
</head>
<body>
<div class="container mt-2">
    <div style="display: inline-block;">
        <label>Quiz Name:</label>
        <label>${sessionScope.quizResult.name}&nbsp;</label>
    </div>
    <div style="display: inline-block;">
        <label>User Name:</label>
        <label>${sessionScope.user.name}&nbsp;</label>
    </div>
    <div style="display: inline-block;">
        <label>Start Time:</label>
        <label>${sessionScope.startTime}&nbsp;</label>
    </div>
    <div style="display: inline-block;">
        <label>End Time:</label>
        <label>${sessionScope.endTime}</label>
    </div>
    <div class="question bg-white p-3 border-bottom">
        <c:forEach items="${sessionScope.quizResult.questions}" var="question" varStatus="questionStatus">
            <div class="d-flex flex-row align-items-center question-title">
                <h3 class="text-danger">Q.${questionStatus.index+1}</h3>
                <h3 class="mt-1 ml-2">${question.description}</h3>
            </div>
            <c:forEach items="${question.choices}" var="choice" varStatus="choiceStatus">
                <div>
                    <label class="radio">
                        <label>
                            <span>${choice.description}</span>
                            <c:if test="${question.selectIdx == choice.id}">
                                <span style="color: Red">&nbsp;&nbsp;Your Answer</span>
                            </c:if>
                            <c:if test="${choice.answer == 1}">
                                <span style="color: Green">Correct Answer</span>
                            </c:if>
                        </label>
                    </label>
                </div>
            </c:forEach>
        </c:forEach>
    </div>
    <div style="display: inline-block;">
        <h1></h1>
        <label>Pass:</label>
        <label style="${sessionScope.isPass==1?"color:Green":"color:Red"} ">${sessionScope.isPass==1?"Passed":"Failed"}</label>
    </div>
    <div>
        <a href="/home.jsp">Take another quiz</a>
    </div>
</div>

</body>
</html>
