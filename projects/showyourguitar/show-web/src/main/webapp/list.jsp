<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- <%@ page import="java.util.Set" %>   --%>
<%@ page import="java.util.List" %>
<%@ page import="hu.mitro.ejbservice.domain.GuitarStub" %>
<%@ page import="hu.mitro.ejbservice.domain.GuitarBrandStub" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% List<GuitarStub> guitars = (List<GuitarStub>)request.getAttribute("guitars"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>.: List Of All Guitars :.</title>
</head>
<body>
	<h3>Guitars Details</h3>
	<hr size="1" color="gray"/>
	<table>
<%-- 		<%=guitars%> --%>
	    <c:forEach items="${guitars}" var="guitar">
	        <tr>
	            <td><h4><c:out value="${guitar.guitarbrand}"/>: <c:out value="${guitar.guitarType}"/></h4></td>
	        </tr>  
	        <tr>
	            <td>
		            serial: <c:out value="${guitar.serialNumber}"/>,
		            color: <c:out value="${guitar.color}"/>,
		            vintage: <c:out value="${guitar.vintage}"/>,
		            price: <c:out value="${guitar.price}"/> Ft
	            </td>
	        </tr>
	    </c:forEach>
	</table>
</body>
</html>