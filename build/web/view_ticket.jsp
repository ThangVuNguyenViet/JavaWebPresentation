<%-- 
    Document   : view_ticket
    Created on : Mar 5, 2019, 10:41:49 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
        <h1>View Ticket</h1>
        <a href="user.jsp" style="clear: both">Back to User Page</a>
        <c:if test="${requestScope.INFO != null}">
            <c:if test="${not empty requestScope.INFO}" var="checkList">
                <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                    <div style="clear: both">
                        <div style="width: 350px; height: 200px; float: left">
                            <img src="${dto.imgUrl}" width="100%"/>
                        </div>
                        <div style="float: left; margin-left: 10px">
                            Tour Id: ${dto.tourId}<br/>
                            Tour Name: ${dto.tourName}<br/>
                            Ticket ID: ${dto.ticketId}<br/>
                            Start Date: ${dto.startDate}<br/>
                            Ticket left: ${dto.ticketLeft}<br/>
                            Price Adult: ${dto.priceAdult}<br/>
                            Price Child: ${dto.priceChild}<br/>
                            <c:if test="${param.action eq 'View Cart'}" var="check">
                                <form action="MainUserController" method="POST">
                                    <input type="hidden" name="ticketId" value="${dto.ticketId}"/>
                                    <input type="submit" name="action" value="Remove Cart"/>
                                </form>
                            </c:if>
                            <c:if test="${!check}">
                                <form action="MainUserController" method="POST">
                                    <input type="hidden" name="ticketId" value="${dto.ticketId}"/>
                                    <input type="hidden" name="tourId" value="${dto.tourId}"/>
                                    <input type="submit" name="action" value="Add To Cart"/>
                                </form>
                            </c:if>
                            <c:url var="bookTicketLink" value="MainUserController">
                                <c:param name="ticketId" value="${dto.ticketId}"/>
                                <c:param name="action" value="Book Ticket"/>
                            </c:url>
                            <a href="${bookTicketLink}">Book Ticket</a>
                        </div>
                    </div>
                    <br/>
                </c:forEach>
            </c:if>
        </c:if>
<jsp:include page="footer.jsp"/>
