-- major table ����
insert into major values('soft', '����Ʈ�����а�');
insert into major values('com', '��ǻ�Ͱ��а�');
insert into major values('busi', '�濵�а�');

-- student table ����
insert into student values('201314135', '�����', 'soft', 'gpfqk', 'asdf');
insert into student values('201314134', '������', 'soft', 'cesti0777', 'asdf');
insert into student values('201212111', '������', 'com', 'king7854', 'dsaf');

-- professor table ����
insert into professor values('softnam', '����ȫ', 'soft', '�α���');
insert into professor values('softji', '������', 'soft', '�α���');
insert into professor values('comlim', '��â��', 'com', '������');

-- lecture table ����
insert into lecture values('1111','����Ʈ�������','soft', 'softnam', '��', '13:00', '15:00', 30, 0);
insert into lecture values('2222','�����͸��̴�','soft', 'softji', '��', '14:00', '16:00', 35, 0);
insert into lecture values('1133','��ȣó��','com', 'comlim', '��', '9:00', '11:00', 50, 0);						

-- registration table ����
insert into registration values(registration_seq_rnum.nextval, '201314135', '2222');
insert into registration values(registration_seq_rnum.nextval, '201314134', '1111');				
insert into registration values(registration_seq_rnum.nextval, '201212111', '1133');	

commit;

