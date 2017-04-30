<%@page import="com.kota.stratagem.weblayer.common.RegistrationAttribute"%>
<%@page import="com.kota.stratagem.ejbservice.domain.AppUserRepresentor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% AppUserRepresentor user= (AppUserRepresentor) request.getAttribute(RegistrationAttribute.ATTR_USER); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>:: Register ::</title>
</head>
<body>
	<h1>Register</h1>
	<div class="frame">
		<form method="post" action="Register">
			<div>
				<label>User name: </label>
				<input class="inputheader" type="text" name="username" value="${user.name}" />
				<br/><br/>
				<label>Email address: </label>
				<input class="inputheader" type="text" name="email" value="${user.email}" />
				<br/><br/>
				<label>Password: </label>
				<input class="inputheader" type="password" name="password" value="${user.passwordHash}" />
				<br/><br/>
				<label>Confirm password: </label>
				<input class="inputheader" type="password" name="password_confirmation" value="${user.passwordHash}" />
				<br/><br/>
			</div>
			<div>
				<input type="submit" value="Register" />&nbsp;
				<a href="ProjectList">cancel</a>
			</div>
		</form>
	</div>
</body>
</html>