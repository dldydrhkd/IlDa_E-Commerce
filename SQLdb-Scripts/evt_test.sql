USE SHDB;
drop table IF EXISTs secondTestTbl;
drop table IF EXISTs firstTestTbl; 

-- 이벤트 스케줄러를 이용하여 일정 시간이 지난 후 
-- 조건에 해당하는 부모테이블의 row삭제와 foreignkey로 이어진 자식테이블의 row가 정상적으로 삭제되는지 확인하는 테스트
create table firstTestTbl(
	firstKey int auto_increment,
	firstCondition char(2) default '부모',
	firstTime datetime default now(),
	
	constraint firstTestTbl_firstKey_pk primary key(firstKey)
);

create table secondTestTbl(
	secondKey int auto_increment,
	secondCondition char(2) default '자식',
	firstKey int not null,
	
	constraint secondTestTbl_secondKey_pk primary key(secondKey),
	constraint secondTestTbl_firstkey_firstTestTbl_fk foreign key(firstkey) references firstTestTbl(firstkey) on delete cascade
);
	
insert into firstTestTbl values(default, default, default);

insert into SecondTestTbl values(default, default, 1);
insert into SecondTestTbl values(default, default, 2);
insert into SecondTestTbl values(default, default, 3);
insert into SecondTestTbl values(default, default, 4);

select * from firstTestTbl ;
select * from SecondTestTbl ;

-- --------------------------------------------------------------
SET GLOBAL event_scheduler = ON;
show variables like 'event%';
show events;
drop event evt_test;

create event IF NOT EXISTS evt_test
	on schedule every 30 second starts current_timestamp 
	enable 	
	do
	delete from shdb.firstTestTbl where firstTime < date_sub(now(), interval 30 second) ;
end

show events;



