<%@ page import="hu.smiklos.stmm.ejb.domain.MoneyTransferStub" %>
<%@ page import="hu.smiklos.stmm.pers.entity.MoneyTransfer" %>
<%@ page import="hu.smiklos.stmm.web.common.MoneyTransferAttributes" %>
<%@ page import="hu.smiklos.stmm.pers.entity.RepaymentType" %>
<%
    MoneyTransferStub mtStub = (MoneyTransferStub) request.getAttribute(MoneyTransferAttributes.MONEYTRANSFER_CREATE_STUB);

%>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Invest</h3>
            </div>
            <div class="panel-body">
                <form action="" method="post" role="form">
                    <div class="form-group">
                        <label for="<%= MoneyTransferStub.TRANSFER_AMOUNT %>" class="control-label">Amount
                            to invest</label>

                        <input type="number" class="form-control" name="<%= MoneyTransferStub.TRANSFER_AMOUNT %>"
                               id="<%= MoneyTransferStub.TRANSFER_AMOUNT %>" placeholder="Invest amount">

                    </div>
                    <div class="form-group">
                        <label for="<%= MoneyTransferStub.EXPECTED_RETURN_AMOUNT %>"
                               class=" control-label">Total return</label>

                        <input type="number" class="form-control"
                               name="<%= MoneyTransferStub.EXPECTED_RETURN_AMOUNT %>"
                               id="<%= MoneyTransferStub.EXPECTED_RETURN_AMOUNT %>"
                               placeholder="Expected return amount">

                    </div>
                    <div class="form-group">
                        <label for="<%= MoneyTransferStub.INVEST_TIME_PERIOD %>" class="control-label">Investment
                            period</label>

                        <input type="number" class="form-control" name="<%= MoneyTransferStub.INVEST_TIME_PERIOD %>" id="<%= MoneyTransferStub.INVEST_TIME_PERIOD %>"
                               placeholder="months">

                    </div>
                    <div class="form-group">
                        <label for="<%= MoneyTransferStub.REPAYMENT_TYPE%>"
                               class="control-label">Repayment period
                        </label>

                        <select class="form-control" name="<%= MoneyTransferStub.REPAYMENT_TYPE%>"
                                id="<%= MoneyTransferStub.REPAYMENT_TYPE%>">
                            <% for (RepaymentType rType : mtStub.getMoney_transfer_repayment_types()) { %>
                            <option value="<%= rType.getRepayment_type_id() %>" <%= (mtStub.getMoney_transfer_repayment_type() != null && mtStub.getMoney_transfer_repayment_type().getRepayment_type_id().equals(rType.getRepayment_type_id())) ? "selected" : "" %> ><%= rType.getRepayment_type_name() %>
                            </option>
                            <% } %>
                        </select>

                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
