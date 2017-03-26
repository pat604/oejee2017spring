<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.qwaevisz.tickethandling.weblayer.common.ListAttribute" %>
<%@ page import="hu.qwaevisz.tickethandling.weblayer.common.FormValue" %>
<%@ page import="hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub" %>
<%@ page import="hu.qwaevisz.tickethandling.ejbservice.domain.PriorityStub" %>
<%@ page import="hu.qwaevisz.tickethandling.ejbservice.domain.StatusStub" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://qwaevisz.hu/jsp/tlds/tickettag" prefix="bt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Tickets ::</title>
</head>
<body>
    <bt:header>List of Books</bt:header>
	<br/><br/><br/>
	<c:choose>
	    <c:when test="${requestScope.tickets.isEmpty()}">
            <span>Ticket list is <strong>empty</strong>.</span>
        </c:when>
        <c:otherwise>
            <table class="bookstable">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>System</th>
                        <th>Priority</th>
                        <th>Status</th>
                        <th>Sender</th>
                        <th>Last changed on</th>
                        <th>&nbsp;</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.tickets}" var="ticket">
                        <tr>
                            <td><a href="Ticket?id=<c:out value="${ticket.id}" />"><c:out value="${ticket.id}" /></a></td>                         
                            <td><c:out value="${ticket.system}" /></td>
                            <td><c:out value="${ticket.priority.label}" /></td>
                            <td><c:out value="${ticket.status.label}" /></td>
                            <td><c:out value="${ticket.sender_name}" /></td>
                            <td><c:out value="${ticket.lastchanged}" /></td>
                            <td><a href="TicketDelete?id=<c:out value="${ticket.id}" />">delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br/>
        </c:otherwise>
	</c:choose>
	<br/><br/>
	<div>
	    <a href="Ticket?id=-1&edit=1">Create</a> a brand new ticket.
	</div>
</body>
</html>