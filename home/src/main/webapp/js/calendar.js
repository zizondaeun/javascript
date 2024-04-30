/**
* calendar.js
*/
//달력만들기
document.addEventListener("DOMContentLoaded", initForm); //페이지를 다 다운받은후에 함수를 실행하세요
	//console.log(show);	

function initForm(){ //function이 initForm 으로 바뀜(너무 길어서)
	let show = document.querySelector('#show');
	show.appendChild(svc.makeTable());
	//document.querySelector('#show>table').appendChild(svc.makeHeader());
	document.querySelector('#show>table').appendChild(svc.makeHeader2());
	document.querySelector('#show>table').appendChild(svc.makeBody());
	
}

const svc = { //객체만듦
	makeTable: function(){ //makeTable이라는 메소드
		let tbl = document.createElement('table'); //let tbl = <table></table>
		tbl.setAttribute('border', "2"); //<table border="2"></table>
		return tbl;
	},
	makeHeader: function(){
		const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat']; 
		let thd = document.createElement('thead'); //let tbd = <thead></thead>
		let tr = document.createElement('tr'); //let tr = <tr></tr>
		days.forEach((day) => { //day매개값을 받아서 {}를 실행하는 화살표 함수
			let th = document.createElement('th'); //let th = <th></th>
			th.innerHTML = day; //<th>day</th>
			tr.appendChild(th); //<tr><th>day</th></tr>
		});
		thd.appendChild(tr); //<thead><tr><th>day</th></tr></thead>
		return thd;
	},
	makeHeader2: function(){ //reduce() 사용해서 하기
		const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat']; 
		let tr = days.reduce((acc,curVal) => {
			let th = document.createElement('th'); //let th = <th></th>
			th.innerHTML = curVal; //<th>curVal</th>
			acc.appendChild(th); //th를 acc값에 누산한다는 건가?
			return acc;
		}, document.createElement('tr')); //초기값/ <tr></tr> -> <tr><th/>*7</tr>
		let thd = document.createElement('thead'); //let tbd = <thead></thead>
		thd.appendChild(tr); //<thead><tr><th/>*7</tr></thead>
		
		return thd;
	},
	makeBody: function(){
		let tbd = document.createElement('tbody'); //let tbd = <tbody></tbody>
		let tr = document.createElement('tr'); //let tr = <tr></tr>
		//달력 공백넣기(첫번째 네모칸)
		let spaces = 1; //1의 위치가 어디에 있어야 하는지...
		for(let i=0; i<spaces; i++){
			let td = document.createElement('td'); //let td = <td></td>
			td.innerHTML = " "; //<td> </td>
			tr.appendChild(td); //<tr><td> </td></tr>
		}
		
		//날짜 출력해주는 부분
		for(let d = 1; d <= 30; d++){ //교수님 문제)d가 7일이 될때마다 반복되게
			let td = document.createElement('td'); //let td = <td></td>
			td.innerHTML = d; //<td>d</td>
			tr.appendChild(td); //<tr><td>d</td></tr>
			if((d + spaces) % 7 == 0){
				//토요일이 끝나면 새로운 한주의 시작
				tbd.appendChild(tr); //<tbd><tr><td>d</td></tr></tbd> -> <tr><td/>*7</tr>
				tr = document.createElement('tr'); //tr = <tr></tr>
			}
		}
		tbd.appendChild(tr); //왜 또 append하는지?-4월의 마지막주는 3일뿐이라 for문이 끝나고 그 3일을 tbd에 넣어주기 위해서 밖에서 
		return tbd;
	}
	
}//end of svc