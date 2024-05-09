/** 
 *board.js 
*/
//수정버튼
document.querySelector('#modBtn').addEventListener('click', function() {
	document.forms.myFrm.action = "modBoardForm.do"; //수정화면 호출
	document.forms.myFrm.submit(); //submit해야 form호출이 됨 /myfrm의 submit이벤트를 호출해줘
})

//삭제버튼
document.querySelector('.btn-danger').addEventListener('click', function() {
	document.forms.myFrm.action = "removeBoardForm.do"; //삭제화면 호출
	document.forms.myFrm.submit(); //submit 이벤트 호출
})