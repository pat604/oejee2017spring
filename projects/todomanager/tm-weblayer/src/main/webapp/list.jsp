<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
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
<title>:: Todos ::</title>
</head>
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
<body>
	<div class="container">
	    <table class="table">
	        <thead>
	            <tr>
	                <th>Name</th>
	                <th>Description</th>
	                <th>State</th>
	                <th>Deadline</th>
	                <th>Priority</th>
	                <th>SubTodos</th>
					<th>Edit/Delete</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach items="${requestScope.todos}" var="todo">
	                <tr>
	                    <td><c:out value="${todo.name}" /></td>
	                    <td><c:out value="${todo.description}" /></td>
	                    <td><c:out value="${todo.state}" /></td>
	                    <td><c:out value="${todo.deadline}" /></td>
	                    <td><c:out value="${todo.priority.name}" /></td>
						<td>							
							<ul>
								<c:forEach items="${todo.subTodos}" var="subTodo">
									<li>
										<c:out value="${subTodo.name}" />
									</li>
								</c:forEach>
							</ul>
						</td>
						<td>
							<form action="" method="post">
								<!--<input type="hidden" name="type" value="edit">-->
								<input type="hidden" name="todoName" value="${todo.name}">
								<button class="btn btn-primary todoEditButton" name="type" value="edit">Edit</button>
							</form>
							<form action="" method="post">
								<!--<input type="hidden" name="type" value="delete">-->
								<input type="hidden" name="todoName" value="${todo.name}">
								<button class="btn btn-danger todoDeleteButton" name="type" value="delete">Delete</button>
							</form>
						</td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	</div>
</body>
</html>