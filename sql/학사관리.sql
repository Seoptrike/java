create table oldenrollments(
    lcode char(4) not null, 
    scode char(8) not null, 
    edate date, 
    grade int default 0, 
    primary key(lcode, scode), 
    foreign key(lcode) references courses(lcode), 
    foreign key(scode) references students(scode)
);

drop table oldeenrollments;

create table courses(
     lcode char(4) not null, 
     lname varchar(50) not null, 
     hours int, 
     room char(3), 
     instructor char(3), 
     capacity int default 0, 
     persons int default 0, 
     primary key(lcode),
     foreign key(instructor) references professors(pcode)
);
desc courses;
create table oldstudents(
     scode char(8) not null, 
     sname varchar(15) not null, 
     dept varchar(30), 
     year int default 1, 
     birthday date, 
     advisor char(3), 
     primary key(scode), 
     foreign key(advisor) references professors(pcode)
);

create table professors(
     pcode char(3) not null, 
     pname varchar(15) not null, 
     dept varchar(30), 
     hiredate date, 
     title varchar(15), 
     salary int default 0, 
     primary key(pcode)
);

insert into professors(pcode,pname,dept,hiredate,title,salary) values('221','�̺���','����','75/04/03','������',3000000);
insert into professors(pcode,pname,dept,hiredate,title,salary) values('228','���籤','����','91/09/19','�α���',2500000);
insert into professors(pcode,pname,dept,hiredate,title,salary) values('311','������','����','94/06/09','�α���',2300000);
insert into professors(pcode,pname,dept,hiredate,title,salary) values('509','����ȯ','����','92/10/14','������',2000000);

insert into students(scode,sname,dept,year,birthday,advisor) values('92414029','������','����',3,'73/10/06','228');
insert into students(scode,sname,dept,year,birthday,advisor) values('92414033','��â��','����',4,'73/10/26','221');
insert into students(scode,sname,dept,year,birthday,advisor) values('92514009','������','����',4,'73/11/16','311');
insert into students(scode,sname,dept,year,birthday,advisor) values('92514023','������','����',4,'73/08/29','311');
insert into students(scode,sname,dept,year,birthday,advisor) values('92454018','�̿���','����',3,'74/09/30','509');
insert into students(scode,sname,dept,year,birthday,advisor) values('95454003','���翵','����',4,'76/02/06','509');
insert into students(scode,sname,dept,year,birthday,advisor) values('95414058','������','����',4,'76/03/12','221');
insert into students(scode,sname,dept,year,birthday,advisor) values('96414404','�����','����',3,'77/12/22','228');

insert into courses(lcode,lname,hours,room,instructor,capacity,persons) values('C301','����ó����', 3 ,'506','221',100,80);
insert into courses(lcode,lname,hours,room,instructor,capacity,persons) values('C401','�����ͺ��̽�',3,'414','221',80,80);
insert into courses(lcode,lname,hours,room,instructor,capacity,persons) values('C421','�˰���',3,'510','228',80,72);
insert into courses(lcode,lname,hours,room,instructor,capacity,persons) values('C312','�ڷᱸ��',2,'510','228',100,60);
insert into courses(lcode,lname,hours,room,instructor,capacity,persons) values('E221','��ȸ��',3,'304','311',100,80);
insert into courses(lcode,lname,hours,room,instructor,capacity,persons) values('A109','�ѱ��ǰ��๮ȭ',2,'101','509',120,36);

insert into enrollments(lcode, scode, edate, grade) values('C401','92414033','98/03/02',85);
insert into enrollments(lcode, scode, edate, grade) values('C301','92414033','98/03/02',80);
insert into enrollments(lcode, scode, edate, grade) values('C421','92414033','98/03/02', 0);
insert into enrollments(lcode, scode, edate, grade) values('C401','95414058','98/03/03',90);
insert into enrollments(lcode, scode, edate, grade) values('C301','95414058','98/03/03',80);
insert into enrollments(lcode, scode, edate, grade) values('C312','95414058','98/03/03',80);
insert into enrollments(lcode, scode, edate, grade) values('C401','92514023','98/03/03',70);
insert into enrollments(lcode, scode, edate, grade) values('C301','92514023','98/03/03',70);
insert into enrollments(lcode, scode, edate, grade) values('C421','92514023','98/03/03',70);
insert into enrollments(lcode, scode, edate, grade) values('C301','92414029','98/03/03',90);
insert into enrollments(lcode, scode, edate, grade) values('C421','92414029','98/03/03',0);
insert into enrollments(lcode, scode, edate, grade) values('C312','92414029','98/03/03',70);
insert into enrollments(lcode, scode, edate, grade) values('E221','92414029','98/03/03',75);
insert into enrollments(lcode, scode, edate, grade) values('A109','92414029','98/03/03',90);
insert into enrollments(lcode, scode, edate, grade) values('C301','92514009','98/03/03',70);
insert into enrollments(lcode, scode, edate, grade) values('C401','92514009','98/03/03',85);
insert into enrollments(lcode, scode, edate, grade) values('E221','92514009','98/03/03',85);
insert into enrollments(lcode, scode, edate, grade) values('C301','96414404','98/03/04',75);
insert into enrollments(lcode, scode, edate, grade) values('C401','96414404','98/03/04',75);
insert into enrollments(lcode, scode, edate, grade) values('C421','96414404','98/03/04',75);
insert into enrollments(lcode, scode, edate, grade) values('C312','92454018','98/03/04',90);
insert into enrollments(lcode, scode, edate, grade) values('E221','92454018','98/03/04',90);
insert into enrollments(lcode, scode, edate, grade) values('A109','95454003','98/03/05',85);
insert into enrollments(lcode, scode, edate, grade) values('C301','95454003','98/03/05',83);
insert into enrollments(lcode, scode, edate, grade) values('E221','95454003','98/03/05',75);

select count(*) from enrollments;

select *
from professors;
select pname,dept,title
from professors;

select distinct(dept) 
from professors;

select sname,scode,birthday
from students
where dept='����' and year='3';

select pname,dept, hiredate
from professors
where hiredate <='1993/03/01';

select *
from students
where advisor != '221' ;


select lcode, scode,grade
from enrollments
where grade >= 80
order by grade;

select lcode, lname, instructor, hours
from courses
where lname like '%����%';
/*'1973'��� �л����� �����ϴ� �������� �̸�, �Ҽ��а�, ������ �˻��Ͻÿ�.*/
select pname, dept, title
from professors, courses, students
where birthday like '%1973%';

/* ��ü �л��� 30% �̻��� ������û�� ������ ��ȣ�� �˻��Ͻÿ�. */
select * from enrollments;
select lname
from courses
where persons/count(scode) >=0.3; 

select lcode from enrollments group by lcode 
having count(*) >= (select count(*) * 0.3 from students);

/*'�����ͺ��̽�'�� �����ϴ� ������, �� ������ ������û �� �л����� �а�, �̸�, ������ �˻��Ͻÿ�.*/

/*�л����� �а�, �л��̸�, ���������̸��� �˻��Ͻÿ�.*/
select s.dept , sname , p.pname, p.dept
from professors p, students s
where p.pcode = s.advisors;
select* from students where advisor in ( select pcode from professors);
/*���¹�ȣ, ���¸�, �����̸��� �˻��Ͻÿ�.*/
select c.lcode , c.lname , p.pname
from professors p, courses c
where p.pcode = c.instructor;
/*�й�, �л��̸�, �л����� ������û �� ���¹�ȣ, ������û���� �˻��Ͻÿ�*/
select s.scode, s.sname, e.lcode, e.edate
from students s, enrollments e
where s.scode = e.scode;
/*�й�, �л����� ������û �� ���¹�ȣ, ���¸�, ������ �˻��Ͻÿ�.*/
select e.scode, c.lcode, c.lname, e.grade
from courses c, enrollments e
where c.lcode = e.lcode
order by grade desc;
/*'�̺���'�� ������ �����ϴ� �л����� �̸�, �г�, ��������� �˻��Ͻÿ�*/
select sname, year, birthday
from students s,professors p
where s.advisor = p.pcode and pname= '�̺���';
/*'98/03/03'�� ������û �� �л����� �й�, �л��̸�, ���¹�ȣ�� �˻��Ͻÿ�.*/
select s.scode, s.sname, e.lcode
from students s ,enrollments e
where s.scode = e.scode and e.edate = '98/03/03';
/*'����'�� �������� �����ϴ� �л����� �̸�, �г�, ��������� �˻��Ͻÿ�.*/
select s.sname, s.year, s.birthday
from professors p , students s
where p.pcode=s.advisor and p.dept = '����';
/*�ڷᱸ��'�� �����ϴ� ������ �а���, ���� ���� �˻��Ͻÿ�.*/
select p.dept , p.pname
from professors p , courses c
where p.pcode = c.instructor and c.lname = '�ڷᱸ��';
/*'����ó����'�� ������û �� �л����� �й�, ������û��, ������ �˻��Ͻÿ�.*/
select s.scode, e.edate , e.grade
from students s ,enrollments e,courses c
where s.scode=e.scode and c.lcode=e.lcode and c.lname='����ó����';
/*'�ڷᱸ��' ������ ������û �� �л����� �а�, �л��̸�, ������ �˻��Ͻÿ�.*/
select s.dept,s.sname, e.grade
from students s, enrollments e, courses c
where s.scode = e.scode and e.lcode = c.lcode and c.lname = '�ڷᱸ��';
/*'����'�� �л����� �й�, �л��̸�, ������û �� ���¹�ȣ, ���� ��, ������ �˻��Ͻÿ�.*/
select s.scode,s.dept,s.sname,e.lcode,c.lname,e.grade
from students s, courses c, enrollments e
where s.scode=e.scode and c.lcode=e.lcode and s.dept='����';
/*'����ó����'�� �����ϴ� ������ �̸�, �� ������ �����ϴ� �л����� �й�, �л����� �˻��Ͻÿ�.*/
select p.pname, s.scode, s.sname
from professors p, students s , courses c
where p.pname = s.advisor and c.instructor=p.pcode and lname='����ó����';
/*'�����ͺ��̽�'�� �����ϴ� ������, �� ������ ������û �� �л����� �а�, �̸�, ������ �˻��Ͻÿ�.*/
select p.pname, s.dept, s.sname, e.grade
from professors p, students s, enrollments e, courses c
where p.pcode = c.instructor and s.scode=e.scode and c.lcode=e.lcode and lname= '�����ͺ��̽�' ;
/*������ 80�� �̻��� �л����� �й�, �л��̸�, ���¹�ȣ, ���¸�, ��米�� ���� �˻��Ͻÿ�.*/
select s.scode, s.sname, c.lcode, c.lname, p.pname, e.grade
from professors p , students s, courses c, enrollments e
where p.pcode=c.instructor and e.scode = s.scode and c.lcode=e.lcode and e.grade>=80
order by grade desc;

/*�˰���'�� �����ϴ� ������ ������ȣ, �����̸�, �Ҽ��а��� �˻��Ͻÿ�. */
select p.pcode,p.pname,p.dept
from professors p, courses c
where p.pcode=c.instructor and lname='�˰���';

/*��ü �л��� 30% �̻��� ������û�� ������ ��ȣ�� �˻��Ͻÿ�.*/

/*'1973'��� �л����� �����ϴ� �������� �̸�, �Ҽ��а�, ������ �˻��Ͻÿ�.*/

select *
from students;

select *
from enrollments;

select *
from courses;

/*3.�������� �� �޿��װ� ��� �޿����� ���Ͻÿ�.*/
select sum(salary), avg(salary)
from professors;

/*����� �������� �� �޿��װ� ��� �޿����� ���Ͻÿ�.*/
select sum(salary), avg(salary)
from professors
where dept='����';

/*������û �� ����� �߿��� �ְ� ������ ���� ������ ���Ͻÿ�.*/
select max(grade),min(grade)
from enrollments;

/*����� �л����� ��� �� ������ ���Ͻÿ�.*/
select count(*)
from students
where dept = '����';
/*������û �� �л����� ��� �� ������ ���Ͻÿ�.*/
select count( distinct(scode))
from enrollments;

/*�� �а��� �л����� ���� ���Ͻÿ�.*/
select dept , count(scode)
from students 
group by dept;

/*�������� �Ҽ��а���, ���޺��� �з��Ͽ� �� ���޺� ��� �޿��׼��� ���Ͻÿ�.*/
select dept, title , avg(salary)
from professors
group by dept,title;

select *
from professors;

/*�� �л��鿡 ���� �й�, �л��̸�, ������û ������� ��� ������ ���Ͻÿ�.*/
select e.scode, s.sname, s.dept, p.pname, avg(grade) as avg ,count(lcode)
from students s, enrollments e, professors p
where s.scode=e.scode and p.pcode=s.advisor
group by e.scode, s.sname, s.dept , p.pname ;

/*�� �л��鿡 ���� ������û ������� ��� ������ ���Ͻÿ�.*/
select lname, avg(grade)
from students s,enrollments e, courses c
where s.scode = e.scode and e.lcode = c.lcode
group by lname;

/*������û �� ������� �л����� �׷����Ͽ� ��� ������ ���� ����, �л���ȣ, ��� ������ ������ ���� ������ �����Ͽ� ����Ͻÿ�.*/
select lname, avg(grade) ,s.sname, s.scode
from courses c, enrollments e, students s
where s.scode=e.scode and e.lcode=c.lcode
group by lname, s.scode, s.sname
order by sname, avg(grade) desc;

create view stu_enr_pro as
select e.*,s.sname,s.dept,pname,p.dept pro_dept
from enrollments e, students s, professors p
where e.scode=s.scode and advisor=pcode;
/*������û ������� ��� ������ 85�� �̻��� �л����� �л���ȣ, ��� ������ ���Ͻÿ�.*/
select sname, s.scode, avg(grade) as avg
from students s, enrollments e
where s.scode=e.scode
group by sname,s.scode
having avg(grade) >= 85
order by avg desc;

/*���º� ��������� 80�� �̻��� ���µ��� ���¹�ȣ�� ��������� ����Ͻÿ�.*/
select lname, e.lcode, avg(grade)
from enrollments e , courses c
where e.lcode = c.lcode
group by lname, e.lcode
having avg(grade)>=80;

/*�л����� 3�� �̻��� �а� ���� ����, �а���, �л����� ����Ͻÿ�.*/
select lname, count(s.scode) as count
from courses c, students s, enrollments e
where c.lcode = e.lcode and e.scode= s.scode
group by lname
having count(s.scode) >=3;

/*������û ��������� 85�� �̻��� �л����� �л���ȣ, �л��̸�, ��� ������ ��������� ���� ������ ����Ͻÿ�.*/
select s.scode,sname,avg(grade)
from students s , enrollments e 
where s.scode=e.scode
group by s.scode,sname
having avg(grade)>= 80
order by avg(grade) desc;

/*���º� ��������� 80�� �̻��� ���µ��� ���¹�ȣ, ���¸�, ��������� ��������� ���� ������ ����Ͻÿ�.*/

select e.lcode, lname, avg(grade)
from enrollments e, courses c
where e.lcode=c.lcode
group by e.lcode,lname
having avg(grade)>=80
order by avg(grade) desc;

select *
from stu_enr_pro;

/*4.��ȸ*/
/*'�˰���'�� �����ϴ� ������ ������ȣ, �����̸�, �Ҽ��а��� �˻��Ͻÿ�.*/
select pcode, pname, dept
from professors
where pcode in (select instructor from courses where lname='�˰���');

/*���ǽ� '510'ȣ���� �����ϴ� ������ ������ȣ, �����̸�, �Ҽ��а��� �˻��Ͻÿ�.*/
select pcode, pname, dept
from professors
where pcode in (select instructor from courses where room='510');

/*'��â��' �л��� �Ҽӵ� �а��� �����ϴ� �������� �̸�, ����, �ӿ����ڸ� �˻��Ͻÿ�.*/
select *
from professors
where dept in
(select dept from students where sname='��â��');

/*������û ������ ������ 90�� �̻��� �л����� �̸�, �л���ȣ, �Ҽ��а�, �г��� �˻��Ͻÿ�.*/
select sname,scode,dept,year
from students
where scode in
(select scode
from enrollments
group by scode
having avg(grade)>=80);

/*'����'�� �������� ����ϴ� ������ �̸�, ���ǽð���, ���ǽ��� �˻��Ͻÿ�.*/
/*'98/03/02'�� ������û �� �л����� �а�, �й�, �л��̸�, �г��� �˻��Ͻÿ�.*/
/*'509'ȣ���� ���Ǹ� ��� �л����� �а�, �й�, �л��̸��� �˻��Ͻÿ�.*/
/*������û ������ ��������� 80�� �̻��� �л����� �̸�, �л���ȣ, �Ҽ��а�, �г��� �˻��Ͻÿ�.*/
/*'����'�� �л����� �����ϴ� ������ �̸�, ������ȣ, �Ҽ��а�, ������ �˻��Ͻÿ�.*/
/*�л����� '3'�� �̻��� �а��� �ٹ��ϴ� �������� �̸�, �Ҽ��а�, ������ �˻��Ͻÿ�.*/
/*'�̿���'�� ������û�� ������ ��ȣ, �����, ������ �˻��Ͻÿ�.*/
/*'�˰���'�� ������û�� �л����� �й�, �л��̸�, �а��� �˻��Ͻÿ�.*/
/*'1973'��� �л����� �����ϴ� �������� �̸�, �Ҽ��а�, ������ �˻��Ͻÿ�.*/
/*��ü �л��� 30% �̻��� ������û�� ������ ��ȣ�� �˻��Ͻÿ�.*/



/*'98414022', '������', '75-05-10', '����' ���� �л����̺� �����Ͻÿ�.*/
insert into students( scode,sname,birthday,dept)
values('98414022','������','75-05-10','����');
/*�������� ������û ������ ������û(Enrollments)���̺� �����Ͻÿ�.*/
/*'1998�� 1�� 1��' ������ �߻��� ��� ������û �����͸� oldEnrollments���̺�� �����Ͻÿ�.*/

insert into oldenrollments(scode,lcode,edate,grade)
select scode,lcode,edate,grade from enrollments where edate <='98/03/03';


select *
from enrollments
where edate < '1998-03-03';


/*4�г� �л����� ��� �л� �����͸� oldstudents ���̺�� �����Ͻÿ�.*/

insert into oldstudents
select * from students where year=4;

/*�л����̺��� '������'�� �����͸� �����Ͻÿ�.*/
/*'1998�� 1�� 1��' ������ ��û�� ��� ������û �����͸� �����Ͻÿ�.*/

/*������û �� ���� ���� ������ ���� ���� ���� ������û �����͸� �����Ͻÿ�.*/
/*������û �� ���� ���� ������ ���� ���� ���� ������û �����͸� �����Ͻÿ�.*/
/*�л����̺��� ����� 3�г� �����͸� 4�г����� �����Ͻÿ�.*/
/*'����ȯ' ������ ������ '������'���� '�α���'�� �����Ͻÿ�.*/
/*'�����' �л��� ��û�� ��� ������û �����͸� �����Ͻÿ�.*/
/*'����'�� �������� �޿��� 10% ���� ��Ű�ÿ�.*/
/*��� �������� �޿��� 10% ���� ��Ű�ÿ�.*/
/*'����'�� �л����� ��û�� ������û �����͸� ��� �����Ͻÿ�.*/
/*'����'�� ������ ����ϴ� ������ ���ǽ��� ��� '123'ȣ�Ƿ� �����Ͻÿ�.*/

/*2.����*/
/*'���籤' ������ �����ϴ� �л����� ���������� ������ȣ '221'�� �����Ͻÿ�.*/
update students 
set advisor='221'
where advisor in(
select s.advisor
from students s, professors p
where s.advisor = p.pcode and pname='���籤');


/*'����ó����' ������ ������û �� �л����� ������ 5���� ���� ��Ű�ÿ�. */

update enrollments 
set grade= grade+5 
where lcode in
(select e.lcode
from enrollments e, courses c
where e.lcode=c.lcode and lname='����ó����');

/*'����'�� �л����� ������û �� ������û �������� ������ 0�� ó�� �Ͻÿ�.*/

/*'������' �л��� ���������� �����ϴ� ������ ���ǽ��� '304'ȣ�� �����Ͻÿ�.*/
update courses
set room = 304
where instructor in
(select advisor
from students s, courses c, professors p
where s.advisor=p.pcode and c.instructor=p.pcode and sname='������');

/*'��ȸ��'�� �����ϴ� ������ �޿��� 100000�� �λ��Ͻÿ�.*/
/*������û�ο����� 80�� �̻��� ���¸� �����ϴ� �������� �޿��� 100000�� �λ��Ͻÿ�.*/
/*������' �л��� ��� ���� ������ 5���� ���� ��Ű�ÿ�.*/
/*'����'�� 3�г� �л����� ������û �� ������� ������ 5���� ���� ��Ű�ÿ�.*/
/*'����'�� '�α���'�� �����ϴ� ���ǽð����� 1�� ���� ��Ű�ÿ�.*/
/*������û �� ������3���� �̻��� �л����� �г��� 1�� ���� ��Ű�ÿ�.*/
/*������û ��������� 80�� �̸��� �л����� �г��� 1�� ���ҽ�Ű�ÿ�.*/
/*'����ó����'�� ������û �� �л����� �а��� '����'���� �����Ͻÿ�.*/
/*���º� ��������� 80�� �̻��� ������� ���ǽ��� '509'ȣ�� �����Ͻÿ�.*/
/*'����ȯ' ������ �����ϴ� ���¸� ��û�� ������û �����͸� �����Ͻÿ�.*/
/*'�ڷᱸ��'�� ������û �� �л��� �г��� 1�� ���� ��Ű�ÿ�.*/
