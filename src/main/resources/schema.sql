drop table if exists jewelry;

CREATE TABLE jewelry (
                         id int NOT NULL AUTO_INCREMENT,
                         name varchar(100) NOT NULL,
                         color varchar(20) not null,
                         price float NOT NULL,
                         price_new float NOT NULL,
                         image blob,
                         PRIMARY KEY (id)
);