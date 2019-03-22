﻿﻿<%-- 
    Document   : manage_tour
    Created on : Feb 21, 2019, 9:01:04 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<h1>Managing Ticket Page</h1>
<c:url var="insertLink" value="insert_ticket.jsp">
    <c:param name="txtTourId" value="${param.txtTourId}"/>
</c:url>
<a href="${insertLink}">Insert ticket</a>
<c:set var="tour" value="${requestScope.TOUR}"/>
<font color="red">${requestScope.INVALID}</font><br/>
<c:url var="backLink" value="MainTourController">
    <c:param name="action" value="Search"/>
    <c:param name="txtSearch" value="${param.txtSearch}"/>
</c:url>
<a href="${backLink}">Go to Manage Tour</a><br/>
<div style="clear:both" >
    <div style="float: left">
        <img src="${tour.imgUrl}" style="width: 323px; height: 200px"/>
    </div>
    <div style="float: left; margin-left: 10px">
        Tour Id: ${tour.tourId}<br/>
        Tour Name: ${tour.tourName}<br/>
        Origin: ${tour.tourOrigin}<br/>
        Destination: ${tour.tourDes}<br/>
        Duration: ${tour.tourDuration} day(s)<br/>
        Description: ${tour.description}<br/>
    </div>
</div>
<div style="clear: both">
    <c:if test="${requestScope.INFO != null}">
        <c:if test="${not empty requestScope.INFO}" var="checkList">
            <table border="1">
                <thead>
                    <tr>
                        <th>Ticket Id</th>
                        <th>Tour Id</th>
                        <th>Start Date</th>
                        <th>Price Adult</th>
                        <th>Price Child</th>
                        <th>Ticket Left</th>
                        <th>Delete</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                    <tbody>
                        <tr>
                            <td>${dto.ticketId}</td>
                            <td>${dto.tourId}</td>
                            <td>${dto.startDate}</td>
                            <td>${dto.priceAdult}</td>
                            <td>${dto.priceChild}</td>
                            <td>${dto.ticketLeft}</td>
                            <td>
                                <c:url var="deleteLink" value="MainTicketController">
                                    <c:param name="action" value="Delete"/>
                                    <c:param name="txtTicketId" value="${dto.ticketId}"/>
                                    <c:param name="txtTourId" value="${param.txtTourId}"/>
                                    <c:param name="txtSearch" value="${param.txtSearch}"/>
                                </c:url>
                                <a href="${deleteLink}">Delete</a>
                            </td>
                            <td>
                                <form action="MainTicketController" method="POST">
                                    <input type="hidden" name="txtTicketId" value="${dto.ticketId}"/>
                                    <input type="hidden" name="txtTourId" value="${param.txtTourId}"/>
                                    <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                    <input type="submit" name="action" value="Edit"/>
                                </form>
                            </td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </c:if>
    </c:if>
</div>
<jsp:include page="footer.jsp"/>
