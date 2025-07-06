-- 제품 정보 테이블 생성 (PRODUCT_TB)

CREATE TABLE PRODUCT_TB (
    PRO_NUM   NUMBER PRIMARY KEY,     -- 제품 번호 (기본키)
    PRO_NAME  VARCHAR2(20) NOT NULL,  -- 제품 이름
    PRO_PRICE VARCHAR2(20) NOT NULL,  -- 제품 가격
    PRO_COUNT VARCHAR2(20) NOT NULL   -- 제품 수량
);
