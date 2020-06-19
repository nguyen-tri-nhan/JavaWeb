<%-- 
    Document   : shopping
    Created on : Jun 11, 2020, 7:32:36 AM
    Author     : nguyentrinhan2000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Milk tea</title>
    </head>
    <body>
        <h1>Welcome to milk tea shop</h1>
        <form action="MainController">
            Select your drinking:
            <select name="cmbTea">
                <option value="T01-Peach Tea-20">Peach Tea</option>
                <option value="T02-Matcha Tea-35">Matcha Tea</option>
                <option value="T03-Black Tea-20">Black Tea</option>
                
            </select>
            <input type="submit" name="btnAction" value="Add"/>
            <input type="submit" name="btnAction" value="View"/>
            <%
                String message = (String)request.getAttribute("MESSAGE");
                if (message == null){
                    message = "";
                }
            %>
            <h1>
                <%= message %>
            </h1>
        </form>
    </body>
</html>
