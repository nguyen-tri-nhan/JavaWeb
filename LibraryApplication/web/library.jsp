<%-- 
    Document   : library
    Created on : Jun 14, 2020, 5:02:04 PM
    Author     : nguyentrinhan2000
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:if test="${empty requestScope.LIST_BOOK_VIEW}">
    <c:redirect url="UserViewBookController"></c:redirect>
</c:if>
<c:if test="${sessionScope.USER.role == 'Admin'}">
    <c:redirect url="adminpage.jsp"></c:redirect>
</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FPTU Visual Library</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>

        <ul>
            <li><a class="active" href="library.jsp">Home</a></li>
            <li><a href="#">Hot</a></li>
            <li><a href="#">Books</a></li>
            <li><a href="#">E-Books</a></li>
            <li><a href="https://www.facebook.com/nguyentrinhan.811/" target="_blank">Facebook</a></li>
                <c:if test="${sessionScope.USER.role=='Student'}">
                <li  style="float: right"><a href="MainController?btnAction=Logout">Logout</a></li>
                <li style="float: right"><a href="UserOrderController">Welcome, ${sessionScope.USER.fullName}</a></li>
                </c:if>
                <c:if test="${empty sessionScope.USER}">
                <li style="float: right" ><a href="login.html">Login</a></li>
                </c:if>
        </ul>

        <form action="MainController">

            <select name="cmbFilter">
                <option value="Name">Name</option>
                <option value="Price">Price</option>
                <option value="Author">Author</option>
                <option value="Language">Language</option>
                <option value="Publisher">Publisher</option>
                <option value="Genre">Genre</option>
            </select>
            <input type ="text" value="${param.txtSearchBook}" name ="txtSearchBook"/>
            <input type="submit" value="Filter" name="btnAction"/>
            <c:if test="${sessionScope.USER.role=='Student'}">
                <input type="submit" value="View Cart" name="btnAction"/>
            </c:if>
            <font color="green">${requestScope.MESSAGE}</font>
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>Author</th>
                    <th>Publisher</th>
                    <th>Language</th>
                    <th>Genre</th>
                        <c:if test="${sessionScope.USER.role=='Student'}">
                        <th>Add</th>
                        </c:if>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="books" items="${requestScope.LIST_BOOK_VIEW}"
                           varStatus="counter">
                <form action="MainController" method="POST">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${books.title}</td>
                        <td>${books.price}</td>
                        <td>${books.author}</td>
                        <td>${books.publisher}</td>
                        <td>${books.language}</td>
                        <td>${books.genre}</td>
                        <c:if test="${sessionScope.USER.role=='Student'}">
                            <td>
                                <form action="MainController">
                                    <input type="submit" value="Add To Cart" name="btnAction" />
                                    <input type="hidden" value="${books.bookcode}" name ="txtbookcode"/>
                                </form>
                            </td>
                        </c:if>

                    </tr>
                </form> 
            </c:forEach>
        </tbody>
    </table>
</body>


</html>
<%@include file="banner.jsp" %>