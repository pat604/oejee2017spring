<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub" %>
<%@ page import="hu.qwaevisz.tickethandling.ejbservice.domain.PriorityStub" %>
<%@ page import="hu.qwaevisz.tickethandling.ejbservice.domain.StatusStub" %>
<%@ page import="hu.qwaevisz.tickethandling.weblayer.common.TicketAttribute" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- TicketStub ticket = (TicketStub) request.getAttribute(TicketAttribute.ATTR_TICKET); %-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Ticket ::</title>
</head>
<body>
	<div class="frame">
		<form method="post" action="Ticket">
			<div>
				<input class="inputheader" type="text" name="id" value="< out.print(ticket.getId()); %>" />:
				<input class="inputheader" type="text" name="system" value="< out.print(ticket.getSystem()); %>" />
				<br/><br/>
			</div>
			<div>
				<label>ID: </label>
				<c:choose>
                     <c:when test="${requestScope.isnew}">
                        <input type="text" name="id" value="" />
                     </c:when>
                     <c:otherwise>
                        <span>< out.print(ticket.getId()); %></span>
                        <input type="hidden" name="id" value="<= ticket.getId() %>" />
                     </c:otherwise>
                </c:choose>
			</div>
			<div>
				<label for="system">System: </label>
				<input type="text" name="system" id="system" value="< out.print(ticket.getSystem()); %>" />
			</div>
			<div>
				<label for="priority">Priority: </label>
				<select name="priority" id="priority">
					< for ( PriorityStub priority : PriorityStub.values()) { %>
						<option value="< out.print(priority.name()); %>" < out.print( priority == ticket.getPriority() ? "selected=\"selected\"" : "" ); %> >< out.print(priority.getLabel()); %></option>
					< } %>
				</select>
			</div>
			<br/><br/>
			<div>
				<input type="submit" value="Save" />&nbsp;
				<a href="Ticket?id=< out.print(ticket.getId()); %>">cancel</a>
			</div>
		</form>
	</div>
</body>
</html>