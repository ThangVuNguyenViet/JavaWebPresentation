<%-- 
    Document   : manage_account
    Created on : Feb 21, 2019, 9:15:57 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
        <h1>Managing Account Page</h1>
        <h2>Search</h2>
        <form action="MainAccountController" method="POST">
            Username: <input type="text" name="txtSearch"/>
            <br/>
            <input type="submit" name="action" value="Search"/>
        </form>

        <c:if test="${requestScope.INFO != null}">
            <c:if test="${not empty requestScope.INFO}" var="checkList">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Username</th>
                            <th>Delete</th>
                            <th>View</th>
                        </tr>
                    </thead>
                    <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                        <tbody>
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.username}</td>
                                <td>
                                    <c:url var="deleteLink" value="MainAccountController">
                                        <c:param name="action" value="Delete"/>
                                        <c:param name="username" value="${dto.username}"/>
                                        <c:param name="txtSearch" value="${param.txtSearch}"/>
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                                <td>
                                    <form action="MainAccountController" method="POST">
                                        <input type="hidden" name="username" value="${dto.username}"/>
                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                        <input type="submit" name="action" value="View"/>
                                    </form>
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>

            </c:if>
        </c:if>
        <a href="admin.jsp">Back to admin Page</a>
<jsp:include page="footer.jsp"/>
