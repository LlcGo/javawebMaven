<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增论坛帖子</title>
</head>
<body>
<form action="details?method=addDetail" method="post">
	<table border="1px" width="50%" cellspacing="0" align="center">

		<tr style="height: 80px; font-size: 30px; background-color: cyan;">
			<th colspan="2">发布新帖</th>
		</tr>

		<tr style="height: 50px; font-size: 20px;">
			<td style="background-color: cyan; padding-left: 10px">发布版区：</td>
			<td><select name="sortId" id="sortId">
				<c:forEach items="${sortList}" var="sort">
					<option value="${sort.id}">${sort.name}</option>
				</c:forEach>
			</select></td>
		</tr>

		<tr style="height: 50px; font-size: 20px;">
			<td style="background-color: cyan; padding-left: 10px">作者：</td>
			<td><input type="text" name="author" id="author" size="30"/></td>
		</tr>

		<tr style="height: 50px; font-size: 20px;">
			<td style="background-color: cyan; padding-left: 10px">标题：</td>
			<td><input type="text" name="title" id="title" size="30"/></td>
		</tr>

		<tr style="height: 50px; font-size: 20px;">
			<td style="background-color: cyan; padding-left: 10px">详细内容：</td>
			<td>
				<textarea rows="5" cols="50" name="detail" id="detail" ></textarea>
			</td>
		</tr>

		<tr style="height: 50px; font-size: 30px; background-color: cyan;">
			<td colspan="2" style="text-align: center">
				<input type="submit" value="提&nbsp;&nbsp;交"/>
				<input type="button" value="返&nbsp;&nbsp;回" onclick="goBack()"/>
			</td>
		</tr>
	</table>

</form>
</body>
</html>