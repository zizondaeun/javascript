/**
* ajax.js(Asynchronous JavaScript and XML)
*/

//비동기방식(setTimeout = 함수):step 1->3->2로 처리됨 /시간걸어주는거 ex)dom,settimeout,ajax *중요하대*
//장점:웹에서는 속도가 빠른것이 좋은데 순차적으로 하게되어버리면 느리잖아(시간절약)
setTimeout(function(){ //함수, 숫자
	console.log("step 1"); //1초있다가 처리하는거
}, 1000); 

setTimeout(function(){ 
	console.log("step 2"); //3초있다가 처리하는거
}, 3000); 

setTimeout(function(){ 
	console.log("step 3"); //2초있다가 처리하는거
}, 2000); 

//동기방식:step 1->2->3로 처리됨(순차적으로 처리하는거) 
setTimeout(function(){ 
	console.log("step 1"); //1초있다가 처리하는거
	
	setTimeout(function(){ 
		console.log("step 2"); //3초있다가 처리하는거
	
		setTimeout(function(){ 
			console.log("step 3"); //2초있다가 처리하는거
		}, 2000);
	}, 3000); 
}, 1000); 


