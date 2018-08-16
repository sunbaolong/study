<%--
  Created by IntelliJ IDEA.
  User: sunbaolong
  Date: 2018/7/15
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:out value="${spitter.userName}"/><br>
<c:out value="${spitter.firstName}"/>
<c:out value="${spitter.lastName}"/>
</body>
</html>
