<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/bootstrap/bootstrap.min.css" />" rel="stylesheet" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.10.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap/bootstrap.min.js" />"></script>
<title>${param.title}</title>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/home">Spring-Init</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<!-- menu -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
					<li><a class="navbar-brand" href="${pageContext.request.contextPath}/person/list">Person</a></li>
					<li><a class="navbar-brand" href="${pageContext.request.contextPath}/security/user/list">用户</a></li>
					<li><a class="navbar-brand" href="${pageContext.request.contextPath}/security/role/list">权限</a></li>
			</ul>
			<shiro:authenticated>
				<form class="navbar-form navbar-right" role="search" style="margin-top: 15px;">
				</form>
			</shiro:authenticated>
		</div>
		<!-- /.navbar-collapse -->
	</nav>

	<div>${param.body}</div>

	<nav class="navbar-default navbar-fixed-bottom" role="navigation">
		<div style="height: 17px; font-size: 9px;" align="center">
			<strong>Copyright &nbsp;&copy;&nbsp; 2014 &nbsp;&bull;&nbsp; TaiYuan Credo Software Co., Ltd. &nbsp;All
				rights reserved.</strong>
		</div>
	</nav>
</body>
</html>