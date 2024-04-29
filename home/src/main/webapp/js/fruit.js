/**
 * fruit.js
 */
//버튼누르면 가리키는거
console.log(document.querySelector('button'));
//addEventListener()-클릭이벤트가 발생하면 기능실행
document.querySelector('#addBtn').addEventListener('click', function() {
	//요소생성(createElement)
	//자식요소(appendChild)-li안에 btn속성을 넣어주는거

	//let txt = document.querySelector('p').innerText;-p태그 넣는거
	//li.innerText = txt;

	//let val = document.querySelector('input').value;
	//let li = document.createElement('li');
	//li.innerText = '수박(3000)';
	//li.innerText = val;
	
	let txt = document.querySelector('input').value;
	let price = document.querySelector('input:nth-of-type(2)').value;
	let li = document.createElement('li');
	li.innerText = txt + '(' + price + ')';
	//let li = <li>참외(2000)</li>
	
	//삭제버튼
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	//let btn = <button>삭제</button>
	li.appendChild(btn)
	//let li = <li>참외(2000)<button>삭제</button></li>
	btn.addEventListener('click',function(){
		console.log(this); //this:자기자신(버튼태그)
		this.parentElement.remove(); //remove()?/parentElement-상위요소 가리키는거
	}); //버튼의 부모인 li를 삭제해
	
	//innerText 값을 ul안에 넣은거
	let ul = document.querySelector('ul');
	ul.appendChild(li);
});

		
