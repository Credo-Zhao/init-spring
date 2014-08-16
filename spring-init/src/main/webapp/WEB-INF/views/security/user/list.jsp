<c:import url="/WEB-INF/template/layout.jsp" charEncoding="UTF-8">
	<c:param name="title" value="用户管理" />
	<c:param name="body">
		<c:if test="${message!=null}">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		<table class="table table-hover table-bordered" style="margin-bottom: 0px;">
			<tr>
				<th>登录帐号</th>
				<th>员工ID</th>
				<th>姓名</th>
				<th>Email</th>
				<th>手机</th>
				<th>最后登录时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pageUser.content}" var="user">
				<tr>
					<td>${user.name}</td>
					<td>${user.employeeId}</td>
					<td>${user.realName}</td>
					<td>${user.email}</td>
					<td>${user.mobile}</td>
					<td>${user.lastLogin}</td>
					<td><a href='${pageContext.request.contextPath}/security/user/edit/${user.id}'>edit</a>&nbsp;&nbsp; <a
						href='${pageContext.request.contextPath}/security/user/delete/${user.id}'>delete</a></td>
				<tr>
			</c:forEach>
		</table>

		<!-- Button trigger modal -->
		<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">新建用户</button>

		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
			<div class="modal-dialog">
				<form role="form" action="${pageContext.request.contextPath}/security/user/create" method="post">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">
								<b>创建新用户</b>
							</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<input class="form-control" type="text" name="name" placeholder="用户账户" required>
							</div>
							<div class="form-group">
								<input class="form-control" type="password" name="password" placeholder="密码" required>
							</div>
							<div class="form-group">
								<input class="form-control" type="text" name="employeeId" placeholder="员工ID" required>
							</div>
							<div class="form-group">
								<input class="form-control" type="text" name="realName" placeholder="真实姓名" required>
							</div>
							<div class="form-group">
								<input class="form-control" type="email" name="email" placeholder="Email" required>
							</div>
							<div class="form-group">
								<input class="form-control" type="number" name="mobile" placeholder="手机" required>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">确定新增用户</button>
						</div>
					</div>
				</form>
			</div>
		</div>

	</c:param>
</c:import>

