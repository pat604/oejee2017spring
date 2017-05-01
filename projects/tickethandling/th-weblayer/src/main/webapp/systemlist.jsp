<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.List"%>
<%@ page
	import="hu.qwaevisz.tickethandling.weblayer.common.ListAttribute"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://qwaevisz.hu/jsp/tlds/tickettag" prefix="bt"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.html"></jsp:include>
</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="jumbotron jumbotron-ticketing">
		<bt:header>List of Systems</bt:header>
	</div>
	<div class="container">
		<br /> <br />
		<div class="row">
			<div class="col-sm-2 strong">ID</div>
			<div class="col-sm-3 strong">Company Name</div>
			<div class="col-sm-7 strong">Components</div>
		</div>

		<c:forEach items="${requestScope.systems}" var="system">
			<div class="row">
				<div class="col-sm-2">
					<c:out value="${system.id}" />
				</div>
				<div class="col-sm-3">
					<c:out value="${system.company_name}" />
				</div>
				<div class="col-sm-7">
					<c:forEach items="${system.components}" var="component">
						<c:out value="${component.id}," />
					</c:forEach>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>