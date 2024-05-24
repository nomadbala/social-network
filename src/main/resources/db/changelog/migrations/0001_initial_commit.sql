-- liquibase formatted sql

-- changeset SaparSayat:1
-- comment first migration
create table roles
(
    role_id bigint not null,
    name varchar(255),
    primary key (role_id)
);

create table users
(
    user_id bigint not null,
    email    varchar(255) unique,
    login    varchar(255) unique,
    password varchar(255) not null,
    username varchar(255),
    sigma varchar(64),
    primary key (user_id)
);

create table user_roles
(
    role_id bigint not null,
    user_id bigint not null,
    primary key (role_id, user_id),
    foreign key (role_id) references roles(role_id),
    foreign key (user_id) references users(user_id)
);