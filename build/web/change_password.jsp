<%-- 
    Document   : change_password
    Created on : Mar 11, 2019, 12:23:28 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
        <h1>Change Password</h1>
        <form action="MainAccountController" method="POST">
            Old Password: <input type="password" name="txtOldPassword"/>
            <font color="red">${requestScope.INVALID.oldPasswordInvalid}</font>
            <br/>
            New Password: <input type="password" name="txtNewPassword"/>
            <font color="red">${requestScope.INVALID.newPasswordInvalid}</font>
            <br/>
            Confirm Password: <input type="password" name="txtConfirm"/>
            <font color="red">${requestScope.INVALID.confirmPasswordInvalid}</font>
            <br/>
            <input type="submit" name="action" value="Change Password"/>
        </form>
<jsp:include page="footer.jsp"/>