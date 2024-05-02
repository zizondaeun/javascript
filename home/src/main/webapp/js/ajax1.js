/**
* ajax1.js(Asynchronous JavaScript and XML)
*/

const xhtp = new XMLHttpRequest(); //객체
xhtp.open('get', '../empList.json'); //호출할 페이지 지정(EmpListJson에서)
xhtp.send(); //호출
xhtp.onload = function(){ //이벤트 발생하면 실행됨
	let jsonObj = JSON.parse(xhtp.responseText); //json방식으로 문자열 또는 HTML방식으로도 가능 /responseText:속성
	console.log(jsonObj);
}