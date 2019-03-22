<%-- 
    Document   : insert_tour
    Created on : Feb 23, 2019, 3:19:43 PM
    Author     : Thang
--%>

<%@page import="thang.constants.Location"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
        <h1>Insert Tour</h1>
        <form action="MainTourController" method="POST" enctype="multipart/form-data" >
            Tour Name: <input name="txtTourName" type="text" />
            <font color="red">
            ${requestScope.INVALID.tourNameInvalid}
            </font><br/>
            Tour Duration <input name="txtTourDuration" type="text" />
            <font color="red">
            ${requestScope.INVALID.tourDurationInvalid}
            </font><br/>
            Tour Origin:
            <select name="cbxTourOrigin">
                <c:forEach items="<%= Location.values()%>" var="location">
                    <option value="${location.location}">${location.location}</option>
                </c:forEach>
            </select><br/>
            Tour Destination:
            <select name="cbxTourDes">
                <c:forEach items="<%= Location.values()%>" var="location">
                    <option value="${location.location}">${location.location}</option>
                </c:forEach>
            </select><br/>
            Description:<br/> 
            <textarea name="txtDescription" rows="5" cols="60"></textarea>
            <br/>
            <input type="file" name="chooseImg" accept="image/*" onchange="handleFileSelect(this)" /><br/>
            <img id="img"  height="350px" src="#"/><br/>
            <input type="submit" value="Insert" name="action"/>
        </form>

    </body>
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
<jsp:include page="footer.jsp"/>
