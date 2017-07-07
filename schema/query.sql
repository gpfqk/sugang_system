-- ���� : alt+s
-- major table

drop table major cascade constraint;

create table major(
	mcode varchar2(30) not null,
	mname varchar2(30) not null,
	constraint major_mnum_pk primary key(mcode)
);

-- Test data ����
insert into major values('soft', '����Ʈ�����а�');
insert into major values('com', '��ǻ�Ͱ��а�');
insert into major values('busi', '�濵�а�');

commit;

select * from major;

-- student table

drop table student cascade constraint;

create table student(
	scode varchar2(30) not null,
	sname varchar2(30) not null,
	mcode varchar2(30) not null,
	sid varchar2(30) not null,
	spassword varchar2(30) not null,
	constraint student_scode_pk primary key(scode),
	constraint student_mcode_fk foreign key(mcode) references major(mcode)
);

-- Test data ����
insert into student values('201314135', '�����', 'soft', 'gpfqk', 'asdf');
insert into student values('201314134', '������', 'soft', 'cesti0777', 'asdf');
insert into student values('201212111', '������', 'com', 'king7854', 'dsaf');

commit;

select * from student;

-- professor table

drop table professor cascade constraint;

create table professor (
	pcode varchar2(30) not null,
	pname varchar2(30) not null,
	mcode varchar2(30) not null,
	constraint professor_pcode_pk primary key(pcode),
	constraint professor_mcode_fk foreign key(mcode) references major(mcode)
);

-- Test data ����
insert into professor values('softnam', '����ȫ', 'soft');
insert into professor values('softji', '������', 'soft');
insert into professor values('comlim', '��â��', 'com');

commit;

select * from professor;

-- lecture table

drop table lecture cascade constraint;

create table lecture (
	lcode varchar2(30) not null,
	lname varchar2(30) not null,
	mcode varchar2(30) not null,
	pcode varchar2(30) not null,
	lday varchar2(30) not null,
	lstart varchar2(30) not null,
	lend varchar2(30) not null,
	lcount number(10) not null,
	lcurrent number(10) not null,
	constraint lecture_lcode_pk primary key(lcode),
	constraint lecture_mcode_fk foreign key(mcode) references major(mcode),
	constraint lecture_pcode_fk foreign key(pcode) references professor(pcode)
);

-- Test data ����
insert into lecture values('1111','����Ʈ�������','soft', 
						'softnam', '��', '13:00', '15:00', 30, 0);
insert into lecture values('2222','�����͸��̴�','soft', 
						'softji', '��', '14:00', '16:00', 35, 0);
insert into lecture values('1133','��ȣó��','com', 
						'comlim', '��', '9:00', '11:00', 50, 0);						

commit;

select * from lecture;

-- registration table

drop table registration cascade constraint;

create table registration (
	rnum number(10) not null,
	scode varchar2(30) not null,
	lcode varchar2(30) not null,
	constraint registration_rnum_pk primary key(rnum),
	constraint registration_scode_fk foreign key(scode) references student(scode),
	constraint registration_lcode_fk foreign key(lcode) references lecture(lcode)
);
create sequence registration_seq_rnum;

-- Test data ����
insert into registration values(registration_seq_rnum.nextval, '201314135', '2222');
insert into registration values(registration_seq_rnum.nextval, '201314134', '1111');				
insert into registration values(registration_seq_rnum.nextval, '201212111', '1133');	

commit;

select * from registration;