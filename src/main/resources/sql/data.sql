-- --------------------------------------- web2 ----------------------------------------
-- 샘플 회원 데이터 (비밀번호는 BCrypt 암호화 적용)
INSERT INTO users (uid, upwd, uname, uphone, urole)
VALUES
-- test1 / 1234
('test1', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '유재석', '010-1111-2222', 'USER'),
-- admin / 1234
('admin', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '관리자', '010-9999-9999', 'ADMIN'),
-- guest / 1234
('guest', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '손님', '010-0000-0000', 'USER');