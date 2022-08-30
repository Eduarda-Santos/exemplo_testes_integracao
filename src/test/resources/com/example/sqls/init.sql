use testing;

CREATE TABLE users (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    email varchar(255) UNIQUE,
    PRIMARY KEY (id)
);