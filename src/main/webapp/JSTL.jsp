<%@ page import="java.util.List" %>
<%@ page import="com.lc.el.User" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Lc
  Date: 2023/4/16
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%--核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="v" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL核心标签用法</title>
</head>
<body>
    <h2>c标签  c库</h2>
    <h3>c:if判断</h3>
    <%
        request.setAttribute("userAge",20);
    %>
    <h4>c:if标签 test属性,进行条件判断,结果是布尔类型值 必须掌握 没有else</h4>
    <p>用户是否成年
        <c:if test="${userAge < 18}">未成年</c:if>
        <c:if test="${userAge > 18}">成年</c:if>
    </p>

    <h4>var属性,保存test条件判断的结果 方便复用</h4>
    <%
        request.setAttribute("userSex",1);
    %>
    <p>
        用户性别
        <v:if test="${userSex == 1}" var="sexFlag">男</v:if>
        <v:if test="${!sexFlag}">女</v:if>
    </p>

    <h3>c:choose标签:多重if选择结构 必须掌握 有if else</h3>
    <%
        request.setAttribute("userSalary",10100.0);
    %>
    <p>
        职业等级:
        <c:choose>
            <c:when test="${userSalary < 8000}">白领</c:when>
            <c:when test="${userSalary < 12000}">蓝领</c:when>
            <c:when test="${userSalary < 20000}">金领</c:when>
            <c:otherwise>黑领</c:otherwise>
        </c:choose>
    </p>

    <h3>c:foreach标签 for循环必须掌握</h3>
    <%
        List<User> userList = Arrays.asList(
                User.builder().userId(1).userEmail("164@qq.com").userTel("666").userName("xiaom").build(),
                User.builder().userId(2).userEmail("164@1qq.com").userTel("666").userName("xiaom1").build(),
                User.builder().userId(3).userEmail("164@2qq.com").userTel("666").userName("xiaom2").build(),
                User.builder().userId(4).userEmail("164@3qq.com").userTel("666").userName("xiaom3").build(),
                User.builder().userId(5).userEmail("164@4qq.com").userTel("666").userName("xiaom4").build()
        );
        request.setAttribute("userList",userList);
    %>
    <h3>遍历用户</h3>
    <table border="1px" width="60%" cellspacing="0">
        <tr>
            <th>用户编号</th>
            <th>用户名称</th>
            <th>用户手机</th>
            <th>用户邮箱</th>
            <th>操作列表</th>
        </tr>
<%--        item属性:指定el表达式,从作用域中,获取要遍历的集合对象
            var属性：定义个类型变量 接收每一个遍历好的对象 类似增强for
            之后下面就可以直接用了
            varStatus属性 自定义一个状态遍历，可以获取遍历集合元素的序列号值属性，
            index是他的下标值从0开始
            count是从1开始计数
--%>
        <c:forEach items="${userList}" var="user" varStatus="status">
            <tr align="center">
                <td>${user.userId}--${status.index}--${status.count}</td>
                <td>${user.userName}</td>
                <td>${user.userTel}</td>
                <td>${user.userEmail}</td>
                <td><a href="#">修改</a></td>
            </tr>
        </c:forEach>
    </table>

   <h2>JSTL格式化标签库 又叫fmt 必须掌握</h2>
   <h3>格式化日期</h3>
   <%
       request.setAttribute("birthday",new Date());
   %>
   <p>不格式化,获取当前日期:${birthday}</p>
   <p>格式化,获取当前日期:<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></p>

   <h3>格式化数值</h3>
   <%
       request.setAttribute("userLeftMoney",1010.103);
   %>
   <h3>格式化数据之后:<fmt:formatNumber value="${userLeftMoney}" pattern="0.00"></fmt:formatNumber></h3>
</body>
</html>
