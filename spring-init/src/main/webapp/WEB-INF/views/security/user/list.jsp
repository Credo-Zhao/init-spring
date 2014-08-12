<c:import url="/WEB-INF/template/layout.jsp" charEncoding="UTF-8">
	<c:param name="title" value="用户管理" />
	<c:param name="body">
		<table class="table table-hover table-condensed table-bordered" style="margin-bottom: 0px;">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>AGE</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${pagingPerson.content}" var="person">
				<tr>
					<td style="width: 400px;">${person.id}</td>
					<td>${person.name}</td>
					<td>${person.age}</td>
					<td><a href='${pageContext.request.contextPath}/person/edit/${person.id}'>edit</a>&nbsp;&nbsp; <a
						href='${pageContext.request.contextPath}/person/delete/${person.id}'>delete</a></td>
				<tr>
			</c:forEach>
		</table>
	</c:param>
</c:import>

