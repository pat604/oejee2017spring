<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="../../header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../../partial/navbar.jsp"></jsp:include>
	
	<div class="control-view hm-black-strong">
		<div class="flex-center">
			<ul>
	            <li>
	 	        	<h1 class="brand-name-control font-bold wow fadeInDown" data-wow-delay="0.2s">Objectives</h1>
				</li>
				<li>
				<hr class="hr-light"></li>
	            <li>
		            <p class="wow fadeInDown" data-wow-delay="0.22s">The goals that we work to achive</p>
	            </li>
	        </ul>
        </div>
    </div>
	
	<div class="container">
		<table class="table table-hover">
		    <thead>
		        <tr>
		            <th>#</th>
		            <th>Name</th>
		            <th>Status</th>
		            <th>Priority</th>
		            <th>Projects</th>
		            <th>Tasks</th>
		            <th>Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		    	<c:set var="count" value="0" scope="page" />
				<c:forEach items="${requestScope.objectives}" var="objective">
						<c:set var="count" value="${count + 1}" scope="page"/>
                        <tr>
                        	<th scope="row"><c:out value="${count}" /></th>
                            <td><c:out value="${objective.name}" /></td>
                            <td><c:out value="${objective.status.label}" /></td>
                            <td><c:out value="${objective.priority}" /></td>
                            <td><c:out value="${objective.projects.size()}" /></td>
                            <td><c:out value="${objective.tasks.size()}" /></td>
                            <td>
	                            <a href="ObjectiveAction?id=<c:out value="${objective.id}" />"><i class="fa fa-wpforms" aria-hidden="true"></i></a>
	                            <a href="ObjectiveAction?id=<c:out value="${objective.id}" />&edit=1"><i class="fa fa-edit"  aria-hidden="true"></i></a>
	                            <a href="ObjectiveDelete?id=<c:out value="${objective.id}" />"><i class="fa fa-trash"  aria-hidden="true"></i></a>
                            </td>
                        </tr>
				</c:forEach>
		    </tbody>
		</table>
	</div>
	
	<jsp:include page="../../partial/copyright.jsp"></jsp:include>
	<jsp:include page="../../partial/wow.jsp"></jsp:include>
	
</body>
</html>