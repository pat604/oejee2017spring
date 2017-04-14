<%@ page import="hu.smiklos.stmm.ejb.domain.WalletStub" %>
<%@ page import="hu.smiklos.stmm.web.common.WalletAttributes" %>
<% WalletStub wallet = (WalletStub)request.getAttribute(WalletAttributes.WALLET_STUB); %>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Wallet summary</h3>
            </div>
            <div class="panel-body">
                <p>Amount: <%= wallet.getAmount() %> MBC </p>
            </div>
        </div>
    </div>
</div>
