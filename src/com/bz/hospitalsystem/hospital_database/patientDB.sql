create database Hospital_Management;
use Hospital_Management;

create table patientDetails(
firstName varchar(50) not null,
lastName varchar(50),
age int(3) not null,
patientId int(5) primary key auto_increment
);

desc patientDetails;
select * from patientDetails;
drop table patientDetails;
