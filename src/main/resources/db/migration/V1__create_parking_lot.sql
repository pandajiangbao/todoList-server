CREATE TABLE parking_lot
(
ID varchar(255) NOT null ,
Name varchar(255) unique ,
capacity INT check(capacity>=0),
location VARCHAR(255),
PRIMARY key (ID)
);
