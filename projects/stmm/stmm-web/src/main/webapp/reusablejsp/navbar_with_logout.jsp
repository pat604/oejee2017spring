<%@ page import="hu.smiklos.stmm.ejb.uribuilder.UriBuilder" %>
<%@ page import="hu.smiklos.stmm.web.common.Page" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<%= Page.HOME.getUrl() %>">moneybook</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="<%=Page.CREDIT_CARD.getUrl() %>">Credit card</a></li>
                <li><a href="<%= Page.MB_ACCOUNT.getUrl() %>">MB Account</a></li>
                <li><a href="<%= Page.INVEST.getUrl() %>">Invest</a></li>
                <li><a href="<%= Page.BORROW.getUrl() %>">Borrow</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        <%= request.getUserPrincipal().getName() %>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="<%= Page.LOGOUT.getUrl() %>">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--/.navbar-collapse -->
    </div>
</nav>