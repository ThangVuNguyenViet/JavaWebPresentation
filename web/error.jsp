<%-- 
    Document   : error
    Created on : Feb 19, 2019, 11:04:56 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error Page</h1>
        <h2 style="color: red">
            ${requestScope.ERROR}
        </h2>
    </body>
</html>
