/**
 * jsondate.js
 */

 const employees = `[{"id":1,"first_name":"Toddie","last_name":"Renfield","email":"trenfield0@webnode.com","gender":"Male","salary":3403},
{"id":2,"first_name":"Emyle","last_name":"Yelden","email":"eyelden1@statcounter.com","gender":"Female","salary":4200},
{"id":3,"first_name":"Morgun","last_name":"Bosch","email":"mbosch2@reuters.com","gender":"Male","salary":4647},
{"id":4,"first_name":"Locke","last_name":"Cocci","email":"lcocci3@topsy.com","gender":"Male","salary":3660},
{"id":5,"first_name":"Eugenie","last_name":"Carrol","email":"ecarrol4@printfriendly.com","gender":"Non-binary","salary":4859},
{"id":6,"first_name":"Rubie","last_name":"Knocker","email":"rknocker5@narod.ru","gender":"Female","salary":3942},
{"id":7,"first_name":"Diena","last_name":"Rawlison","email":"drawlison6@nature.com","gender":"Female","salary":4280},
{"id":8,"first_name":"Harp","last_name":"Sindell","email":"hsindell7@dion.ne.jp","gender":"Male","salary":4553},
{"id":9,"first_name":"Starlin","last_name":"Shearston","email":"sshearston8@msu.edu","gender":"Female","salary":3401},
{"id":10,"first_name":"Eugenie","last_name":"Knevett","email":"eknevett9@fda.gov","gender":"Female","salary":4968},
{"id":11,"first_name":"Pennie","last_name":"Jakubowicz","email":"pjakubowicza@hao123.com","gender":"Non-binary","salary":3620},
{"id":12,"first_name":"Brendon","last_name":"Acom","email":"bacomb@oakley.com","gender":"Male","salary":3354},
{"id":13,"first_name":"Lowell","last_name":"Winsom","email":"lwinsomc@apple.com","gender":"Male","salary":3162},
{"id":14,"first_name":"Christalle","last_name":"Batchan","email":"cbatchand@china.com.cn","gender":"Female","salary":4183},
{"id":15,"first_name":"Tadd","last_name":"Alf","email":"talfe@people.com.cn","gender":"Male","salary":4103},
{"id":16,"first_name":"Rooney","last_name":"Flippelli","email":"rflippellif@timesonline.co.uk","gender":"Male","salary":4957},
{"id":17,"first_name":"Umberto","last_name":"Eddie","email":"ueddieg@icio.us","gender":"Male","salary":4198},
{"id":18,"first_name":"Alberto","last_name":"Murphey","email":"amurpheyh@sphinn.com","gender":"Male","salary":4885},
{"id":19,"first_name":"Lorraine","last_name":"Burbury","email":"lburburyi@amazon.co.jp","gender":"Female","salary":3949},
{"id":20,"first_name":"Clareta","last_name":"Piotrowski","email":"cpiotrowskij@chron.com","gender":"Bigender","salary":3256}]`;

//console.log(employees);
const empList = JSON.parse(employees); //문자열 -> 객체 /파싱한 결과..?
//console.log(empList);