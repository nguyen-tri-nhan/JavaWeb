<%-- 
    Document   : adminauth
    Created on : Jul 9, 2020, 7:42:35 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <c:if test="${sessionScope.USER.role!='Admin'}">
            <c:redirect url="login.html"/>
        </c:if>
    </body>
</html>
