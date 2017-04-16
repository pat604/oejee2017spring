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
<div class="container-fluid first_container">
    <div class="row">
        <div class="col-md-6">
            <jsp:include page="/reusablejsp/errors.jsp"></jsp:include>
            <jsp:include page="/reusablejsp/wallet_summary.jsp"></jsp:include>
            <jsp:include page="/reusablejsp/invest_money_form.jsp"></jsp:include>
        </div>
        <div id="content_for_investment_list" class="col-md-6">


        </div>
    </div>
    <jsp:include page="/reusablejsp/footer.jsp"></jsp:include>
</div>
<jsp:include page="/reusablejsp/jquery_before_body_close.jsp"></jsp:include>
<script>
    $(document).ready(function(){
        $("#content_for_investment_list").load('<%= Page.INVESTMENT_LIST.getUrl() %>');
    });
</script>
</body>
</html>
