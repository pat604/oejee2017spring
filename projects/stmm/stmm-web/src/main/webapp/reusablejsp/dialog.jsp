<%@ page import="hu.smiklos.stmm.web.common.Modal" %>
<%@ page import="hu.smiklos.stmm.web.common.Dialog" %>
<%@ page import="hu.smiklos.stmm.ejb.uribuilder.UriBuilder" %>
<% if(request.getAttribute(Dialog.ATTR_DIALOG) != null) {
    Dialog dialog= (Dialog)request.getAttribute(Dialog.ATTR_DIALOG);
%>
<div class="modal fade" id="moneybookDialog" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"><%= dialog.getTitle() %></h4>
            </div>
            <div class="modal-body">
                <p><%= dialog.getMessage() %></p>
            </div>
            <div class="modal-footer">
                <a href="<%= UriBuilder.getUrl(dialog.getUrl(),dialog.getAction()) %>" class="btn btn-info" role="button"><%= dialog.getButtontext()%></a>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script>
    $( document ).ready(function() {
        $("#moneybookDialog").modal('show');
    });
</script>
<%  } %>
