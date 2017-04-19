<%@ page import="hu.smiklos.stmm.web.common.MoneyTransferAttributes" %>
<%@ page import="hu.smiklos.stmm.pers.entity.MoneyTransfer" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="hu.smiklos.stmm.pers.entity.RepaymentType" %>
<%@ page import="hu.smiklos.stmm.pers.entity.trunk.MoneyTransferStates" %>
<%@ page import="hu.smiklos.stmm.web.common.Page" %>
<%@ page import="hu.smiklos.stmm.ejb.domain.MoneyTransferStub" %>
<% if (request.getAttribute(MoneyTransferAttributes.INVESTMENTS) != null) { %>
<% Set<MoneyTransfer> mTransfers = (Set<MoneyTransfer>) request.getAttribute(MoneyTransferAttributes.INVESTMENTS); %>
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
                <th>Repay</th>
                <th>X</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (MoneyTransfer mt : mTransfers) {
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(String.valueOf(mt.getTransfer_amount()));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(String.valueOf(mt.getExpected_return_amount() - mt.getTransfer_amount()));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(mt.getTransferState());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(mt.getMoney_transfer_repayment_type().getRepayment_type_name());
                    out.println("</td>");
                    out.println("<td>");
                    if (mt.getTransferState().equals(MoneyTransferStates.ONPLATE)) {
                    %>
                    <a href="<%= String.format("%s?%s=%s", Page.INVEST.getUrl(), MoneyTransferStub.MONEY_TRANSFER_ID_TO_DELETE_INVESTMENT, mt.getMoneytransfer_id()) %>"> X </a>
                    <% }
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
<% if (request.getAttribute(MoneyTransferAttributes.INVESTMENTS) != null) { %>
<script>
    $(document).ready(function () {
        $('#investment_list').DataTable();
    });

</script>
<% } %>