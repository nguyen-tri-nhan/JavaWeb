<%-- 
    Document   : search
    Created on : Jun 2, 2020, 7:39:17 AM
    Author     : nguyentrinhan2000
--%>

<%@page import="java.util.List"%>
<%@page import="sample.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <% 
            String fullName = (String)session.getAttribute("FULLNAME"); 
            if (fullName == null){
                response.sendRedirect("login.html");
            }
        %>
<!--        <h1>Welcome <%= session.getAttribute("FULLNAME")%> </h1>-->
        <h1>Welcome ${sessionScope.FULLNAME}</h1>
        <a href="MainController?btnAction=Logout">Logout</a>
        <% 
            String Search = request.getParameter("txtSearch"); 
            if (Search == null){
                Search = "";
            }
        %>
        <h2>You Searched <%=Search%> </h2>
        <form action="MainController">
            Search <input type ="text" value="<%=Search%>" name ="txtSearch"/>
            <input type="submit" value="Search" name ="btnAction"/>
        </form>
        <%
            List<UserDTO> list = (List<UserDTO>) request.getAttribute("LIST_USER");
            if (list != null) {
                
                if (!list.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Num</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Pass</th>
                    <th>RoleID</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>

            <% int count = 1;
                for (UserDTO dto : list) {
            %>
            <tr>
            <form action="MainController" method="POST">
                <td>
                    <%= count++%>
                </td>
                <td>
                    
                    <input type ="text" name="txtUserID" value="<%= dto.getUserID()%>" readonly="true"/>
                </td>
                <td>
                    
                    <input type ="text" name="txtFullName" value="<%= dto.getFullName()%>"/>
                </td>
                <td>
                    <%= dto.getPassword()%>
                </td>
                <td>
                    
                    <input type ="text" name="txtRoleID" value="<%= dto.getRoleID()%>"/>
                </td>
                <td>
                    <a href="MainController?btnAction=Delete&txtUserID=<%= dto.getUserID() %>&txtSearch=<%= Search %>">Delete</a>
                </td>
                <td>
                    <input type ="submit" name="btnAction" value="Update"/>
                    <input type="hidden" name="txtSearch" value="<%= Search %>"
                </td>
            </form>
            </tr>
            <% } %>

        </table>


        <%
                }
            }
        %>

    </body>
</html>
