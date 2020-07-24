<%-- 
    Document   : viewdetail
    Created on : Jul 12, 2020, 11:35:20 AM
    Author     : Lenovo
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>${sessionScope.USER.fullName}</title>
    </head>
    <body>
        <c:if test="${sessionScope.USER.role!='Student'}">
            <c:redirect url="login.html"/>
        </c:if>
        <ul>
            <li><a href="library.jsp">Home</a></li>
            <li><a href="#">Hot</a></li>
            <li><a href="#">Books</a></li>
            <li><a href="#">E-Books</a></li>
            <li><a href="https://www.facebook.com/nguyentrinhan.811/" target="_blank">Facebook</a></li>
                <c:if test="${sessionScope.USER.role=='Student'}">
                <li  style="float: right"><a href="MainController?btnAction=Logout">Logout</a></li>
                <li style="float: right"><a class="active" href="UserOrderController">Welcome, ${sessionScope.USER.fullName}</a></li>
                </c:if>
                <c:if test="${empty sessionScope.USER}">
                <li style="float: right" ><a href="login.html">Login</a></li>
                </c:if>
        </ul>
        <font color="red"><p>No one can change these value</p></font>
        <c:if test = "${requestScope.LIST_ORDER_DETAIL != null}">
            <c:if test = "${not empty requestScope.LIST_ORDER_DETAIL}">

                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>Book Name</th>
                            <th>Price</th>
                            <th>Amount</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${requestScope.LIST_ORDER_DETAIL}" varStatus="counter">

                        <form action="MainController" method="POST">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.id}</td>
                                <td>${dto.bookname}</td>
                                <td>${dto.amount}</td>
                                <td>${dto.price}</td>
                            </tr>
                        </form>

                    </c:forEach>
                </tbody>
            </c:if>
        </c:if>
        <a href="profile.jsp">Back</a>
        <footer>
            <p>© Copyright by <a href="https://nguyentrinhan-dev.github.io/" target="_blank">Nguyen Tri Nhan</a></p>
            <p>Powered by FPT University </p>
        </footer>
</body>
</html>
