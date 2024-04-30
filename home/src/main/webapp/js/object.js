/*
*object.js(객체,함수)
*객체(속성,메소드)
*/
const obj = { //new Object(); -객체만듦
	name:"홍길동", //name:속성
	age:20,
	showInfo: function(){ //showInfo-함수정의구문
		return `이름은 ${this.name}이고 나이는 ${this.age}입니다.`; //백틱써서 문자열로
	},
	empList: function(){ //메소드 하나더 선언(익명함수..?)
		//Ajax (목금 수업할것)
		fetch('../empList.json') //보내는거
		.then(function(result){ //then 메소드
			return result.json(); //json 문자열 -> 객체 변환시켜줌 :then
		})
		.then(function(result){ //앞에서 반환된 값이 여기에서 기능하는거지.. 
			console.log(result); //위의 결과값을 출력 / DOM활용
			result.forEach(function(member){
				let tr = document.createElement('tr'); // let tr = <tr></tr>
				for(let prop in member){
					let td = document.createElement('td'); // let td = <td></td>
					td.innerText = member[prop];
					tr.appendChild(td); //<tr><td></td></tr>
				}
				document.querySelector('tbody').appendChild(tr); //tbody = <tr><td></td></tr>
			});
		})
	}
} 
//console.log('이름:' + obj.name);
obj.name = "Hongkildong"; //값을 바꿔줬어
console.log(`이름: ${obj.name}, 나이: ${obj["age"]}`); 
console.log(obj.showInfo()); //괄호해야해

console.log(window); //window객체(최상위)가 가지고 있는 메소드와 속성 확인 가능
//속성확인
for(let prop in obj){ 
	console.log(`속성: ${prop}, 값: ${obj[prop]}`); //${prop}은 속성만 가져와, ${obj[prop]}는 값 가져와
}

//window.alert('확인!!');
console.clear(); //콘솔의 로그를 지움:clear
obj.empList(); //위의 empList를 여기서 호출

 
