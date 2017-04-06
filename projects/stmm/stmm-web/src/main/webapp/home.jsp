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

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Wellcome world!</h1>
        <p>Lorem ipsum dolor sit amet, an diam tantas vis, cu prima partiendo constituto vis. Quo euismod referrentur te, in vim quot laudem minimum. An cibo deleniti quaerendum sea, duo labores scripserit no. Te pro everti impedit perfecto. Vim no audiam posidonium. Eam ne iriure fuisset.</p>
        <% if (!(request != null && request.getUserPrincipal() != null && request.getUserPrincipal().getName() != null)) { %>
        <p><a class="btn btn-primary btn-lg" href="<%= Page.USER_REGISTRATION.getUrl() %>"
              role="button">Register &raquo;</a></p>
        <% } %>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-6">
            <h2>Invest</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-6">
            <h2>Borrow</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
    </div>

    <hr>

    <footer>
        <p>&copy; 2016 Company, Inc.</p>
    </footer>
</div> <!-- /container -->


<jsp:include page="/reusablejsp/jquery_before_body_close.jsp"></jsp:include>
</body>
</html>
