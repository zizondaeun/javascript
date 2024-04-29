/**
* data.js
*/
const members = [
	{no:1001, name:'홍길동', point:90},
	{no:1002, name:'김길동', point:100},
	{no:1003, name:'박길동', point:95}
];

//배열 for반복문
//for(let mem of members){}

members.forEach(function(item, idx, ary){ //(매개변수)
	if(item.point >= 95)
		console.log(item, idx, ary)
})