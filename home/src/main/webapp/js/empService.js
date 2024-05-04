/**
*empService.js => 목록, 추가, 수정, 삭제 기능 객체
*/
//통신
const svc = {
	//목록/empfetch에서 얘를 부르기만 했고
	empList: function(successCall, errorCall) {
		fetch('../empJson.json')
			.then(result => result.json())
			.then(successCall)
			.catch(errorCall);
	},
	//등록 (목록 방식이나 이거나 선택해서 해)/addemp에서는 param ={}로 값을 받아
	addEmp(param = {}, successCall, errorCall) { //초기값으로 객체를 넘기겠다
		fetch('../empsave.json', { //옵션객체{}
			method: 'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			body: 'job=add&name=' + param.name + '&phone=' + param.phone
				+ '&salary=' + param.salary + '&date=' + param.date + '&email=' + param.mail //어제 한 ajax처럼 job이 add고 paramObj의 값들을 가져와야함
		})
			.then(result => result.json())
			.then(successCall)
			.catch(errorCall)
	},
	//수정
	editEmp(param = {}, successCall, errorCall) {
		fetch('../empsave.json', {
			method: 'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			body: 'job=edit&empNo=' + param.empNo + '&salary=' + param.salary + '&email=' + param.email
		})
			.then(result => result.json())
			.then(successCall)
			.catch(errorCall)
	},
	//삭제
	deleteEmp(eno, successCall, errorCall){
		fetch('../empsave.json?job=delete&empNo=' + eno)
			.then(result => result.json())
			.then(successCall)
			.catch(errorCall);
	}
}