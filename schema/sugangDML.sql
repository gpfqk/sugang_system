-- major table 생성
insert into major values('soft', '소프트웨어학과');
insert into major values('com', '컴퓨터공학과');
insert into major values('busi', '경영학과');

-- student table 생성
insert into student values('201314135', '백경진', 'soft', 'gpfqk', 'asdf');
insert into student values('201314134', '박지빈', 'soft', 'cesti0777', 'asdf');
insert into student values('201212111', '김형준', 'com', 'king7854', 'dsaf');

-- professor table 생성
insert into professor values('softnam', '남원홍', 'soft', '부교수');
insert into professor values('softji', '지정희', 'soft', '부교수');
insert into professor values('comlim', '임창훈', 'com', '정교수');

-- lecture table 생성
insert into lecture values('1111','소프트웨어공학','soft', 'softnam', '월', '13:00', '15:00', 30, 0);
insert into lecture values('2222','데이터마이닝','soft', 'softji', '수', '14:00', '16:00', 35, 0);
insert into lecture values('1133','신호처리','com', 'comlim', '목', '9:00', '11:00', 50, 0);						

-- registration table 생성
insert into registration values(registration_seq_rnum.nextval, '201314135', '2222');
insert into registration values(registration_seq_rnum.nextval, '201314134', '1111');				
insert into registration values(registration_seq_rnum.nextval, '201212111', '1133');	

commit;

