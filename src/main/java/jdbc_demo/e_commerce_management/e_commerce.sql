
USE INTERVIEW;
-- 1. Create table
CREATE TABLE employee (
    employee_id   INT PRIMARY KEY AUTO_INCREMENT,  -- unique ID for each employee
    first_name    VARCHAR(50),
    last_name     VARCHAR(50),
    salary        DECIMAL(10,2),
    joining_date  DATE,
    department    VARCHAR(50),
    gender        CHAR(1)  -- M/F
);


-- 2. Insert sample 5 records

INSERT INTO employee (first_name, last_name, salary, joining_date, department, gender)
VALUES
('John',  'Smith',   50000.00, '2020-05-10', 'IT',        'M'),
('Alice', 'Johnson', 60000.00, '2019-03-15', 'HR',        'F'),
('David', 'Brown',   55000.00, '2021-07-20', 'Finance',   'M'),
('Emma',  'Davis',   65000.00, '2018-11-05', 'Marketing', 'F'),
('Raj',   'Kumar',   70000.00, '2022-01-12', 'IT',        'M');
SELECT LOWER(FIRST_NAME) AS FIRSTNAME  FROM EMPLOYEE;


-- 5. Write a query for combine FirstName and LastName and display it as "Name" (also 
-- include white space between first name & last name) 
SELECT CONCAT(FIRST_NAME,' ',LAST_NAME)AS FULL_NAME FROM EMPLOYEE;
-- 6. Select employee detail whose name is "Vikas"
SELECT * FROM EMPLOYEE WHERE FIRST_NAME='VIKAS';
-- 7. Get all employee detail from EmployeeDetail table whose "FirstName" start with 
-- latter 'a'.
SELECT * FROM EMPLOYEE WHERE FIRST_NAME LIKE 'A%'OR 'a%';

-- 8. Get all employee details from EmployeeDetail table whose "FirstName" contains 
-- 'k' 
SELECT * FROM EMPLOYEE WHERE FIRST_NAME LIKE '%k%'OR '%k%';

-- 9. Get all employee details from EmployeeDetail table whose "FirstName" end with 
-- 'h' 
SELECT * FROM EMPLOYEE WHERE FIRST_NAME LIKE '%A'OR '%a';

-- 10. Get all employee detail from EmployeeDetail table whose "FirstName" start with 
-- any single character between 'a-p' 
-- MySQL
SELECT *
FROM employee
WHERE first_name REGEXP '^[A-Pa-p]';
-- 11). Get all employee detail from EmployeeDetail table whose "FirstName" not start 
-- with any single character between 'a-p' 
select * FROM EMPLOYEE
WHERE FIRST_NAME   not REGEXP '[A-Pa-p]';

-- 13). Get all employee detail from EmployeeDetail table whose "lastName" start with 
-- 'S' and contain 4 letters. 
select * from employee
where last_name like 'S____';

-- 15). Get all unique "Department" from EmployeeDetail table.
SELECT DISTINCT(DEPARTMENT) FROM EMPLOYEE ;

-- 16). Get the highest "Salary" from EmployeeDetail table. 
select max(salary) as HighSalary from employee;

-- 17). Get the lowest "Salary" from EmployeeDetail table. 
select min(salary) as LowSalary from employee;

-- 18). Show "JoiningDate" in "dd mmm yyyy" format, ex- "15 Feb 2013"
select DATE_FORMAT(joining_date,'%d %b %y') as formateddate from employee; 
-- 19). Show "JoiningDate" in "yyyy/mm/dd" format, ex- "2013/02/15"
select date_format(joining_date,'%y/%m/%d') as FormatedDate from employee;
--  20)Show only time part of the "JoiningDate". 
select Time(Joining_date) as TimeJoin from employee;

--  21). Get only Year part of "JoiningDate". 
SELECT YEAR(JOINING_DATE) FROM EMPLOYEE;
-- 22). Get only Month part of "JoiningDate". 
SELECT MONTH(JOINING_DATE) FROM EMPLOYEE;

-- 23). Get system date. 
 SELECT curdate();
--  24). Get UTC date. 
 SELECT utc_date();