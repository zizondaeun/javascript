/*
*jquery1.js
*/

//document.addEventListener("DOMContentLoaded", initForm); //돔들이 다다운받아지면 이 함수를 실행하겠다

$(document).ready(function(){ //document가 준비가 다 되면 함수를 실행하겠다
	//버튼삭제
	$('tbody button').on('click', delRow); //html에서 이미 만들어둔 값에는 이벤트를 건적이없기때문에 tbody의 버튼에도 이벤트 걸어줘
	
	$('#addBtn').on('click', function(){
		//사용자가 입력한 2개의 값을 td에 생성해주고, tr도 만들어서 tbody하위요소에 넣겠다
		//console.log($('#addBtn'));
		let inputName = $('input[name="name"]');
		let inputScore = $('input[name="score"]');
		if(!inputName.val()){
			alert('값을 입력하세요');
			return;
		}
		let tr = $('<tr />').append(
			$('<td />').append($('<input />').attr('type', 'checkbox')), //체크박스
			$('<td />').text(inputName.val()), //input의 name의 value를 가져오는 방식 
			$('<td />').text(inputScore.val()),
			$('<td />').append($('<button>삭제</button>').on('click', delRow))
		);
		$('#list tbody').append(tr); 
		inputName.val('');
		inputScore.val('');
							
	})
});

function delRow(e){
	$(e.target).parent().parent().remove();
}
