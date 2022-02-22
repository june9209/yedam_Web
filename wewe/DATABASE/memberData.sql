create table users(
id varchar2(10) primary key,
pwd varchar2(20) not null,
name varchar2(10)not null,
hobby number(2)not null ,
gender number(1)not null,
religion number(1)not null,
introduction varchar2(500)not null
)