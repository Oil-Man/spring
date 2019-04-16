<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; UTF-8" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Spring-MVC</title>
</head>
<body>
    <div class="upload">
        <form action="upload" enctype="multipart/form-data" method="post">
            <input type="file" name="file">
            <input type="submit" value="上传">
        </form>
    </div>
    <div>
        <p>图片展示</p>
        <c:if test="${ filePath != null }">
            <img src="${ctxPath}${filePath}" alt="" width="200px" height="200px">
        </c:if>
    </div>
</body>
</html>