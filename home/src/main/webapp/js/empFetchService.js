/**
*empFetch.js Ajax 기능을 fetch함수 활용
*empSvc 객체에 기능을 구현. 메소드를 호출 /Ajax 더 단순하게 코드짜서 해보기
*/
document.addEventListener("DOMContentLoaded", initForm); //content가 로딩되면 initform이 처음 실행할 함수

function initForm() {
	//Ajax호출 /목록출력/fetch 라는 함수를 통해 리스트 불러올수있게 함
	svc.empList(result => { //성공했을때 실행할 함수
		result.forEach(emp => {
			let tr = makeRow(emp); //
			document.querySelector('#elist').appendChild(tr);
		}) //end of forEach
	}, //successCall 
		err => console.log(err) //errorCall 실패했을때 실행할 함수
	);

	//등록이벤트
	document.querySelector('#addBtn').addEventListener('click', addRow);
}//end of initForm

function makeRow(emp = {}) { //데이터 한 건 들어오면 기능하게끔
	let props = ['empNo', 'empName', 'email', 'salary'];
	//한 건에 대한 처리
	let tr = document.createElement('tr');
	tr.setAttribute('data-no', emp.empNo); //Attribute data-no(값을 받아오는거)사용자가 지정한 데이터속성을 지정하는거
	tr.addEventListener('dblclick', modifyRow);
	props.forEach(prop => { //<tr><td>id</td><td>first_name</td><td>email</td><td>salary</td><td><button>삭제</button></td></tr>
		let td = document.createElement('td');
		td.innerHTML = emp[prop];
		tr.appendChild(td);
	});
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerHTML = '삭제';
	btn.addEventListener('click', deleteRow);
	td.appendChild(btn);
	tr.appendChild(td);

	return tr;
} //end of makeRow 

//삭제이벤트
function deleteRow() {	
	let eno = this.parentElement.parentElement.dataset.no; //dataset 값을 가져오는거 (tr의 값을 가져온것을 eno라는 변수에 선언)
	let tr = this.parentElement.parentElement; //=tr(버튼의 상위요소tr-td-btn) /button:this

	let param = 'job=delete&empNo=' + eno;

	let paramObj = { eno }

	svc.deleteEmp(eno,
		data => {
			if (data.retCode == 'OK') {
				tr.remove();
			} else if (data.retCode == 'NG') {
				alert('처리 실패!');
			}
		},
		err => console.log(err) //errorCall
	)
}//end of deleteRow

//등록
function addRow() { //위의 addRow를 함수로 
	//db insert & 화면출력
	//사원이름(ename),연락처(phone),급여(salary),입사일자(date),이메일(email) /괄호안에 있는것들을 파라미터로 

	let paramObj = {
		job: 'add',
		name: document.querySelector('#ename').value,
		phone: document.querySelector('#ephone').value,
		salary: document.querySelector('#esalary').value,
		date: document.querySelector('#edate').value,
		mail: document.querySelector('#email').value
	} //등록param

	svc.addEmp(paramObj,
		data => {
			if (data.retCode == 'OK') {
				let tr = makeRow(data.retVal); //리턴밸류가 실제값을 가지고 있음
				document.querySelector('#elist').appendChild(tr);
			}
		},
		err => console.log(err) //errorCall
	)
} //end of addRow

//화면 수정 함수
function modifyRow() {
	let originMail = this.children[2].innerText;
	let originSalary = this.children[3].innerText;
	let oldTr = this; //tr :this
	let newTr = this.cloneNode(true); //하위요소까지 다 복제돼

	//console.log(tr);
	newTr.querySelector('td:nth-of-type(3)').innerHTML = '<input value="' + originMail + '">';
	newTr.querySelector('td:nth-of-type(4)').innerHTML = '<input value="' + originSalary + '">';
	newTr.querySelector('button').innerText = '수정'; //삭제 -> 수정 버튼안의 내용을 바꾸기위해
	newTr.querySelector('button').addEventListener('click', updateRow); //click은 tr
	console.log(newTr);
	oldTr.parentElement.replaceChild(newTr, oldTr); //parentElement가 tbody/*노드를 교체한다/append못써 삭제못하니까(계속 추가되기만 하니까)
}//end of modifyRow 

//수정
function updateRow() {
	let oldTr = this.parentElement.parentElement; //button:this,oldTr:tr

	let empNo = this.parentElement.parentElement.dataset.no; //data-no -> dataset.no ..../버튼의 상위요소:emp.empNo
	let email = this.parentElement.parentElement.children[2].children[0].value; //td의 input값 
	let salary = this.parentElement.parentElement.children[3].children[0].value;

	let param = 'job=edit&empNo=' + empNo + '&salary=' + salary + '&email=' + email;

	let paramObj = {
		empNo,
		email,
		salary
	}

	svc.editEmp(paramObj,
		data => {
			if (data.retCode == 'OK') {
				let newTr = makeRow(data.retVal); //리턴밸류가 실제값을 가지고 있음
				oldTr.parentElement.replaceChild(newTr, oldTr);
			}
		},
		err => console.log(err) //errorCall
	)
} //end of updateRow
