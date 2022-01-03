<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 1/1/2022
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<script type="text/javascript" src="<%=basePath%>js/nav.js"></script>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navigation</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="<%=basePath%>home.jsp">Home</a>
            <% if (session.getAttribute("user") == null) {%>
            <a class="nav-item nav-link" href="<%=basePath%>pages/login.jsp">Login</a><%}%>
            <a class="nav-item nav-link" href="<%=basePath%>pages/register.jsp">Registration</a>
            <a class="nav-item nav-link" href="<%=basePath%>pages/feedback.jsp">Feedback</a>
            <a class="nav-item nav-link" href="<%=basePath%>pages/contactUs.jsp">Contact Us</a>
            <% if (session.getAttribute("user") != null) {%><a class="nav-item nav-link"
                                                               href="javascript:void(0);"
                                                               onclick="logOut()">Log &nbsp;out</a><%}%>
        </div>
    </div>
</nav>

</body>
</html>
