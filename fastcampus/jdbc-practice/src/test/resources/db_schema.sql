DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS
(
    userId   varchar(12) NOT NULL,
    password varchar(12) NOT NULL,
    name     varchar(50) NOT NULL,
    email    varchar(50),

    PRIMARY KEY (userId)
);
