CREATE TABLE clietaccount
(
    id int primary key,
    clientid UUID NOT NULL,
    firstName VARCHAR(50)   NOT NULL,
    lastNAmet  VARCHAR(50)  NOT NULL,
    phonenumber VARCHAR(30),
    emailaddress VARCHAR(250) NOT NULL
--                          last_updated date  NOT NULL
);
CREATE TABLE logintoaccount
(
    id int primary key,
    userName VARCHAR(250) NOT NULL,
    paswword VARCHAR(250) NOT NULL

);