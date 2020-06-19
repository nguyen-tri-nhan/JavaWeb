<%-- 
    Document   : update
    Created on : Jun 9, 2020, 9:35:23 AM
    Author     : nguyentrinhan2000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UPDATE</title>
    </head>
    <body>
        <%
            String userID = request.getParameter("txtUserID");
            if (userID == null) {
                userID = "";
            }
            String fullName = request.getParameter("txtFullName");
            if (fullName == null) {
                fullName = "";
            }
            String RoleID = request.getParameter("txtRoleID");
            if (RoleID == null)
                RoleID = "";
        %>
        <form action="MainController">
            UserID <input type ="text" name="txtUserID" value="" readonly="true"/>
            Full Name <input type="text" name="txtFullName" value=""/>
            Role ID <input type="text" name="txtRoleID" value=""/>
            <input type="submit" name="btnAction" value="Update"/>
        </form>
    </body>
</html>
