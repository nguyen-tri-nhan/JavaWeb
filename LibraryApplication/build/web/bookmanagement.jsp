<%-- 
    Document   : bookmanagement
    Created on : Jun 30, 2020, 6:00:08 PM
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

        <h3>Admin tool: Create book</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>BookID</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>Author</th>
                    <th>Quantity</th>
                    <th>Create</th>
                </tr>
            </thead>
            <tbody>
            <form action="MainController" method="POST">
                <tr>
                    <td><input type="text" name="txtNewBookID" value="${param.txtNewBookID}"/></td>
                    <td><input type="text" name="txtNewTitle" value="${param.txtNewTitle}"/></td>
                    <td><input type="text" name="txtNewPrice" value="${param.txtNewPrice}"/></td>
                    <td><input type="text" name="txtNewAuthor" value="${param.txtNewAuthor}"/></td>
                    <td><input type="text" name="txtNewQuantity" value="${param.txtNewQuantity}"/></td>
                    <td>
                        <input type="submit" value="CreateBook" name="btnAction"/>
                        <input type="hidden" name="txtSearchBook" value="${param.txtSearchBook}"/>
                    </td>
                </tr>
            </form>
        </tbody>
    </table>
    <c:set var="errors" value="${requestScope.ERROR_BOOK}"/>
    <font color="red"> ${errors.errorbookcode} </font> </br>
    <font color="red"> ${errors.errortitle} </font> </br>
    <font color="red"> ${errors.errorauthor} </font> </br>
    <font color="red"> ${errors.errorquantity} </font> </br>
    <font color="red"> ${errors.errorprice} </font> </br>


    <h3>Admin Tool: Book management</h3>
    <form action="MainController">
        Search <input type ="text" value="${param.txtSearchBook}" name ="txtSearchBook"/>
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
                    <form action="MainController" method="POST">
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
                            <td>${books.author}</td>
                            <td>
                                <input type="text" name="txtQuantity"
                                       value="${books.quantity}"/>
                            </td>
                            <td>
                                <input type="submit" value="UpdateBook" name="btnAction" />
                                <input type="hidden" value="${param.txtSearchBook}" name ="txtSearchBook"/>
                            </td>
                            <td>
                                <input type="submit" value="DeleteBook" name="btnAction" />
                                <input type="hidden" value="${param.txtSearchBook}" name ="txtSearchBook"/>
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