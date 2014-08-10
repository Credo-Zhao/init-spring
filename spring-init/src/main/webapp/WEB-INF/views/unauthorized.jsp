<c:import url="/WEB-INF/template/layout.jsp" charEncoding="UTF-8">
	<c:param name="title" value="没有权限" />
	<c:param name="body">
		<div style="color: red;">您没有权限[${exception.message}]</div>
	</c:param>
</c:import>

