CREATE DATABASE OnlineOrderDB;
USE OnlineOrderDB;
-- Create tables:
-- Customer(cust_id, cust_name, email)
-- Orders(order_id, cust_id, order_date, amount)
CREATE TABLE Customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    last_order_date DATETIME
);
CREATE TABLE Orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    amount DECIMAL(10,2),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);
INSERT INTO Customer (customer_name, email) VALUES
('Virat Kohli', 'Kohli@gmail.com'),
('Smrithi', 'dot@gamail.com'),
('Rohit', 'rohit@gmail.com'),
('Kiran ', 'kiran@gmail.com'),
('Priya Rao', 'priya@gmail.com');
INSERT INTO Orders (customer_id, amount) VALUES
(1, 2500.00),
(1, 1500.00),
(2, 3000.00),
(3, 500.00),
(3, 700.00),
(4, 1200.00),
(4, 800.00),
(5, 0.00),
(2, 1000.00),
(1, 2000.00);

 -- Get all orders placed by a specific customer
 SELECT o.order_id, o.order_date, o.amount, c.customer_name, c.email
FROM Customer c
INNER JOIN Orders o ON o.customer_id = c.customer_id
WHERE c.customer_id = 1;

-- Retrieve the customer with the highest total purchase amount.
select c.customer_name,c.email,sum(o.amount)as ToatlPurchase from Customer c
Inner Join orders o  on o.customer_id =c.customer_id
GROUP BY c.customer_id, c.customer_name
order by ToatlPurchase DESC
limit 1;

-- Display customers who haven’t placed any order.
select * from Customer;
select * from orders;
SELECT * FROM Customer c
LEFT JOIN Orders o ON c.customer_id = o.customer_id
WHERE o.order_id IS NULL;

-- 4. Average order value
SELECT AVG(amount) AS avg_order_value FROM Orders;

-- //histroy -- Show top 3 customers by purchase amount
  SELECT 
   c.customer_id,
    c.customer_name,
    c.email,
  sum(o.amount) TotalPurchase
                FROM Orders o
                JOIN Customer c ON o.customer_id = c.customer_id
                group by c.customer_id,c.customer_name,c.email
                limit 3;

