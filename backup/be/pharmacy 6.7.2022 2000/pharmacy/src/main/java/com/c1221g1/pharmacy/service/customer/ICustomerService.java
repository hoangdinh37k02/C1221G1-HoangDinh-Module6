package com.c1221g1.pharmacy.service.customer;

import com.c1221g1.pharmacy.entity.customer.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function getRetailCustomer
     * */
    Customer getRetailCustomer();

    Page<Customer> findAllCustomer(Pageable pageable,
                                   String customerId,
                                   String customerName,
                                   String customerAddress,
                                   String customerPhone,
                                   String customerType);

    void deleteCustomer(String id);

    Customer findById(String id);

    /**
     *     Create by TruongNQ
     *     Time : 15:05 29/06/2022
     *     Function create customer
     */
    Customer save(Customer customer);



    /**
     *     Create by TruongNQ
     *     Time : 18:04 29/06/2022
     *     Function find by customer id
     */
    Customer findByCustomerId(String customerId);


    /**
     * Create by TruongNQ
     * Time : 20:23 29/06/2022
     * Function update customer
     */
    void updateCustomer(Customer customer);
}

