SELECT * FROM project_01.memberinfo;
desc project_01.memberinfo;

-- email 받을 수 있게 변환
ALTER TABLE `project_01`.`memberinfo` 
CHANGE COLUMN `ID` `ID` VARCHAR(45) NOT NULL ;

-- 인증코드와 verify 확인 코드 
ALTER TABLE `project_01`.`memberinfo` 
ADD COLUMN `code` VARCHAR(10) NULL AFTER `REGDATE`,
ADD COLUMN `verify` CHAR(1) NULL DEFAULT 'N' AFTER `code`;
delete from project_01.memberinfo where id like '%atple%';

ALTER TABLE `project_01`.`memberinfo` 
CHANGE COLUMN `code` `code` VARCHAR(25) NULL DEFAULT NULL ;