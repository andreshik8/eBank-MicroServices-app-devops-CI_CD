package com.dev.accountservice.client;

import com.dev.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers")
    List<Customer> getAllCustomers();

    @GetMapping("/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);
}
