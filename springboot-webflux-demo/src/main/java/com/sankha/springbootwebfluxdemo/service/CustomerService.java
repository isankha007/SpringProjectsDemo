package com.sankha.springbootwebfluxdemo.service;

import com.sankha.springbootwebfluxdemo.dao.CustomerDao;
import com.sankha.springbootwebfluxdemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadCustomer()  {
        long start= System.currentTimeMillis();
         List<Customer> customers = customerDao.getCustomers();
        long end= System.currentTimeMillis();
        System.out.println("Total time esplated "+(end-start));
        return customers;
    }

    public Flux<Customer> loadCustomerStream()  {
        long start= System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomersStream();
        long end= System.currentTimeMillis();
        System.out.println("Total time esplated "+(end-start));
        return customers;
    }

}
