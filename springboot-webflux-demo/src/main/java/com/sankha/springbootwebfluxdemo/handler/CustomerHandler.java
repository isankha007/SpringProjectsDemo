package com.sankha.springbootwebfluxdemo.handler;

import com.sankha.springbootwebfluxdemo.dao.CustomerDao;
import com.sankha.springbootwebfluxdemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {
    @Autowired
    private CustomerDao customerDao;

    public Mono<ServerResponse> loadCustomer(ServerRequest request){
         Flux<Customer> customersList = customerDao.getCustomersList();
         return ServerResponse.ok().body(customersList,Customer.class);
    }

    public Mono<ServerResponse> findCustomer(ServerRequest request){
        int custId=
                Integer.valueOf(request.pathVariable("input"));
         Mono<Customer> customerMono = customerDao.getCustomersList().filter(c -> c.getId() == custId).next();
//        customerDao.getCustomersList().filter(c->c.getId()==custId).take(1).single();
        return ServerResponse.ok().body(customerMono,Customer.class);
    }

    public Mono<ServerResponse> saveCustomer(ServerRequest request){
         Mono<Customer> customerMono = request.bodyToMono(Customer.class);
         Mono<String> saveResponse = customerMono.map(customerDao -> customerDao.
                getId() + ":" + customerDao.getName());
         return ServerResponse.ok().body(saveResponse,String.class);
    }
}
