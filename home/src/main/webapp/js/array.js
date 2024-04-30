/**
* array.js
*/
const ary = []; //배열 객체 만듦 / new Array(); - 생성자 만들때(아까 object랑 같아)
ary.push('apple'); //문자
ary.push(['banana', 'cherry']); //배열
ary.push({name: "홍길동", age: "20"}); //객체

console.log(ary);

const fruits = []; //배열 선언
fruits.push({name: "사과", price: 1000}); //마지막 요소에 추가
fruits.push({name: "수박", price: 5000});
fruits.pop(); //뒤에서부터 제거
fruits.unshift({name: "수박", price: 5000}); //앞쪽(인덱스0번째)에서 추가
fruits.shift(); //앞에서부터 제거
fruits.push({name: "수박", price: 1000}); //마지막 요소에 추가
// [사과,수박]
//추가,수장,삭제 가능 : splice
fruits.splice(1, 0, {name: '참외', price: 3000}); //추가
fruits.splice(1, 1, {name: '참외', price: 5000}); //수정(수박자리에 참외)
fruits.splice(1, 2); //삭제(3번째거 없으면 삭제)


console.log(fruits);


