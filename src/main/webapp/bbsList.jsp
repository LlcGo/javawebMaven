<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论坛管理系统主页</title>
</head>
<body>
	<h2 style="text-align: center">课工场KH101论坛管理系统</h2>
	<form action="details" method="post">
		<input type="hidden" name="method" value="detailList"/>
		<p style="text-align: center">
			讨论版区：
			  <select name="sortId" id="sortId">
					<option value="0">全部</option>
				  <c:forEach items="${sortList}" var="sort">
					  <option value="${sort.id}">${sort.name}</option>
				  </c:forEach>
				</select>
			<input type="submit" id="searchBtn" value="搜索"/>
			<input type="button" onclick="to()" value="发帖"/>
		</p>
	</form>
	
	<table border="1px" width="90%" cellspacing="0" align="center">
		<thead>
			<tr style="height: 80px; font-size: 30px; background-color: cyan;">
				<th colspan="8">论坛帖子详情列表</th>
			</tr>
			<tr>
				<th colspan="8" style="text-align: right;">
					欢迎:&nbsp;&nbsp;${loginUser }&nbsp;&nbsp; <a href="logout">退出登录</a>
				</th>
			</tr>
			<tr style="height: 40px; background-color: cyan;">
				<th>编号</th>
				<th>版区</th>
				<th>主题</th>
				<th>详情</th>
				<th>作者</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
            <c:forEach items="${detailList}" var="detail">
				<tr align="center">
				<td>${detail.id}</td>
				<td>${detail.sortId}</td>
				<td>${detail.title}</td>
				<td>${detail.detail}</td>
				<td>${detail.author}</td>
				<td>${detail.createDate}</td>
				<td>
					<a href="#">修改</a>&nbsp;&nbsp;<a href="#">删除</a>
				</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="8" style="height: 40px; text-align: center;">
					<a href="#">首页</a>&nbsp;|&nbsp;
					<a href="#">&lt;&lt;上一页</a>&nbsp;|&nbsp;
					<a href="#">下一页&gt;&gt;</a>&nbsp;|&nbsp;
					<a href="#">尾页</a>&nbsp;|&nbsp;
					共&nbsp;5&nbsp;条&nbsp;&nbsp;每页&nbsp;5&nbsp;条&nbsp;&nbsp;
					当前第&nbsp;1&nbsp;页&nbsp;/&nbsp;共&nbsp;1&nbsp;页
				</td>
			</tr>
		</tfoot>
	</table>
</body>
<script type="text/javascript">
function to() {
  location.href = "details?method=toAddDetail"
}

</script>
</html>