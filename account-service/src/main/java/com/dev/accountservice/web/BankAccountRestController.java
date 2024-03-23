package com.dev.accountservice.web;

import com.dev.accountservice.client.CustomerRestClient;
import com.dev.accountservice.entities.BankAccount;
import com.dev.accountservice.model.Customer;
import com.dev.accountservice.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerClient;

    @GetMapping("/accounts")
    public List<BankAccount> accountList() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount accountById(@PathVariable String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerClient.getCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
