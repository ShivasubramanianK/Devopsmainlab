# Customer Details Information System

This is a simple Java application for storing and managing customer records.

## Features
- Add new customer records
- View all customers
- Search by customer ID
- Search by customer name
- Update customer details
- Delete customer records

## Run the project

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.customer.system.CustomerManagementSystem"
```

If `exec-maven-plugin` is not available, run the application using the generated class file:

```bash
mvn package
java -cp target/classes com.customer.system.CustomerManagementSystem
```

## Project structure

- `src/main/java/com/customer/system/Customer.java`
- `src/main/java/com/customer/system/CustomerService.java`
- `src/main/java/com/customer/system/CustomerManagementSystem.java`
