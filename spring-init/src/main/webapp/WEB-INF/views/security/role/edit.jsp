<c:import url="/WEB-INF/template/layout.jsp" charEncoding="UTF-8">
	<c:param name="title" value="Create Role" />
	<c:param name="body">

		<script type="text/javascript">
			$(document).ready(
					function() {
						var chk_value = "${role.viewPermissions}".split(",");
						/* for ( var e in chk_value) {
							 $('input:checkbox[value= "'+$.trim(chk_value[e])+'"]').attr('checked', true); 
							
						} */
						$.each(chk_value, function(key, val) {
						    // firebug console
						    console.log('index in arr:' + key + ", corresponding value:"+val);
						    $('input:checkbox[value= "'+$.trim(val)+'"]').attr('checked', true); 
						});
					});

			function generatePermissionString() {
				var chk_value = [];
				$('input[name="permission"]:checked').each(function() {
					chk_value.push($(this).val());
				});
				$('input[name="permissionStr"]').val(chk_value);
			}
		</script>
		<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/security/role/edit" method="post">
			<div align="left" style="width: 600px; margin-right: auto; margin-left: auto;">
				<div class="form-group">
					<label for="roleName" class="col-sm-2 control-label">角色名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="roleName" required value="${role.name}">
					</div>
				</div>
				<div class="form-group">
					<label for="roleDesc" class="col-sm-2 control-label">角色说明</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="roleDesc" required value="${role.description}">
					</div>
				</div>
				<div class="form-group">
					<label for="roleDesc" class="col-sm-2 control-label">角色权限</label>
					<div class="col-sm-10">
						 <c:forEach items="${permissions}" var="permission">
							<label><input type="checkbox" name="permission" value="${permission.abbreviation}">${permission.description}</label>
							<br />
						</c:forEach>
					</div>
				</div>
				<input type="text" name="permissionStr" hidden="true" />
				<input type="text" name="id" hidden="true" value="${role.id}"/>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" value="提交" onclick="generatePermissionString();" class="btn btn-primary" /> <input type="reset" value="重置"
							class="btn btn-default" />
					</div>
				</div>
			</div>
		</form>
	</c:param>
</c:import>

