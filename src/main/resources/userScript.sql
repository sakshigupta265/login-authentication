--To Create the database if database nt exist with name of LoginAuthentication
create database LoginAuthentication;

use LoginAuthentication;

-- To create User Table
CREATE TABLE `users` (
  `user_Id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_Name` VARCHAR(50) NOT NULL DEFAULT '''Customer''',
  `user_Email` VARCHAR(40) NOT NULL DEFAULT '''Customer''',
  `user_Password` VARCHAR(20) NOT NULL DEFAULT '''Customer''',
  `user_Role` VARCHAR(40) NOT NULL DEFAULT '''Customer''',
  PRIMARY KEY  (`user_Id`)
) ENGINE=INNODB DEFAULT CHARSET=latin1

--To insert data

INSERT INTO loginauthentication.users (user_Id, user_Name, user_Email, user_Password,user_type) VALUES('20', 'admin', 'admin@gmail.com', 'admin','Admin');
