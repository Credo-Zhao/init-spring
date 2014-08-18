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
					<td><button onclick="editUser('${pageContext.request.contextPath}/security/user/edit/${user.id}')" class="btn btn-primary btn-xs"
							data-toggle="modal" data-target="#editModal">edit</button>&nbsp;&nbsp; <a
						href='${pageContext.request.contextPath}/security/user/delete/${user.id}'>delete</a></td>
				<tr>
			</c:forEach>
		</table>

		<!-- Button trigger modal -->
		<button class="btn btn-primary" data-toggle="modal" data-target="#createModal">新建用户</button>

		<!-- Create Modal -->
		<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
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
							<button type="submit" class="btn btn-primary">确定</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<script type="text/javascript">
			function editUser(path) {
				alert(path);
				$.ajax({
					url : path,
					type : 'get',
					async : true,
					dataType: "json",
					success: function(user){
						alert(user.employeeId);
                        $('#name').empty();   //清空resText里面的所有内容
                        $('#employeeId').empty();
                        $('#name').val(user.name);
                        $('#employeeId').val(user.employeeId);
                        $('#realName').val(user.realName);
                        $('#email').val(user.email);
                        $('#mobile').val(user.mobile);
                     }
				});
			}
		</script>

		<!-- Edit Modal -->
		<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
			<div class="modal-dialog">
				<form:form id="editForm" action="${pageContext.request.contextPath}/security/user/edit" method="post" modelAttribute="user">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">
								<b>编辑用户信息</b>
							</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<input class="form-control" id="name" type="text" name="name" placeholder="用户账户" required>
							</div>
							<div class="form-group">
								<input class="form-control" type="password" name="password" placeholder="密码" required>
							</div>
							<div class="form-group">
								<input class="form-control" id="employeeId" type="text" name="employeeId" placeholder="员工ID" required>
							</div>
							<div class="form-group">
								<input class="form-control" id="realName" type="text" name="realName" placeholder="真实姓名" required>
							</div>
							<div class="form-group">
								<input class="form-control" id="email" type="email" name="email" placeholder="Email" required>
							</div>
							<div class="form-group">
								<input class="form-control" id="mobile" type="number" name="mobile" placeholder="手机" required>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">确定</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>


	</c:param>
</c:import>

