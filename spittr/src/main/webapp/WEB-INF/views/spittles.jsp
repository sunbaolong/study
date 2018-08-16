<%--
  Created by IntelliJ IDEA.
  User: sunbaolong
  Date: 2018/7/15
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%> <!--支持EL表达式，不设的话，EL表达式不会解析-->

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:out value="${test}"/>
<c:forEach items="${spittleList}" var="spittle">
    <li id="spittle_<c:out value="spittle.id"/>">
        <div class="spittleMessage">
            <c:out value="${spittle.message}"/>
        </div>
        <div>
            <span class="spittleTime"><c:out value="${spittle.time}"/></span>
            <span class="spittleLocation">(<c:out value="${spittle.latitude}"/>,<c:out value="${spittle.longitude}"/>)</span>
        </div>
    </li>
</c:forEach>

</body>
</html>
