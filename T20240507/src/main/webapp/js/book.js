/**
 * 
 */

document.addEventListener("DOMContentLoaded", initForm);
//booklist불러오는거
function initForm(){
	fetch('data/data.json')
		.then((result) => result.json())
		.then(data => {
			data.forEach(code => {
				let tr = makeRow(code);
				document.querySelector('#list').appendChild(tr); 
			})
		})
		.catch(err => console.log(err));
	
	//저장이벤트
	document.querySelector('#addBtn').addEventListener('click', addRow);
		//console.log(document.querySelector('#addBtn'));

	//선택삭제 이벤트
	document.querySelector('#selDel').addEventListener('click',function(){
		let tr = document.querySelectorAll('#list tr');
		tr.forEach(content => {
			let checked = content.children[0].children[0].checked;
			//console.log(checked);
			if(checked){
				content.remove();
			}
			
		})
	})
}//end of initForm

//저장
function addRow(){
	let code = document.querySelector('#code').value;
	let bName = document.querySelector('#bookName').value;
	let aName = document.querySelector('#authorName').value;
	let press = document.querySelector('#press').value;
	let price = document.querySelector('#price').value;
	
	const book = { code, bName, aName, press, price };
	let tr = makeRow(book);
	//초기
	document.querySelector('#list').appendChild(tr);
	document.querySelector('#code').value = "";
	document.querySelector('#bookName').value = "";
	document.querySelector('#authorName').value = "";
	document.querySelector('#press').value = "";
	document.querySelector('#price').value = "";
}//end of addRow

//체크박스 전체삭제
document.querySelector('thead input[type="checkbox"]').addEventListener('change',function(){
	let inp = this;
	document.querySelectorAll('tbody input[type="checkbox"]')
		.forEach(function(book){
			book.checked = inp.checked;
		})
})

//저장
function makeRow(book = { code, book_name, author_name, press, price }){
	let tr = document.createElement('tr');
	
	//삭제 체크박스
	let td = document.createElement('td');
	let ckb = document.createElement('input');
	ckb.setAttribute('type', 'checkBox');
	td.appendChild(ckb);
	tr.appendChild(td);
	
	for (let prop in book) { 
		let td = document.createElement('td');
		td.innerText = book[prop]; 
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
}//end of makeRow 

//삭제
function deleteRow(){
	let no = this.parentElement.parentElement;
	console.log(no);
	no.remove();
}



