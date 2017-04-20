
$(document).ready(function(){

	$('#pButton').click(function(){
		var value = $('#prioSelector').val();
		$('#pList').append('<li>' + value + '</li>');
		$('#pList').append('<input class="toHide" type="text" name="selPriorities" value="'+ value +'" />');
		$('.toHide').hide();
	});
	
	$('#cButton').click(function(){
		var value = $('#catSelector').val();
		$('#cList').append('<li>' + value + '</li>');
		$('#cList').append('<input class="toHide" type="text" name="selCategories" value="'+ value +'" />');
		$('.toHide').hide();
	});
	
	$('#sButton').click(function(){
		var name = $('#subTodoName').val();
		var desc = $('#subTodoDesc').val();
		var displayedValue = name + ": " + desc;
		var storedValue = name + "::un1qe::" + desc;
		$('#sList').append('<li>' + displayedValue + '</li>');
		$('#sList').append('<input class="toHide" type="text" name="selSubTodos" value="'+ storedValue +'" />');
		$('.toHide').hide();
	});

/*
	$('.todoDeleteButton').click(function(){
		var todo = $(this).attr('todoData');
		$.ajax({
			type: 'POST',
			url: 'todoList',
			data: 'type=delete&todo=' + todo,
			success: function(){
				console.log('DELETED');
				location.reload();
			}
		});
	});

	$('.todoEditButton').click(function(){
		var todo = $(this).attr('todoData');
		$.ajax({
			type: 'POST',
			url: 'todoList',
			data: 'type=edit&todo=' + todo,
			success: function(){
				console.log('EDITED');
			}
		});
	});
*/

});	
	