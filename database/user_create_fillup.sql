CREATE DATABASE `JETLogin`;
USE `JETLogin`;
create table user
(
    userId   bigint auto_increment
        primary key,
    login    varchar(20) not null,
    password varchar(40) not null,
    constraint user_login_uindex
        unique (login)
);
