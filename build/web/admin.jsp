<%-- 
    Document   : admin
    Created on : Feb 19, 2019, 11:15:21 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<h1>Hello Admin</h1>
<a href="manage_account.jsp">Manage Account</a><br/>
<a href="manage_tour.jsp">Manage Tour</a><br/>
<a href="manage_book.jsp">Manage Book Tour</a><br/>
<form action="register.jsp" method="POST">
    <input type="hidden" name="roleId" value="1"/>
    <input type="submit" value="Create Admin Account"/>
</form>
<form action="MainAccountController" method="POST">
    <input type="submit" name="action" value="Log Out"/>
</form>
<jsp:include page="footer.jsp"/>
