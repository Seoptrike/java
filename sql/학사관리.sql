create table enrollments(
    lcode char(4) not null, 
    scode char(8) not null, 
    edate date, 
    grade int default 0, 
    primary key(lcode, scode), 
    foreign key(lcode) references courses(lcode), 
    foreign key(scode) references students(scode)
);

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
create table students(
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
select lcode
from couses c, enrollments e ,students s
where c.lcode = e.lcode and count(s.scode) and count(*) >= (select count(*) * 0.3 from students);

/*'1973'��� �л����� �����ϴ� �������� �̸�, �Ҽ��а�, ������ �˻��Ͻÿ�.*/

select *
from students;

select *
from enrollments;

select *
from courses;