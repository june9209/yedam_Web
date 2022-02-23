CREATE TABLE users(
    id          VARCHAR2(20) primary key,
    password    VARCHAR2(25),
    name        VARCHAR2(20),
    hobby       VARCHAR2(40),
    gender      VARCHAR2(10),
    religion    VARCHAR2(20),
    introduction VARCHAR2(200));