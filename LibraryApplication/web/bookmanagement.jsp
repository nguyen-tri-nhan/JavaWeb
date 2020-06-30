<%-- 
    Document   : bookmanagement
    Created on : Jun 29, 2020, 4:01:24 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Management</title>
    </head>
    <body>
        <c:if test="${sessionScope.USER.role!='Admin'}">
            <c:redirect url="login.html"/>
        </c:if>
        <nav>
            <a href="adminpage.jsp" >Back</a>
            <a href="usermanagement.jsp">User Management</a>
            <a href="MainController?btnAction=Logout">Logout</a>
        </nav>
        <h1>Welcome ${sessionScope.USER.fullName}</h1>
        <h3>Admin Tool: Book management</h3>
        <form action="MainController">
            Search <input type="text" value="${param.txtSearchBook}" name="txtSearchBook"/>
            <input type="submit" value="SearchBook" name="btnAction"/>
        </form>
        <c:if test="${requestScope.LIST_BOOK_MANAGEMENT != null}">
            <c:if test="${not empty requestScope.LIST_BOOK_MANAGEMENT}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>BookID</th>
                            <th>Title</th>
                            <th>Price</th>
                            <th>Author</th>
                            <th>Quantity</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="books" items="${requestScope.LIST_BOOK_MANAGEMENT}"
                                   varStatus="counter">
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>
                                    <input type="text" name="txtBookId" 
                                           value="${books.bookcode}" readonly="true"/>
                                </td>
                                <td>${books.title}</td>
                                <td>
                                    <input type="text" name="txtPrice"
                                           value="${books.price}"/>
                                </td>
                                <td>${books.authors}</td>
                                <td>
                                    <input type="text" name="txtQuantity"
                                           value="${books.quantity}"/>
                                </td>
                                <td>Update</td>
                                <td>Delete</td>
                            </tr>
                        </form> 
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </c:if>
</body>
</html>
