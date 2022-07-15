
create table book (book_id integer not null auto_increment, author varchar(255), book_image LONGTEXT, book_name varchar(255), employee_note varchar(255)Hibernate: create table book (book_id integer not null auto_increment, author varchar(255), book_image LONGTEXT, book_name varchar(255), employee_note varchar(255), publication_date DATE, publisher varchar(255), storage_quantity bigint, total_page integer, book_type_id integer, primary key (book_id)) engine=InnoDB
create table book_type (id integer not null auto_increment, type_name varchar(255), primary key (id)) engine=InnoDB
create table customer (customer_id integer not null auto_increment, address varchar(255), customer_name varchar(255), date_of_birth DATE, phone varchar(255), primary key (customer_id)) engine=InnoDB
create table invoice (invoice_id integer not null auto_increment, create_date DATE, customer_id integer, primary key (invoice_id)) engine=InnoDB
create table invoice_detail (invoice_detail_id integer not null auto_increment, quantity integer, book_id integer, invoice_id integer, primary key (invoice_detail_id)) engine=InnoDB
create table user (user_id integer not null auto_increment, user_name varchar(255), user_password varchar(255), customer_id integer, primary key (user_id)) engine=InnoDB
alter table book add constraint FK560l33961sgrup678f7yxsxja foreign key (book_type_id) references book_type (id)
alter table invoice add constraint FK5e32ukwo9uknwhylogvta4po6 foreign key (customer_id) references customer (customer_id)
alter table invoice_detail add constraint FK2psp9xo11if0jd4r2dbgrcrpm foreign key (book_id) references book (book_id)
alter table invoice_detail add constraint FKit1rbx4thcr6gx6bm3gxub3y4 foreign key (invoice_id) references invoice (invoice_id)
alter table user add constraint FKdptx0i3ky01svofwjytq5iry0 foreign key (customer_id) references customer (customer_id)