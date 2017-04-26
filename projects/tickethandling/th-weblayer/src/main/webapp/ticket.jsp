<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page
	import="hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub"%>
<%@ page
	import="hu.qwaevisz.tickethandling.ejbservice.domain.PriorityStub"%>
<%@ page
	import="hu.qwaevisz.tickethandling.ejbservice.domain.StatusStub"%>
<%@ page
	import="hu.qwaevisz.tickethandling.ejbservice.domain.EmployeeStub"%>
<%@ page
	import="hu.qwaevisz.tickethandling.ejbservice.domain.SystemStub"%>
<%@ page
	import="hu.qwaevisz.tickethandling.weblayer.common.TicketAttribute"%>
<%@ page
	import="hu.qwaevisz.tickethandling.persistence.entity.Message"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://qwaevisz.hu/jsp/tlds/tickettag" prefix="bt"%>
<%
	TicketStub ticket = (TicketStub) request.getAttribute(TicketAttribute.ATTR_TICKET);
	ArrayList<SystemStub> syss = (ArrayList<SystemStub>) request.getAttribute(TicketAttribute.ATTR_SYSTEMS);
	ArrayList<EmployeeStub> emps = (ArrayList<EmployeeStub>) request.getAttribute(TicketAttribute.ATTR_EMPLOYEES);
%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.html"></jsp:include>
</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="jumbotron jumbotron-ticketing">
		<h1>
			<%
				out.print(ticket.getId());
			%>
		</h1>
	</div>
	<div class="container table-ticketing">
		<div class="row">
			<div class="col-md-6">
				<h3>Overview</h3>
				<span class="line-ticketing"></span>
				<form>
					<input type="text" name="id" id="id" hidden="hidden"
						contenteditable="false" value="<%out.print(ticket.getId());%>" />

					<div class="form-group">
						<label class="control-label" for="system">System: </label> <select
							class="form-control" name="system" id="system"
							disabled="disabled">
							<%
								for (SystemStub sys : syss) {
							%>
							<option value="<%out.print(sys.getId());%>"
								<%out.print(ticket.getSystem() != null && sys.getId().equals(ticket.getSystem().getId()) ? "selected=\"selected\"" : "");%>>
								<%
									out.print(sys.getId());
								%>
							</option>
							<%
								}
							%>
						</select>
					</div>

					<div class="form-group">
						<label class="control-label" for="processor">Processor: </label> <select
							class="form-control" name="processor" id="processor"
							disabled="disabled">
							<%
								for (EmployeeStub emp : emps) {
							%>
							<option value="<%out.print(emp.getId());%>"
								<%out.print(ticket.getProcessor() != null && emp.getId().equals(ticket.getProcessor().getId()) ? "selected=\"selected\"" : "");%>>
								<%
									out.print(emp.getId());
								%>
							</option>
							<%
								}
							%>
						</select>
					</div>

					<div class="form-group">
						<label class="control-label" for="level">Level: </label> <input
							class="form-control" type="number" name="level" id="level"
							max="3" min="1" value="<%out.print(ticket.getLevel());%>"
							disabled="disabled" />
					</div>
					<div class="form-group">
						<label class="control-label" for="sender_name">Sender
							name: </label> <input class="form-control" type="text" name="sender_name"
							id="sender_name" value="<%out.print(ticket.getSender_name());%>"
							disabled="disabled" />

					</div>
					<div class="form-group">
						<label class="control-label" for="business_impact">Business
							impact: </label> <input class="form-control" type="text"
							name="business_impact" id="business_impact"
							value="<%out.print(ticket.getBusiness_impact());%>"
							disabled="disabled" />

					</div>
					<div class="form-group">
						<label class="control-label" for="steps_to_rep">Steps to
							reproduce the issue: </label> <input class="form-control" type="text"
							name="steps_to_rep" id="steps_to_rep"
							value="<%out.print(ticket.getSteps_to_rep());%>"
							disabled="disabled" />

					</div>
					<div class="form-group">
						<label class="control-label" for="priority">Priority: </label> <select
							class="form-control" name="priority" id="priority"
							disabled="disabled">
							<%
								for (PriorityStub priority : PriorityStub.values()) {
							%>
							<option value="<%out.print(priority.name());%>"
								<%out.print(priority == ticket.getPriority() ? "selected=\"selected\"" : "");%>>
								<%
									out.print(priority.getLabel());
								%>
							</option>
							<%
								}
							%>
						</select>

					</div>
					<div class="form-group">
						<label class="control-label" for="status">Status: </label> <select
							class="form-control" name="status" id="status"
							disabled="disabled">
							<%
								for (StatusStub status : StatusStub.values()) {
							%>
							<option value="<%out.print(status.name());%>"
								<%out.print(status == ticket.getStatus() ? "selected=\"selected\"" : "");%>>
								<%
									out.print(status.getLabel());
								%>
							</option>
							<%
								}
							%>
						</select>

					</div>
					<div class="form-group">

						<a href="Ticket?id=<%out.print(ticket.getId());%>&edit=1">Edit</a>&nbsp;|&nbsp;<a
							href="TicketList">Back</a>

					</div>
				</form>
			</div>
			<div class="col-md-6">
				<h3>Messages</h3>
				<span class="line-ticketing"></span>
				<%
					for (Message message : ticket.getConversation()) {
				%>
				<div class="message-ticketing">
					<div class="row">
						<div class="col-sm-12"><h4><% out.print(message.getDate().toLocaleString()); %></h4></div>
						<div class="col-sm-2"><strong>From:</strong></div>
						<div class="col-sm-10"><% out.print(message.getFrom()); %></div>
						<div class="col-sm-2"><strong>To:</strong></div>
						<div class="col-sm-10"><% out.print(message.getTo()); %></div>
						<div class="col-sm-12"><strong>Text:</strong></div>
						<div class="col-sm-12"><% out.print(message.getText()); %></div>
					</div>
				</div>
				<%		
					}
				%>
			</div>
		</div>
	</div>
</body>
</html>