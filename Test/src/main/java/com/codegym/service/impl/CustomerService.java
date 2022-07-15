package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> getAll(String name, Pageable pageable) {
        return this.iCustomerRepository.findCustomerByName("%" + name + "%", pageable);
    }

    @Override
    public Customer findCustomerById(int id) {
        return this.iCustomerRepository.findCustomerById(id);
    }

    @Override
    public void deleteCustomerById(int id) {
        this.iCustomerRepository.deleteCustomerById(id);
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        this.iCustomerRepository.save(customer);
    }
}
