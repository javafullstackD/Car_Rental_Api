package com.example.car_rental.service;

import com.example.car_rental.entity.Customer;
import com.example.car_rental.exception.CustomerException;
import com.example.car_rental.exception.InputEmptyException;

import java.util.List;

public interface CustomerServiceInterface {

    public Customer addCustomer(Customer customer) throws InputEmptyException;

    public List<Customer> viewAllCustomers() throws CustomerException;

    public Customer getCustomerByDlNum(String dlNum) throws CustomerException;

    public void deleteCustomer(String customerDlNum) throws CustomerException;

    public Customer updateCustomer(String customerDlNum, Customer customer) throws CustomerException ;


}

