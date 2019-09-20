CREATE TABLE `user_details` (`id` int(10) not null AUTO_INCREMENT,
   `username` varchar(100) not null,
   `password` varchar(100) not null,
   PRIMARY KEY(`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;