<c:import url="/WEB-INF/template/layout.jsp" charEncoding="UTF-8">
	<c:param name="title" value="角色列表" />
	<c:param name="body">
		<p>
			<a href='${pageContext.request.contextPath}/security/role/form' class="btn btn-info">CREATE</a>
		</p>
		<table class="table table-hover table-condensed table-bordered" style="margin-bottom: 0px;">
			<tr>
				<th>角色名称</th>
				<th>说明</th>
				<th>权限列表</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${roleList}" var="role">
				<tr>
					<td>${role.name}</td>
					<td>${role.description}</td>
					<td>${role.viewPermissions}</td>
					<td><a href='${pageContext.request.contextPath}/security/role/edit/${role.id}'>edit</a>&nbsp;&nbsp; <a
						href='${pageContext.request.contextPath}/person/role/${role.id}'>delete</a></td>
				<tr>
			</c:forEach>
		</table>
	</c:param>
</c:import>

