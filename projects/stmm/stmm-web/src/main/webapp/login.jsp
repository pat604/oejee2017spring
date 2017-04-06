<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hu.smiklos.stmm.web.common.LoginAttribute" %>

<html>
<jsp:include page="/reusablejsp/head_tag.jsp"></jsp:include>
<body>
<jsp:include page="/reusablejsp/navbar_registration.jsp"></jsp:include>
<%
    String userName = (String) request.getAttribute(LoginAttribute.ATTR_USERNAME);
    String errorMessage = (String) request.getAttribute(LoginAttribute.ATTR_ERROR);
%>
<div class="container">
    <div class="vcenter">
        <% if (errorMessage != null) {%>
        <div class="row">
            <div class="col-md-6 col-md-offset-3 vcenter">
                <div id="error-panel" class="panel panel-danger">
                    <div class="panel-heading">
                        <h3 class="panel-title">Login error!</h3>
                    </div>
                    <div class="panel-body">
                        <ul>
                            <li><%= errorMessage %>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <% } %>
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div id="form-panel" class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Login</h3>
                    </div>
                    <div class="panel-body">
                        <form action="j_security_check" method="post">
                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" name="j_username" id="username" value="<%= userName %>"
                                       class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" name="j_password" id="password" class="form-control"/>
                            </div>
                            <input type="submit" name="submit" value="Login" class="btn btn-default"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/reusablejsp/jquery_before_body_close.jsp"></jsp:include>

<style>
    body {
        padding-top: 50px;
        /* Whatever the height of your navbar is; the
                default is 50px */
    }

    .vcenter {
        padding-top: 5%;
    }

</style>

</body>
</html>
