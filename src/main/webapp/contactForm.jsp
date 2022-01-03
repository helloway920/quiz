<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 1/1/2022
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="../js/contactUs.js"></script>
    <title>Contact Page</title>
</head>
<body>
<jsp:include page="nav.jsp" flush="true"/>
<section class="mb-4">

    <!--Section heading-->
    <h2 class="h1-responsive font-weight-bold text-center my-4">Contact us</h2>
    <!--Section description-->
    <p class="text-center w-responsive mx-auto mb-5">Do you have any questions? Please do not hesitate to contact us
        directly. Our team will come back to you within
        a matter of hours to help you.</p>

    <div class="row">
        <c:forEach items="${sessionScope.admins}" var="admin" varStatus="adminStatus">
            <div class="col-md-3 text-center">
                <ul class="list-unstyled mb-0">
                    <li><i class="bi bi-person-circle"></i>
                        <p>Name:&nbsp;&nbsp;${admin.name}</p>
                    </li>
                    <li><i class="fas fa-map-marker-alt fa-2x"></i>
                        <p>Address:&nbsp;&nbsp;${admin.address}</p>
                    </li>
                    <li><i class="fas fa-envelope mt-4 fa-2x"></i>
                        <p>Email:&nbsp;&nbsp;${admin.email}</p>
                    </li>
                </ul>
            </div>
        </c:forEach>
        <small id="credentialError" style="color: red"></small>
    </div>
</section>
</body>
</html>
