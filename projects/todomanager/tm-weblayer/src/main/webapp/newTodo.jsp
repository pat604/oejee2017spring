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
	<form method="post" action="newTodo">
		<div>
			<label>Name</label>
	    	<input type="text" name="name" value="" />	
		</div>
		<div>
			<label>Priority</label>
	    	<select name="priorities">
			  	<c:forEach items="${requestScope.priorities}" var="priority">
	                <option value="${priority.name}">
	                    ${priority.name}
	                </option>
	            </c:forEach>
			</select>
		</div>
		<div>
			<label>Category</label>
	    	<select name="categories">
			  	<c:forEach items="${requestScope.categories}" var="category">
	                <option value="${category.name}">
	                    ${category.name}
	                </option>
	            </c:forEach>
			</select>
		</div>
		<div>
			<label>Description</label>
	    	<input type="text" name="description" value="" />	
		</div>
	
		<div>
			<input type="submit" value="Save" />&nbsp;
		</div>
	</form>
</body>
</html>