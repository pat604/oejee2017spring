<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hu.todomanager.ejbservice.domain.TodoStub" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: New Todo ::</title>
</head>
<body>
	<div>
    	<input type="text" name="name" value="" />	
	</div>
	<div>
    	<input type="number" name="priority" value="" />	
	</div>
	<div>
    	<input type="text" name="description" value="" />	
	</div>

	<div>
		<input type="submit" value="Save" />&nbsp;
	</div>
	
</body>
</html>