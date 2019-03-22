<%-- 
    Document   : manage_book
    Created on : Feb 28, 2019, 1:32:17 PM
    Author     : Thang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
        <h1>Managing Book Page</h1>
        <h2>Search</h2>
        <form action="MainBookController" method="POST">
            Tour name: <input type="text" name="txtSearch"/>
            <br/>
            <input type="submit" name="action" value="Search"/>
        </form>

        <c:if test="${requestScope.INFO != null}">
            <c:if test="${not empty requestScope.INFO}" var="checkList">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Book Id</th>
                            <th>Ticket Id</th>
                            <th>Tour Name</th>
                            <th>Username</th>
                            <th>Price Adult</th>
                            <th>Price Child</th>
                            <th>Adult Quantity</th>
                            <th>Child Quantity</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                        <tbody>
                            <tr>
                                <td>${dto.bookId}</td>
                                <td>${dto.ticketId}</td>
                                <td>${dto.tourName}</td>
                                <td>${dto.username}</td>
                                <td>${dto.priceAdult}</td>
                                <td>${dto.priceChild}</td>
                                <td>${dto.adultQuant}</td>
                                <td>${dto.childQuant}</td>
                                <td>${dto.total}</td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </c:if>
        </c:if>
        <a href="admin.jsp">Back to admin page</a>
<jsp:include page="footer.jsp"/>
