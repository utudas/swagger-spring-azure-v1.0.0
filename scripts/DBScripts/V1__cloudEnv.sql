
-- Drop sequences if exists
DROP SEQUENCE IF EXISTS sapr.art_sequence;
DROP SEQUENCE IF EXISTS sapr.cust_sequence;
DROP SEQUENCE IF EXISTS sapr.orders_sequence;
DROP SEQUENCE IF EXISTS sapr.order_line_sequence;

-- Create sequences
CREATE SEQUENCE sapr.art_sequence INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE sapr.cust_sequence INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE sapr.orders_sequence INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE sapr.order_line_sequence INCREMENT BY 1 MINVALUE 1 START WITH 1;

-- Drop tables if exists
DROP TABLE IF EXISTS sapr.order_line;
DROP TABLE IF EXISTS sapr.orders;
DROP TABLE IF EXISTS sapr.customer;
DROP TABLE IF EXISTS sapr.article;


-- Drop enum types
DROP TYPE IF EXISTS status_values;

-- Create table article
CREATE TABLE sapr.article(
    article_id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(20),
    price NUMERIC (5, 2),
    type VARCHAR(20)
);

-- Create table customer
CREATE TABLE sapr.customer(
    customer_id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(20)
);


-- Create type status_values
create type status_values as enum('IN_PROGRESS', 'SHIPPED', 'COMPLETED');

-- Create table orders
CREATE TABLE sapr.orders (
 orders_id BIGINT PRIMARY KEY NOT NULL,
 customer_id BIGINT,
 status VARCHAR(20),
 order_date timestamp without time zone,
 FOREIGN KEY (customer_id) REFERENCES sapr.customer (customer_id)
);

-- Create table order
CREATE TABLE sapr.order_line (
 order_line_id BIGINT PRIMARY KEY NOT NULL,
 orders_id BIGINT,
 article_id BIGINT,
 quantity BIGINT,
 FOREIGN KEY (orders_id) REFERENCES sapr.orders (orders_id),
 FOREIGN KEY (article_id) REFERENCES sapr.article (article_id)
);
