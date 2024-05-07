/**
 * 
 */
//console.log('start');

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
			let checked = content.children[5].children[0].checked;
			//console.log(checked);
			if(checked){
				let no = content.children[0].innerHTML;
				deleteRow(no,
				data => {
					if(data.retCode =='OK') {
							content.remove();
						} else if (data.retCode == 'NG') {
							alert('처리 실패');
						}
				})
			}
		})
	})
}//end of initForm

//체크박스 전체삭제
document.querySelector('div input[type="checkbox"]').addEventListener('change',function(){
	let inp = this;
	document.querySelectorAll('div input[type="checkbox"]')
		.forEach(function(book){
			book.checked = inp.checked;
		})
})

function makeRow(book = {}){
	let props = ['code', 'book_name', 'author_name', 'press', 'price'];
	//{"code":"P12301285","book_name":"이것이자바다","author_name":"홍성문","press":"신흥출판사","price":25000},
	let tr = document.createElement('tr');
	tr.setAttribute('data-no', book.code);
	//console.log(book.code);
	props.forEach(prop => {
		let td = document.createElement('td');
		td.innerHTML = book[prop];
		tr.appendChild(td);
	});
	//삭제 체크박스
	let td2 = document.createElement('td');
	let ckb = document.createElement('input');
	ckb.setAttribute('type', 'checkBox');
	td2.appendChild(ckb);
	tr.appendChild(td2);
	
	//삭제버튼
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerHTML = '삭제';
	btn.addEventListener('click',deleteRow);
	td.appendChild(btn);
	tr.appendChild(td);
	
	return tr;
}//end of makeRow 

//등록
function addRow(){
	let code = document.querySelector('#code').value;
	let bName = document.querySelector('#bookName').value;
	let aName = document.querySelector('#authorName').value;
	let press = document.querySelector('#press').value;
	let price = document.querySelector('#price').value;
	let param = 'add&code=' + code + '&bookName=' + bName + '&authorName=' + aName 
				+ '&press' + press + '&price' + price;
	
	fetch('data/data.json', {
		method: 'post',
		hearders: {'Conetent-Type': 'application/x-www-form-urlencoded'},
		body: param
	})
		.then(result => result.json())
		.then(data => {
			if(data.retCode == 'OK'){
				let tr = makeRow(data.retVal);
				document.querySelector('#list').appendChild(tr);
			}
		})
		.catch(console.log);
}//end of addRow

//삭제
function deleteRow(){
	let no = this.parentElement.parentElement.dataset.no;
	let tr = this.parentElement.parentElement;
	fetch('data/data.json?=delete&code=' + no) //??
		.then(result => result.json())
		.then(data => {
			if(data.retCode == 'OK'){
				tr.remove();
			}else if(data.retCode == 'NG'){
				alert('처리실패');
			}
		})
		.catch(err => console.log(err));
}



