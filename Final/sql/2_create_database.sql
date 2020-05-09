CREATE DATABASE `workshopdb` DEFAULT CHARACTER SET utf8;

CREATE USER 'workshop_user'@'localhost' IDENTIFIED BY 'workshop_password';

GRANT SELECT,INSERT,UPDATE,DELETE
    ON `workshopdb`.*
    TO workshop_user@localhost;