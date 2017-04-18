<%@ page import="hu.smiklos.stmm.web.common.MoneyTransferAttributes" %>
<%@ page import="hu.smiklos.stmm.pers.entity.MoneyTransfer" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<% if(request.getAttribute(MoneyTransferAttributes.INVESTMENTS) != null) { %>
<%  Set<MoneyTransfer> mTransfers = (Set<MoneyTransfer>) request.getAttribute(MoneyTransferAttributes.INVESTMENTS);  %>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Investments</h3>
    </div>
    <div class="panel-body">
        <table id="investment_list" class="display">
            <thead>
            <tr>
                <th>Inv.</th>
                <th>Inc.</th>
                <th>State</th>
            </tr>
            </thead>
            <tbody>
            <%
                for(MoneyTransfer mt : mTransfers){
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(mt.getTransfer_amount());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(mt.getExpected_return_amount() - mt.getTransfer_amount());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(mt.getTransferState());
                    out.println("</td>");
                    out.println("</tr>");
                }
            %>
            </tbody>
        </table>
    </div>
</div>
<% } else { %>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Panel title</h3>
    </div>
    <div class="panel-body">
        <p> No investments yet!</p>
    </div>
</div>

<% } %>
<% if(request.getAttribute(MoneyTransferAttributes.INVESTMENTS) != null) { %>
<script>
    $(document).ready(function(){
        $('#investment_list').DataTable();
    });

</script>
<% } %>