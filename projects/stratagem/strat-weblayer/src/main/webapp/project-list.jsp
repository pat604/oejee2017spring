<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://qwaevisz.hu/jsp/tlds/booktag" prefix="bt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Magazines ::</title>
</head>
<body>
    <bt:header>List of Projects</bt:header>
    <div>
    	<% String userName = (String) request.getUserPrincipal().getName(); %>
	    Welcome <strong><%= userName %></strong>! <a href="Logout">Logout</a>
	</div>
	<br/><br/>
</body>
</html>