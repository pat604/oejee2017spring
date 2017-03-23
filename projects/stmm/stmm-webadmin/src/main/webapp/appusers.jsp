<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hu.smiklos.stmm.ejb.domain.AppUserStub" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="hu.smiklos.stmm.webadmin.common.AdminPages" %>
<%@ page import="hu.smiklos.stmm.ejb.uribuilder.UriBuilder" %>
<%@ page import="hu.smiklos.stmm.webadmin.common.AdminActions" %>

<div class="col-lg-12">
    <h1 class="page-header">Application users</h1>
</div>
<div class="row">
    <div class="panel-body">
        <table width="100%" class="table table-striped table-bordered table-hover" id="dTable">
            <thead>
            <tr>
                <th>User id</th>
                <th>Wallet id</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<AppUserStub> users = (List<AppUserStub>) request.getAttribute("users");
                for (AppUserStub user : users) {
                    out.write("<tr>");
                    out.write("<td>" + user.getAppuserId() + "</td>");
                    out.write("<td>" + user.getWalletId() + "</td>");
                    out.write("</tr>");
                }
            %>
            <td><a><% out.write("edit");%></a><a onclick="changeContent('<%= UriBuilder.getUrl(AdminPages.EditUser.getUrl(), AdminActions.EditUser.getAction()) %>')"><% out.write("delete"); %> </a></td>
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