<%@ page import="hu.smiklos.stmm.ejb.uribuilder.UriBuilder" %>
<%@ page import="hu.smiklos.stmm.web.common.Page" %>
<%@ page import="hu.smiklos.stmm.ejb.domain.UserRegistrationStub" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<jsp:include page="/reusablejsp/head_tag.jsp"></jsp:include>
<body>
<jsp:include page="/reusablejsp/navbar_registration.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 vcenter">
            <div id="form-panel" class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Registration form</h3>
                </div>
                <div class="panel-body">
                    <form method="post" action="<%=Page.USER_REGISTRATION.getUrl()%>">
                        <div class="form-group">
                            <label for="<%= UserRegistrationStub.FIRST_NAME %>">First name</label>
                            <input type="text" name="<%= UserRegistrationStub.FIRST_NAME %>" class="form-control" id="<%= UserRegistrationStub.FIRST_NAME %>" placeholder="First name">
                        </div>
                        <div class="form-group">
                            <label for="<%= UserRegistrationStub.LAST_NAME %>">Last name</label>
                            <input type="text" class="form-control" name="<%= UserRegistrationStub.LAST_NAME %>" id="<%= UserRegistrationStub.LAST_NAME %>" placeholder="Last name">
                        </div>
                        <div class="form-group">
                            <label for="<%= UserRegistrationStub.USERNAME %>">Username</label>
                            <input type="text" name="<%= UserRegistrationStub.USERNAME %>" class="form-control" id="<%= UserRegistrationStub.USERNAME %>" placeholder="Username">
                        </div>
                        <div class="form-group">
                            <label for="<%= UserRegistrationStub.PASSWORD %>">Password</label>
                            <input type="password" name="<%= UserRegistrationStub.PASSWORD %>" class="form-control" id="<%= UserRegistrationStub.PASSWORD %>" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="<%= UserRegistrationStub.PASSWORD_AGAIN %>">Password</label>
                            <input type="password" name="<%= UserRegistrationStub.PASSWORD_AGAIN %>" class="form-control" id="<%= UserRegistrationStub.PASSWORD_AGAIN %>" placeholder="Retype password">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
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
        padding-top: 10%;
    }

</style>
</body>
</html>