-- --------------------------------------- web2 ----------------------------------------
-- [2] 회원 테이블 생성
DROP TABLE IF EXISTS users;
CREATE TABLE users (
    uno INT AUTO_INCREMENT PRIMARY KEY,     -- 회원번호 (PK)
    uid VARCHAR(50) NOT NULL UNIQUE,        -- 아이디
    upwd VARCHAR(255) NOT NULL,             -- 비밀번호
    uname VARCHAR(50) NOT NULL,             -- 닉네임 (이름)
    uphone VARCHAR(20),                     -- 연락처
    urole VARCHAR(20) DEFAULT 'USER',       -- 권한 (기본 USER)
    udate DATETIME DEFAULT NOW()            -- 가입일
);

