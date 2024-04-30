/**
* js/array1.js
*/
empList.forEach((item, idx) => {
	//if(item.gender == 'Female' && item.salary > 4000){
	//	console.log(item); //ctrl + f5 강력 새로고침
	//}
	//indexOf로 이름 찾기
	//if(item.first_name.indexOf('B') >= 0){
	//	console.log(item);
	//}
	if(item.first_name.indexOf('c') >= 0){
		console.log(item);
	}
});
//filter()메소드가 배열 만들어준대
let newAry = empList.filter((item, idx, ary) => {
	//return idx < 10;
	//return item.gender == 'Male';
	//return item.first_name.length >= 6;
	return (idx + 1) == ary.length;
}); 
//map():A -> A'으로 바꾸고 싶을때(맵핑)
newAry = empList.map((item, idx, ary) => {
	const obj = {
		no: item.id,
		name: item.first_name + "-" + item.last_name,
		email: item.email
	}
	return obj;
});
console.log(newAry);

console.clear();

//reduce() 메소드는 매개값을 4개를 갖는다(누산기,값,인덱스,배열)
let result = empList.reduce((acc, curVal) => {
	if(curVal.gender == 'Male'){ 
		acc.push(curVal);
	}
	return acc;
}, []); //초기값이 배열이야
console.log(result);
 
//const array1 = [1, 2, 3, 4];
const array1 = [1, 7, 2, 9, 3, 4];

// 0 + 1 + 2 + 3 + 4
const initialValue = 0;
const sumWithInitial = array1.reduce(function(acc, currentValue){ //누산값은 0과 cur은 1
	console.log(`acc => ${acc}, currentValue => ${currentValue}`);
	//return acc + currentValue;
	
	//최대값
	//return acc > currentValue ? acc : currentValue; 삼항연산자
	//if(acc > currentValue){
	//	return acc;
	//}else{
	//	return currentValue;
	//}
//}, initialValue); //누산값 + cur의 값 (=다음 순번의 초기값)
	
	//최소값
	return acc < currentValue ? acc : currentValue;
	//if(acc < currentValue){
	//	return acc;
	//}else{
	//	return currentValue;
	//}
});
console.log(`최소값: ${sumWithInitial}`);
//console.log(sumWithInitial); //총합

//String.prtotype.indexOf('') => 찾는 값의 인덱스를 반환/prtotype이 원형이래
//Array.prtotype.indexOf('') => 찾는 값의 인덱스를 반환
console.log("abcde".indexOf("c"));
console.log("abcde".indexOf("k")); //없으면 -1 반환
console.log([1,2,3,4,5].indexOf(3));

let genderAry = []; //gender를 종류별로 한가지만 담고싶어

empList.forEach(emp => {
	if(genderAry.indexOf(emp.gender) == -1){
		genderAry.push(emp.gender);
	}
});
console.log(genderAry); //['Male','Female','Bigender','Genderfluid']이렇게 나오게


