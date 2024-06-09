create table chat (
    no     number   primary key,    
    sndr   varchar2(20),
    msg    varchar2(400),
    dttm   date
);