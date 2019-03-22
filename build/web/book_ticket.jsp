<%-- 
    Document   : book_ticket
    Created on : Mar 6, 2019, 11:15:23 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
    <script type="text/javascript">
        function calc() {
            var adultQuant = document.getElementById('adultQuant').value;
            var childQuant = document.getElementById('childQuant').value;
            var adultPrice = ${requestScope.DTO.priceAdult};
            var priceChild = ${requestScope.DTO.priceChild};
            document.getElementById("total").innerHTML = "Total: " + (adultPrice * adultQuant + priceChild * childQuant);
        }
    </script>
    <body>
        <h1>Book Ticket</h1>
        <c:set var="ticket" value="${requestScope.DTO}"/>
        <div style="clear: both">
            <div style="float: left">
                <img src="${ticket.imgUrl}" style="width: 350px; height: 200px;"/>
            </div>
            <div style="float: left; margin-left: 10px">
                Tour Id: ${ticket.tourId}<br/>
                Tour Name: ${ticket.tourName}<br/>
                Ticket Id: ${ticket.ticketId}<br/>
                Start Date: ${ticket.startDate}<br/>
                Ticket left: ${ticket.ticketLeft}<br/>
                Price Adult: ${ticket.priceAdult}<br/>
                Price Child: ${ticket.priceChild}<br/>
            </div>
        </div>
        <div style="clear: both">
            <form action="MainUserController" method="POST">
                Username: <input type="text" readonly name="txtUsername" value="${sessionScope.USERNAME}"/><br/>
                Ticket Id: <input type="text" readonly name="ticketId" value="${ticket.ticketId}"/><br/>
                Adult Quantity: <input type="number" name="txtAdultQuant" value="${param.txtAdultQuant}" min="0" max="${ticket.ticketLeft}" id="adultQuant" onchange="calc()"/>
                <font color="red">
                ${requestScope.INVALID.adultQuantInvalid}
                </font><br/>
                Child Quantity: <input type="number" name="txtChildQuant" value="${param.txtChildQuant}" min="0" max="${ticket.ticketLeft}" id="childQuant" onchange="calc()"/>
                <font color="red">
                ${requestScope.INVALID.childQuantInvalid}
                </font>
                <p id="total">Total: 0</p>
                <input type="submit" value="Complete" name="action"/>
            </form>
        </div>
<jsp:include page="footer.jsp"/>
