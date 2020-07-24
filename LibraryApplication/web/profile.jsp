<%-- 
    Document   : profile
    Created on : Jul 11, 2020, 9:53:13 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:if test="${sessionScope.USER.role!='Student'}">
    <c:redirect url="login.html"/>
</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>${sessionScope.USER.fullName}</title>
    </head>
    <body>
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
        <form action="UserOrderController">
            <input type="hidden" name="txtUserID" value="${sessionScope.USER.id}"/>
        </form>


        <c:if test="${requestScope.LIST_ORDER_USER == null}">
            <c:redirect url="UserOrderController"/>
        </c:if>
        <c:if test="${empty requestScope.LIST_ORDER_USER}">
            <font color="red"><h3>Your ordered list is empty</h3></font>
        </c:if>
        <c:if test = "${requestScope.LIST_ORDER_USER != null}">
            <c:if test = "${not empty requestScope.LIST_ORDER_USER}">

                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Order ID</th>
                            <th>Order Date</th>
                            <th>Return Date</th>
                            <th>Status</th>
                            <th>Request</th>
                            <th>View</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${requestScope.LIST_ORDER_USER}" varStatus="counter">

                        <form action="MainController" method="POST">
                            <tr>
                                <td>${counter.count}</td>
                                <td>
                                    <input type="text" name="txtOrderId" value="${dto.orderid}" readonly="true" />
                                </td>
                                <td>${dto.orderdate}</td>
                                <td>${dto.returndate}</td>
                                <td>
                                    <c:if test = "${dto.returned}">
                                        <font color="green">Returned</font>
                                    </c:if>
                                    <c:if test = "${!dto.returned}">
                                        <font color="red">Not Returned</font>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${dto.required == 0}">
                                        <input type="submit" value="Require" name="btnAction"/>
                                    </c:if>
                                    <c:if test="${dto.required == 1}">
                                        <input type="submit" value="Required" name="btnAction" disabled=""/>
                                    </c:if>
                                    <c:if test="${dto.required == 2}">
                                        <input type="submit" value="Returned" name="btnAction" disabled=""/>
                                    </c:if>
                                </td>
                                <td>
                                    <input type="submit" value="View Orderdetails" name="btnAction"/>
                                </td>
                            </tr>
                        </form>

                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </c:if>
    <footer>
        <p>© Copyright by <a href="https://nguyentrinhan-dev.github.io/" target="_blank">Nguyen Tri Nhan</a></p>
        <p>Powered by FPT University </p>
    </footer>
</body>
</html>
