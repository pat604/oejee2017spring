<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub" %>
<%@ taglib uri="http://qwaevisz.hu/jsp/tlds/tickettag" prefix="bt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Ticket ::</title>
</head>
<body>
    <jsp:useBean id="ticket" class="hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub" scope="request" />
    <h1><jsp:getProperty name="ticket" property="id" /></h1>
    <div><label>System: </label><span><jsp:getProperty name="ticket" property="system" /></span></div>
    <div><label>Priority: </label><span>${requestScope.ticket.priority.label}</span></div>
    <div><label>Processor: </label><span><jsp:getProperty name="ticket" property="processor" /></span></div>
    <div><label>Status: </label><span>${requestScope.ticket.status.label}</span></div>
    <div><label>Creation date: </label><span><jsp:getProperty name="ticket" property="creationdate" /></span></div>
    <div><label>Last changed: </label><span><jsp:getProperty name="ticket" property="lastchanged" /></span></div>
    <div><label>Sender name: </label><span><jsp:getProperty name="ticket" property="sender_name" /></span></div>
    <div><label>Level: </label><span><jsp:getProperty name="ticket" property="level" /></span></div>
    <div><label>Business impact: </label><span><jsp:getProperty name="ticket" property="business_impact" /></span></div>
    <div><label>Steps to reproduce the problem: </label><span><jsp:getProperty name="ticket" property="steps_to_rep" /></span></div>
    
    <br/><br/>
    <div>
        <a href="TicketList">back</a>
        <a href="Ticket?id=<% out.print(ticket.getId()); %>&edit=1">edit</a>
    </div>
</body>
</html>