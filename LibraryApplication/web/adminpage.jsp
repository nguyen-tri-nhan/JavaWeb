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
        <link rel="stylesheet" href="css/style.css" />
        <title>Admin Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.USER.role!='Admin'}">
            <c:redirect url="login.html"/>
        </c:if>
        <header>
            <nav>
                <a href="MainController?btnAction=Logout">Logout</a>        

            </nav>
            <h1>Welcome ${sessionScope.USER.fullName}</h1>
        </header>
        <h2>
            <a href="bookmanagement.jsp">BOOK MANAGEMENT</a></br>
            <a href="usermanagement.jsp">USER MANAGEMENT</a></br>
            <a href="ordermanagement.jsp">ORDER MANAGEMENT</a></br> 
        </h2>
        <footer>
            <p>© Copyright by <a href="https://nguyentrinhan-dev.github.io/" target="_blank">Nguyen Tri Nhan</a></p>
            <p>Powered by FPTU</p>
        </footer>
    </body>
</html>
