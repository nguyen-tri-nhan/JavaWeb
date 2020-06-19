<%-- 
    Document   : newjsp
    Created on : Jun 2, 2020, 7:12:17 AM
    Author     : nguyentrinhan2000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%! int x = 9; %>
        <% int x = 0; %>
        <h1>
            Value of X = <%= this.x%>
        </h1>
    </body>
</html>
