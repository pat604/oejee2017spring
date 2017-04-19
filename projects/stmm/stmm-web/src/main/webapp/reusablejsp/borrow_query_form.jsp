<%@ page import="hu.smiklos.stmm.ejb.domain.BorrowStub" %>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Borrow</h3>
    </div>
    <div class="panel-body">
        <form action="" method="post" class="form-inline" role="form">

                <div class="form-group">
                    <label class="control-label" for="<%= BorrowStub.BORROW_REPAYMENT_TYPE %>">Repayment type</label>
                    <select class="form-control" id="<%= BorrowStub.BORROW_REPAYMENT_TYPE %>"
                            name="<%= BorrowStub.BORROW_REPAYMENT_TYPE %>">
                        <option value="M">Monthly</option>
                        <option value="W">Weekly</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="sr-only" for="<%= BorrowStub.BORROW_AMOUNT%>">Amount</label>
                    <div class="input-group">
                        <input type="number" class="form-control" name="<%= BorrowStub.BORROW_AMOUNT%>"
                               id="<%= BorrowStub.BORROW_AMOUNT%>" placeholder="Amount to borrow">
                        <div class="input-group-addon">MBC</div>
                    </div>
                </div>



                <div class="form-group">
                    <label class="sr-only" for="<%= BorrowStub.BORROW_REPAYMENT_PERIOD_MONTH_MIN %>">Repayment
                        duration</label>
                    <div class="input-group">
                        <div class="input-group-addon">Duration</div>
                    <input type="number" class="form-control" name="<%= BorrowStub.BORROW_REPAYMENT_PERIOD_MONTH_MIN %>"
                           id="<%= BorrowStub.BORROW_REPAYMENT_PERIOD_MONTH_MIN %>" placeholder="from">
                    </div>
                </div>
                <div class="form-group">
                    <label class="sr-only" for="<%= BorrowStub.BORROW_REPAYMENT_PERIOD_MONTH_MAX %>">TO</label>
                    <div class="input-group">
                        <input type="number" class="form-control"
                               name="<%= BorrowStub.BORROW_REPAYMENT_PERIOD_MONTH_MAX %>"
                               id="<%= BorrowStub.BORROW_REPAYMENT_PERIOD_MONTH_MAX %>" placeholder="to">
                        <div class="input-group-addon">Months</div>
                    </div>
                </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>