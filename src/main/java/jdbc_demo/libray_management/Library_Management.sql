create database insurance_management;
use insurance_management;
create table  customers(
customer_id int primary key,
first_name varchar(50),
last_name varchar(50),
date_of_birth date,
gender varchar(40),
contact_number  VARCHAR(15),
email varchar(50),
address varchar(100)
);
create table  policies(
policy_id int primary key,
policy_name varchar(50),
policy_type varchar(50),
coverage_details varchar(30),
premium int,
start_date date,
end_date date
);
create table claims(
claim_id int primary key,
claim_date date,
claim_amount int,
approved_amount int,
claim_status varchar(10),
policy_id int,
customer_id int,
foreign key (policy_id) references policies(policy_id),
foreign key(customer_id) references customers(customer_id)
);

create table agents(
agent_id int primary key,
first_name varchar(50),
last_name varchar(50),
contact_number varchar(15),
email varchar(20),
hire_date date
);
create table policy_assignments(
assignment_id int primary key,
start_date date,
end_date  date,
policy_id int,
customer_id int,
foreign key (policy_id) references policies(policy_id),
foreign key(customer_id) references customers(customer_id)
);
create table claim_processing(
processing_id int,
processing_date date,
payment_amount int,
payment_date date,
claim_id int,
foreign key(claim_id) references claims(claim_id)
);


-- Insert Customers
insert into customers values
(1, 'Amit', 'Sharma', '1990-05-12', 'Male', '9876543210', 'amit.sharma@example.com', 'Delhi, India'),
(2, 'Priya', 'Iyer', '1988-08-25', 'Female', '9123456789', 'priya.iyer@example.com', 'Bangalore, India');

-- Insert Policies
insert into policies values
(101, 'Health Protect Plus', 'Health', 'Covers hospitalization', 15000, '2024-01-01', '2025-01-01'),
(102, 'Life Secure Plan', 'Life', 'Life cover for family', 20000, '2024-02-01', '2029-02-01');

-- Insert Claims
insert into claims values
(1001, '2024-03-15', 50000, 45000, 'Approved', 101, 1),
(1002, '2024-04-10', 30000, 0, 'Pending', 102, 2);

-- Insert Agents
insert into agents values
(201, 'Rajesh', 'Kumar', '9988776655', 'rajesh@insure.com', '2023-06-20'),
(202, 'Sneha', 'Patil', '9876501234', 'snehal@insure.com', '2024-01-15');

-- Insert Policy Assignments
insert into policy_assignments values
(301, '2024-01-01', '2025-01-01', 101, 1),
(302, '2024-02-01', '2029-02-01', 102, 2);

-- Insert Claim Processing
-- 0:42:29	insert into claim_processing values (401, '2024-03-20', 45000, '2024-03-25', 1001), (402, '2024-04-15', 0, NULL, 1002)	Error Code: 1146. Table 'insurance_management.claim_processing' doesn't exist	0.000 sec
 
insert into claim_processing values
(401, '2024-03-20', 45000, '2024-03-25', 1001),
(402, '2024-04-15', 0, NULL, 1002);

 show tables;
 drop table  calim_processing;
--  DDL Queries
--  1. Add a newcolumn to the agents table:
--  2. Rename the policy_name column in the policies table to policy_title:
--  3. Drop the address column from the customers table--  
-- 1
alter table agents
add column number_of_policies_done int;
 select * from agents;
 -- updating new column 
 update agents
 set number_of_policies_done=7
 where agent_id=202;
 
 -- 2
 select * from policies;
 alter table policies
  change policy_type policy_titile varchar(30);
 -- 3
 select * from customers;
 alter table customers
 drop address;
 
--   DMLQueries
--  1. Update a policy's premium amount:
--  2. Delete a specific claim:
--  3. Insert a new policy assignment:

-- 1 
   select * from policies;
   update  policies
   set premium=10000
   where policy_id=101;
   
   -- 2   beause of forien key  need to delete from realted id also
select * from claims; 
DELETE FROM claim_processing
WHERE claim_id = 1002;
DELETE FROM claims
WHERE claim_id = 1002;


-- 3
-- INSERT INTO policy_assignments (assignment_id, start_date, end_date, policy_id, customer_id) VALUES (303, '2024-02-01', '2025-02-01', 201, 101)	Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails (`insurance_management`.`policy_assignments`, CONSTRAINT `policy_assignments_ibfk_1` FOREIGN KEY (`policy_id`) REFERENCES `policies` (`policy_id`))	0.016 sec
 select* from policies;
 select * from customers;
INSERT INTO policy_assignments (assignment_id, start_date, end_date, policy_id, customer_id)
VALUES (303, '2024-02-01', '2025-02-01', 101, 1);

--  Join Queries
--  1. Retrieve all customers with their assigned policies and agents:
--  2. Find all claims and the associated policy details:
--  3. List all claims along with the customer details:
--  4. Get the total claim amount and number of claims per policy type:
--  5. Find the most recent claim for each customer

select * from policy_assignments;
select * from customers;
select * from policies;
select * from agents;

ALTER TABLE policy_assignments
ADD agent_id INT,
ADD CONSTRAINT fk_agent FOREIGN KEY (agent_id) REFERENCES agents(agent_id);
INSERT INTO policy_assignments (assignment_id, start_date, end_date, policy_id, customer_id, agent_id)
VALUES (304, '2024-03-01', '2025-03-01', 102, 2, 201);

select
 c.first_name as customer_name, 
 a.first_name as agent_name,
 pa.start_date,
 pa.end_date
 from customers c
 inner join  policy_assignments pa on  c.customer_id=pa.customer_id
 inner join agents a on pa.agent_id=a.agent_id;
 
 -- 2 --3

 select 
  cu.first_name,cu.contact_number,
 c.claim_id,c.claim_amount,c.claim_status,
 p.policy_name,p.start_date,p.end_date
 from claims c
 left join customers cu on c.customer_id=cu.customer_id 
 left join policies  p on c.policy_id=p.policy_id;
	
 -- 4
  
  insert into claims values
(1003, '2024-03-15', 5000, 4500, 'Approved', 102, 1);
SELECT 
    p.policy_titile,
    COUNT(c.claim_id) AS total_number_of_claims,
    SUM(c.claim_amount) AS total_claim_amount
FROM claims c
left JOIN policies p 
    ON c.policy_id = p.policy_id
GROUP BY p.policy_titile;


-- 5
select * from claims; 
select * from customers;
  insert into claims values
(1002, '2025-9-8', 5000, 4500, 'Approved', 101, 2);

SELECT 
    c.customer_id,
    cu.first_name,
    cu.email,
    MAX(c.claim_date) AS most_recent_claim_date
FROM claims c
INNER JOIN customers cu 
    ON c.customer_id = cu.customer_id
GROUP BY c.customer_id, cu.first_name, cu.email
ORDER BY most_recent_claim_date DESC;

 

