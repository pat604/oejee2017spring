<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%@ page import="java.util.Set" %> --%>
<%@ page import="hu.mitro.ejbservice.domain.GuitarStub" %>
<% GuitarStub guitar = (GuitarStub) request.getAttribute("guitar"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>.: <% out.print(guitar.getGuitarbrand() + " " + guitar.getGuitarType()); %> :.</title>
</head>
<body>
	<h2><% out.print(guitar.getGuitarbrand()); %>: <% out.print(guitar.getGuitarType()); %></h2>
	<div><label>color: </label><span><% out.print(guitar.getColor()); %></span><br>
	<label>serial: </label><span><% out.print(guitar.getSerialNumber()); %></span><br>
	<label>vintage: </label><span><% out.print(guitar.getVintage()); %></span><br>
	<label>price: </label><span><%	out.print(guitar.getPrice()); %> HUF</span><br>
	<label>owner: </label><span><% out.print(guitar.getOwner().getUsername()); %></span></div>
</body>
</html>