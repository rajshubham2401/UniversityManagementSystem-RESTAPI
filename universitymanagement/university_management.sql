-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/



--
-- Database: `university_management`
--
CREATE DATABASE IF NOT EXISTS `university_management`;
USE `university_management`;

-- --------------------------------------------------------

--
-- Table structure for table `department_details`
--

DROP TABLE IF EXISTS `department_details`;
CREATE TABLE IF NOT EXISTS `department_details` (
  `slno` int(5) NOT NULL AUTO_INCREMENT,
  `dept_id` varchar(10) NOT NULL,
  `dept_name` varchar(50) NOT NULL,
  `subjects_id` varchar(50) NOT NULL,
  PRIMARY KEY (`dept_id`),
  UNIQUE KEY `UNIQUE` (`slno`)
) 


-- --------------------------------------------------------

--
-- Table structure for table `marks_details`
--

DROP TABLE IF EXISTS `marks_details`;
CREATE TABLE IF NOT EXISTS `marks_details` (
  `slno` int(5) NOT NULL AUTO_INCREMENT,
  `student_reg_no` varchar(10) NOT NULL,
  `subject_id` varchar(10) NOT NULL,
  `mark` int(3) NOT NULL,
  PRIMARY KEY (`slno`)
) 


-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

DROP TABLE IF EXISTS `student_details`;
CREATE TABLE IF NOT EXISTS `student_details` (
  `slno` int(5) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(50) NOT NULL,
  `student_reg_no` varchar(10) NOT NULL,
  `student_age` int(5) NOT NULL,
  `student_gender` varchar(10) NOT NULL,
  `dept_id` varchar(10) NOT NULL,
  `subjects_id` varchar(50) NOT NULL,
  PRIMARY KEY (`student_reg_no`),
  UNIQUE KEY `UNIQUE` (`slno`)
) 

-- --------------------------------------------------------

--
-- Table structure for table `subject_details`
--

DROP TABLE IF EXISTS `subject_details`;
CREATE TABLE IF NOT EXISTS `subject_details` (
  `slno` int(5) NOT NULL AUTO_INCREMENT,
  `subject_id` varchar(10) NOT NULL,
  `subject_name` varchar(50) NOT NULL,
  PRIMARY KEY (`subject_id`),
  UNIQUE KEY `UNIQUE` (`slno`)
) 

