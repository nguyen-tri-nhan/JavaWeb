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
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Book Management</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <c:if test="${sessionScope.USER.role!='Admin'}">
            <c:redirect url="login.html"/>
        </c:if>
        <ul>
            <li><a href="adminpage.jsp" >Back</a></li>
            <li><a href="usermanagement.jsp">User Management</a></li>
            <li><a class="active" href="bookmanagement.jsp">Book Management</a></li>
            <li><a href="ordermanagement.jsp">Order Management</a></li>
            <li style="float: right"><a href="MainController?btnAction=Logout">Logout</a></li>
        </ul>
        <h1>Welcome ${sessionScope.USER.fullName}</h1>

        <h3>Admin tool: Create book</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>BookID</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>Author</th>
                    <th>Publisher</th>
                    <th>Language</th>
                    <th>Genre</th>
                    <th>Quantity</th>
                    <th>Create</th>
                </tr>
            </thead>
            <tbody>
            <form action="MainController" method="POST">
                <tr>
                    <td><input type="text" name="txtNewBookID" value="${param.txtNewBookID}"/></td>
                    <td><input type="text" name="txtNewTitle" value="${param.txtNewTitle}"/></td>
                    <td><input type="number" name="txtNewPrice" value="${param.txtNewPrice}"/></td>
                    <td><input type="text" name="txtNewAuthor" value="${param.txtNewAuthor}"/></td>
                    <td><input type="text" name="txtNewPublisher" value="${param.txtNewPublisher}"/></td>
                    <td><input type="text" name="txtNewLanguage" value="${param.txtNewLanguage}"/></td>
                    <td><input type="text" name="txtNewGenre" value="${param.txtNewGenre}"/></td>
                    <td><input type="number" name="txtNewQuantity" value="${param.txtNewQuantity}"/></td>
                    <td>
                        <input type="submit" value="Create Book" name="btnAction"/>
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
        <input type="submit" value="Search Book" name="btnAction"/>
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
                        <th>Publisher</th>
                        <th>Language</th>
                        <th>Genre</th>
                        <th>Quantity</th>
                        <th>Update</th>
                        <th>Status</th>
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
                                <input type="number" name="txtPrice"
                                       value="${books.price}"/>
                            </td>
                            <td>${books.author}</td>
                            <td>${books.publisher}</td>
                            <td>${books.language}</td>
                            <td>${books.genre}</td>
                            <td>
                                <input type="number" name="txtQuantity"
                                       value="${books.quantity}"/>
                            </td>
                            <td>
                                <input type="submit" value="Update Book" name="btnAction" />
                                <input type="hidden" value="${param.txtSearchBook}" name ="txtSearchBook"/>
                            </td>
                            <td>
                                <c:if test="${books.active}">
                                    <input type="submit" value="Deactive" name="btnAction" />
                                    <input type="hidden" value="False" name="txtActive"/>
                                </c:if>
                                <c:if test="${!books.active}">
                                    <input type="submit" value="Active" name="btnAction" />
                                    <input type="hidden" value="True" name="txtActive"/>
                                </c:if>
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
