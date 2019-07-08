<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="<%= basePath %>">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>login.jsp</title>
<style type="text/css">
body {
	background: url("images/view.jpg");
}

div {
	width: 400px;
	height: 400px;
	border: 1px solid white;
	margin: 0 auto;
	margin-top: 100px;
	background-color: RGB(26, 50, 50);
}

form {
	margin: 0 auto;
	margin-top: 200px;
	margin-left: 100px;
}
</style>
</head>
<body>
	<div>
		<form action="user/login.action" method="post">
			<table>
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="reset" value="重置">&nbsp&nbsp
						<input type="submit" value="登录"></td>
				</tr>
			</table>


		</form>
	</div>
</body>
<script type="text/javascript">
	var msg = "${msg}";
	if(msg){
		alert(msg);
	}
</script>
<c:remove var="msg" scope="session" />
</html>