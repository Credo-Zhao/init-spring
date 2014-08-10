<c:import url="/WEB-INF/template/layout.jsp" charEncoding="UTF-8">
	<c:param name="title" value="PersonList" />
	<c:param name="body">
		<p>
			<a href='${pageContext.request.contextPath}/person/form/' class="btn btn-info">CREATE</a>
		</p>
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
		<div align="left">
			<ul class="pagination" style="margin-top: 0px;">
				<!-- 总页数 -->
				<li><a href="#">${(pagingPerson.number + 1)}/${pagingPerson.totalPages}</a></li>
				<!-- 首页 -->
				<li><a href='<c:url value="?page=0" />'>&laquo;&laquo; 首页</a></li>
				<!-- 上一页 -->
				<li><c:if test="${!pagingPerson.isFirst()}">
						<a href='<c:url value="?page=${f:h(pagingPerson.number - 1)}" />'>&laquo; 上一页</a>
					</c:if></li>
				<li class="disabled"><c:if test="${pagingPerson.isFirst()}">
						<a href='#" />'>&laquo;上一页</a>
					</c:if></li>
				<!-- 中间五个 -->
				<li><c:if test="${pagingPerson.number-1>0}">
						<a href='<c:url value="?page=${f:h(pagingPerson.number-2)}" />'>${f:h(pagingPerson.number-1)}</a>
					</c:if></li>
				<li><c:if test="${pagingPerson.hasPrevious()}">
						<a href='<c:url value="?page=${f:h(pagingPerson.number-1)}" />'>${f:h(pagingPerson.number)}</a>
					</c:if></li>

				<li class="active"><a href='<c:url value="?page=${f:h(pagingPerson.number)}" />'>${f:h(pagingPerson.number+1)}</a></li>

				<li><c:if test="${pagingPerson.hasNext()}">
						<a href='<c:url value="?page=${f:h(pagingPerson.number+1)}" />'>${f:h(pagingPerson.number+2)}</a>
					</c:if></li>
				<li><c:if test="${pagingPerson.number+2<pagingPerson.totalPages}">
						<a href='<c:url value="?page=${f:h(pagingPerson.number+2)}" />'>${f:h(pagingPerson.number+3)}</a>
					</c:if></li>
				<!-- 下一页 -->
				<li><c:if test="${!pagingPerson.isLast()}">
						<a href='<c:url value="?page=${f:h(pagingPerson.number + 1)}" />'>下一页 &raquo;</a>
					</c:if></li>
				<li class="disabled"><c:if test="${pagingPerson.isLast()}">
						<a href='#'>下一页&raquo;</a>
					</c:if></li>
				<!-- 尾页 -->
				<li><a href='<c:url value="?page=${pagingPerson.totalPages-1}" />'>尾页 &raquo;&raquo;</a></li>
			</ul>
		</div>
	</c:param>
</c:import>

