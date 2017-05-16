
    var datatable = $('#offer_list_table').dataTable({
        data: [],
        columns: [
            { title: "Amount" },
            { title: "Repayment" },
            { title: "Type" },
            { title: "Cost"},
            { title: "Number"}

        ]
    }).api();
    var response;
    var responseArray = []
    var config = {
        getLoanQueryURL: function () {
            return "http://localhost:8080/stmm-restservice/api/loanquery";
        }
    };

    function getLoanOffers(repaymenttype) {
        var jqxhr = $.get(config.getLoanQueryURL() + "/" + repaymenttype, function (data) {
            response = data;
        });
        return jqxhr;
    }

    function setTableData(data) {
        datatable.clear();
        datatable.rows.add(newDataArray);
        datatable.draw();
    }
    /**
     * private double amount;
     * private double repayment_amount;
     * private String repayment_type;
     * private double cost_of_loan;
     * private double number_repayment_unit;
     *
     * @param response
     * @returns {Array}
     * @constructor
     */
    function LoanOfferForRestStubToArray(response) {
        fullArray= [];
        var i= 0;
        while(response[i]){
            var entity = response[i];
            var record = new Array();
            record.push(entity.amount);
            record.push(entity.repayment_amount);
            record.push(entity.repayment_type);
            record.push(entity.cost_of_loan);
            record.push(entity.number_repayment_unit);
            fullArray.push(record);
            i++;
        }
        return fullArray;
    }

    function requestLoanOffers() {
        console.log("get Loan offer")
        var repaymentType = "M"
        repaymentType = $("#BORROW_REPAYMENT_TYPE").find(":selected").val();
        console.log("repaymentType", repaymentType);
        getLoanOffers(repaymentType).done(function(){
            var fullAray = LoanOfferForRestStubToArray(response);
            console.log("response:", response);
            datatable.clear();
            datatable.rows.add(fullAray).draw();
        });
    }
