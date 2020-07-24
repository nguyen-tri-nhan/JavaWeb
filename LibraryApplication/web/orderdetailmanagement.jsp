<%-- 
    Document   : orderdetailmanagement
    Created on : Jul 9, 2020, 7:41:35 PM
    Author     : Lenovo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="adminauth.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Order Details</title>
    </head>
    <body>
        <h3>Admin tool: Management</h3>
        <font color="red"><p>No one can change these value</p></font>
        <c:if test = "${requestScope.LIST_ORDER_DETAIL_MANAGEMENT != null}">
            <c:if test = "${not empty requestScope.LIST_ORDER_DETAIL_MANAGEMENT}">

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
                        <c:forEach var="dto" items="${requestScope.LIST_ORDER_DETAIL_MANAGEMENT}" varStatus="counter">

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
                <a href="ShowOrderController?txtSearch">Back</a>
</body>
</html>
