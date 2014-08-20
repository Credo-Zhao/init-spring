<c:import url="/WEB-INF/template/layout.jsp" charEncoding="UTF-8">
	<c:param name="title" value="Create Person" />
	<c:param name="body">
		<div align="center" style="width: 600px;">
			<form:form action="." method="post" modelAttribute="role" cssClass="form-horizontal">
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">角色名称</label>
					<div class="col-sm-10">
						<form:input path="name" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label for="age" class="col-sm-2 control-label">角色说明</label>
					<div class="col-sm-10">
						<form:input path="description" cssClass="form-control" />
					</div>
				</div>
				<form:hidden path="id" />
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">提交</button>
						&nbsp;
						<button type="reset" class="btn">重置</button>
						&nbsp; <a href='${pageContext.request.contextPath}/person/list' class="btn">取消</a>
					</div>
				</div>
			</form:form>

		</div>
	</c:param>
</c:import>

