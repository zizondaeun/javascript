//혼자 다시 해본거
document.addEventListener("DOMContentLoaded", initForm);

//json목록에 있는 데이터 넣기
function initForm(){
	fetch('data/data.json') //백이랑 연결하려고 
	 .then((result) => result.json())
	 .then(data => {
		data.forEach(content => {
			let tr = makeRow(content);
			document.querySelector('#list').appendChild(tr);
		})
	 })
	 .catch();
	 
	//저장 이벤트
	document.querySelector('#addBtn').addEventListener('click', addRow);
		console.log(document.querySelector('#addBtn'));

	//선택삭제 이벤트
 	document.querySelector('#selDel').addEventListener('click', function(){
		//console.log(document.querySelector('#selDel'));
		let tr = document.querySelectorAll('#list tr');
		tr.forEach(content => {
			let ck = content.children[0].children[0].checked;
			if(ck){
				content.remove();
			}
		})
	})
}

//
function addRow(){
	let code = document.querySelector('#code').value;
	let bName = document.querySelector('#bookName').value;
	let aName = document.querySelector('#authorName').value;
	let press = document.querySelector('#press').value;
	let price = document.querySelector('#price').value;
	
	const books = {code, bName, aName, press, price}
	let tr = makeRow(books);
	
	//값 초기화
	document.querySelector('#list').appendChild(tr);
	document.getElementById('code').value = "";
	document.getElementById('bookName').value = "";
	document.getElementById('authorName').value = "";
	document.getElementById('press').value = "";
	document.getElementById('price').value = "";
	
}

//체크박스 전체삭제
document.querySelector('thead input[type="checkBox"]').addEventListener('click', function(){
	let inp = document.querySelectorAll('tbody input[type="checkBox"]');
	inp.forEach(chk => {
		//console.log(chk.checked);
		if(chk.checked){
			chk.checked = false;
		}else{
			chk.checked = true;
		}
	})
})

//
function makeRow(books = {code, book_name, author_name, press, price}){
	let tr = document.createElement('tr');
	
	//체크박스
	let td = document.createElement('td');
	let ckb = document.createElement('input');
	ckb.setAttribute('type', 'checkBox');
	td.appendChild(ckb);
	tr.appendChild(td);
	
	for(let book in books){
		let td = document.createElement('td');
		td.innerText = books[book];
		tr.appendChild(td);
	}
	//삭제버튼
	td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerHTML = '삭제';
	btn.addEventListener('click', deleteRow);
	td.appendChild(btn);
	tr.appendChild(td);
	
	return tr;
}

//삭제
function deleteRow(){
	let tr = this.parentElement.parentElement;
	console.log(this.parentElement.parentElement);
	tr.remove();
}