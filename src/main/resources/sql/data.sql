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

-- ============================================
--INSERT INTO ecategory (cno, cname) VALUES
--(1, '공지사항'),
--(2, '자유게시판'),
--(3, 'Q&A게시판');
-- ---------------------------------------- JPA DAY04 샘플 ----------------------------------------
INSERT INTO todo (title, content, done, create_date, update_date)
VALUES
('아침 운동하기', '헬스장에서 러닝머신 30분 뛰기', false, NOW(), NOW()),
('점심 식사 준비', '닭가슴살 샐러드 만들기', false, NOW(), NOW()),
('스터디 참여', 'Spring Boot JPA 실습 복습', true, NOW(), NOW()),
('프로젝트 정리', 'Todo 기능 페이징+검색 정리하기', false, NOW(), NOW()),
('책 읽기', '이펙티브 자바 3장 읽기', false, NOW(), NOW()),
('영화 보기', '주말에 인사이드 아웃 2 보기', false, NOW(), NOW()),
('친구 만나기', '카페에서 근황 나누기', true, NOW(), NOW()),
('쇼핑하기', '마우스패드 새로 구입', false, NOW(), NOW()),
('운동 기록하기', '운동 일지를 Notion에 정리', false, NOW(), NOW()),
('저녁 산책', '한강공원 1시간 걷기', false, NOW(), NOW()),
('개발 공부', 'React Router와 Axios 정리', true, NOW(), NOW()),
('주간 계획 세우기', '다음 주 목표 3개 작성', false, NOW(), NOW()),
('블로그 작성', 'RootLab 프로젝트 후기 작성', false, NOW(), NOW()),
('청소하기', '책상 정리 및 쓰레기 버리기', true, NOW(), NOW()),
('세탁물 정리', '빨래 개서 옷장에 넣기', false, NOW(), NOW()),
('Flutter 공부', 'Dio 통신과 위젯 구조 복습', true, NOW(), NOW()),
('회의 준비', '팀 회의 발표자료 수정', false, NOW(), NOW()),
('메일 확인', '훈련기관 메일 확인 및 답장', false, NOW(), NOW()),
('포트폴리오 수정', '프로젝트 소개 추가 및 스크린샷 교체', true, NOW(), NOW()),
('휴식 시간', '산책 후 커피 한 잔 마시기', false, NOW(), NOW());