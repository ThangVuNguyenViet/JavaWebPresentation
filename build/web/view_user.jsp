<%-- 
    Document   : view_user
    Created on : Mar 9, 2019, 10:50:54 PM
    Author     : Thang
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<c:set var="dto" value="${requestScope.DTO}"/>
<c:if test="${dto != null}" var="check">
    <h1>View User ${dto.username}</h1>
    Fullname: ${dto.fullname}<br/>
    Year of birth: ${dto.yob}<br/>
    Gender: 
    <c:if test="${dto.gender}" var="isMale">Male</c:if>
    <c:if test="${!isMale}">Female</c:if><br/>
    Email: ${requestScope.DTO.email}
    Phone: ${requestScope.DTO.phone}
    Address: ${requestScope.DTO.address}
</c:if>
<c:if test="${!check}">
    This User has not filled the profile<br/>
</c:if>
<br/>
<c:url value="manage_account.jsp" var="backLink">
    <c:param name="search" value="${param.search}"/>
</c:url>
<a href="${backLink}">Back to Manage Account</a>
<jsp:include page="footer.jsp"/>
