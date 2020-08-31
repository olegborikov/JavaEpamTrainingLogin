CREATE DATABASE `JETLogin`;
USE `JETLogin`;
create table user
(
    user_id  bigint auto_increment
        primary key,
    login    varchar(20) not null,
    password varchar(40) not null,
    constraint user_login_uindex
        unique (login)
);

INSERT INTO user (`login`, `password`)
VALUES ('user', '3c18df3f8739eb07681f5d69cad66943f999832');
INSERT INTO user (`login`, `password`)
VALUES ('olegborikov', 'e43713ad9e2fc4c55c1e2b373d3f548bd1ffed6e');
INSERT INTO user (`login`, `password`)
VALUES ('admin', 'a753c776ff3ed4fefa2af948af87448910153281');
