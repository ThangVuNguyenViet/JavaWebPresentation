<%-- 
    Document   : view_history
    Created on : Mar 10, 2019, 2:10:23 PM
    Author     : Thang
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
        <h1>History</h1>
        <a href="user.jsp">Go back to User Page</a>
        <c:if test="${requestScope.INFO != null}">
            <c:if test="${not empty requestScope.INFO}" var="checkList">
                <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                    <div style="clear: both">
                        <div style="width: 350px; height: 200px; float: left">
                            <img src="${dto.imgUrl}" width="100%"/>
                        </div>
                        <div style="float: left; margin-left: 10px">
                            Tour Name: ${dto.tourName}<br/>
                            Start Date: ${dto.startDate}<br/>
                            Price Adult: ${dto.priceAdult}<br/>
                            Price Child: ${dto.priceChild}<br/>
                            Adult Quantity: ${dto.adultQuant}<br/>
                            Child Quantity: ${dto.childQuant}<br/>
                            Total: ${dto.total}<br/>
                        </div>
                    </div>
                    <br/>
                </c:forEach>
            </c:if>
        </c:if>
<jsp:include page="footer.jsp"/>
