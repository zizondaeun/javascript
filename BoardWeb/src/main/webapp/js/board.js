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

//댓글목록 출력
//const bno = 538;
console.log('bno: ' ,bno);

fetch('replyList.do?bno=' + bno)
	.then(resolve => resolve.json()) //json -> 객체
	.then(result => {
		console.log(result);
		result.forEach(reply => {
			let tmpl = document.querySelector('div.reply li:nth-of-type(3)').cloneNode(true);
			console.log(tmpl);
			tmpl.style.display = 'block';
			tmpl.setAttribute('data-rno', reply.replyNo);
			tmpl.querySelector('span:nth-of-type(1)').innerText = reply.replyNo;
			tmpl.querySelector('span:nth-of-type(2)').innerText = reply.reply;
			tmpl.querySelector('span:nth-of-type(3)').innerText = reply.replyer;
			document.querySelector('div.reply ul').appendChild(tmpl);
		})
	})
	.catch(err => {
		console.log(err);
	})

//목록 출력의 끝부분

//삭제버튼의 이벤트
function deleteRow(e){
	const rno = e.target.parentElement.parentElement.dataset.rno;
	//console.log(rno);
	//fetch 삭제 기능 구현
	fetch('removeReply.do?rno=' + rno)
		.then(resolve => resolve.json())
		.then(result => {
			if(result.retCode == 'OK'){
				alert('삭제완료');
				e.target.parentElement.parentElement.remove();
			}else if(result.retCode == 'NG'){
				alert('삭제를 완료할 수 없습니다');
				
			}else{
				alert('알 수 없는 반환값');
			}
		})
		.catch(err => console.log(err));
}//end of deleteRow(e)

//댓글등록이벤트(addEventListener는 중첩, onclick은 한번만)
document.getElementById('addReply').addEventListener('click', function(e){
	//console.log(document.querySelector('#addReply'));
	//fetch
	let reply = document.getElementById('reply').value;
	fetch('addReply.do?bno=' + bno + '&replyer=' + writer + '&reply=' + reply) //board.js으로부터
		.then(resolve => resolve.json())
		.then(result => {
			if(result.retCode == 'OK'){
				location.reload();
			}
		})
		.catch(err => console.log(err));
})



	