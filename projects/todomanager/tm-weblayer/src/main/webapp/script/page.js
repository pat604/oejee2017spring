
$(document).ready(function(){

	$('#pButton').click(function(){
		var value = $('#prioSelector').val();
		$('#pList').append('<li>' + value + '</li>');
		$('#pList').append('<input type="hidden" name="selPriorities" value="'+ value +'" />');
	});
	
	$('#cButton').click(function(){
		var value = $('#catSelector').val();
		$('#cList').append('<li>' + value + '</li>');
		$('#cList').append('<input type="hidden" name="selCategories" value="'+ value +'" />');
	});
	
	$('#sButton').click(function(){
		var name = $('#subTodoName').val();
		var desc = $('#subTodoDesc').val();
		var displayedValue = name + ": " + desc;
		var storedValue = name + "::un1qe::" + desc;
		$('#sList').append('<li>' + displayedValue + '</li>');
		$('#sList').append('<input type="hidden" name="selSubTodos" value="'+ storedValue +'" />');
	});

});	
	