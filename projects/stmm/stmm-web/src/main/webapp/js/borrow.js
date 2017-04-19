$(document).ready(function () {
    $('#offer_list_table').DataTable();

});
function seeDetails(money_transfer_id_parameter_name, money_transfer_id, url, modalId, contentId) {

    console.log(money_transfer_id);
    console.log(url);
    console.log(modalId);
    console.log(contentId);

    $("#"+modalId).modal('show')
    var uri =  url + "?" + money_transfer_id_parameter_name+"="+money_transfer_id;
    console.log(uri);
    $("#"+contentId).load(uri);

}