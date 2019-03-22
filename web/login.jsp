<%-- 
    Document   : index
    Created on : Feb 19, 2019, 1:17:09 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<form action="MainAccountController" method="POST">
    <label>Username:</label> <input name="txtUsername" type="text"/>
    <font color="red">
    ${requestScope.INVALID.usernameInvalid}
    </font><br/>
    <label>Password:</label> <input name="txtPassword" type="password"/>
    <font color="red">
    ${requestScope.INVALID.passwordInvalid}
    </font><br/>
    <input type="submit" value="Login" name="action"/>
</form>
<form action="register.jsp" method="POST">
    <input type="hidden" name="roleId" value="2"/>
    <input type="submit" value="Create Account"/>
</form>
<jsp:include page="footer.jsp"/>
