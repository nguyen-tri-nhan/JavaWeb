<%-- 
    Document   : ordermanagement
    Created on : Jul 9, 2020, 4:15:15 PM
    Author     : Lenovo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Management</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <c:if test="${sessionScope.USER.role!='Admin'}">
            <c:redirect url="login.html"/>
        </c:if>
        <header>

            <ul>
                <li><a href="adminpage.jsp" >Back</a></li>
                <li><a href="usermanagement.jsp">User Management</a></li>
                <li><a href="bookmanagement.jsp">Book Management</a></li>
                <li><a class="active" href="ordermanagement.jsp">Order Management</a></li>
                <li style="float: right"><a href="MainController?btnAction=Logout">Logout</a></li>
            </ul>
        </header>
        <h3>Admin tool: Management</h3>
        <form action="MainController" method="POST">
            Search <input type ="text" value="${param.txtSearch}" name ="txtSearch"/>
            <input type="submit" value="Show Order" name="btnAction"/>
        </form>
        <font color="red"><h4>CAUTION: YOU CAN ONLY UPDATE STATUS ONE TIME!</h4></font>
        <c:if test = "${requestScope.LIST_ORDER_MANAGEMENT != null}">
            <c:if test = "${not empty requestScope.LIST_ORDER_MANAGEMENT}">

                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Order ID</th>
                            <th>User ID</th>
                            <th>Order Date</th>
                            <th>Return Date</th>
                            <th>Returned status</th>
                            <th>Required</th>
                            <th>View</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${requestScope.LIST_ORDER_MANAGEMENT}" varStatus="counter">

                        <form action="MainController" method="POST">
                            <tr>
                                <td>${counter.count}</td>
                                <td>
                                    <input type="text" name="txtOrderId" value="${dto.orderid}" readonly="true" />
                                </td>
                                <td>${dto.userid}</td>
                                <td>${dto.orderdate}</td>
                                <td>${dto.returndate}</td>
                                <td>
                                    <c:if test = "${dto.returned}">
                                        <input type="checkbox"  readonly="true" name="returned" value="False" checked="" disabled=""/>
                                        <font color="green">RETURNED</font>
                                    </c:if>
                                    <c:if test = "${!dto.returned}">
                                        <input type="checkbox" name="returned" value="True" disabled=""/>
                                        <font color="red">NOT RETURNED</font>
                                    </c:if>
                                </td> 
                                <td>
                                    <c:if test="${!dto.returned && dto.required == 1}">
                                        <input type="submit" value="Accept" name="btnAction" />
                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                    </c:if>
                                    <c:if test="${dto.returned or dto.required == 0 or dto.required == 2}">
                                        <input type="submit" value="Accept" name="btnAction" disabled="" />
                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                    </c:if>
                                </td>
                                <td>
                                    <input type="submit" value="View Details" name="btnAction"/>
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
