<%-- 
    Document   : success
    Created on : Jun 16, 2020, 8:12:57 AM
    Author     : nguyentrinhan2000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success Page</title>
    </head>
    <body>
        <jsp:useBean id="loginAttribute" class="sample.beans.UserBean" scope="session"></jsp:useBean>
        Welcome <jsp:getProperty name="loginAttribute" property="userID"></jsp:getProperty>
        Welcome scripting : <%= ((sample.beans.UserBean)session.getAttribute("loginAttribute")).getUserID() %> 
    </body>
</html>
