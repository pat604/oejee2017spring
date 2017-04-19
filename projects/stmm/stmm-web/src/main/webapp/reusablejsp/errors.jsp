<%@ page import="hu.smiklos.stmm.ejb.common.Errors" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="hu.smiklos.stmm.web.common.GeneralAttributes" %>
<%
    Errors errors = new Errors();
    if(request.getAttribute(GeneralAttributes.ERRORS) != null) {
        errors = (Errors) request.getAttribute("errors");
    }
%>
<% if(errors.hasError()) {%>
<div class="row">
    <div class="col-md-12">
        <div id="error-panel" class="panel panel-danger">
            <div class="panel-heading">
                <h3 class="panel-title">Error!</h3>
            </div>
            <div class="panel-body">
                <%
                    Iterator it = errors.getErrorList().entrySet().iterator();
                    out.println("<ul>");
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry)it.next();
                        out.println("<li><a href='#"+ pair.getKey()+"'>"+pair.getValue()+"</a></li>");
                        it.remove(); // avoids a ConcurrentModificationException
                    }
                    out.println("</ul>");
                %>
            </div>
        </div>
    </div>
</div>
<% } %>
