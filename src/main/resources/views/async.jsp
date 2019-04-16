<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; UTF-8" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Spring-MVC</title>
</head>
<body>
<script type="text/javascript" src="${ctxPath}/static/js/jquery-3.3.1.min.js"></script>
<script>
    deferred();
    function deferred () {
        $.get('defer', function (data) {
            console.log(data);
            deferred();
        })
    };
</script>
</body>
</html>