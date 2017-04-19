<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.todomanager.ejbservice.domain.TodoStub" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Todos ::</title>
</head>
<body>
    <bt:header>List of Todos</bt:header>
	    <table>
	        <thead>
	            <tr>
	                <th>Name</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach items="${requestScope.todos}" var="todo">
	                <tr>
	                    <td><c:out value="${todo.name}" /></td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
</body>
</html>