SELECT * FROM project_01.memberinfo;
desc project_01.memberinfo;


ALTER TABLE `project_01`.`memberinfo` 
ADD COLUMN `email` VARCHAR(45) NULL AFTER `verify`,
CHANGE COLUMN `ID` `ID` VARCHAR(12) NOT NULL ;

delete from project_01.memberinfo where id = '123';

-- 암호화해보기
select pw
	, password(pw) as password
    , md5(pw) as md5
    , sha2(pw, 256) as sha2 -- recently added
    , sha(pw) as sha
    , sha1(pw) as sha1 -- sha 와 sha1 은 같은 결과를 가져온다.
from project_01.memberinfo
limit 0, 1;


-- 암호화
update project_01.memberinfo set pw=HEX(AES_ENCRYPT('1111', 'password')) where idx = 1;
-- 복호화
select CONVERT(AES_DECRYPT(UNHEX(pw), 'password') using utf8) from project_01.memberinfo where idx=1;
select AES_DECRYPT(UNHEX(pw), 'password') from project_01.memberinfo where idx=1;
-- 암호화
update project_01.memberinfo set upw=HEX(AES_ENCRYPT('1111', SHA2('password', 256))) where idx = 1;
-- 복호화
select CONVERT(AES_DECRYPT(UNHEX(upw),  SHA2('password', 256)) using utf8) from project_01.memberinfo where idx=1;
select AES_DECRYPT(UNHEX(pw),  SHA2('password', 256)) from project_01.memberinfo where idx=1;