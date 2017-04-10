<%@ page import="hu.smiklos.stmm.web.common.Modal" %>
<% if(request.getAttribute(Modal.ATTR_MODAL) != null) {
    Modal modal= (Modal)request.getAttribute(Modal.ATTR_MODAL);
%>
<div class="modal fade" id="moneybookModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"><%= modal.getTitle() %></h4>
            </div>
            <div class="modal-body">
                <p><%= modal.getMessage() %></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script>
    $( document ).ready(function() {
        $("#moneybookModal").modal('show');
    });
</script>
<%  } %>
