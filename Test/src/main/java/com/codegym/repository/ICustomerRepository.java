package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);
    @Query(value = "select * from customer where customer_name like :name and flag = 1",
    countQuery = "select * from customer where customer_name like :name and flag = 1", nativeQuery = true)
    Page<Customer> findCustomerByName(String name, Pageable pageable);

    @Query(value = "select * from customer where customer_id = :id",nativeQuery=true)
    Customer findCustomerById(int id);

    @Transactional
    @Modifying
    @Query(value = "update customer set flag = 0 where customer_id = :id", nativeQuery = true)
    void deleteCustomerById (int id);
}
