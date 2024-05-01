//입력하면 add 누르면 밑에 추가되는거
//아무것도 입력안하고 add누르면 알림창뜨기
//x누르면 삭제되게
//밑줄되는거

//console.log(inp);
let addBtn = document.querySelector('.addBtn');
//console.log(addBtn);

let li = document.querySelectorAll('#myUL li');
//console.log(li);
li.forEach(function(content){ 
	let span = document.createElement('span');
	let txt = document.createTextNode("\u00D7");
	span.className = 'close'; 
	span.appendChild(txt);
	
	span.addEventListener('click',function(){
		content.remove();
	})
	content.appendChild(span);
})

addBtn.addEventListener('click', function() {
	let inp = document.querySelector('#myInput').value; //이유
	//console.log(inp);
	if(inp == ''){
		alert('입력하세요');
	}else{
		let li = document.createElement('li');
		let ul = document.querySelector('#myUL');
		//console.log(ul);
		li.innerHTML = inp;
		let span = document.createElement('span');
		let txt = document.createTextNode("\u00D7");
		span.className = 'close';
		span.appendChild(txt);
		
		span.addEventListener('click',function(){
			li.remove();
		})
		
		li.appendChild(span);
		ul.appendChild(li);
	}
	//inp지워(초기화)
	document.querySelector('#myInput').value = '';
})

let ul = document.querySelector('#myUL').addEventListener('click', function(el){
	//console.log(el.target); //=윈도우 객체의 타겟 가져와
	let target = el.target; //클릭한 li 
	//console.log(el);
	if(target.className == 'checked'){ //li의 class만 가져왔으니까 나머지 li도 가져와야하니까
		target.className = '';
	}else{
		target.className = 'checked';
	}
})

//document.querySelector('.addBtn').addEventListener('click',function(){
//	console.log(document.querySelector('.addBtn'));
//})







