package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> getAll(String nameVal, Pageable pageable);

    Customer findCustomerById(int id);

    void deleteCustomerById(int id);

    void save(Customer customer);

    void updateCustomer(Customer customer);
}
