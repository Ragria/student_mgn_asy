select user(), database();

show tables;

insert into student values (1, '1번', 50, 60, 70);
insert into student values (2, '2번', 60, 70, 80);

select stdNo, stdName, kor, eng, math from student;

select stdNo, stdName, kor, eng, math from student where stdNo = 1;

update student set kor = 40 where stdNo = 1;

delete from student where stdNo = 2;
