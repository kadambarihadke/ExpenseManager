CREATE TABLE `expenses_details` (`eid` int(10) not null AUTO_INCREMENT,
   `expensetitle` varchar(100),
   `description` varchar(100),
   `category` varchar(100),
   `amount` int(100),
   `Date` date not null,
   PRIMARY KEY(`eid`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;