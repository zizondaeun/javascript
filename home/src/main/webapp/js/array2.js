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
makeHeader(empList);
makeList(empList);
//html에 thead안에 tr,th만드는거(연습)
function makeHeader(ary = []){
	let emp = [ 'no', 'name', 'email', 'salary','gender' ];
	let tr = document.createElement('tr'); //let tr = <tr></tr>
	emp.forEach((umm) => {
		let th = document.createElement('th'); //let th = <th></th>
		th.innerHTML = umm; //<th>umm</th>
		tr.appendChild(th); //<tr><th>umm</th></tr>
	})
	document.querySelector('#show thead').appendChild(tr);
}

let chk = false;
document.querySelector('#genderList').addEventListener('change', function(){
	if(chk){ //1.첫번째일때만 chk가 실행안되게 하게끔 
		makeList(empList); //다 보여주는거
	}
	 let gen = document.querySelector('#genderList').value; //셀렉의 값을 가져와
	 let data = document.querySelectorAll('#show tbody tr');
	 data.forEach(function(tr){ //forEach를 통해 tr 한줄 가져와
		let td = tr.children[4].innerHTML; //gender 값을 가져옴
		if(td != gen){ //비교했을때 같지않으면 지워줘 근데 다 지워져버리니까 makeList(empList)로 전체 다 불러 반복
			tr.remove(); //2.
		}
	 })
	 chk = true; //3.
})


