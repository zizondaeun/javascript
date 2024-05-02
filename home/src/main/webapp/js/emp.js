/**
*emp.js
*/

document.addEventListener("DOMContentLoaded", initForm); //content가 로딩되면 initform이 처음 실행할 함수

//화면 로딩 후 처름 실행할 함수 /목록부르는거
function initForm(){
	//Ajax호출
	const xhtp = new XMLHttpRequest();
	xhtp.open('get','../empJson.json'); //*엄청 중요)empJson.json라는 url /../
	xhtp.send(); //메소드로 결과받아와서
	xhtp.onload = function(){
		let data = JSON.parse(xhtp.responseText); //여기에 값을 받아
		console.log(data); //th불러옴
		data.forEach(emp => {
			let tr = makeRow(emp);
			document.querySelector('#elist').appendChild(tr); //<tbody><tr></tr></tbody> /list불러옴
		})
	}
	//등록버튼 이벤트
	document.querySelector('#addBtn').addEventListener('click', addRow);
	
} //end of initForm

function addRow(){ //위의 addRow를 함수로
	//db insert & 화면출력
	const addHtp = new XMLHttpRequest();
	//사원이름(ename),연락처(phone),급여(salary),입사일자(hire),이메일(email) /괄호안에 있는것들을 파라메터로 
	let ename = document.querySelector('#ename').value;
	let ephone = document.querySelector('#ephone').value;
	let esalary = document.querySelector('#esalary').value;
	let edate = document.querySelector('#edate').value;
	let email = document.querySelector('#email').value;
	
	let param = '../empsave.json?job=add&name=' + ename + '&phone=' + ephone //job라는 파라메터/이거 모르겠어
								+ '&salary=' + esalary + '&date=' + edate + '&email=' + email; //문자열이니까 변수로 선언해도 됨
	addHtp.open('get',param);
	addHtp.send();
	addHtp.onload = function(){
		let result = JSON.parse(addHtp.responseText);
		console.log(result); //꼭 확인해보기
		if(result.retCode == 'OK'){
			let tr = makeRow(result.retVal); //리턴밸류가 실제값을 가지고 있음
			document.querySelector('#elist').appendChild(tr);
		}
	}
} //end of addRow

function makeRow(emp = {}){ //데이터 한 건 들어오면 기능하게끔
	let props = ['empNo', 'empName', 'email', 'salary'];
	//한 건에 대한 처리
		let tr = document.createElement('tr'); 
		tr.setAttribute('data-no', emp.empNo); //Attribute data-no속성이래..
		tr.addEventListener('dblclick', modifyRow);
		props.forEach(prop => { //<tr><td>id</td><td>first_name</td><td>email</td><td>salary</td></tr>
			let td = document.createElement('td');
			td.innerHTML = emp[prop];
			tr.appendChild(td); 
		});
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.innerHTML = '삭제'; 
		btn.addEventListener('click', deleteRow);
		td.appendChild(btn);
		tr.appendChild(td); //<tr><td><btn>삭제</btn></td></tr>
		
		return tr;
} //end of makeRow 

//화면 수정 함수
function modifyRow(){
	let originMail = this.children[2].innerText;
	let originSalary = this.children[3].innerText;
	let oldTr = this;
	let newTr = this.cloneNode(true); //true 넣어주면 하위요소까지 다 복제돼
	
	//console.log(tr);
	newTr.querySelector('td:nth-of-type(3)').innerHTML = '<input value="' + originMail + '">';
	newTr.querySelector('td:nth-of-type(4)').innerHTML = '<input value="' + originSalary + '">';
	newTr.querySelector('button').innerText = '수정';
	newTr.querySelector('button').addEventListener('click', updateRow); //click은 tr
	console.log(newTr);
	oldTr.parentElement.replaceChild(newTr, oldTr); //parentElement가 tbody
}

//updateRow
function updateRow(){
	let oldTr = this.parentElement.parentElement;
	let empNo = this.parentElement.parentElement.dataset.no; //data-no -> dataset.no ..../버튼의 상위요소
	let email = this.parentElement.parentElement.children[2].children[0].value;
	let salary = this.parentElement.parentElement.children[3].children[0].value;
	console.log(empNo,email,salary);
	
	const editHtp = new XMLHttpRequest();
	editHtp.open('get', '../empsave.json?job=edit&empNo=' + empNo + '&salary=' + salary + '&email=' + email); //값을 넘겨받는다는 =?
	editHtp.send();
	editHtp.onload = function(){
		let result = JSON.parse(editHtp.responseText);
		console.log(result);
		if(result.retCode == 'OK'){
			
			//다시 원래대로 수정버튼 -> 삭제버튼!!! 이거 다시하기
			let newTr = makeRow(result.retVal);
			//newTr.querySelector('td:nth-of-type(3)').innerHTML = '<input value="' + originMail + '">';
			//newTr.querySelector('button').innerText = '삭제';
			//newTr.querySelector('button').addEventListener('change', updateRow);
			//console.log(newTr);
			
			//let oldTr = this;
			oldTr.parentElement.replaceChild(newTr,oldTr); 
		}
	}
}

function deleteRow(){
	const delNo = this.parentElement.parentElement.children[0].innerText;
	let tr = this.parentElement.parentElement; //밑에서 this안되니까 tr로 선언해줌
	console.log(delNo);
	//서블릿실행(삭제) -> OK값이 반환이 되면 -> 화면에서 지우도록 처리
	const delHtp = new XMLHttpRequest(); //
	delHtp.open('get','../empsave.json?job=delete&empNo=' + delNo) //상대경로
	delHtp.send();
	delHtp.onload = function(){
		let result = JSON.parse(delHtp.responseText); //성공하면 retCode:OK
		//console.log(result);
		if(result.retCode == 'OK'){
			tr.remove(); //tr을 지워야하니까 /윈도우객체
		}else if(result.retCode == 'NG'){
			alert('처리 중 에러발생'); //DB에서 delete하고 웹에서 새고 하기전에 해당 번호 삭제하면 알림창 뜨는거
		}else{
			alert('처리코드 확인하세요')
		}
	}
} //end of delteRow


//웹에서 서버500에러는 콘솔창 확인해보기