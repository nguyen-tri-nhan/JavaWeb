<%-- 
    Document   : adminPage
    Created on : Jun 14, 2020, 4:59:19 PM
    Author     : nguyentrinhan2000
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.USER.role!='Admin'}">
            <c:redirect url="login.html"/>
        </c:if>
        <h1>Welcome ${sessionScope.USER.fullName}</h1>
        <a href="MainController?btnAction=Logout">Logout</a></br>
        <a href="bookmanagement.jsp">BOOK MANAGEMENT</a>
        <a href="usermanagement.jsp">USER MANAGEMENT</a>
    </body>
</html>
