-- Insert data into Employee table
INSERT INTO `salesdb`.`Employee` (`name`, `role`) VALUES 
('Alice Johnson', 'Accountant'),
('Bob Smith', 'Driver'),
('Charlie Brown', 'SalesRepresentative');

-- Insert data into Person table
INSERT INTO `salesdb`.`Person` (`name`, `location`, `type`) VALUES 
('John Doe', 'Cairo', 'Customer'),
('Jane Roe', 'Alexandria', 'Supplier'),
('Mike Davis', 'Giza', 'Customer');

-- Insert data into Phone table
INSERT INTO `salesdb`.`Phone` (`phoneNumber`, `Employee_id`, `Person_id`) VALUES 
('01012345678', 1, NULL),
('01123456789', NULL, 1),
('01234567890', 2, NULL),
('01098765432', NULL, 2),
('01187654321', 3, NULL),
('01234567891', NULL, 3);

-- Insert data into item table
INSERT INTO `salesdb`.`item` (`name`, `description`, `itemBalance`, `sellingPrice`, `PurchasingPrice`) VALUES 
('Item A', 'Description for Item A', 100, 150.00, 100.00),
('Item B', 'Description for Item B', 200, 250.00, 200.00),
('Item C', 'Description for Item C', 300, 350.00, 300.00);

-- Insert data into Transaction table
INSERT INTO `salesdb`.`Transaction` (`transactionDate`, `totalAmount`, `salesRepId`, `Person_id`) VALUES 
('2024-06-01 10:00:00', 450.00, 3, 1),
('2024-06-02 11:00:00', 750.00, 3, 3);

-- Insert data into PurchaseTransaction table
INSERT INTO `salesdb`.`PurchaseTransaction` (`purchaseDate`, `totalAmount`, `Person_id`) VALUES 
('2024-06-01 09:00:00', 500.00, 2),
('2024-06-03 12:00:00', 800.00, 2);

-- Insert data into Payment table
INSERT INTO `salesdb`.`Payment` (`amount`, `paymentDate`, `paymentType`, `paymentWay`, `Transaction_id`, `Person_id`, `PurchaseTransaction_id`) VALUES 
(150.00, '2024-06-01 11:00:00', 'Payment', 'Cash', 1, 1, NULL),
(200.00, '2024-06-03 13:00:00', 'Receipt', 'Credit Card', NULL, 2, 2),
(350.00, '2024-06-02 12:00:00', 'Payment', 'Cash', 2, 3, NULL);

-- Insert data into PurchaseDetail table
INSERT INTO `salesdb`.`PurchaseDetail` (`quantity`, `purchasingPrice`, `comulativePrice`, `PurchaseTransaction_id`, `item_id`, `price`) VALUES 
(10, 50.00, 500.00, 1, 1, 50.00),
(20, 40.00, 800.00, 2, 2, 40.00);

-- Insert data into TransactionDetail table
INSERT INTO `salesdb`.`TransactionDetail` (`quantity`, `sellingPrice`, `comulativePrice`, `Transaction_id`, `item_id`, `price`) VALUES 
(3, 150.00, 450.00, 1, 1, 150.00),
(3, 250.00, 750.00, 2, 2, 250.00);

