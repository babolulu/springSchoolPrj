MySQL 접속 방법 


create database school;
CREATE USER 'school'@'localhost' IDENTIFIED BY 'school';
grant all on school.* to 'school'@'localhost' identified by 'school';
FLUSH PRIVILEGES;

use school;

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emailAddress` varchar(255) NOT NULL,
  `password` varchar(15) NOT NULL,
  `nickName` varchar(255) NOT NULL,
  `dateOfBirth` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;