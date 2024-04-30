/**
 * jsondate.js
 */

 const employees = `[{"id":1,"first_name":"Lizabeth","last_name":"Flement","email":"lflement0@admin.ch","gender":"Female","salary":4065},
{"id":2,"first_name":"Mahalia","last_name":"Blampey","email":"mblampey1@about.com","gender":"Female","salary":4975},
{"id":3,"first_name":"Lusa","last_name":"Pero","email":"lpero2@paginegialle.it","gender":"Female","salary":3034},
{"id":4,"first_name":"Neron","last_name":"Eyckelberg","email":"neyckelberg3@bbb.org","gender":"Male","salary":3499},
{"id":5,"first_name":"Alyda","last_name":"Brakewell","email":"abrakewell4@example.com","gender":"Female","salary":3430},
{"id":6,"first_name":"Vince","last_name":"Membry","email":"vmembry5@histats.com","gender":"Male","salary":4685},
{"id":7,"first_name":"Shannen","last_name":"Galvan","email":"sgalvan6@hp.com","gender":"Female","salary":4986},
{"id":8,"first_name":"Jake","last_name":"Scollick","email":"jscollick7@nature.com","gender":"Male","salary":3928},
{"id":9,"first_name":"Antonino","last_name":"Waudby","email":"awaudby8@imageshack.us","gender":"Male","salary":3777},
{"id":10,"first_name":"Hedvig","last_name":"D'Andrea","email":"hdandrea9@ebay.com","gender":"Female","salary":4968},
{"id":11,"first_name":"Manuel","last_name":"Paal","email":"mpaala@state.tx.us","gender":"Male","salary":4813},
{"id":12,"first_name":"Celka","last_name":"Lurcock","email":"clurcockb@sfgate.com","gender":"Female","salary":4436},
{"id":13,"first_name":"Mace","last_name":"Cowcha","email":"mcowchac@economist.com","gender":"Male","salary":3480},
{"id":14,"first_name":"Georgy","last_name":"Golland","email":"ggollandd@archive.org","gender":"Male","salary":4131},
{"id":15,"first_name":"Constantina","last_name":"Brolan","email":"cbrolane@wunderground.com","gender":"Female","salary":4846},
{"id":16,"first_name":"Clemens","last_name":"Helliker","email":"chellikerf@shop-pro.jp","gender":"Male","salary":4664},
{"id":17,"first_name":"Chan","last_name":"Billingham","email":"cbillinghamg@vkontakte.ru","gender":"Male","salary":3300},
{"id":18,"first_name":"Babara","last_name":"Stapforth","email":"bstapforthh@imageshack.us","gender":"Female","salary":4578},
{"id":19,"first_name":"Anallese","last_name":"Barham","email":"abarhami@dailymotion.com","gender":"Female","salary":4642},
{"id":20,"first_name":"Dianemarie","last_name":"Wannan","email":"dwannanj@desdev.cn","gender":"Female","salary":3027}]`;

//console.log(employees);
const empList = JSON.parse(employees); //문자열 -> 객체 /파싱한 결과..?
//console.log(empList);