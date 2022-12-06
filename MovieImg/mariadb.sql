USE mysql;
set password for 'root'@'localhost' = PASSWORD('1234');
drop database javaproject;
create database javaproject;
use javaproject;

drop table movie;
drop table moviename;
drop table member;

create table movie(
	title varchar(50) primary key,
	img varchar(50),
	price bigint
);
create table member(
	userid varchar(50) primary key,
	userpw varchar(5000),
	name varchar(50),
	email varchar(50),
	userhp varchar(50),
	role tinyint
);

create table ordergoods(
	orderid bigint primary key AUTO_INCREMENT,
	userid varchar(50),
	personcount bigint,
	screeningplace varchar(50),
	title varchar(50),
	saleprice bigint,
	FOREIGN KEY(userid) REFERENCES member(userid),
	FOREIGN KEY(title) REFERENCES movie(title)
	
);
 create table store(
	storeid bigint primary key AUTO_INCREMENT,
	storecount bigint,
	storepayment varchar(50),
	storepaymentconfirm varchar(50),
	storetotalprice bigint,

 );


alter table ordergoods convert to character set utf8;
alter table moviename convert to character set utf8;
alter table member convert to character set utf8;
show variables like 'c%';
set character_set_server = 'utf8';
set character_set_database = 'utf8';
insert into member(userid,userpw) values('1','1');


"movie create"
insert into movie(title,img,price) values('올빼미','owl.jpg',10000);
insert into movie(title,img,price) values('바르도','bardo.jpg',20000);
insert into movie(title,img,price) values('유포자들','spreaders.jpg',15000);
insert into movie(title,img,price) values('데시벨','decibel.jpg',9000);


insert into ordergoods(
userid,personcount,
screeningplace,saleprice,title) 
values('1',2,'영등포',15000,'올빼미');