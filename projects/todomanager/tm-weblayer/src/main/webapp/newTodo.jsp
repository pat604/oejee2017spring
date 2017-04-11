<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hu.todomanager.ejbservice.domain.TodoStub" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="style/page.css" />
<script src="script/jquery-3.2.1.min.js"></script>
<script src="script/page.js"></script>
<title>:: New Todo ::</title>
</head>
<body>
<div class="container">
	<div class="row">
	<div class="col-xs-6">
	<form method="post" action="newTodo">
		<div class="form-group">
			<label>Name</label>
	    	<input class="form-control" type="text" name="name" value="" />	
		</div>
		
		<div class="form-group">
			<label>Description</label>
	    	<input class="form-control" type="text" name="description" value="" />	
		</div>
		
		<div class="form-group">
			<label>Priority</label>
	    	<select id="prioSelector" class="form-control" name="priorities">
			  	<c:forEach items="${requestScope.priorities}" var="priority">
	                <option value="${priority.name}">
	                    ${priority.name}
	                </option>
	            </c:forEach>
			</select>
			<div class="form-group">
				<button type="button" id="pButton" class="btn btn-default">Add Priority</button>
				<ul id="pList">
				</ul>
			</div>
		</div>
		
		<div class="form-group">
			<label>Category</label>
	    	<select id="catSelector" class="form-control" name="categories">
			  	<c:forEach items="${requestScope.categories}" var="category">
	                <option value="${category.name}">
	                    ${category.name}
	                </option>
	            </c:forEach>
			</select>
			<div class="form-group">
				<button type="button" id="cButton" class="btn btn-default">Add Category</button>
				<ul id="cList">
				</ul>
			</div>
		</div>

		<div class="form-group">
			<div class="row">
				<div class="col-xs-6">
					<label>SubTodo Name</label>
					<input type="text" class="form-control" />
				</div>
				<div class="col-xs-6">
					<label>SubTodo Description</label>
					<input type="text" class="form-control" />
				</div>
			</div>
			<input id="subTodoInput" type="text" class="form-control" />
			<button type="button" id="sButton" class="btn btn-default">Add SubTodo</button>
			<ul id="sList">
			</ul>
		</div>
	
		<div class="form-group">
			<input class="form-control" class="btn btn-success" type="submit" value="Save" />&nbsp;
		</div>
	</form>
	</div>
	</div>
</div>
</body>
</html>