<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 1/1/2022
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="../js/feedback.js"></script>
    <title>Feedback Page</title>
</head>
<body>
<jsp:include page="nav.jsp" flush="true"/>
<div class="container mt-2">
    <form method="post">
        <div style="display: inline-block;">
            <label>Quiz: </label>
            <select id="quizTypeId" name="quizTypeId">
                <c:forEach items="${sessionScope.quizTypeIds}" var = "quizType">
                    <option value="${quizType.value}">
                            ${quizType.key}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div style="display: inline-block;">
            <label>Rating: </label>
            <select id="ratingId" name="ratingId">
                <option value="1">
                    1
                </option>
                <option value="2">
                    2
                </option>
                <option value="3">
                    3
                </option>
                <option value="4">
                    4
                </option>
                <option value="5">
                    5
                </option>
            </select>
        </div>
        <div style="display: inline-block;">
            <label>Feedback:</label>
            <input type="text" id="feedback" placeholder="Feedback" name="feedback">
        </div>
        <button type="submit" class="btn btn-primary" id="submit">Submit</button>
    </form>
</div>
</body>
</html>
