/**
* array2.js
*/
let genderAry = []; //gender를 종류별로 한가지만 담고싶어
empList.forEach(emp => {
	if(genderAry.indexOf(emp.gender) == -1){
		genderAry.push(emp.gender);
	}
});

genderAry.forEach(gender => {
	let opt = document.createElement('option'); //let opt = <option></option>
	opt.innerHTML = gender; //<option>gender</option>
	document.querySelector('#genderList').appendChild(opt);
}) //<select><option>gender</option></select>

//함수(배열)
function makeList(ary = []){
	let obj = {id: 1, first_name: '', last_name: '', email: '', gender: '', salary: ''}
	let props = ['id', 'first_name', 'email', 'salary','gender'];
	//*document.querySelector('#show tbody').innerHTML = ""; //기존목록지우기(밑에 교수님방식으로 할때 makeList목록 지워주는거 ) 
	ary.forEach(emp => {
		//한 건에 대한 처리
		let tr = document.createElement('tr'); 
		props.forEach(prop => { //<tr><td>id</td><td>first_name</td><td>email</td><td>salary</td></tr> 이게 한번이고 20개 생겨
			let td = document.createElement('td');
			td.innerHTML = emp[prop];
			tr.appendChild(td); 
		})
		document.querySelector('#show tbody').appendChild(tr);
	})
}

makeList(empList);
makeHeader(); 
//호현씨연습)html에 thead안에 tr,th만드는거
function makeHeader(){
	let emps = [ 'no', 'name', 'email', 'salary','gender' ];
	let tr = document.createElement('tr'); //let tr = <tr></tr>
	emps.forEach((emp) => {
		let th = document.createElement('th'); //let th = <th></th>
		th.innerHTML = emp; //<th>emp</th>
		tr.appendChild(th); //<tr><th>emp</th>*5</tr>
	})
	document.querySelector('#show thead').appendChild(tr);
}

//교수님과제)체인지 박스의 값과 테이블의 값이(gender) 같은게 나오게
let chk = false; //체인지이벤트 위에서 변수선언한 이유는 처음때만 makeList가 안보이게 하려고 밖에 선언한거야
document.querySelector('#genderList').addEventListener('change',function(){
	//console.log(document.querySelector('#genderList')); 이벤트가 잘작동하는지 콘솔로 확인
	if(chk){ //1.첫번째일때만 chk가 실행안되게 하게끔 4.
		makeList(empList); //젠더 선택하면 처음에만 리스트가 두번씩 나와서 문제인거야
	} //*makeList를 첫번째에서 호출하면 안돼 왜냐 두번보이니까
	
	let opt = document.querySelector('#genderList').value; //네모박스의 셀렉의 값을 가져와(4개)
	//console.log(opt); genderList의 값 하나씩과 비교해야하니까 .value
	let data = document.querySelectorAll('#show tbody tr'); //id가 show인 테이블의 thead의 tr을 다 가져와
	data.forEach(function(tr){ //forEach를 통해 tr 한줄 가져와
		let td = tr.children[4].innerHTML; //gender 값을 가져옴
		//console.log(td); table의 td값 쭉 나와
		if(opt != td){ //비교했을때 같지않으면 테이블에서지워줘 근데 다 지워져버리니까(?콘솔에 다시 찍어보기) makeList(empList)로 전체 다 불러 반복
						//근데 그렇게 하면 첫화면에서 전체리스트보여주고 옵션선택하면 두번씩 내용이 반복이 되어버리고 그다음이 한번씩 나와서 이거만 
						//여기서 끝내면 안돼	
			tr.remove(); //2.
		}
	})
	chk = true; //3. /이거 위치
})

//교수님 방법(filter방식으로 해보기)
//document.querySelector('#genderList').addEventListener('change',function(){
//	let filterAry = empList.filter(emp => emp.gender == this.value); //emp라는 (매개)변수를 받아서
//	makeList(filterAry); //makeList 위에서 지워주는거 했음(주석처리*)
//});









