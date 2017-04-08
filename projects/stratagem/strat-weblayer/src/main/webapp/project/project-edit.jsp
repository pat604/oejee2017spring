<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.kota.stratagem.ejbservice.domain.ProjectRepresentor" %>
<%@ page import="com.kota.stratagem.ejbservice.domain.ProjectStatusRepresentor" %>
<%@ page import="com.kota.stratagem.weblayer.common.project.ProjectAttribute" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% ProjectRepresentor project = (ProjectRepresentor) request.getAttribute(ProjectAttribute.ATTR_PROJECT); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Project ::</title>
</head>
<body>
	<div class="frame">
		<form method="post" action="ProjectDetail">
			<div>
				<input type="text" name="id" value="<% project.getStringId(); %>" />
				<label>Name: </label>
				<input class="inputheader" type="text" name="name" value="<% out.print(project.getName()); %>" />
				<br/><br/>
				<label>Description: </label>
				<input class="inputheader" type="text" name="description" value="<% out.print(project.getDescription()); %>" />
				<br/><br/>
			</div>
			<div>
				<label for="status">Category: </label>
				<select name="status" id="status">
					<% for ( ProjectStatusRepresentor status : ProjectStatusRepresentor.values()) { %>
						<option value="<% out.print(status.name()); %>" <% out.print( status == project.getStatus() ? "selected=\"selected\"" : "" ); %> ><% out.print(status.getLabel()); %></option>
					<% } %>
				</select>
			</div>
			<div>
				<label for="Visibility">Visible: </label>
				<input type="checkbox" name="visibility" id="visibility" value="<% out.print(project.getVisible()); %>" />
			</div>
			<br/><br/>
			<div>
				<input type="submit" value="Save" />&nbsp;
				<a href="ProjectList">cancel</a>
			</div>
		</form>
	</div>
</body>
</html>