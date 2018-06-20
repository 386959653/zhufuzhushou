/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_permission` */

insert  into `role_permission`(`id`,`role_id`,`permission_id`) values (1,1,1),(2,2,1);

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL,
  `permission_name` varchar(100) DEFAULT NULL,
  `url` varchar(2083) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission` */

insert  into `sys_permission`(`id`,`permission_name`,`url`) values (1,'管理员','/userList');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL COMMENT '父角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`role_name`,`pid`) values (1,'admin',2),(2,'user',NULL);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`) values (1,'test','123'),(2,'admin','123');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`user_id`,`role_id`) values (1,1,2),(2,2,1);

drop table if exists group_list;

/*==============================================================*/
/* Table: group_list                                            */
/*==============================================================*/
create table group_list
(
   id                   bigint not null,
   group_name           varchar(100),
   group_owner_user_id  bigint,
   generate_purchase_list_time datetime,
   insert_username      varchar(100),
   insert_time          datetime,
   update_username      varchar(100),
   update_time          datetime,
   primary key (id)
);


drop table if exists user_group;

/*==============================================================*/
/* Table: user_group                                            */
/*==============================================================*/
create table user_group
(
   id                   bigint not null,
   user_id              bigint,
   group_id             bigint,
   group_role           enum("煮妇","吃货"),
   insert_username      varchar(100),
   insert_time          datetime,
   update_username      varchar(100),
   update_time          datetime,
   primary key (id)
);


drop table if exists order_list;

/*==============================================================*/
/* Table: order_list                                            */
/*==============================================================*/
create table order_list
(
   id                   bigint not null,
   user_id              bigint,
   menu_id              bigint,
   insert_username      varchar(100),
   insert_time          datetime,
   update_username      varchar(100),
   update_time          datetime,
   primary key (id)
);


drop table if exists menu;

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   id                   bigint not null,
   dish_name            varchar(100),
   insert_username      varchar(100),
   insert_time          datetime,
   update_username      varchar(100),
   update_time          datetime,
   primary key (id)
);

