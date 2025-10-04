create database E_commerce;
use E_commerce;
CREATE TABLE Customers(
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    fullName VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    Phone VARCHAR(20),
    CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO Customers (fullName, Email, Phone) VALUES
('Aarav Sharma', 'aarav@example.com', '+91-9876543210'),
('Ananya Singh', 'ananya@example.com', '+91-8765432109'),
('Rohit Verma', 'rohit@example.com', '+91-9123456789'),
('Kiran Mehta', 'kiran@example.com', '+91-9988776655');


-- categories 
CREATE TABLE Categories(
categoryID INT PRIMARY KEY AUTO_INCREMENT,
categoryName VARCHAR(40) UNIQUE NOT NULL
);

INSERT INTO Categories (categoryName) VALUES
('Electronics'),
('Clothing'),
('Books'),
('Home Appliances');


-- PRODUCTS
 CREATE TABLE PRODUCTS(
 productID INT PRIMARY KEY AUTO_INCREMENT,
 productName VARCHAR(100) NOT NULL,
 price DECIMAL(10,2) NOT NULL,
stock INT NOT NULL,
categoryID INT,
FOREIGN KEY (categoryId)references Categories(categoryId)
);

INSERT INTO Products (productName, price, stock, categoryID) VALUES
('Smartphone', 25000.00, 50, 1),    -- Electronics
('Jeans', 1999.00, 200, 2),         -- Clothing
('Novel - Java Basics', 499.00, 100, 3), -- Books
('Microwave Oven', 8000.00, 30, 4); -- Home Appliances


-- Orders
 CREATE TABLE ORDERS(
 orderid INT PRIMARY KEY AUTO_INCREMENT,
 customerId INT,
 orderDate DATETIME DEFAULT CURRENT_TIMESTAMP,
 paymentMethod VARCHAR(50),
 foreign key (customerId) REFERENCES Customers(customer_Id)
 );
 
 INSERT INTO Orders (customerId, paymentMethod) VALUES
(1, 'Credit Card'),
(2, 'UPI'),
(3, 'Cash on Delivery'),
(4, 'Net Banking');


 -- Order Details (many-to-many between Orders and Products)
 
 CREATE TABLE OrderDetails(
 orderDetailsId INT PRIMARY KEY AUTO_INCREMENT,
 orderId INT,
 productId INT,
quantity INT NOT NULL,
price DECIMAL(10,2) NOT NULL,
FOREIGN KEY (orderId) references Orders(orderid),
FOREIGN KEY (productId) references Products(productid)
);

INSERT INTO OrderDetails (orderId, productId, quantity, price) VALUES
(1, 1, 1, 25000.00),  -- Aarav bought 1 Smartphone
(2, 2, 2, 1999.00),   -- Ananya bought 2 Jeans
(3, 3, 1, 499.00),    -- Rohit bought 1 Book
(4, 4, 1, 8000.00);   -- Kiran bought 1 Microwave

-- Audit Table 
CREATE TABLE OrderAudit ( 
    auditID INT PRIMARY KEY AUTO_INCREMENT, 
    orderID INT, 
    customerID INT, 
    orderDate DATETIME, 
    actionType VARCHAR(20), 
    loggedAt DATETIME DEFAULT CURRENT_TIMESTAMP 
); 
INSERT INTO OrderAudit (orderID, customerID, orderDate, actionType) VALUES
(1, 1, NOW(), 'INSERT'),
(2, 2, NOW(), 'INSERT'),
(3, 3, NOW(), 'INSERT'),
(4, 4, NOW(), 'INSERT');

-- High Value Orders 
CREATE TABLE HighValueOrders ( 
    hVOrderID INT PRIMARY KEY AUTO_INCREMENT, 
    orderID INT,
    customerID INT, 
    totalAmount DECIMAL(12,2), 
    createdAt DATETIME DEFAULT CURRENT_TIMESTAMP 
); 
INSERT INTO HighValueOrders (orderID, customerID, totalAmount) VALUES
(1, 1, 25000.00),
(4, 4, 8000.00), 
(2, 2, 3998.00),
(3, 3, 499.00);

select * from orders;
select MONTH(orderDate) from orders;

SELECT 
    c.customer_id,
    c.fullName,
    SUM(od.quantity * od.price) AS total_spent,
    COUNT(DISTINCT p.categoryID) AS categories_bought
FROM Customers c
JOIN Orders o ON c.customer_id = o.customerID
JOIN OrderDetails od ON o.orderID = od.orderID
JOIN Products p ON od.productID = p.productID
WHERE o.orderDate >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH)
GROUP BY c.customer_id, c.fullName
HAVING COUNT(DISTINCT p.categoryID) >= 3
ORDER BY total_spent DESC
LIMIT 3;

SELECT 
    o.orderID,
    c.fullName AS customer_name,
    o.orderDate,
    o.paymentMethod,
    SUM(od.quantity * od.price) AS total_amount
FROM Orders o
JOIN Customers c ON o.customerID = c.customer_id
JOIN OrderDetails od ON o.orderID = od.orderID
WHERE o.orderDate >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)
GROUP BY o.orderID, c.fullName, o.orderDate, o.paymentMethod
ORDER BY o.orderDate DESC;

SELECT *
FROM Customers
WHERE Email = 'aarav@example.com';


SELECT p.productID, p.productName, p.price, p.stock, c.categoryName
FROM Products p
JOIN Categories c ON p.categoryID = c.categoryID
WHERE c.categoryName = 'Electronics';

SELECT 
    o.orderID,
    c.fullName AS customer_name,
    o.orderDate,
    p.productName,
    od.quantity,
    od.price,
    (od.quantity * od.price) AS total
FROM Orders o
JOIN Customers c ON o.customerID = c.customer_id
JOIN OrderDetails od ON o.orderID = od.orderID
JOIN Products p ON od.productID = p.productID
ORDER BY o.orderID;
---//stored procesure
DELIMITER $$
CREATE PROCEDURE PlaceOrder(
    IN p_customerId INT,
    IN p_productId INT,
    IN p_quantity INT,
    IN p_paymentMethod VARCHAR(50)
)
BEGIN
    DECLARE stockLeft INT;
    DECLARE orderId INT;
    SELECT Stock INTO stockLeft
    FROM Products
    WHERE ProductID = p_productId;
    IF stockLeft >= p_quantity THEN
        SELECT 'Available for order' AS Status;
    ELSE
        SELECT 'Insufficient stock' AS Status;
    END IF;
END;
DELIMITER ;
