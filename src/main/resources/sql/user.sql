# 创建数据库
create database if not exists WuYue;

use WuYue;

# 创建用户数据表
create table user (
                      id smallint primary key ,
                      username char(20) not null ,
                      password char(20) not null
);

alter table user modify id smallint auto_increment;
desc user;