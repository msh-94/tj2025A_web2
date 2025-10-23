use springweb2;
-- 1.기존 테이블 초기화
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS member;

-- 2.회원(member) 테이블 생성
CREATE TABLE member (
    mno INT AUTO_INCREMENT PRIMARY KEY,   -- 회원번호 (PK)
    name VARCHAR(50),                     -- 이름
    grade VARCHAR(20)                     -- 등급 (VIP, GOLD, SILVER)
);

-- 3. 주문(orders) 테이블 생성
CREATE TABLE orders (
    ono INT AUTO_INCREMENT PRIMARY KEY,   -- 주문번호 (PK)
    mno INT,                              -- 회원번호 (FK)
    product VARCHAR(50),                  -- 상품명
    price INT,                            -- 가격
    order_date DATE,                      -- 주문일자
    FOREIGN KEY (mno) REFERENCES member(mno)
);

-- 4. 샘플 데이터 삽입
INSERT INTO member (name, grade)
VALUES ('유재석', 'VIP'), ('강호동', 'GOLD'), ('신동엽', 'SILVER');

INSERT INTO orders (mno, product, price, order_date)
VALUES
(1, '노트북', 1500000, '2025-10-10'),
(1, '마우스', 30000, '2025-10-11'),
(2, '키보드', 50000, '2025-10-11'),
(3, '모니터', 200000, '2025-10-12');
# ===================================================================
select * from member; -- 원본 테이블 조회
select * from orders; -- 원본 테이블 조회

# 뷰(VIEW) : 가상 테이블 , 하나 이상의 원본 테이블들을 기반으로 만들어진 가상 테이블
# 권한/보안 , 복잡한 쿼리문(집계) 결과 저장 (재사용) 등등

# [1] 뷰
# 1. 뷰 만들기
# create or replace view 뷰이름 as 쿼리문
create or replace view order_test as select * from orders;
# 2. 뷰 목록 확인
show full tables where table_type = 'view';
# 3. 뷰 수정
# alter view 뷰이름 as 새로운쿼리문;
alter view order_test as select product , price from orders; 
# 4. 뷰 조회
select * from order_test;
# 5. 뷰 삭제
drop view if exists order_test;

# 뷰 주의할점 : 특별한 경우가 아니면 select 가능하다 , 뷰 에서는 update, delete, insert 조건 사용
# 뷰 는 주로 읽기 모드 사용된다 
# 수정 불가능 뷰 : join(집계) , group by , 함수 , 계산식(집계/통계) 포함 하면 ㅇㄺ기모드 만 가능
# 수정이 가능한 뷰 : 단일 테이블 기반 ( join, 통계, 집계 등 없는 테이블 )

# [2] 조건 뷰 생성 , 만약에 회원 100만명 이상일때 조회 속도를 평가하면 몇배 의 성능 차이 있을수 있다
# 1. vip 뷰 만들기
create or replace view vip_member as 
select * from member where grade = 'vip'; 

# 2. vip 조회
select * from vip_member; -- 뷰 조회
select * from member where grade = 'vip'; -- 원본 조회 : 결과는 같지만 조회속도에서는 느리다
# 3. 뷰 데이터 수정
update vip_member set name = '유재석2';

# [3] 조인 뷰 생성 , 관계형 데이터베이스란? 서로 다른 테이블간의 (PK-FK) 연관관계를 구조
# 1. 조인 결과 뷰 만들기
create or replace view view_order_summary as
select o.mno , m.name, o.product from member m inner join orders o on m.mno = o.mno;
# 2. 뷰 조회
select * from view_order_summary;
# 3. 뷰 데이터 수정
update view_order_summary set name = '유재석3';


# [4] 뷰 의 데이터를 수정하는 조건 : 단일 테이블의 원본 필드이면 가능 , 집계/통계/그룹/계산 등등 필드에 대해서는 불가능하다
create or replace view vip_member2 as select * , 10+10 as 집계 from member where grade = 'vip';
select * from vip_member2;
update vip_member2 set 집계 = 30;
update vip_member2 set name = '유재석4';