

INSERT INTO `branch` (`branch_id`,`branch_name`,`branch_location`) VALUES (1,'City X-Ray','Janakpuri');
INSERT INTO `branch` (`branch_id`,`branch_name`,`branch_location`) VALUES (2,'Janta X-Ray','Tilaknagar');
INSERT INTO `branch` (`branch_id`,`branch_name`,`branch_location`) VALUES (3,'Raj Diagonsis','South Delhi');
INSERT INTO `branch` (`branch_id`,`branch_name`,`branch_location`) VALUES (4,'Star Imaging','North Delhi');


INSERT INTO `vaccine`(`vaccine_id`,`vaccine_code`,`vaccine_name`,`vaccine_cost`,`vaccine_country`) VALUES (1,'Covid1','BNT162b2',2000,'US');
INSERT INTO `vaccine`(`vaccine_id`,`vaccine_code`,`vaccine_name`,`vaccine_cost`,`vaccine_country`) VALUES (2,'Covid2','mRNA-1273',3000,'IND');
INSERT INTO `vaccine`(`vaccine_id`,`vaccine_code`,`vaccine_name`,`vaccine_cost`,`vaccine_country`) VALUES (3,'Covid3','CoronaVac',2000,'CHINA');
INSERT INTO `vaccine`(`vaccine_id`,`vaccine_code`,`vaccine_name`,`vaccine_cost`,`vaccine_country`) VALUES (4,'Covid4','Sputnik',2500,'RUSSIA');
INSERT INTO `vaccine`(`vaccine_id`,`vaccine_code`,`vaccine_name`,`vaccine_cost`,`vaccine_country`) VALUES (5,'Covid5','Covaxin',1500,'IND');


INSERT INTO `vaccine_branch_relation` (`branch_id`,`vaccine_id`,`vaccine_count`) VALUES (1,1,5);
INSERT INTO `vaccine_branch_relation` (`branch_id`,`vaccine_id`,`vaccine_count`) VALUES (1,2,1);
INSERT INTO `vaccine_branch_relation` (`branch_id`,`vaccine_id`,`vaccine_count`) VALUES (1,3,10);
INSERT INTO `vaccine_branch_relation` (`branch_id`,`vaccine_id`,`vaccine_count`) VALUES (1,4,30);
INSERT INTO `vaccine_branch_relation` (`branch_id`,`vaccine_id`,`vaccine_count`) VALUES (1,5,15);
INSERT INTO `vaccine_branch_relation` (`branch_id`,`vaccine_id`,`vaccine_count`) VALUES (2,1,5);
INSERT INTO `vaccine_branch_relation` (`branch_id`,`vaccine_id`,`vaccine_count`) VALUES (2,2,0);
INSERT INTO `vaccine_branch_relation` (`branch_id`,`vaccine_id`,`vaccine_count`) VALUES (2,3,10);
INSERT INTO `vaccine_branch_relation` (`branch_id`,`vaccine_id`,`vaccine_count`) VALUES (2,4,30);
INSERT INTO `vaccine_branch_relation` (`branch_id`,`vaccine_id`,`vaccine_count`) VALUES (3,1,1);
INSERT INTO `vaccine_branch_relation` (`branch_id`,`vaccine_id`,`vaccine_count`) VALUES (3,2,0);
INSERT INTO `vaccine_branch_relation` (`branch_id`,`vaccine_id`,`vaccine_count`) VALUES (3,3,10);
INSERT INTO `vaccine_branch_relation` (`branch_id`,`vaccine_id`,`vaccine_count`) VALUES (4,1,5);
INSERT INTO `vaccine_branch_relation` (`branch_id`,`vaccine_id`,`vaccine_count`) VALUES (4,2,3);


INSERT INTO `schedule` (`schedule_id`,`branch_id`,`contact_info`,`payment_mode`,`payment_status`,`schedule_status`,`schedule_time`,`vaccine_id`) VALUES (1,1,'vivekkumar2502@gmail.com','CASH','OPEN','OPEN','04:30 pm - 04:45 pm',1);
INSERT INTO `schedule` (`schedule_id`,`branch_id`,`contact_info`,`payment_mode`,`payment_status`,`schedule_status`,`schedule_time`,`vaccine_id`) VALUES (2,1,'vivekkumar2502@gmail.com','CASH','OPEN','DONE','04:00 pm - 04:15 pm',2);
INSERT INTO `schedule` (`schedule_id`,`branch_id`,`contact_info`,`payment_mode`,`payment_status`,`schedule_status`,`schedule_time`,`vaccine_id`) VALUES (3,3,'vivekkumar2502@gmail.com','CASH','DONE','OPEN','09:00 am - 09:15 am',1);
INSERT INTO `schedule` (`schedule_id`,`branch_id`,`contact_info`,`payment_mode`,`payment_status`,`schedule_status`,`schedule_time`,`vaccine_id`) VALUES (4,2,'vivekkumar2502@gmail.com','CASH','OPEN','OPEN','04:30 pm - 04:45 pm',3);
INSERT INTO `schedule` (`schedule_id`,`branch_id`,`contact_info`,`payment_mode`,`payment_status`,`schedule_status`,`schedule_time`,`vaccine_id`) VALUES (5,2,'vivekkumar2502@gmail.com','CASH','OPEN','DONE','04:00 pm - 04:15 pm',1);
INSERT INTO `schedule` (`schedule_id`,`branch_id`,`contact_info`,`payment_mode`,`payment_status`,`schedule_status`,`schedule_time`,`vaccine_id`) VALUES (6,4,'vivekkumar2502@gmail.com','CASH','DONE','DONE','09:00 am - 09:15 am',2);
INSERT INTO `schedule` (`schedule_id`,`branch_id`,`contact_info`,`payment_mode`,`payment_status`,`schedule_status`,`schedule_time`,`vaccine_id`) VALUES (7,4,'vivekkumar2502@gmail.com','CASH','DONE','DONE','09:00 am - 09:15 am',3);