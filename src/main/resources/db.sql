DROP TABLE IF EXISTS entry_to_keyword;
DROP TABLE IF EXISTS keywords;
DROP TABLE IF EXISTS files;
DROP TABLE IF EXISTS entries;

CREATE TABLE entries (
  id int unsigned not null auto_increment primary key,
  title varchar(1024),
  content text not null,
  type varchar(255) not null,
  parent_id int unsigned null,
  created_at timestamp null default null,
  updated_at timestamp null default null,
  deleted_at timestamp null default null,
  index(type),
  constraint `entries_parent_id_fk` foreign key (parent_id) references entries(id)
) charset=utf8 engine=innodb;


CREATE TABLE files (
  id int unsigned not null auto_increment primary key,
  name varchar(255) not null,
  type varchar(255) not null,
  entry_id int unsigned not null,
  constraint `files_entry_id_fk` foreign key (entry_id) references entries(id)
)charset=utf8 engine=innodb;

CREATE TABLE keywords (
  id int unsigned not null auto_increment primary key,
  name varchar(255) not null,
  index(name)
)charset=utf8 engine=innodb;

CREATE TABLE entry_to_keyword (
  entry_id int unsigned not null,
  keyword_id int unsigned not null,
  primary key(keyword_id, entry_id),
  index(entry_id, keyword_id),
  constraint `entry_to_keyword_entry_id_fk` foreign key (entry_id) references entries(id),
  constraint `entry_to_keyword_keyword_id_fk` foreign key (keyword_id) references keywords(id)
);

INSERT INTO entries VALUES
(null, "Notes", "", "note", null, now(), null, null),
(null, "First entry", "First entry content. Lorem ipsum something.", "note", 1, now(), null, null),
(null, "Second entry", "Second entry content. Lorem ipsum something.", "note", 1, now(), null, null),
(null, "Third entry", "Third entry content. Lorem ipsum something.", "note", 1, now(), null, null),
(null, "Fourth entry", "Fourth entry content. Lorem ipsum something.", "note", 1, now(), null, null);
