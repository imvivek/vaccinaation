DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch` (
  `branch_id` int NOT NULL,
  `branch_name` varchar(45) NOT NULL,
  `branch_location` varchar(45) NOT NULL,
  PRIMARY KEY (`branch_id`)
);

DROP TABLE IF EXISTS `vaccine`;
CREATE TABLE `vaccine` (
  `vaccine_id` int NOT NULL,
  `vaccine_code` varchar(45) NOT NULL,
  `vaccine_name` varchar(45) NOT NULL,
  `vaccine_cost` int NOT NULL,
  `vaccine_country` varchar(45) NOT NULL,
  PRIMARY KEY (`vaccine_id`)
);

DROP TABLE IF EXISTS `vaccine_branch_relation`;
CREATE TABLE `vaccine_branch_relation` (
  `branch_id` int NOT NULL,
  `vaccine_id` int NOT NULL,
  `vaccine_count` int NOT NULL,
  PRIMARY KEY (`branch_id`,`vaccine_id`),
  CONSTRAINT `branch_id` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`),
  CONSTRAINT `vaccine_id` FOREIGN KEY (`vaccine_id`) REFERENCES `vaccine` (`vaccine_id`)
);

DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `schedule_id` int NOT NULL auto_increment,
  `branch_id` int NOT NULL,
  `contact_info` varchar(255) NOT NULL,
  `payment_mode` varchar(255) NOT NULL,
  `payment_status` varchar(255) NOT NULL,
  `schedule_status` varchar(255) NOT NULL,
  `schedule_time` varchar(255) NOT NULL,
  `vaccine_id` int NOT NULL,
  PRIMARY KEY (`schedule_id`),
  CONSTRAINT `branchId` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`),
  CONSTRAINT `vaccineId` FOREIGN KEY (`vaccine_id`) REFERENCES `vaccine` (`vaccine_id`)
);




