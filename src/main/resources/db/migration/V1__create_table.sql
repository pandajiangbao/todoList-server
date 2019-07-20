CREATE TABLE parking_lot
(
    ID int not null auto_increment,
    Name varchar(255) unique ,
    capacity INT check(capacity>=0),
    location VARCHAR(255),
    PRIMARY key (ID)
);
CREATE TABLE parking_order
(
    ID int not null auto_increment not null ,
    parking_lot_name varchar(255),
    car_number varchar(255),
    created_time timestamp,
    closed_time timestamp,
    status boolean default true,
    PRIMARY key (ID)
);

