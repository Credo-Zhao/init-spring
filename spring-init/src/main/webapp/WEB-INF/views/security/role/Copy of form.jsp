<c:import url="/WEB-INF/template/layout.jsp" charEncoding="UTF-8">
	<c:param name="title" value="Create Role" />
	<c:param name="body">

		<div align="center" style="width: 600px; margin-right: auto; margin-left: auto;">
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label for="roleName" class="col-sm-2 control-label">角色名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="roleName" required>
					</div>
				</div>
				<div class="form-group">
					<label for="roleDesc" class="col-sm-2 control-label">角色说明</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="roleDesc" required>
					</div>
				</div>
				<div class="form-group">
					<label for="roleDesc" class="col-sm-2 control-label">权限设置</label>
					<div class="col-sm-10" align="left">
						<p>用户模块设置：</p>
						<label style="width: 150px"> <input type="checkbox">User:所有
						</label> <label style="width: 150px"> <input type="checkbox">User:查看
						</label> <br />
						<p>权限模块设置：</p>
						<label style="width: 150px"> <input type="checkbox">Role:所有
						</label> <label style="width: 150px"> <input type="checkbox">Role:查看
						</label> <br />
						<p>License模块设置：</p>
						<label style="width: 150px"> <input type="checkbox">License:所有
						</label> <label style="width: 150px"> <input type="checkbox">License:查看
						</label>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">提交</button>
						&nbsp;
						<button type="reset" class="btn">重置</button>
						&nbsp; <a href='${pageContext.request.contextPath}/security/role/list' class="btn">取消</a>
					</div>
				</div>
			</form>
		</div>

	</c:param>
</c:import>

