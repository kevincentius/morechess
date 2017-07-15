CREATE SCHEMA `morechess`;

USE `morechess`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `morechess`.`user_role` (
  `username` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`, `role`),
  CONSTRAINT `user`
    FOREIGN KEY (`username`)
    REFERENCES `morechess`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
