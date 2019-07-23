CREATE TABLE todo
(
    ID int not null auto_increment,
    value varchar(255) unique ,
    is_selected BOOLEAN default false,
    is_edited BOOLEAN default false,
    PRIMARY key (ID)
);
INSERT INTO todo(`value`,`is_selected`) VALUES ('panda', false);

