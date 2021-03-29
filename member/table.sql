create table tblMember(
 idx number primary key,
 name varchar2(10) not null,
 phone varchar2(13) not null,
 team varchar2(10) not null
);

create sequence seqmember;

insert into tblMember(idx,name,phone,team)
values (seqmember.nextval, '홍길동', '010-5555-6666','산적');