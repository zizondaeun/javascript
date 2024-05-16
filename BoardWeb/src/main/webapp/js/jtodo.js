/**
 * jtodo.js
 */
//화면의 li요소에 닫기버튼 달기

$('li').append(
	$('<span />')
		.text("\u00D7")
		.addClass('close')
		.on('click', function(){
			$(this).parent().css('display', 'none');
		})
);
//ul의 하위에 있는 li요소에 클릭이벤트
$('ul').on('click',function(e){
	if(e.target.tagName == 'LI'){
		$(e.target).toggleClass('checked');
	}
});
//신규요소 등록하기
function newElement(){
	let inputValue = $('#myInput').val();
	let li = $('<li />').text(inputValue);
	if(inputValue == ''){
		alter("You must write something!")
	}else{
		li.appendTo('#myUL');
	}
	
	li.append($('<span />').text('\u00D7').addClass('close').on('click', function(){
		$(this).parent().css('display', 'none');
	})
	);
}; //end of newElement
