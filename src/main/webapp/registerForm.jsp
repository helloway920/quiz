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
    <script type="text/javascript" src="../js/register.js"></script>
    <title>Register Page</title>
</head>
<body>
<jsp:include page="/nav.jsp" flush="true"/>
<div class="container mt-2">
    <form method="post">
        <div class="form-group">
            <label for="userName">User Name</label>
            <input type="text" class="form-control" id="userName" placeholder="User Name" name="userName">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" placeholder="Password" name="password">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" placeholder="Email" name="email">
        </div>
        <div class="form-group">
            <label for="birthDate">BirthDate</label>
            <input type="datetime-local" class="form-control" id="birthDate" placeholder="BirthDate" name="birthDate">
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" placeholder="Address" name="address">
        </div>
        <div class="radio-inline">
            <label for="isAdmin">Admin</label>
            <input type="radio" id="isAdmin" name="isAdmin" value="1"><label for="isAdmin">Y</label>
            <input type="radio" id="isAdmin2" name="isAdmin" value="0"><label for="isAdmin2">N</label>
        </div>
        <button type="submit" class="btn btn-primary" id="submit">Submit</button>
    </form>

    <small id="credentialError" style="color: red"></small>
</div>

</body>
</html>
