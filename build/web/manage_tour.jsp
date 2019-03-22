<%-- 
    Document   : manage_tour
    Created on : Mar 17, 2019, 1:38:18 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
        <h1>Tour Managing Page</h1>
        <a href="insert_tour.jsp">Insert new Tour</a><br/>
        <a href="admin.jsp">Back to admin Page</a>
        <h2>Search</h2>
        <form action="MainTourController" method="POST">
            Tour name: <input type="text" name="txtSearch" value="${param.txtSearch}"/>
            <br/>
            <input type="submit" name="action" value="Search"/>
        </form>
        <font color="red">${requestScope.INVALID}</font>
        <c:if test="${requestScope.INFO != null}">
            <c:if test="${not empty requestScope.INFO}" var="checkList">
                <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                    <div style="clear:both;" >
                        <div style="float: left; width: 323px; height: 200px">
                            <img src="${dto.imgUrl}" width="100%"/>
                        </div>
                        <div style="float: left; margin-left: 10px">
                            Tour Id: ${dto.tourId}<br/>
                            Tour Name: ${dto.tourName}<br/>
                            Origin: ${dto.tourOrigin}<br/>
                            Destination: ${dto.tourDes}<br/>
                            Duration: ${dto.tourDuration} day(s)<br/>
                            Description: ${dto.description}<br/>
                            <c:url var="deleteLink" value="MainTourController">
                                <c:param name="action" value="Delete"/>
                                <c:param name="tourId" value="${dto.tourId}"/>
                                <c:param name="txtSearch" value="${param.txtSearch}"/>
                            </c:url>
                            <a href="${deleteLink}">Delete</a>
                            <form action="MainTourController" method="POST">
                                <input type="hidden" name="txtTourId" value="${dto.tourId}"/>
                                <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                <input type="submit" name="action" value="Edit"/>
                            </form>
                            <form action="MainTicketController" method="POST">
                                <input type="hidden" name="txtTourId" value="${dto.tourId}"/>
                                <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                <input type="submit" name="action" value="See Ticket"/>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </c:if>
<jsp:include page="footer.jsp"/>
