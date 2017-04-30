<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hu.todomanager.ejbservice.domain.TodoStub" %>
<%@ page import="hu.todomanager.weblayer.common.TodoParameter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="style/page.css" />
<script src="script/jquery-3.2.1.min.js"></script>
<script src="script/page.js"></script>
<title>:: Edit Todo ::</title>
</head>
<body>
<header>
	<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="https://en.wikipedia.org/wiki/Wikipedia:To-do_list">Todo</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/tm-weblayer/todoList"><i class="fa fa-home"></i>Home</a></li>
			<li><a href="/tm-weblayer/newTodo"><i class="fa fa-home"></i>New Todo</a></li>
		</ul>
	</div>
	</nav>
</header>

<div class="container">
	<div class="row">
	<div class="col-xs-6 col-xs-offset-3">
	<form method="post" action="editTodo">
		<div class="form-group">
			<label>Name</label>
	    	<input class="form-control" type="text" name="name" value="${requestScope.todo.name}" readonly/>	
		</div>
		
		<div class="form-group">
			<label>Description</label>
	    	<input class="form-control" type="text" name="description" value="${requestScope.todo.description}" />	
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
					<c:forEach items="${requestScope.todoPriorities}" var="priority">
						<li>${priority.name}</li>
						<input type="hidden" name="selPriorities2" value="${priority.name}" />
					</c:forEach>
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
					<c:forEach items="${requestScope.todoCategories}" var="category">
						<li>${category.name}</li>
						<input type="hidden" name="selCategories2" value="${category.name}" />
					</c:forEach>
				</ul>
			</div>
		</div>

		<div class="form-group">
			<div class="row">
				<div class="col-xs-6">
					<label>SubTodo Name</label>
					<input id="subTodoName" type="text" class="form-control"/>
				</div>
				<div class="col-xs-6">
					<label>SubTodo Description</label>
					<input id="subTodoDesc" type="text" class="form-control" />
				</div>
			</div>
			<button type="button" id="sButton" class="btn btn-default">Add SubTodo</button>
			<ul id="sList">
				<c:forEach items="${requestScope.todo.subTodos}" var="subTodo">
					<li>${subTodo.name}: ${subTodo.description}</li>
					<input type="hidden" name="selSubTodos2" value="${subTodo.name}::un1qe::${subTodo.description}" />
				</c:forEach>
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