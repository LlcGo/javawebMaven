<%--
  Created by IntelliJ IDEA.
  User: Lc
  Date: 2023/4/16
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login" method="post">
    <table border="1px" width="40%" cellspacing="0" align="center">
        <tr height="50px">
            <td>用户名：</td>
            <td>
                <input type="text" name="uname" id="uname" size="30"/>
            </td>
        </tr>
        <tr height="50px">
            <td>用户密码：</td>
            <td>
                <input type="password" name="upwd" id="upwd" size="30"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
