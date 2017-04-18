$(document).ready(function () {
    $('#offer_list_table').DataTable();

});
function seeDetails(money_transfer_id, url, modalId, contentId) {

    console.log(money_transfer_id);
    console.log(url);
    console.log(modalId);
    console.log(contentId);

    $("#"+modalId).modal('show')

}