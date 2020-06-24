<%-- 
    Document   : create
    Created on : Jun 9, 2020, 7:16:58 AM
    Author     : nguyentrinhan2000
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.dtos.ErrorUserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix=""%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create user</title>
    </head>
    <%--<body>
        <%
            ErrorUserDTO errorDTO = (ErrorUserDTO)request.getAttribute("ERROR_USER");
            if(errorDTO == null){
                errorDTO = new ErrorUserDTO("", "", "", "", "");
            }
        %>
        <form action="MainController" method="POST">
            UserID <input type="text" name="txtUserID"/>
            </br><%= errorDTO.getErrorUserID() %></br>
            </br> ${requestScope.errorDTO.getErrorUserID()} </br>
            Full Name <input type="text" name="txtFullName"/>
            </br><%= errorDTO.getErrorfullName() %></br>
            </br> ${requestScope.errorDTO.getErrorfullName()} </br>
            Role ID <input type="text" name="txtRoleID"/>
            </br><%= errorDTO.getErrorroleID() %></br>
            </br> ${requestScope.errorDTO.getErrorroleID()} </br>
            Password <input type="password" name ="txtPassWord"/>
            </br><%= errorDTO.getErrorPassword() %></br>
            </br> ${requestScope.errorDTO.getErrorPassword()} </br>
            Re Password <input type="password" name ="txtRePassWord"/>
            </br><%= errorDTO.getErrorRePassword() %></br>
            </br> ${requestScope.errorDTO.getErrorRePassword()} </br>
            <input type ="submit" name="btnAction" value="Create"/>
            <input type="reset" value="reset"/>
        </form>
    </body>--%>
    <body>
        <h1>Create new account</h1>
        <form action="MainController" method="POST">
            <c:set var="errors" value="${requestScope.ERROR_USER}"/>
            UserID <input type="text" name="txtUserID"
                          value="${param.txtUserID}"/> </br>
            <font color="red"> ${errors.errorUserID} </font> </br>
            Full Name <input type="text" name="txtFullName"
                             value="${param.txtFullName}"/> </br>
            <font color="red">${errors.errorfullName}</font> </br>
            Role ID <input type="text" name="txtRoleID"/> </br>
            <font color="red">${errors.errorroleID}</font> </br>
            Password <input type="password" name ="txtPassWord"/> </br>
            <font color="red">${errors.errorPassword}</font> </br>
            Re Password <input type="password" name ="txtRePassWord"/> </br>
            <font color="red">${errors.errorRePassword}</font> </br>
            <input type ="submit" name="btnAction" value="Create"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
