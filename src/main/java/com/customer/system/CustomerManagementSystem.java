package com.customer.system;

import java.util.List;
import java.util.Scanner;

public class CustomerManagementSystem {
    private static final CustomerService service = new CustomerService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedData();

        while (true) {
            displayMenu();
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addCustomer();
                    break;
                case "2":
                    viewAllCustomers();
                    break;
                case "3":
                    searchCustomerById();
                    break;
                case "4":
                    searchCustomerByName();
                    break;
                case "5":
                    updateCustomer();
                    break;
                case "6":
                    deleteCustomer();
                    break;
                case "7":
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("Customer Details Information System");
        System.out.println("========================================");
        System.out.println("1. Add Customer");
        System.out.println("2. View All Customers");
        System.out.println("3. Search Customer by ID");
        System.out.println("4. Search Customer by Name");
        System.out.println("5. Update Customer");
        System.out.println("6. Delete Customer");
        System.out.println("7. Exit");
    }

    private static void seedData() {
        service.addCustomer(new Customer(1, "Alice Johnson", "alice@example.com", "1234567890", "New York"));
        service.addCustomer(new Customer(2, "Bob Smith", "bob@example.com", "9876543210", "London"));
        service.addCustomer(new Customer(3, "Charlie Brown", "charlie@example.com", "5557771234", "Paris"));
    }

    private static void addCustomer() {
        try {
            System.out.print("Enter customer ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Enter customer name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Enter email: ");
            String email = scanner.nextLine().trim();
            System.out.print("Enter phone: ");
            String phone = scanner.nextLine().trim();
            System.out.print("Enter city: ");
            String city = scanner.nextLine().trim();

            service.addCustomer(new Customer(id, name, email, phone, city));
            System.out.println("Customer added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a numeric value.");
        }
    }

    private static void viewAllCustomers() {
        List<Customer> customers = service.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        System.out.println("\nCustomer List:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private static void searchCustomerById() {
        try {
            System.out.print("Enter customer ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            Customer customer = service.getCustomerById(id);

            if (customer == null) {
                System.out.println("Customer not found.");
            } else {
                System.out.println(customer);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a numeric value.");
        }
    }

    private static void searchCustomerByName() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine().trim();
        List<Customer> customers = service.searchCustomersByName(name);

        if (customers.isEmpty()) {
            System.out.println("No matching customer found.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    private static void updateCustomer() {
        try {
            System.out.print("Enter customer ID to update: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            Customer existing = service.getCustomerById(id);

            if (existing == null) {
                System.out.println("Customer not found.");
                return;
            }

            System.out.print("Enter new name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine().trim();
            System.out.print("Enter new phone: ");
            String phone = scanner.nextLine().trim();
            System.out.print("Enter new city: ");
            String city = scanner.nextLine().trim();

            Customer updated = new Customer(id, name, email, phone, city);
            boolean success = service.updateCustomer(id, updated);
            if (success) {
                System.out.println("Customer updated successfully.");
            } else {
                System.out.println("Update failed.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a numeric value.");
        }
    }

    private static void deleteCustomer() {
        try {
            System.out.print("Enter customer ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            boolean success = service.deleteCustomer(id);
            if (success) {
                System.out.println("Customer deleted successfully.");
            } else {
                System.out.println("Customer not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a numeric value.");
        }
    }
}
