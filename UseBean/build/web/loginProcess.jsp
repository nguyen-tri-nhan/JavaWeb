<!-- 
    Document   : loginProcess
    Created on : Jun 16, 2020, 8:03:09 AM
    Author     : nguyentrinhan2000
-->


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Process</title>
    </head>
    <body>
        <jsp:useBean id="loginAttribute" class="sample.beans.UserBean" scope="session">
            <jsp:setProperty name="loginAttribute" property="userID" value='<%= request.getParameter("txtUserID") %>'></jsp:setProperty>
            <jsp:setProperty name="loginAttribute" property="password" value='<%= request.getParameter("txtPassword") %>'></jsp:setProperty>
        </jsp:useBean>
        <%
            boolean check = loginAttribute.checkLogin();
            if (check){
                response.sendRedirect("success.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        %>
    </body>
</html>
