DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    username  VARCHAR(64) NOT NULL,
    password  VARCHAR(250),
    authority VARCHAR(64)
);


DROP TABLE IF EXISTS clients;

create table CLIENTS
(
    ID                     INTEGER auto_increment,
    CLIENT_ID              VARCHAR(64)  not null,
    SECRET                 VARCHAR(64)  not null,
    GRANT_TYPES            VARCHAR(250) not null,
    SCOPES                 VARCHAR(64)  not null,
    ACCESS_TOKEN_VALIDITY  INTEGER,
    AUTHORITIES            VARCHAR(255),
    REDIRECT_URIS          VARCHAR(255),
    REFRESH_TOKEN_VALIDITY INTEGER,
    RESOURCE_IDS           VARCHAR(255),
    PRIMARY KEY (ID),
    UNIQUE (CLIENT_ID)
);

