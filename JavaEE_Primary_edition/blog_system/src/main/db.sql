create database  if not exists java105_blog_system;

use java105_blog_system;

drop table if exists blog;

create table blog (
    blogId int primary key auto_increment,
    title varchar(256),
    content text,/*比varchar更长的字符串*/
    postTime datetime,
    -- userId 就是当前文章作者的用户 id
    userId int
) ;

drop table if exists user;
create table user (
    userId int primary key auto_increment,
    username varchar(50) unique,
    password varchar(50)
) ;

insert into blog values(null,"这是第一篇博客","从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客从今天开始，我要认真写博客",now(),1);
insert into blog values(null,"这是第二篇博客","从今天开始，我要认真写博客",now(),2);
insert into blog values(null,"这是第三篇博客","从今天开始，我要认真写博客",now(),2);

insert into user values(null,"zhangsan","123");
insert into user values(null,"lisi","123");