<%--
  Created by IntelliJ IDEA.
  User: Lc
  Date: 2023/4/22
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <ul>
             <c:forEach items="${addressPage}" var="address">
                 <li>${address.address_areaId}</li>
                 <li>${address.address_name}</li>
                 <li>${address.address_regionId}</li>
             </c:forEach>
    </ul>
</body>
</html>
