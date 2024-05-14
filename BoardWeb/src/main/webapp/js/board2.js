/** 
 *board.js 원래 board.js
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
console.log('bno: ', bno);
let page = 1;
//목록출력
showList();
function showList() {
	//댓글목록을 초기화
	document.querySelectorAll('div.content ul li').forEach((li, idx) => {
		if (idx >= 3) {
			li.remove();
		}
	})

	fetch('replyList.do?bno=' + bno + '&page=' + page)
		.then(resolve => resolve.json()) //json -> 객체
		.then(result => {
			console.log(result);
			result.forEach(reply => {
				const row = makeRow(reply);
				document.querySelector('div.reply ul').appendChild(row);
			});
			createPageList();
		})
		.catch(err => {
			console.log(err);
		}) //목록 출력의 끝부분
}

//삭제버튼의 이벤트
function deleteRow(e) {
	console.log(e);
	let id = e.target.parentElement.parentElement.children[2].innerHTML; //댓글작성자id
	const rno = e.target.parentElement.parentElement.dataset.rno;
	//console.log(rno);

	//댓글 작성자만 삭제할수있도록
	if (writer == id) {
		//fetch 삭제 기능 구현
		fetch('removeReply.do?rno=' + rno)
			.then(resolve => resolve.json())
			.then(result => {
				if (result.retCode == 'OK') {
					alert('삭제완료');
					//e.target.parentElement.parentElement.remove();
					showList(); //댓글삭제하면 계속 5개 되도록			
				} else if (result.retCode == 'NG') {
					alert('삭제를 완료할 수 없습니다');

				} else {
					alert('알 수 없는 반환값');
				}
			})
			.catch(err => console.log(err));
	} else {
		alert('삭제할 권한이 없습니다');
	}
}//end of deleteRow(e)

//댓글등록이벤트(addEventListener는 중첩, onclick은 한번만)
document.getElementById('addReply').addEventListener('click', function(e) {
	//console.log(document.querySelector('#addReply'));
	let reply = document.getElementById('reply').value;
	if (writer == '') { //댓글창에 로그인하지 않고 입력할때 뜨는 알림창
		alert("로그인 후에 입력하세요");
		return;
	} else if (reply == '') { //빈 댓글을 입력할때 뜨는 알림창
		alert("댓글을 입력하세요");
		return;
	} else {
		//fetch
		fetch('addReply.do?bno=' + bno + '&replyer=' + writer + '&reply=' + reply) //board.js으로부터
			.then(resolve => resolve.json())
			.then(result => {
				if (result.retCode == 'OK') {
					//location.reload(); /새로고침..?/reload 대신하기위해 makeRow를 생성
					const row = makeRow(result.retVal);
					document.querySelector('div.reply ul').appendChild(row);
					//댓글등록 후에 reply내용 초기화하기
					document.getElementById('reply').value = "";
				}
			})
			.catch(err => console.log(err));
	}
})
//row 생성
function makeRow(reply = {}) {
	let tmpl = document.querySelector('div.reply li:nth-of-type(3)').cloneNode(true);
	console.log(tmpl);
	tmpl.style.display = 'block';
	tmpl.setAttribute('data-rno', reply.replyNo);
	tmpl.querySelector('span:nth-of-type(1)').innerText = reply.replyNo;
	tmpl.querySelector('span:nth-of-type(2)').innerText = reply.reply;
	tmpl.querySelector('span:nth-of-type(3)').innerText = reply.replyer;
	return tmpl;
}

//댓글페이징 생성
let pagination = document.querySelector('div.pagination');
function createPageList() {
	let totalCnt = 127;
	let startPage, endPage, realEnd;
	let prev, next;

	realEnd = Math.ceil(totalCnt / 5);

	endPage = Math.ceil(page / 5) * 5;
	startPage = endPage - 4;
	endPage = endPage > realEnd ? realEnd : endPage;

	prev = startPage > 1;
	next = endPage < realEnd;

	console.log(startPage, endPage, realEnd, prev, next);

	//a 태그 생성
	pagination.innerHTML = '';
	//이전페이지 여부
	if (prev) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', startPage - 1);
		aTag.setAttribute('href', '#');
		aTag.innerHTML = "&laquo;";
		aTag.addEventListener('click', function(e) {
			e.preventDefault(); //a 태그는 페이지 이동
			page = e.target.dataset.page;
			showList();
		})
		pagination.appendChild(aTag);
	}
	for (let pg = startPage; pg <= endPage; pg++) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', pg);
		aTag.setAttribute('href', pg);
		if (pg == page) {
			aTag.className = 'active';
		}
		aTag.innerHTML = pg;
		aTag.addEventListener('click', function(e) {
			e.preventDefault(); //a 태그는 페이지 이동
			page = e.target.dataset.page;
			showList();
		})
		pagination.appendChild(aTag);
	}
	//이후페이지 여부
	if (next) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', endPage + 1);
		aTag.setAttribute('href', '#');
		aTag.innerHTML = "&raquo;";
		aTag.addEventListener('click', function(e) {
			e.preventDefault(); 
			page = e.target.dataset.page;
			showList();
		})
		pagination.appendChild(aTag);
	}
}
//page = 3;


