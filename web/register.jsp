<%-- 
    Document   : register
    Created on : Feb 19, 2019, 9:55:08 PM
    Author     : Thang
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
    <body>
        <h1>Register Page</h1>
        <form action="MainAccountController" method="POST">
            Username: <input type="text" name="txtUsername"/>
            <font color="red">
            ${requestScope.INVALID.usernameInvalid}
            </font>
            <br/>            
            Password <input type="password" name="txtPassword"/>
            <font color="red">
            ${requestScope.INVALID.passwordInvalid}
            </font>
            <br/>
            <input type="hidden" name="roleId" value="${param.roleId}"/>
            <input type="submit" name="action" value="Register"/>
        </form>
<jsp:include page="footer.jsp"/>
