<%-- 
    Document   : update
    Created on : Feb 18, 2019, 3:38:54 PM
    Author     : Thang
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
        <jsp:useBean id="date" class="java.util.Date" />
        <fmt:formatDate value="${date}" pattern="yyyy" var="currentYear" />
        <h1>Update Page</h1>
        <form action="MainAccountController" method="POST">
            Username: <input name="txtUsername" type="text" readonly="true" value="${requestScope.DTO.username}"/><br/>
            Fullname: <input name="txtFullname" type="text" value="${requestScope.DTO.fullname}" /><br/>
            <font color="red">
            ${requestScope.INVALID.fullnameInvalid}
            </font>
            Year of birth: 
            <select name="cbxYob">
                <c:forEach begin="${currentYear - 100}" end="${currentYear}" var="index">
                    <c:if test="${requestScope.DTO.yob == index}" var="checkYob">
                        <option value="${index}" selected>${index}</option>
                    </c:if>
                    <c:if test="${!checkYob}">
                        <option value="${index}">${index}</option>
                    </c:if>
                    <option value="${index}">${index}</option>
                </c:forEach>
            </select><br/>
            Gender: 
            <c:if test="${requestScope.DTO.gender}" var="checkGender">
                <input type="radio" name="rbnGender" value="0" checked> Male
                <input type="radio" name="rbnGender" value="1"> Female
            </c:if>
            <c:if test="${!checkGender}">
                <input type="radio" name="rbnGender" value="0" > Male
                <input type="radio" name="rbnGender" value="1" checked> Female
            </c:if>

            <br/>
            Email: <input type="email" name="txtEmail" value="${requestScope.DTO.email}"/><br/>
            <font color="red">
            ${requestScope.INVALID.emailInvalid}
            </font>
            Phone: <input type="tel" name="txtPhone" value="${requestScope.DTO.phone}"/><br/>
            <font color="red">
            ${requestScope.INVALID.phoneInvalid}
            </font>
            Address <input type="text" name="txtAddress" value="${requestScope.DTO.address}"/><br/>
            <font color="red">
            ${requestScope.INVALID.addressInvalid}
            </font>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="submit" name="action" value="Update"/>
        </form>
<jsp:include page="footer.jsp"/>
