-- major data ����
insert into major values('soft', '����Ʈ�����а�');
insert into major values('com', '��ǻ�Ͱ��а�');
insert into major values('busi', '�濵�а�');

-- student data ����
insert into student values('201314135', '�����', 'soft', 'gpfqk', '1234');
insert into student values('201314134', '������', 'soft', 'cesti0777', '1234');
insert into student values('201212123', 'student3', 'soft', 'king7854', '1234');
insert into student values('201412124', 'student4', 'soft', 'stu4', '1234');
insert into student values('201512125', 'student5', 'soft', 'stu5', '1234');
insert into student values('201512129', 'student6', 'soft', 'stu6', '1234');


-- professor data ����
insert into professor values('softnam', '����ȫ', 'soft', '�α���');
insert into professor values('softji', '������', 'soft', '�α���');
insert into professor values('comlim', '��â��', 'soft', '������');
insert into professor values('comkim', '������', 'soft', '�α���');
insert into professor values('comkei', '������', 'com', '������');
insert into professor values('busiksy', '�ڼҿ�', 'com', '�α���');
insert into professor values('busilhw', '�����', 'com', '������');
insert into professor values('busijkj', '������', 'com', '�α���');
insert into professor values('busikji', '������', 'busi', '������');
insert into professor values('busilmk', '�ӹα�', 'busi', '�α���');
insert into professor values('busijjw', '������', 'busi', '������');



-- lecture data ����
insert into lecture values('1111','����Ʈ�������','soft', 'softnam', '��', '13:00', '14:50', 5, 0);
insert into lecture values('2222','�����͸��̴�','soft', 'softji', 'ȭ', '14:00', '15:50', 5, 0);
insert into lecture values('3333','��ȣó��','soft', 'comlim', '��', '09:00', '10:50', 5, 0);		
insert into lecture values('4444','��ǻ�ͱ׷��Ƚ�','soft', 'comkim', '��', '10:00', '10:50', 5, 0);	
insert into lecture values('5555','��ǻ�ͱ���','com', 'comkei', '��', '09:00', '10:50', 5, 4);	
insert into lecture values('6666','c���α׷���','com', 'busiksy', 'ȭ', '14:00', '15:50', 5, 3);	
insert into lecture values('7777','java���α׷���','com', 'busilhw', '��', '09:00', '10:50', 5,5);	
insert into lecture values('8888','�����α׷���','com', 'busijkj', '��', '15:00', '16:50', 5, 1);	
insert into lecture values('9999','�濵����','busi', 'busikji', '��', '09:00', '10:50', 5, 2);	
insert into lecture values('0000','�濵����','busi', 'busilmk', 'ȭ', '14:00', '15:50', 5,4);	
insert into lecture values('1122','�������','busi', 'busijjw', '��', '13:00', '14:50', 5, 5);	


-- registration data ����

insert into registration values(registration_seq_rnum.nextval, '201314134', '3333');
update lecture set lcurrent = lcurrent+1 where lcode = '3333';
insert into registration values(registration_seq_rnum.nextval, '201314135', '1111');
update lecture set lcurrent = lcurrent+1 where lcode = '1111';
insert into registration values(registration_seq_rnum.nextval, '201314135', '2222');
update lecture set lcurrent = lcurrent+1 where lcode = '2222';
insert into registration values(registration_seq_rnum.nextval, '201314135', '4444');
update lecture set lcurrent = lcurrent+1 where lcode = '4444';
insert into registration values(registration_seq_rnum.nextval, '201212123', '1111');
update lecture set lcurrent = lcurrent+1 where lcode = '1111';
insert into registration values(registration_seq_rnum.nextval, '201212123', '2222');	
update lecture set lcurrent = lcurrent+1 where lcode = '2222';
insert into registration values(registration_seq_rnum.nextval, '201212123', '4444');
update lecture set lcurrent = lcurrent+1 where lcode = '4444';
insert into registration values(registration_seq_rnum.nextval, '201412124', '1111');	
update lecture set lcurrent = lcurrent+1 where lcode = '1111';
insert into registration values(registration_seq_rnum.nextval, '201412124', '2222');	
update lecture set lcurrent = lcurrent+1 where lcode = '2222';
insert into registration values(registration_seq_rnum.nextval, '201412124', '3333');	
update lecture set lcurrent = lcurrent+1 where lcode = '3333';
insert into registration values(registration_seq_rnum.nextval, '201412124', '1111');
update lecture set lcurrent = lcurrent+1 where lcode = '1111';
insert into registration values(registration_seq_rnum.nextval, '201412124', '2222');
update lecture set lcurrent = lcurrent+1 where lcode = '2222';
insert into registration values(registration_seq_rnum.nextval, '201412124', '3333');
update lecture set lcurrent = lcurrent+1 where lcode = '3333';
insert into registration values(registration_seq_rnum.nextval, '201512129', '1111');
update lecture set lcurrent = lcurrent+1 where lcode = '1111';

commit;

