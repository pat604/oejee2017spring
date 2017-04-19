<%@ page import="hu.smiklos.stmm.web.common.Page" %>
<%@ page import="hu.smiklos.stmm.web.common.WalletAttributes" %>
<div class="row">
    <div class="col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Add credit</h3>
            </div>
            <div class="panel-body">
                <form action="<%= Page.MB_WALLET.getUrl() %>" method="post" role="form">
                    <div class="form-group">
                        <label for="<%= WalletAttributes.ADDCREDIT_INPUT %>"></label>
                        <input type="number" class="form-control" name="<%= WalletAttributes.ADDCREDIT_INPUT %>" id="<%= WalletAttributes.ADDCREDIT_INPUT %>" placeholder="Credit amount to add">
                    </div>
                    <button type="submit" class="btn btn-primary">Add</button>
                </form>
            </div>

        </div>
    </div>
    <div class="col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Withdraw credit</h3>
            </div>
            <div class="panel-body">
                <form action="<%= Page.MB_WALLET.getUrl() %>" method="post" role="form">
                    <div class="form-group">
                        <label for="<%= WalletAttributes.WITHDRAW_INPUT %>"></label>
                        <input type="number" class="form-control" name="<%= WalletAttributes.WITHDRAW_INPUT %>" id="<%= WalletAttributes.WITHDRAW_INPUT %>" placeholder="Withdraw amount">
                    </div>
                    <button type="submit" class="btn btn-primary">Withdraw</button>
                </form>
            </div>
        </div>
    </div>
</div>
