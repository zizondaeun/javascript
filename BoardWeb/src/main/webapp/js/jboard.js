/*
 *jboard.ja
 */

//수정버튼
$('#modBtn').on('click', function() {
	document.forms.myFrm.action = "modBoardForm.do"; //수정화면 호출
	document.forms.myFrm.submit(); //submit해야 form호출이 됨 /myfrm의 submit이벤트를 호출해줘
})

//삭제버튼
$('.btn-danger').on('click', function() {
	document.forms.myFrm.action = "removeBoardForm.do"; //삭제화면 호출
	document.forms.myFrm.submit(); //submit 이벤트 호출
})

//댓글 수정 기능 추가(modal)
$('.modal-content button').on('click', function(e) {
	const rno = $(e.target).parent().prev().prev().data('rno'); //data-rno
	let reply = $(e.target).parent().parent().children('p:eq(1)').children('input:eq(0)').val();
	
	console.log(rno, reply);
	svc.modReply(//
		{
			rno,
			reply
		},
		result => {
			console.log(result);
			alert('수정완료');
			$('#myBtn').css('display', 'none');
			$('#myModal').css('display', 'none');
			showList();
		},
		err => {
			console.log(err);
		}
	)
})


let page = 1;
showList();

function showList() {
	//새로운 목록을 출력할 경우에 기존 목록 지우기
	$('div.content ul li:gt(2)').remove();

	svc.replyList({
		bno: bno,
		page: page
	},
		result => {
			result.forEach(reply => {
				const row = makeRow(reply);
				row.appendTo('div.reply ul');
			})
			makePageInfo(); //페이징을 여기서 호출해야지
		},
		err => {
			console.log(err)
		})
}
let replyNo;

function makeRow(reply = {}) {
	let tmpl = $('div.reply li:nth-of-type(3)').clone();
	tmpl.css('display', 'block');
	tmpl.on('dblclick', function(e) {
		//선택값을 모달창에 전달
		$('#myModal').css('display', 'block');
		replyNo = $(e.target).parent().children().eq(0).text(); //글번호
		let reply = $(e.target).parent().children().eq(1).text(); //댓글내용
		let replyer = $(e.target).parent().children().eq(2).text(); //작성자
		//console.log(replyNo,reply,replyer);
		$('.modal-content p:eq(0)').attr('data-rno', replyNo);
		$('.modal-content p:eq(0)').text('댓글번호: ' + replyNo);
		$('.modal-content input:eq(0)').val(reply);
	})
	tmpl.attr('data-rno', reply.replyNo);
	tmpl.find('span:eq(0)').text(reply.replyNo);
	tmpl.find('span:eq(1)').text(reply.reply);
	tmpl.find('span:eq(2)').text(reply.replyer);
	return tmpl;
} //end of makeRow

function deleteRow(e) {
	const rno = $(e.target).parent().parent().data('rno'); //data-rno
	//댓글 작성자만 삭제할수있도록
	if (!writer) {
		alert('삭제할 권한이 없습니다');
		return;
	} //이거 안된다...저 아이디를 어떻게 하면 될거같은데...
	//제이쿼리에서 if 안에 어케 해야하는지

	//fetch 삭제 기능 구현
	svc.removeReply(rno, //첫번째 param
		result => {
			if (result.retCode == 'OK') {
				alert('삭제완료');
				//e.target.parentElement.parentElement.remove();
				showList(); //댓글삭제하면 계속 5개 되도록			
			} else if (result.retCode == 'NG') {
				alert('삭제를 완료할 수 없습니다');

			} else {
				alert('알 수 없는 반환값');
			}
		}, //두번째 param
		err => console.log(err)); //세번째 param
} //end of deleteRow

//등록버튼
$('#addReply').on('click', function() {
	let reply = $('#reply').val();
	if (writer == '') {
		alert("로그인 후에 입력하세요");
		return;

	} else if (reply == '') {
		alert("댓글을 입력하세요");
		return;
	}

	svc.addReply({
		bno,
		writer,
		reply
	}, //param1
		result => {
			if (result.retCode == 'OK') {
				page = 1; //최신글 순 일 경우
				showList(); //댓글등록 클릭 바로 후에도 5개씩만 보이도록 하기(과제!!!)
				//댓글등록 후에 reply내용 초기화하기
				$('#reply').val("");
			}
		}, //param2
		err => console.log(err)); //param3
}) ////end of addReply

//댓글 페이징 생성
let pagination = $('div.pagination');

function makePageInfo() {
	svc.getTotalCount(bno //param1
		, createPageList //param2
		, err => console.log(err))
}

function createPageList(result) {
	//페이지 속성지정	
	let totalCnt = result.totalCount; //127
	let startPage, endPage, realEnd;
	let prev, next;

	realEnd = Math.ceil(totalCnt / 5);
	endPage = Math.ceil(page / 5) * 5;
	startPage = endPage - 4;
	endPage = endPage > realEnd ? realEnd : endPage;

	prev = startPage > 1;
	next = endPage < realEnd;

	//a 태그 생성
	pagination.html('');
	//이전페이지 여부
	if (prev) {
		let aTag = $('<a>&laquo;</a>').attr('data-page', startPage - 1).attr('href', '#');
		aTag.on('click', function(e) {
			e.preventDefault(); //a 태그는 페이지 이동
			page = $(e.target).data('page');
			showList();
		})
		aTag.appendTo(pagination);
	}
	for (let pg = startPage; pg <= endPage; pg++) {
		let aTag = $('<a />').html(pg).attr('data-page', pg).attr('href', pg);
		if (pg == page) {
			//aTag.attr('class', 'active');
			aTag.addClass('active');
		}
		aTag.on('click', function(e) {
			e.preventDefault(); //a 태그는 페이지 이동
			page = $(e.target).data('page');
			showList();
		})
		pagination.append(aTag);
	}
	//이후페이지 여부
	if (next) {
		let aTag = $('<a>&raquo;</a>').attr('data-page', endPage + 1).attr('href', '#');
		aTag.on('click', function(e) {
			e.preventDefault(); //a 태그는 페이지 이동
			page = $(e.target).data('page');
			showList();
		})
		pagination.append(aTag);
	}
} //end of createPageList