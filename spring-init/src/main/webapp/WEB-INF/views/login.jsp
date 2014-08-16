<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
<title>Login</title>
<link href="<c:url value="/resources/bootstrap/bootstrap.min.css" />" rel="stylesheet" />
<style>
body {
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	font-size: 16px;
	height: auto;
	padding: 10px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="text"] {
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

.form-signin input[type="password"] {
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
<script type="text/javascript">
	function refreshImage() {
		document.getElementById("captchaImage").setAttribute("src",
				"Kaptcha.jpg?" + Math.round(Math.random() * 10000));
	}
</script>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Welcome To Credo's Notifier</a>
		</div>
	</nav>

	<div class="container">
		<c:if test="${message!=null}">
			<div class="alert alert-danger" role="alert">${message}</div>
		</c:if>
		<form class="form-signin" method="post" action="${pageContext.request.contextPath}/login">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input  name="username" class="form-control" placeholder="Login UserName" required autofocus> <input type="password"
				name="password" class="form-control" placeholder="Password" required> <input type="text" name="code" class="form-control"
				placeholder="Verification code" required style="margin-bottom: 15px;">

			<div>
				<div style="float: left; margin-top: 10px;">
					<label class="checkbox" style="margin-left: 20px;"> <input type="checkbox" value="remember-me"> Remember me
					</label>
				</div>
				<div style="float: right">
					<img src="${pageContext.request.contextPath}/Kaptcha.jpg" id="captchaImage" onclick="javascript:refreshImage()" />
				</div>
			</div>

			<button class="btn btn-lg btn-primary btn-block" style="margin-top: 90px;" type="submit">Sign in</button>

		</form>
	</div>
</body>
</html>