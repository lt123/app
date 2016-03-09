<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<table border="1" width="50%" height="50%" cellspacing="0" align="center">
		<tr>
			<th colspan="6">customer list</th>
		</tr>	
		<tr align="center">
			<td>客户编号</td>
			<td>显示名称</td>
			<td>真实名称</td>
			<td>客户密码</td>
			<td>注册时间</td>
			<td>操作</td>
		</tr>
		
		<c:forEach items="${pageResult.rows }" var="m">
		</c:forEach>
		
	</table>
	
</body>
</html>
