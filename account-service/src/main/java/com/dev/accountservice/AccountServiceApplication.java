package com.dev.accountservice;

import com.dev.accountservice.entities.BankAccount;
import com.dev.accountservice.enums.AccountType;
import com.dev.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository) {
		return args -> {
			List<BankAccount> accountList = List.of(
					BankAccount.builder()
							.accountId(UUID.randomUUID().toString())
							.balance(10000)
							.currency("MAD")
							.createdAt(LocalDate.now())
							.type(AccountType.CURRENT_ACCOUNT)
							.customerId(Long.valueOf(1))
							.build(),
					BankAccount.builder()
							.accountId(UUID.randomUUID().toString())
							.balance(5000)
							.currency("USD")
							.createdAt(LocalDate.now())
							.type(AccountType.SAVING_ACCOUNT)
							.customerId(Long.valueOf(2))
							.build()
			);
			bankAccountRepository.saveAll(accountList);
		};
	}
}
