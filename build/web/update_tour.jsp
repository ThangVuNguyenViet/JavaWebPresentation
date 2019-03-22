<%-- 
    Document   : update_tour
    Created on : Feb 23, 2019, 3:43:57 PM
    Author     : Thang
--%>

<%@page import="thang.constants.Location"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<h1>Update Tour</h1>
<form action="MainTourController" method="POST" enctype="multipart/form-data">
    Tour Id: <input name="txtTourId" type="text" readonly="true" value="${requestScope.DTO.tourId}"/><br/>
    Tour Name: <input name="txtTourName" type="text" value="${requestScope.DTO.tourName}"/>
    <font color="red">
    ${requestScope.INVALID.tourNameInvalid}
    </font><br/>
    Tour Duration <input name="txtTourDuration" type="text" value="${requestScope.DTO.tourDuration}"/>
    <font color="red">
    ${requestScope.INVALID.tourDurationInvalid}
    </font><br/>
    Tour Origin:
    <select name="cbxTourOrigin">
        <c:forEach items="<%= Location.values()%>" var="LOCATION">
            <c:if test="${requestScope.DTO.tourOrigin eq LOCATION.location}" var="checkOri">
                <option value="${LOCATION.location}" selected>${LOCATION.location}</option>
            </c:if>
            <c:if test="${!checkOri}">
                <option value="${LOCATION.location}">${LOCATION.location}</option>
            </c:if>
        </c:forEach>
    </select><br/>
    Tour Destination:
    <select name="cbxTourDes">
        <c:forEach items="<%= Location.values()%>" var="LOCATION">
            <c:if test="${requestScope.DTO.tourDes eq LOCATION.location}" var="checkDes">
                <option value="${LOCATION.location}" selected>${LOCATION.location}</option>
            </c:if>
            <c:if test="${!checkDes}">
                <option value="${LOCATION.location}">${LOCATION.location}</option>
            </c:if>
        </c:forEach>
    </select><br/>
    Description:<br/> 
    <textarea name="txtDescription" rows = "5" cols = "60">${requestScope.DTO.description}</textarea>
    <br/>
    <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
    <input type="file" name="chooseImg" accept="image/*" onchange="handleFileSelect(this)" /><br/>
    <input type="hidden" name="imgUrl" value="${requestScope.DTO.imgUrl}"/>
    <img style="width: 350px" id="img"  height="350px" src="${requestScope.DTO.imgUrl}"/><br/>
    <input type="submit" name="action" value="Update"/>
</form>
<jsp:include page="footer.jsp"/>
<script>
    if (window.FileReader) {
        function handleFileSelect(input) {
            var f = input.files[0];
            var reader = new FileReader();

            reader.onload = (function (theFile) {
                return function (e) {
                    document.getElementById('img').src = e.target.result;
                    document.getElementById('img').title = theFile.name;
                };
            })(f);

            reader.readAsDataURL(f);
        }
    } else {
        alert('This browser does not support FileReader');
    }
</script>
