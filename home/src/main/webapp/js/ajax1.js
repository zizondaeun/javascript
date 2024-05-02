/**
* ajax1.js(Asynchronous JavaScript and XML)
*/

const xhtp = new XMLHttpRequest(); //객체 서버로 비동기적으로 데이터를 주고받는 함수..?
xhtp.open('get', '../empList.json'); //호출할 페이지 지정(EmpListJson에서) get:어떻게 통신할거야 (통신방법) url을 통해 값을 가져와(유튜브)
xhtp.send(); //호출						//post:서버로 데이터를 바로 보내는거(로그인정보)
xhtp.onload = function(){ //이벤트 발생하면 실행됨
	let jsonObj = JSON.parse(xhtp.responseText); //json방식으로 문자열 또는 HTML방식으로도 가능 /responseText:속성
	console.log(jsonObj);
}