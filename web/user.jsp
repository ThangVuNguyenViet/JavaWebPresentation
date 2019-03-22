<%-- 
    Document   : user
    Created on : Mar 17, 2019, 1:58:10 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<h1>View Tours</h1>
<h2>Search</h2>
<form action="MainUserController" method="POST">
    Tour name: <input type="text" name="txtSearch" value="${param.txtSearch}"/>
    <br/>
    <input type="submit" name="action" value="Search"/>
</form>
<form action="MainAccountController" method="POST">
    <input type="submit" name="action" value="Log Out"/>
</form>
<a href="ViewHistoryController">View Book History</a><br/>
<a href="EditController">Edit Profile</a><br/>
<a href="change_password.jsp">Change Password</a><br/>
<c:url value="MainUserController" var="viewCartLink">
    <c:param name="action" value="View Cart"/>
</c:url>
<a href="${viewCartLink}">View Cart</a>
<c:if test="${requestScope.INFO != null}">
    <c:if test="${not empty requestScope.INFO}" var="checkList">
        <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
            <div style="clear:both">
                <div style="float: left; width: 350px; height: 200px">
                    <img src="${dto.imgUrl}" width="100%"/>
                </div>
                <div style="float: left; margin-left: 10px">
                    Tour Id: ${dto.tourId}
                    Tour Name: ${dto.tourName}<br/>
                    Origin: ${dto.tourOrigin}<br/>
                    Destination: ${dto.tourDes}<br/>
                    Duration: ${dto.tourDuration} day(s)<br/>
                    Description ${dto.description}<br/>
                    <c:url var="viewTicketLink" value="MainUserController">
                        <c:param name="action" value="View Ticket"/>
                        <c:param name="tourId" value="${dto.tourId}"/>
                        <c:param name="txtSearch" value="${param.txtSearch}"/>
                    </c:url>
                    <a href="${viewTicketLink}">View Ticket</a>
                </div>
            </div>
            <br/>
        </c:forEach>
    </c:if>
</c:if>
<jsp:include page="footer.jsp"/>
