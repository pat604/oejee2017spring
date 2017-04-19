<%@ page import="hu.smiklos.stmm.web.common.AcceptLoanOfferAttributes" %>
<%@ page import="hu.smiklos.stmm.ejb.domain.LoanOfferStub" %>
<%@ page import="hu.smiklos.stmm.pers.entity.RepaymentUnit" %>
<%@ page import="java.util.List" %>
<%@ page import="hu.smiklos.stmm.ejb.domain.RepaymentUnitStub" %>
<%@ page import="java.util.StringJoiner" %>
<% if (request.getAttribute(AcceptLoanOfferAttributes.LOAN_OFFER_STUB) != null) { %>
<% LoanOfferStub loanStub = (LoanOfferStub) request.getAttribute(AcceptLoanOfferAttributes.LOAN_OFFER_STUB); %>
<% List<RepaymentUnitStub> repaymentUnits = loanStub.getPayments(); %>
<div class="row">
    <div class="col-sm-12">
        <h4>You get: <%= String.valueOf(loanStub.getNetValue()) %></h4>
        <h4>You pay back: <%= loanStub.getTotalRepayAmount() %></h4>
        <h4>Payment method: <%= loanStub.getRePaymentMethod() %></h4>
        <h4>In <%= String.valueOf(loanStub.getNumberOfPayments()) %> payments.</h4>

    </div>
</div>
<div class="row">
    <div class="col-sm-12">
        <div class="list-group">
            <a href="#" class="list-group-item disabled">
                Repayments
            </a>
            <% for (RepaymentUnitStub unit : repaymentUnits) { %>
            <a href="#"
               class="list-group-item"><%= String.format("%s MBC until %s ", String.valueOf(unit.getAmount()), unit.getDeadline().toString()) %>
            </a>
            <% } %>
        </div>

    </div>
</div>
<% } %>
