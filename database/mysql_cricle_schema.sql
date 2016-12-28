DROP DATABASE if exists SHARCLE;

CREATE DATABASE SHARCLE;

USE SHARCLE;

CREATE TABLE IF NOT EXISTS Registration (
  UUID varchar(254) NOT NULL,
  Email_id varchar(254) NOT NULL,
  Display_name varchar(254) NOT NULL,
  Comm_user varchar(5) NOT NULL,
  Image varchar(254),
  Time_stamp long,
  PRIMARY KEY (Email_id)
);

CREATE TABLE IF NOT EXISTS Groups (
  UUID varchar(254) NOT NULL,
  Group_id varchar(254) NOT NULL,
  Group_Name varchar(254) NOT NULL,
  Group_address varchar(254),
  GPS_Cords varchar(254),
  Time_stamp long,
  Type varchar(30),
  PRIMARY KEY (Group_id)
);

CREATE TABLE IF NOT EXISTS ChatOffer (
  UUID varchar(254) NOT NULL,
  Group_id varchar(254) NOT NULL,
  Offer_id varchar(254) NOT NULL,
  Offer_type varchar(254),
  Description varchar(254),
  Offer_Starttime long,
  Offer_endtime long,
  User_Id varchar(30),
  Offer_image varchar(254),
  FOREIGN KEY (Group_id) REFERENCES Groups(Group_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Chat (
  UUID varchar(254) NOT NULL,
  Group_id varchar(254) NOT NULL,
  Chat_text varchar(254) NOT NULL,
  User_Id varchar(30) NOT NULL,
  Time_stamp long,
  FOREIGN KEY (Group_id) REFERENCES Groups(Group_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS User_group (
  UUID varchar(254) NOT NULL,
  User_Id varchar(30) NOT NULL, 
  Group_id varchar(254) NOT NULL,
  Last_update_time long,
  Last_access_time long,
  FOREIGN KEY (Group_id) REFERENCES Groups(Group_id) ON DELETE CASCADE
);
