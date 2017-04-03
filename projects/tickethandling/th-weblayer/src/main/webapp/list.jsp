<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.List"%>
<%@ page
	import="hu.qwaevisz.tickethandling.weblayer.common.ListAttribute"%>
<%@ page import="hu.qwaevisz.tickethandling.weblayer.common.FormValue"%>
<%@ page
	import="hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub"%>
<%@ page
	import="hu.qwaevisz.tickethandling.ejbservice.domain.PriorityStub"%>
<%@ page
	import="hu.qwaevisz.tickethandling.ejbservice.domain.StatusStub"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://qwaevisz.hu/jsp/tlds/tickettag" prefix="bt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/tickethandling.css" />

<script src="js/bootstrap.js"></script>
<title>:: Tickets ::</title>
</head>
<body>

	<jsp:include page="navbar.html"></jsp:include>>

	<div class="jumbotron jumbotron-ticketing">
		<bt:header>List of Tickets</bt:header>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<form method="post" action="TicketList" class="form-inline">
					<div class="form-group">
						<label for="priority">Priority:</label> <select name="priority"
							class="form-control" id="priority">
							<%
								String priorityName = (String) request.getAttribute(ListAttribute.ATTR_PRIORITY);
							%>
							<option value="-1"
								<%out.print(FormValue.FILTER_ALL_PRIORITY.equals(priorityName) ? "selected=\"selected\"" : "");%>>-</option>
							<c:set var="priorityValues" value="<%=PriorityStub.values()%>" />
							<c:forEach items="${priorityValues}" var="priority">
								<option value="${priority.name}"
									${priority.name eq requestScope.priority ? "selected=\"selected\"" : ""}>${priority.label}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="status">Status: </label> <select name="status"
							class="form-control" id="status">
							<%
								String statusName = (String) request.getAttribute(ListAttribute.ATTR_STATUS);
							%>
							<option value="-1"
								<%out.print(FormValue.FILTER_ALL_STATUS.equals(statusName) ? "selected=\"selected\"" : "");%>>-</option>
							<c:set var="statusValues" value="<%=StatusStub.values()%>" />
							<c:forEach items="${statusValues}" var="status">
								<option value="${status.name}"
									${status.name eq requestScope.status ? "selected=\"selected\"" : ""}>${status.label}
								</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-default">Filter</button>
				</form>
			</div>
			<div class="col-md-4" style="text-align: right;">
				<a href="Ticket?id=-1&edit=1">Create</a> a brand new ticket.
			</div>
		</div>
		<br />
		<br />
		<c:choose>
			<c:when test="${requestScope.tickets.isEmpty()}">
				<div class="row">
					<div class="col-md-12">
						Ticket list is <strong>empty</strong>.
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="row">
					<div class="col-sm-3 strong">ID</div>
					<div class="col-sm-1 strong">System</div>
					<div class="col-sm-1 strong">Priority</div>
					<div class="col-sm-2 strong">Status</div>
					<div class="col-sm-2 strong">Sender</div>
					<div class="col-sm-2 strong">Last changed on</div>
					<div class="col-sm-1 strong">Actions</div>
				</div>

				<c:forEach items="${requestScope.tickets}" var="ticket">
					<div class="row">
						<div class="col-sm-3">
							<a href="Ticket?id=<c:out value="${ticket.id}" />"><c:out
									value="${ticket.id}" /></a>
						</div>
						<div class="col-sm-1">
							<c:out value="${ticket.system}" />
						</div>
						<div class="col-sm-1">
							<c:out value="${ticket.priority.label}" />
						</div>
						<div class="col-sm-2">
							<c:out value="${ticket.status.label}" />
						</div>
						<div class="col-sm-2">
							<c:out value="${ticket.sender_name}" />
						</div>
						<div class="col-sm-2">
							<c:out value="${ticket.lastchanged}" />
						</div>
						<div class="col-sm-1">
							<a href="TicketDelete?id=<c:out value="${ticket.id}" />"><span
								class="glyphicon glyphicon-trash"></span></a> <a
								href="Ticket?id=<c:out value="${ticket.id}" />&edit=1"><span
								class="glyphicon glyphicon-edit"></span></a>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>


	</div>
</body>
</html>