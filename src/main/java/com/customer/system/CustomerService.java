package com.customer.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {
    private final Map<Integer, Customer> customers = new HashMap<>();

    public void addCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        customers.put(customer.getId(), customer);
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    public Customer getCustomerById(int id) {
        return customers.get(id);
    }

    public List<Customer> searchCustomersByName(String name) {
        List<Customer> result = new ArrayList<>();
        String searchName = name.toLowerCase();
        for (Customer customer : customers.values()) {
            if (customer.getName().toLowerCase().contains(searchName)) {
                result.add(customer);
            }
        }
        return result;
    }

    public boolean updateCustomer(int id, Customer updatedCustomer) {
        if (!customers.containsKey(id)) {
            return false;
        }
        updatedCustomer.setId(id);
        customers.put(id, updatedCustomer);
        return true;
    }

    public boolean deleteCustomer(int id) {
        if (!customers.containsKey(id)) {
            return false;
        }
        customers.remove(id);
        return true;
    }
}
