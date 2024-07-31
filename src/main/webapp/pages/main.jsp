<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
    <c:if test="${not empty stringParam}">
        <h2>String param : ${stringParam}</h2>
    </c:if>
    <c:if test="${not empty intParam}">
        <h2>Int param : ${intParam}</h2>
    </c:if>
</body>
</html>
