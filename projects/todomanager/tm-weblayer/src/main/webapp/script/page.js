
$(document).ready(function(){

	$('#pButton').click(function(){
		var pValue = $('#prioSelector').val();
		$('#pList').append('<li>' + pValue + '</li>');
		$('#pList').append('<input class="toHide" type="text" name="selPriorities" value="'+ pValue +'" />');
		$('.toHide').hide();
	});
	
	$('#cButton').click(function(){
		var cValue = $('#catSelector').val();
		$('#cList').append('<li>' + cValue + '</li>');
		$('#cList').append('<input class="toHide" type="text" name="selCategories" value="'+ cValue +'" />');
		$('.toHide').hide();
	});
	
	$('#sButton').click(function(){
		var sValue = $('#subTodoInput').val();
		$('#sList').append('<li>' + sValue + '</li>');
		$('#sList').append('<input class="toHide" type="text" name="selSubTodos" value="'+ sValue +'" />');
		$('.toHide').hide();
	});
});	
	