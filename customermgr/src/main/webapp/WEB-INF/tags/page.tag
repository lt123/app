<%@tag pageEncoding="UTF-8" description="分页"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="page" type="com.app.common.page.PageResult"
	required="true" description="分页对象"%>

<table width="100%" align="center">
	<tr>
		<td><span class="page-info">[共有记录${pageResult.totalCount}条
				/ 共分${pageResult.totalPage}页 ， 当前是第 ${pageResult.currentPage} 页]</span>
				每页 :${pageResult.pageSize }条
				<select>
					<option value="5">10</option>
					<option value="10" selected>20</option>
					<option value="20">50</option>
				</select>		
		</td>
	</tr>
	<tr>
		<td>
			<c:choose>
				<c:when test="${pageResult.currentPage == 1}">
					<font color="#FF0000">首页</font>
				</c:when>
				<c:when test="${pageResult.currentPage != 1}">
					<a href='${pageContext.request.contextPath}/customer/list/1/${pageResult.pageSize}' title="首页">首页</a>
				</c:when>
			</c:choose>
			
			<a href="#">上页</a>
			<a href="#">下页</a>
			<a href="#">末页</a>
		</td>
	</tr>
</table>