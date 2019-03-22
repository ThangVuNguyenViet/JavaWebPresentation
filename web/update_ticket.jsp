<%-- 
    Document   : update_ticket
    Created on : Feb 27, 2019, 10:31:08 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
        <h1>Update Ticket</h1>
        <jsp:useBean id="date" class="java.util.Date" />
        <fmt:formatDate value="${date}" pattern="yyyy-MM-dd" var="currentDate" />
        <form action="MainTicketController" method="POST">
            Ticket Id: <input name="txtTicketId" type="text" readonly="true" value="${requestScope.DTO.ticketId}"/><br/>
            Tour Id: <input name="txtTourId" type="text" readonly="true" value="${requestScope.DTO.tourId}"/><br/>
            Start Date: <input name="txtStartDate" type="date" min="${currentDate}" value="${requestScope.DTO.startDate}"/><br/>
            Ticket left: <input type="text" name="txtTicketLeft" value="${requestScope.DTO.ticketLeft}"/>
            <font color="red">
            ${requestScope.INVALID.ticketLeftInvalid}
            </font><br/>
            Adult Price <input type="text" name="txtPriceAdult" value="${requestScope.DTO.priceAdult}"/>
             <font color="red">
            ${requestScope.INVALID.priceAdultInvalid}
            </font><br/>
            Child Price <input type="text" name="txtPriceChild" value="${requestScope.DTO.priceChild}"/>
            <font color="red">
            ${requestScope.INVALID.priceChildInvalid}
            </font><br/>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="submit" value="Update" name="action"/>
        </form>
<jsp:include page="footer.jsp"/>
