/**
 * member.js
 */
//추가 클릭이벤트 등록
//사용자의 입력값 3개 -> tr > td * 3 -> tbody 하위요소 추가

document.querySelector('#addMember')//
	.addEventListener('click', addMemberFnc);
	
function addMemberFnc(){
	let no = document.querySelector('#memberNo').value;
	let name = document.querySelector('#memberName').value;
	let point =  document.querySelector('#memberPoint').value;
	
	const mem = { no, name, point } //객체만듦{}
	console.log(mem);
	
	let tr = makeRow(mem);
	//-<tr생성>있던 자리
	//document.querySelector('table:nth-of-type(2) tbody');
	document.querySelector('table#tlist tbody').appendChild(tr); //tlist의 tbody를 가져옴
	
	//editRow();
	
}
document.querySelector('#editMember').addEventListener('click', editRow);


//member 정보를 활용 tr반환하는 함수 만들기
//=function makeRow(member = {no, name, point}){ !!!
function makeRow(member){
	console.log(member);
	
	//tr생성--
	let tr = document.createElement('tr');
	//=let tr = <tr></tr>
	//tr에 click 이벤트 등록
	tr.addEventListener('click',function(e){
		e.stopPropagation(); //!!!
		//tr(this)의 자식요소 children (커서누르면 값이 위로 저장돼)-tr에도 이벤트 넣었고
		document.querySelector('#memberNo').value = tr.children[0].innerHTML;
		console.log(tr.children[0]); //tr.children[0]:td
		document.querySelector('#memberName').value = tr.children[1].innerHTML;  
		document.querySelector('#memberPoint').value = tr.children[2].innerHTML;
	}) //true로 해두면 젤 상위요소로 간대.. window로... 그래서 눌러도 삭제가 안된대..
	//--
	
	for (let prop in member) { //mem이 가지고 있는 속성:prop
		let td = document.createElement('td');
		td.innerText = member[prop]; //mem.no 속성가져오는거,member.prop
		console.log('prop' + prop);
		tr.appendChild(td); //td가 tr의 하위 요소로 들어가는거		
	}//3번 반복해서 tr에 넣어
		
	//버튼만들기 <td><button>삭제</button></td>-버튼에도 이벤트 넣었어
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	btn.addEventListener('click',deleteRow);
	td.appendChild(btn);
	tr.appendChild(td);		
	
	//체크박스 만들기
	td = document.createElement('td');
	let chk = document.createElement('input');
	chk.setAttribute('type', 'checkbox'); //setAttribute input 의 속성을 넣는다
	//<input type = 'checkbox'>
	chk.addEventListener('change',changeRow); //=바뀔때마다 이벤트 발생한다
	td.appendChild(chk);
	tr.appendChild(td);		

	return tr;
	
}//end of makeRow

function deleteRow(evnt){
	evnt.stopPropagation(); //상/하위 요소로 이벤트 차단하는거
	evnt.target.parentElement.parentElement.remove();
	//btn/td/tr
	console.log(evnt);
}

function changeRow(e){
	//this => <input type = "checkbox" checked>
	console.log(this.checked); //this는 input 태그를 말함/checkbox일 경우
}

//members 배열의 갯수만큼 tr생성
members.forEach(function(item){
	let tr = makeRow(item);
	document.querySelector('table#tlist tbody').appendChild(tr);
});
//마우스커서 이동에 따라
//document.addEventListener('mousemove',function(e){
//	console.log(e.pageX,e.pageY);
//})

//4/29 과제 제출 
function editRow(){
	let val = document.querySelector('#memberNo').value;
	//console.log(val);
	//console.log(val.value);
	let tbodyRow = document.querySelectorAll('#tlist tbody tr');

	tbodyRow.forEach(function(tr) {
		let td = tr.children[0].innerHTML;
		if(val == td){
			let up = document.querySelector('#memberName').value;
			let down = document.querySelector('#memberPoint').value;
			tr.children[1].innerHTML = up;
			tr.children[2].innerHTML = down;
		}
		console.log(td);
	})
}

//thead inputp[type="checkbox"]
document.querySelector('thead input[type="checkbox"]')//
.addEventListener('change', function(){
	//event 핸들러 -> this
	//thead의 타입이 checkbox인 얘를 -> tbody에 적용
	let inp = this; 
	document.querySelectorAll('tbody input[type="checkbox"]') //=tbody>tr>td>input(하위)
		//.forEach((item) => { //화살표함수
			//console.log(this); //item이 input 태그임/함수안의 this는 window객체다
			//item.checked = this;
		.forEach(function(item){ 
			console.log(this);
			item.checked = inp.checked;
		})
})
