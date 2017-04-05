<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hu.todomanager.ejbservice.domain.TodoStub" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Todo ::</title>
</head>
<body>
    <jsp:useBean id="todo" class="hu.todomanager.ejbservice.domain.TodoStub" scope="request" />
    <div><label>Todo: </label><span><jsp:getProperty name="todo" property="name" /></span></div>
</body>
</html>