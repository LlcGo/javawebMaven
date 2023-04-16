<%@ page import="com.lc.el.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: Lc
  Date: 2023/4/16
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式的用法</title>
</head>
<body>
   <%
       //el表达式,都是从作用域中取值
       request.setAttribute("userName","xiaoming");
   %>
   <h2>jsp表达式取值和EL表达式取值</h2>
<%--   <p>jsp表达式:userName_jsp = <%=request.getAttributeNames("userName")%></p>--%>
   <p>jsp表达式:userName_jsp = ${userName}</p>
<%--el表达式获取不到为没有 jsp直接是null--%>
<%--   <p>jsp表达式:userName_jsp = <%=request.getAttributeNames("nickName")%></p>--%>
   <p>jsp表达式:userName_jsp = ${nickName}</p>

<h2>EL表达式取值作用域</h2>
   <h3>细节1：没有找到的就不会自动查找</h3>
   <h3>细节2：不指定作用域 获取属性从小到大依次查找，获取不到就空</h3>
   <h3>细节3：查找顺序：pageScope -> requestScope -> sessionScope -> applicationScope</h3>
   <%
       request.setAttribute("userTel","123456");
       session.setAttribute("userEmail","123456@qq.com");
   %>
<p>EL表达式指定作用域取值：request作用域 yrlTel_requset = ${requestScope.userTel}</p>
<p>EL表达式指定作用域取值：session作用域 yrlTel_requset = ${sessionScope.userEmail}</p>
<p>EL表达式不指定作用域取值： userTel = ${userTel},userEmail = ${userEmail}</p>
<p>EL表达式指定作用域取值：值不存在 session作用域 user_session=${nc}</p>

<h2>EL表达式取值操作符</h2>
   <h2>操作符 . []</h2>
<%
    //创建用户对象
    User user = User.builder().userId(101).userName("xw").userTel("123456").userEmail("164@qq.com").build();
    request.setAttribute("user",user);
    User user2 = User.builder().userId(101).userName("xw").userTel("123456").userEmail("164@qq.com").build();
    //集合
    List<User> userList = Arrays.asList(user,user2);
    request.setAttribute("userList",userList);
    //map集合
    Map<String,User> userMap = new HashMap<>();
    userMap.put("userOne",user);
    userMap.put("userTwo",user2);
    request.setAttribute("userMap",userMap);
%>
   <p>
       用户详情:[${user.userId},${user.userName},${user.userTel},${user.userEmail}]
       用户详情1:[${userList[0].userId},${userList[0].userName},${userList[0].userTel},${userList[0].userEmail}]
       用户详情2:[${userList[1].userId},${userList[1].userName},${userList[1].userTel},${userList[1].userEmail}]
       用户详情3:[${userMap["userTwo"].userId},${userMap["userTwo"].userName},${userMap["userTwo"].userTel},${userMap["userTwo"].userEmail}]
       用户详情4:[${userMap["userOne"].userId},${userMap["userOne"].userName},${userMap["userOne"].userTel},${userMap["userOne"].userEmail}]
   </p>

    <%
        request.setAttribute("userNum",101);
    %>

    <h3>算数运算符</h3>
    <p>${userNum-100}</p>

   <h3>控制判断用 empty</h3>
   <%
       request.setAttribute("userEmpty","");
       request.setAttribute("userNull",null);
       request.setAttribute("userListEmpty",new ArrayList<>());
   %>
   <p>空值判断 ${userEmpty == ""},${empty userEmpty}</p>
   <p>null判断 ${userNull == null},${empty userNull}</p>
   <p>集合空判断 ${userListEmpty == null},${empty userListEmpty}</p>
</body>
</html>
