<%-- 
    Document   : insert_user
    Created on : Feb 19, 2019, 11:39:40 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
        <jsp:useBean id="date" class="java.util.Date" />
        <fmt:formatDate value="${date}" pattern="yyyy" var="currentYear" />
        <h1>User Detail</h1>
        <form action="MainAccountController" method="POST">
            Username: <input name="txtUsername" type="text" value="${requestScope.username}" readonly="true"/>
            Fullname: <input name="txtUsername" type="text" /><br/>
            <font color="red">
            ${requestScope.INVALID.fullnameInvalid}
            </font>
            Year of birth: 
            <select name="cbxYob">
                <c:forEach begin="${currentYear - 100}" end="${currentYear}" var="index">
                    <option value="${index}">${index}</option>
                </c:forEach>
            </select><br/>
            Gender: 
            <input type="radio" name="rbnGender" value="0" checked> Male
            <input type="radio" name="rbnGender" value="1"> Female
            <br/>
            Email: <input type="email" name="txtEmail"/><br/>
            <font color="red">
            ${requestScope.INVALID.emailInvalid}
            </font>
            Phone: <input type="tel" name="txtPhone"/><br/>
            <font color="red">
            ${requestScope.INVALID.phoneInvalid}
            </font>
            Address <input type="text" name="txtAddress"/><br/>
            <font color="red">
            ${requestScope.INVALID.addressInvalid}
            </font>
            <input type="submit" value="Insert" name="action"/>
        </form>
<jsp:include page="footer.jsp"/>
