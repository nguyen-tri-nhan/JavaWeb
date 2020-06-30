<%-- 
    Document   : register
    Created on : Jun 30, 2020, 1:48:00 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="library.dtos.ErrorUserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library Create user</title>
    </head>
    <body>
        <h1>Create new STUDENT</h1>
        <form action="MainController" method="POST">
            <c:set var="errors" value="${requestScope.ERROR_USER}"/>
            Student ID <input type="text" name ="txtStudentID" 
                             value="${param.txtStudentID}"/></br>
            <font color="red">${errors.errorid}</font></br>
            Full Name <input type="text" name="txtFullName"
                             value="${param.txtFullName}"/></br>
            <font color="red">${errors.errorname}</font></br>
            Password <input type="password" name="txtPassWord"/></br>
            Re-password <input type="password" name="txtRePassWord"/></br>
            <font color="red">${errors.errorpassword}</font></br>
            <input type="submit" name="btnAction" value="Register"/>
            <input type="reset" value="Reset"/></br>
            <a href="login.html">Have an account yet? Login?</a>
            
        </form>
    </body>
</html>
