<%-- 
    Document   : search
    Created on : Jun 2, 2020, 7:39:17 AM
    Author     : nguyentrinhan2000
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


        <h1>Welcome ${sessionScope.USER.fullName}</h1>
        <a href="MainController?btnAction=Logout">Logout</a>

        <h2>You Searched ${param.txtSearch} </h2>
        <form action="MainController">
            Search <input type ="text" value="${param.txtSearch}" name ="txtSearch"/>
            <input type="submit" value="Search" name ="btnAction"/>
        </form>

        <c:if test = "${requestScope.LIST_USER != null}">
            <c:if test = "${not empty requestScope.LIST_USER}">

                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>UserID</th>
                            <th>FullName</th>
                            <th>RoleID</th>
                            <th>Password</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${requestScope.LIST_USER}" varStatus="counter">
                            <tr>
                        <form action="MainController">
                            <td>${counter.count}</td>
                            <td>
                                <input type="text" name="txtUserID" value="${dto.userID}" readonly="true" />
                            </td>
                            <td>
                                <input type="text" name="txtFullName" value="${dto.fullName}" />
                            </td>
                            <td>
                                <input type="text" name="txtRoleID" value="${dto.roleID}" />
                            </td>
                            <td>${dto.password}</td>
                            <td>
                                <c:url var="delete" value="MainController">
                                    <c:param name="btnAction" value="Delete"></c:param>
                                    <c:param name="txtUserID" value="${dto.userID}"></c:param>
                                    <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
                                </c:url>
                                <a href="${delete}">Delete</a>
                            </td>
                            <td>
                                <input type="submit" value="Update" name="btnAction" />
                                <input type="hidden" name="txtSearch" value="${param.txtSearch}"
                            </td>
                        </form>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</c:if>
</body>
<%--<body>
    <%
        UserDTO user = (UserDTO) session.getAttribute("USER");
        if (user == null) {
            response.sendRedirect("login.html");
        }
    %>
<!--        <h1>Welcome <%= session.getAttribute("FULLNAME")%> </h1>-->
    <h1>Welcome ${sessionScope.FULLNAME}</h1>
    <a href="MainController?btnAction=Logout">Logout</a>
    <%
        String Search = request.getParameter("txtSearch");
        if (Search == null) {
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
                <a href="MainController?btnAction=Delete&txtUserID=<%= dto.getUserID()%>&txtSearch=<%= Search%>">Delete</a>
            </td>
            <td>
                <input type ="submit" name="btnAction" value="Update"/>
                <input type="hidden" name="txtSearch" value="<%= Search%>"
            </td>
        </form>
    </tr>
    <% } %>

</table>


<%
        }
    }
%>

</body>--%>
</html>
