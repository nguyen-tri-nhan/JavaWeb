<%-- 
    Document   : viewcart
    Created on : Jun 11, 2020, 8:07:48 AM
    Author     : nguyentrinhan2000
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.dtos.CartDTO"%>
<%@page import="sample.dtos.TeaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <%--<body>
        <h1>Your cart</h1>
        <%
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
        %>  
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price (x1000VND)</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <% int count = 0;
                    double total = 0;
                    for (TeaDTO dto : cart.getCart().values()) {
                %>
            <form>
                <tr>
                    <td><%= count++%></td>
                    <td><%= dto.getId()%></td>
                    <td><%= dto.getName()%></td>
                    <td>
                        <input type ="number" name = "txtQuantity" value="<%= dto.getQuantity()%>"/>
                    </td>
                    <td><%= dto.getQuantity() * dto.getPrice()%></td>
                    <td>
                        
                        <input type="hidden" name="txtID" value="<%= dto.getId()%>"/>
                        <input type="submit" name="btnAction" value="Remove"/>
                    </td>
                    <td>
                        <input type="submit" name="btnAction" value="UpdateTea"/>
                    </td>
                </tr>
            </form>
                <%
                        total += dto.getQuantity() * dto.getPrice();
                    }
                %>
                <tr>
                    <td>Total</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><%= total%></td>
                    <td><a href="shopping.jsp">Buy</a></td>
                </tr>
            </tbody>
        </table>

        <% }%>
        <h1><a href="shopping.jsp">Back to shopping</a></h1>
    </body>--%>
    <body>
        <h1>Your cart</h1> </br>

        <c:if test="${sessionScope.CART != null}">
            <c:if test="${not empty sessionScope.CART}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set scope="session" var="total" value="${0}"/>
                        <c:forEach var="dto" items="${sessionScope.CART.getCart().values()}" varStatus="counter">
                        <form>
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.id}</td>
                                <td>${dto.name}</td>
                                <td>
                                    <input type ="number" name = "txtQuantity" value="${dto.quantity}"/>
                                </td>
                                <td>${dto.quantity * dto.price * 1000}</td>
                                <td>
                                    <input type="hidden" name="txtID" value="${dto.id}"/>
                                    <input type="submit" name="btnAction" value="Remove"/>
                                </td>
                                <td>
                                    <input type="submit" name="btnAction" value="UpdateTea"/>
                                    <input type="hidden" name="txtQuantity" value="${param.txtQuantity}"
                                </td>
                            </tr>
                            <c:set scope="session" var="total" value="${total + dto.quantity * dto.price * 1000}"/>
                        </form>
                    </c:forEach>
                    <tr>
                        <td>Total</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>${total += dto.quantity * dto.price * 1000}</td>
                        <td><a href="shopping.jsp">Buy</a></td>
                    </tr>
                </tbody>
            </table>
        </c:if>
    </c:if>
</body>
</html>
