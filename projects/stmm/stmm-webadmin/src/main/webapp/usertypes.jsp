<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hu.smiklos.stmm.ejb.domain.AppUserStub" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="hu.smiklos.stmm.webadmin.common.AdminPages" %>
<%@ page import="hu.smiklos.stmm.ejb.uribuilder.UriBuilder" %>
<%@ page import="hu.smiklos.stmm.webadmin.common.AdminActions" %>
<%@ page import="hu.smiklos.stmm.ejb.domain.UserTypeStub" %>

<div class="col-lg-12">
    <h1 class="page-header">User Types</h1>
</div>
<div class="row">
    <div class="panel-body">
        <table width="100%" class="table table-striped table-bordered table-hover" id="dTable">
            <thead>
            <tr>
                <th>User type</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<UserTypeStub> userTypeList = (List<UserTypeStub>) request.getAttribute("usertypelist");
                for (UserTypeStub type : userTypeList) {
                    out.write("<tr>");
                    out.write("<td>" + type.getType() + "</td>");
                    out.write("<td><a href='" + UriBuilder.getUrl(AdminPages.EditUserType.getUrl(),AdminActions.EditUserType.getAction()) + "'> edit </a>" +
                            "<a href='" + UriBuilder.getUrl(AdminPages.DeleteUserType.getUrl(),AdminActions.DeleteUserType.getAction()) + "'> delete </a></td>");
                    out.write("</tr>");
                }
            %>
            </tbody>
        </table>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#dTable').DataTable({
            responsive: true
        });
    });
</script>