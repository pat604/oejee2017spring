<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Set" %>
	<%@ page import="hu.mitro.ejbservice.domain.GuitarStub" %>
	<% GuitarStub guitar = (GuitarStub) request.getAttribute("guitar"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><% out.print(guitar.getGuitarbrand() + " " + guitar.getGuitarType()); %></title>
</head>
<body>
	<h1><% out.print(guitar.getGuitarbrand()); %>: <% out.print(guitar.getGuitarType()); %></h1>
	<div><label>color: </label><span><% out.print(guitar.getColor()); %></span></div>
	<div><label>vintage: </label><span><% out.print(guitar.getVintage()); %></span></div>
	<div><label>Price: </label><span><%	out.print(guitar.getPrice()); %> Ft</span></div>
	<div><label>Category: </label><span><% out.print(guitar.getOwner()); %></span></div>
</body>
</html>