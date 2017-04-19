<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hu.smiklos.stmm.ejb.uribuilder.UriBuilder" %>
<%@ page import="hu.smiklos.stmm.web.common.Page" %>
<%@ page import="hu.smiklos.stmm.web.common.BorrowAttributes" %>
<%@ page import="hu.smiklos.stmm.ejb.domain.OfferListOnBorrowQuery" %>
<%@ page import="hu.smiklos.stmm.pers.entity.MoneyTransfer" %>
<%@ page import="java.util.List" %>
<%@ page import="hu.smiklos.stmm.web.common.AcceptLoanOfferAttributes" %>
<html lang="en">

<jsp:include page="/reusablejsp/head_tag.jsp"></jsp:include>
<body>
<% if (request != null && request.getUserPrincipal() != null && request.getUserPrincipal().getName() != null) { %>
<jsp:include page="/reusablejsp/navbar_with_logout.jsp"></jsp:include>
<% } else { %>
<jsp:include page="/reusablejsp/navbar_with_login.jsp"></jsp:include>
<% } %>
<div class="container first_container">
    <div class="row">
        <div class="col-sm-12">
            <jsp:include page="/reusablejsp/borrow_query_form.jsp"></jsp:include>
        </div>
        <div class="col-sm-12">
            <jsp:include page="/reusablejsp/errors.jsp"></jsp:include>
        </div>
        <div class="col-sm-12">
            <% if(request.getAttribute(BorrowAttributes.OFFERS_ON_BORROW_QUERY ) != null) {%>
            <% OfferListOnBorrowQuery olobQuery = (OfferListOnBorrowQuery) request.getAttribute(BorrowAttributes.OFFERS_ON_BORROW_QUERY);
                List<MoneyTransfer> offerList = olobQuery.getOffers();
            %>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Loan Offers</h3>
                </div>
                <div class="panel-body">
                    <table id="offer_list_table" class="display">
                        <thead>
                        <tr>
                            <th>Amount</th>
                            <th>Cost</th>
                            <th>Repayment</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for(MoneyTransfer mt : offerList){
                                out.println("<tr>");
                                out.println("<td>");
                                out.println(String.valueOf(mt.getTransfer_amount()));
                                out.println("</td>");
                                out.println("<td>");
                                out.println(String.valueOf(mt.getExpected_return_amount() - mt.getTransfer_amount()));
                                out.println("</td>");
                                out.println("<td>");
                                out.println(mt.getMoney_transfer_repayment_type().getRepayment_type_name());
                                out.println("</td>");
                                out.println("<td>"); %>
                                <span onclick="seeDetails('<%= AcceptLoanOfferAttributes.LOAN_OFFER_MONEY_TRANSFER_ID %>','<%= mt.getMoneytransfer_id() %>', '<%= Page.ACCEPT_LOAN_OFFER.getUrl() %>', 'borrow_accept_form','borrow_accept_modal_body')" class="glyphicon glyphicon-eye-open action_icon" aria-hidden="true"></span>
                                <% out.println("</td>");
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
                    <h3 class="panel-title">Loan offers</h3>
                </div>
                <div class="panel-body">
                    <p> Offer list....</p>
                </div>
            </div>
            <% } %>

        </div>
    </div>

    <jsp:include page="/reusablejsp/footer.jsp"></jsp:include>
</div>
<div class="modal fade" id="borrow_accept_form" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Accept offer?</h4>
            </div>
            <div id="borrow_accept_modal_body" class="modal-body">
                <p>One fine body&hellip;</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Accept</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<jsp:include page="/reusablejsp/jquery_before_body_close.jsp"></jsp:include>
<% if(request.getAttribute(BorrowAttributes.OFFERS_ON_BORROW_QUERY ) != null) {%>
<script src="js/borrow.js"></script>
<% } %>
</body>
</html>
