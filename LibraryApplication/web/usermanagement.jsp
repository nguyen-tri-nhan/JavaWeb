<%-- 
    Document   : usermanagement
    Created on : Jun 29, 2020, 4:01:35 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>User Management</title>
    </head>
    <body>
        <c:if test="${sessionScope.USER.role!='Admin'}">
            <c:redirect url="login.html"/>
        </c:if>
        <ul>
            <li><a href="adminpage.jsp" >Back</a></li>
            <li><a class="active" href="usermanagement.jsp">User Management</a></li>
            <li><a href="bookmanagement.jsp">Book Management</a></li>
            <li><a href="ordermanagement.jsp">Order Management</a></li>
            <li style="float: right"><a href="MainController?btnAction=Logout">Logout</a></li>
        </ul>
        <h1>Welcome ${sessionScope.USER.fullName}</h1>
        <h3>Admin tool: Instant Create a user</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>FullName</th>
                    <th>Password</th>
                    <th>Role</th>
                    <th>Create</th>
                </tr>
            </thead>
            <tbody>
            <form action="MainController" method="POST">
                <tr>
                    <td><input type="text" name="txtNewID" value="${param.txtNewID}"/></td>
                    <td><input type="text" name="txtNewName" value="${param.txtNewName}"/></td>
                    <td><input type="password" name="txtNewPass"/></td>
                    <td><input type="number" name="txtNewRole" value="${param.txtNewRole}"/></td>
                    <td>
                        <input type="submit" value="Instant Create" name="btnAction"/>
                        <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                    </td>
                </tr>
            </form>
        </tbody>
    </table>
    <c:set var="errors" value="${requestScope.ERROR_USER}"/>
    <font color="red"> ${errors.errorid} </font> </br>
    <font color="red"> ${errors.errorname} </font> </br>
    <font color="red"> ${errors.errorrole} </font> </br>


    <h3>Admin tool: Management</h3>
    <form action="MainController" method="POST">
        Search <input type ="text" value="${param.txtSearch}" name ="txtSearch"/>
        <input type="submit" value="Search User" name="btnAction"/>
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
                        <th>Action</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${requestScope.LIST_USER}" varStatus="counter">

                    <form action="MainController" method="POST">
                        <tr>
                            <td>${counter.count}</td>
                            <td>
                                <input type="text" name="txtId" value="${dto.id}" readonly="true" />
                            </td>
                            <td>
                                <input type="text" name="txtFullName" value="${dto.fullName}" />
                            </td>
                            <td>
                                <input type="text" name="txtRole" value="${dto.role}" readonly="true" />
                            </td>
                            <td>${dto.password}</td>
                            <td>
                                <%--<c:url var="delete" value="MainController">
                                    <c:param name="btnAction" value="DeleteUser"></c:param>
                                    <c:param name="txtId" value="${dto.id}"></c:param>
                                    <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
                                </c:url>
                                <a href="${delete}">Delete</a>--%>
                                <c:if test="${dto.role == 'Admin'}">
                                    <input type="submit" value="Action Denied" name="btnAction" disabled="" />
                                </c:if>
                                <c:if test="${dto.role != 'Banned' && dto.role != 'Admin'}">
                                    <input type="submit" value="Ban User" name="btnAction" />
                                    <input type="hidden" value="5" name="txtBan"/>
                                    <input type="hidden" value="${param.txtSearch}" name ="txtSearch"/>
                                </c:if>
                                <c:if test="${dto.role == 'Banned'}">
                                    <input type="submit" value="Unban User" name="btnAction" />
                                    <input type="hidden" value="3" name="txtBan"/>
                                    <input type="hidden" value="${param.txtSearch}" name ="txtSearch"/>
                                </c:if>
                            </td>
                            <td>
                                <input type="submit" value="Update User" name="btnAction" />
                                <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                            </td>
                        </tr>
                    </form>

                </c:forEach>
            </tbody>
        </table>
    </c:if>
</c:if>


</body>
</html>
