use example;

drop table if exists discussions;
CREATE TABLE discussions(
   id serial,
   title varchar(100),
   body varchar(500),
   version bigint not null default 0,
   created_on datetime not null,
   updated_on datetime,
   PRIMARY KEY( id )
);

drop table if exists discussion_comments;
CREATE TABLE discussion_comments(
	id serial,
	discussion_id bigint unsigned,
	body varchar(500),
	created_on datetime not null,
	updated_on datetime,
	PRIMARY KEY(id),
	foreign key(discussion_id) references discussions(id)
);


alter table discussions add column (created_on datetime, updated_on datetime);
SET SQL_SAFE_UPDATES=0;
update discussions set created_on = now() where created_on is null;
SET SQL_SAFE_UPDATES=1;
alter table discussions modify created_on datetime NOT NULL;

select * from discussions;

show create table discussions;

insert into discussions (title, body, created_on) values ("title", "body", now());

insert into discussion_comments (discussion_id, body) values (1, "body of comment");
select * from discussion_comments;

select now();
SELECT @@global.time_zone;
SELECT @@session.time_zone;
SET time_zone = "+00:00";