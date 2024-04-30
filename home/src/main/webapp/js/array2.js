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
})

//함수(배열)
function makeList(ary = []){
	let obj = {id: 1, first_name: '', last_name: '', email: '', gender: '', salary: ''}
	let props = ['id', 'first_name', 'email', 'salary'];
	
	ary.forEach(emp => {
		//한 건에 대한 처리
		let tr = document.createElement('tr');
		props.forEach(prop => {
			let td = document.createElement('td');
			td.innerHTML = emp[prop];
			tr.appendChild(td);
		})
		document.querySelector('#show tbody').appendChild(tr);
	})

}
makeList(empList);

