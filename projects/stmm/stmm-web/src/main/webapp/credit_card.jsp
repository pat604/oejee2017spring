<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hu.smiklos.stmm.ejb.uribuilder.UriBuilder" %>
<%@ page import="hu.smiklos.stmm.web.common.Page" %>
<html lang="en">

<jsp:include page="/reusablejsp/head_tag.jsp"></jsp:include>
<body>
    <% if (request != null && request.getUserPrincipal() != null && request.getUserPrincipal().getName() != null) { %>
<jsp:include page="/reusablejsp/navbar_with_logout.jsp"></jsp:include>
    <% } else { %>
<jsp:include page="/reusablejsp/navbar_with_login.jsp"></jsp:include>
    <% } %>
<div class="container first_container">
    <jsp:include page="/reusablejsp/credit_card_details.jsp"></jsp:include>
    <jsp:include page="/reusablejsp/footer.jsp"></jsp:include>
</div>
    <jsp:include page="/reusablejsp/jquery_before_body_close.jsp"></jsp:include>
    <jsp:include page="/reusablejsp/dialog.jsp"></jsp:include>
    <jsp:include page="/reusablejsp/modal.jsp"></jsp:include>
</body>
</html>