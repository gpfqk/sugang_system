select * from major;
select * from student;
select * from professor;
select * from lecture;
select * from registration;

select * from lecture where lcode = '1111'

select * from lecturelist;

select * from lecturelist where mname='����Ʈ�����а�'

select * from lecturelist where mname='?'

desc lecturelist;

select * from lecturelist where lcode = '1111'

/*
deleteRegistration�� lecCode �� ���޵� (����� �����ڵ�)
1. lecCode�� �� ������û ������ �����ϴ��� Ȯ��
	�� stuCode�̸鼭 lecCode�� ������ �ִ��� Ȯ��
2. lecCode�� ������ current-1
*/

delete from registration where lcode = '1111' and sCode = '201314134'


insert into registration values(registration_seq_rnum.nextval, '201314135', '2222');
update lecture set lcurrent = lcurrent + 1 where lcode = '2222'

insert into registration values(registration_seq_rnum.nextval, '201314134', '1111');
update lecture set lcurrent = lcurrent + 1 where lcode = '1111'

insert into registration values(registration_seq_rnum.nextval, '201212111', '1133');
update lecture set lcurrent = lcurrent + 1 where lcode = '1133'

select * from registration;
select * from lecture;

[�����ڵ�:1111 | ���Ǹ�:����Ʈ������� | �а�:����Ʈ�����а� | ��米�� : ����ȫ | �� 13:00~15:00 | 1/30]

select * from registrationlist;


select * 
from lecturelist 
where lcode = '2222' and '2222' not in(select r.lcode 
														      from registration r, registrationlist rl 
														      where r.SCODE = '201314135' and r.LCODE = rl.LCODE)

														      
select * from lecture;			      
