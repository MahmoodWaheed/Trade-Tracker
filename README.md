# Trade Tracker

Trade Tracker is an open-source e-commerce platform designed to simplify sales and purchasing processes. Whether you're a small business owner, an individual seller, or a buyer, Market Master offers the following features:

- **Product Listings**: Easily create and manage product listings with detailed descriptions, images, and pricing.
- **Shopping Cart**: Seamlessly add items to your cart, review your selections, and proceed to checkout.
- **Order Tracking**: Keep track of your orders from purchase to delivery.
- **User Profiles**: Register, log in, and personalize your experience.
- **Secure Transactions**: Built-in security measures ensure safe transactions.

# Sales Management System

## Overview

The Sales Management System is a Java-based application designed to manage sales transactions, track inventory, and handle payments for suppliers and customers. The application is built using Java Swing for the GUI, Hibernate ORM for database interactions, and MySQL as the database.

## Features

- Manage employees, suppliers, customers, and items.
- Record and update sales transactions.
- Generate detailed reports on sales and financial balances.
- Track payments and receipts with unique identifiers.
- View net money in the treasury.

## Technologies Used

- Java
- Java Swing
- Hibernate ORM
- MySQL
- Maven

## Project Structure
![Project_Structure](https://github.com/user-attachments/assets/a7db3f53-ac60-4d5a-b399-c212d1535ed4)


## Database Schema

Below is the schema of the database used in this project:


![Database Schema](https://github.com/user-attachments/assets/89ea83ed-a574-48d3-a123-17564f3f1f62)

## Getting Started

### Prerequisites

- [Java JDK 17 or higher](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL](https://dev.mysql.com/downloads/mysql/)

### Installation

1. Clone the repository:

```sh
git clone https://github.com/MahmoodWaheed/Trade-Tracker.git
cd Trade-Tracker

2. Set Up the database:
 * Create a MySQL database named salesdb.
 * Run the provided SQL script to set up the tables and initial data.

3. Configure database connection:
  * Edit the hibernate.cfg.xml file in the src/main/resources directory to match your MySQL database configuration.

4. Build the project:
  mvn clean install

5. Run the application:
 mvn exec:java -Dexec.mainClass="gui.SalesForm"

6. Once the application is running, you can start tracking your trades and managing sales efficiently. Navigate through the user-friendly interface of the SalesForm to input, view, and update sales information.  
7. Don't forget to regularly back up your sales data to ensure its safety and integrity. You can export reports and analyze your sales performance for better decision-making.  
8. If you encounter any issues or have suggestions for improvements, feel free to contribute to the project on GitHub or reach out to the developer MahmoodWaheed for support.  
9. Thank you for using Trade Tracker to streamline your sales management processes. Happy tracking!
...

## Usage
Use the GUI to manage employees, suppliers, customers, and items.
Record new transactions and update existing ones.
Generate reports on sales and financial balances.

