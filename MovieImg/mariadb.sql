create database javaproject;
use javaproject;
drop table movename;
drop table moviename;
drop table member;
create table moviename(
	movietitle varchar(50) primary key,
	movierank varchar(50),
	movieimg varchar(50),
	moviedate varchar(50)
);
create table member(
	userid varchar(50) primary key,
	userpw varchar(5000),
	name varchar(50),
	email varchar(50),
	userhp varchar(50)
);

create table ordergoods(
	orderid bigint primary key AUTO_INCREMENT,
	users varchar(50),
	personcount bigint,
	screeningplace varchar(50),
	movietitle varchar(50)
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