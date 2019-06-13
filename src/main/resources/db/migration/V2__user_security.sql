
-- Drop sequences if exists
DROP SEQUENCE IF EXISTS sapr.user_sequence;

-- Create sequences
CREATE SEQUENCE sapr.user_sequence INCREMENT BY 1 MINVALUE 1 START WITH 1;

-- Drop tables if exists
DROP TABLE IF EXISTS applicationuser;

-- Create table applicationuser
CREATE TABLE applicationuser(
    id BIGINT PRIMARY KEY NOT NULL,
    username VARCHAR(200),
    password VARCHAR(200)
);

