<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="pageTag" tagdir="/WEB-INF/tags"%>
<html>
<body>

	<table border="1" width="50%" height="50%" cellspacing="0"
		align="center">
		<tr>
			<th colspan="6">customer list</th>
		</tr>
		<tr>
			<td align="center">客户编号</td>
			<td align="center">显示名称</td>
			<td align="center">真实名称</td>
			<td align="center">客户密码</td>
			<td align="center">注册时间</td>
			<td align="center">操作</td>
		</tr>
		<c:forEach items="${pageResult.rows }" var="v">
			<tr>
				<td align="center">${v.customerId}</td>
				<td align="center">${v.showName}</td>
				<td align="center">${v.trueName}</td>
				<td align="center">${v.pwd}</td>
				<td align="center">${v.registerTime}</td>
				<td align="center"><a
					href='${pageContext.request.contextPath}/customer/delete/${v.uuid}/${pageResult.currentPage}/${pageResult.pageSize}'>删除</a>
					<a
					href='${pageContext.request.contextPath}/customer/delete/${v.uuid}/${pageResult.currentPage}/${pageResult.pageSize}'>修改</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="center">
				<pageTag:page page="${page }"/>
			</td>
		</tr>
	</table>


</body>
</html>
