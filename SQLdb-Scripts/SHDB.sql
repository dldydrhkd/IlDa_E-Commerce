DROP DATABASE IF EXISTS SHDB;
CREATE DATABASE IF NOT EXISTS SHDB;
USE SHDB;

drop table IF EXISTs basketTbl;
drop table IF EXISTs commentTbl;
drop table IF EXISTs noticeTbl;
drop table IF EXISTs userTbl;

create table userTbl(
	userNumber int auto_increment,
	userId varchar(10) not null,
	userPwd varchar(10) not null,
	userName varchar(4) not null,
	userBirthDate datetime,
	userPhoneNumber char(11) not null,
	userAddr varchar(30) not null,
	userEmail varchar(30) not null,
	userGender char(1),
	userRegistrationDate datetime not null default now(),
	userCondition char(2) default '일반',
	userWithdrawalDate datetime default null,
	
	constraint userTbl_userNumber_pk primary key(userNumber),
	constraint userTbl_userId_uk unique(userId),
	constraint userTbl_userGender_ck check(userGender in ('남', '녀')),
	constraint userTbl_userCondition_ck check(userCondition in ('일반', '탈퇴'))
);

create table noticeTbl(
	noticeNumber int auto_increment,
	noticeTitle varchar(50) not null,
	noticeInfo text not null,
	noticeState varchar(4) not null default '거래전',
	noticeClassification varchar(4) not null,
	noticeRegistrationDate datetime not null default now(),
	userNumber int not null,
	noticeImgfileRealName varchar(100),
	noticeSource varchar(255),
	noticeProductPrice int not null,
	noticeCondition boolean not null default 1,
	
	
	constraint noticeTbl_noticeNumber_pk primary key(noticeNumber),
	constraint noticeTbl_noticeState_ck check(noticeState in ('거래전', '거래중', '거래완료')),
	constraint noticeTbl_noticeClassification_ck check(noticeClassification 
								in ('의류', '뷰티', '스포츠', '육아', '가구', '도서', '전자제품', '기타')),
	constraint noticeTbl_userNumber_userTbl_fk foreign key(userNumber) references userTbl(userNumber) on delete cascade
);

create table commentTbl(
	commentNumber int auto_increment,
	commentInfo text not null,
	commentRegistrationDate datetime not null default now(),
	noticeNumber int not null,
	userId varchar(10) not null,
	commentCondition boolean not null default 1,
	
	constraint commentTbl_commentNumber_pk primary key(commentNumber),
	constraint commentTbl_noticeNumber_noticeTbl_fk foreign key(noticeNumber) references noticeTbl(noticeNumber) on delete cascade,
	constraint commentTbl_userId_userTbl_fk foreign key(userId) references userTbl(userId) on update cascade 
																						on delete cascade
);

create table basketTbl(
	basketNumber int auto_increment,
	noticeNumber int not null,
	userNumber int not null,

	constraint basketTbl_basketNumber_pk primary key(basketNumber),
	constraint basketTbl_noticeNumber_noticeTbl_fk foreign key(noticeNumber) references noticeTbl(noticeNumber) on delete cascade,
	constraint basketTbl_userNumber_userTbl_fk foreign key(userNumber) references userTbl(userNumber) on delete cascade
);

-- 이벤트 스케줄러 사용
-- 회원탈퇴일 기준으로 하여 5년이 지난 개인정보 삭제

SET GLOBAL event_scheduler = ON;
show variables like 'event%';
drop event evt_userInfo;

create event IF NOT EXISTS evt_userInfo
	on schedule every 1 month starts current_timestamp 
	enable 	
	do
	delete from shdb.usertbl u where u.userWithdrawalDate < date_sub(now(), interval 5 year) ;
end

show events;


