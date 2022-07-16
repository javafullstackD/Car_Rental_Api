package com.example.car_rental.exception;

import com.example.car_rental.entity.Customer;

import java.util.List;

public class CustomerException extends Exception{

    private static final long serialVersionUID = -362688962640929130L;
    public CustomerException() {
    }

    public CustomerException(String message) {
        super(message);
    }
    public static boolean checkIfListEmpty(List<Customer> allCustomers) {
        if (allCustomers.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean checkIfCustomerExist(List<Customer> allCustomers, String customerDlNum) {
        boolean customerExists = allCustomers.stream().filter(s -> s.getCustomerDlNum().equals(customerDlNum)).findFirst().isPresent();
        return customerExists;
    }
}
