<%-- 
    Document   : cart
    Created on : Jul 11, 2020, 5:07:51 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Cart</title>
        <link rel="stylesheet" href="css/style.css" />
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
                <li style="float: right"><a href="UserOrderController">Welcome, ${sessionScope.USER.fullName}</a></li>
                </c:if>
                <c:if test="${empty sessionScope.USER}">
                <li style="float: right" ><a href="login.html">Login</a></li>
                </c:if>
        </ul>

        <h1>Your cart</h1> </br>
        <h1><font color="blue"><a href="library.jsp">Back to library</a></font></h1>

        <c:if test="${sessionScope.CART != null}">
            <c:if test="${not empty sessionScope.CART}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set scope="session" var="total" value="${0}"/>
                        <c:set scope="session" var="sum" value="${0}"/>
                        <c:forEach var="dto" items="${sessionScope.CART.getCart().values()}" varStatus="counter">
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.title}</td>
                                <td>
                                    <input type ="number" name = "txtQuantity" value="${dto.quantity}"/>
                                </td>
                                <td>${dto.quantity * dto.price}</td>
                                <td>
                                    <input type="hidden" name="txtID" value="${dto.bookcode}"/>
                                    <input type="submit" name="btnAction" value="Remove"/>
                                </td>
                                <td>
                                    <input type="submit" name="btnAction" value="Update Element"/>
                                    <input type="hidden" name="txtBookCode" value="${dto.bookcode}"/>
                                </td>
                            </tr>
                            <c:set scope="session" var="total" value="${total + dto.quantity * dto.price}"/>
                            <c:set scope="session" var="sum" value="${sum + dto.quantity}"/>
                        </form>
                    </c:forEach>
                    <tr>
                        <td>Total</td>
                        <td></td>
                        <td>${sum}</td>
                        <td>${total += dto.quantity * dto.price}</td>

                    </tr>
                </tbody>
            </table>

            <form action="MainController">
                Return date: <input name="calendar" type="date" onkeydown="return null"/>
                <script>
                    var today = new Date();
                    today.setDate(today.getDate() + 1);
                    var minDay = today.toISOString().split('T')[0];
                    document.getElementsByName("calendar")[0].setAttribute('min', minDay);
                    today.setDate(today.getDate() + 29);
                    var maxDay = today.toISOString().split('T')[0];
                    document.getElementsByName("calendar")[0].setAttribute('max', maxDay);
                </script>
                <input type="submit" name="btnAction" value="Borrow"/>
                <input type="submit" name="btnAction" value="Cancel"/>
            </form>
            <font color="red">Notice: if you do not pick a return date, your return date is 30 days from today</font>
            <font color="red">In case your browser do not show calendar, your return date is maximum 30</font>
        </c:if>
    </c:if>
    <c:if test="${empty sessionScope.CART}">
        <font color="red"><h1>No item in cart</h1></font>
    </c:if>
    <footer>
        <p>© Copyright by <a href="https://nguyentrinhan-dev.github.io/" target="_blank">Nguyen Tri Nhan</a></p>
        <p>Powered by FPT University </p>
    </footer>
</body>
</html>
