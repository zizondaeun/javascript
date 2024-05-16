/**
 * 
 */
function newElement(){
	let inputVal = $('#myInput').val();
	let li = $('<li />').text(inputVal);
	//console.log(li);
	if(inputVal == ''){
		alert("입력하세요")
	}else{
		let span = $('<span />').text('\u00D7').addClass('close');
		
		li.append(span);
		span.on('click',function(){
			li.remove();
		});
		$('#myUL').append(li)
	}
	//console.log($('#myUL'));
}

$('#myUL').on('click', function(e){
	//console.log($('#myUL'));
	let ck = $(e.target);
	//console.log(ck);
	ck.toggleClass('checked');	
})
//console.log(li);

$('li').append($('<span />').text('\u00D7').addClass('close').on('click', function(e){
	$(e.target).parent().remove();
}));
	
