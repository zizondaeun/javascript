create table users(
id       varchar2(8) primary key,
password varchar2(8),
name     varchar2(20),
role     varchar2(5));

insert into users values('test','test123','������','Admin');
insert into users values('user1','user1','ȫ�浿','User');

commit;