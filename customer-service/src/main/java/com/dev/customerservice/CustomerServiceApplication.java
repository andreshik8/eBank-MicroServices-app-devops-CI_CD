package com.dev.customerservice;

import com.dev.customerservice.config.GlobalConfig;
import com.dev.customerservice.entities.Customer;
import com.dev.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> customers = List.of(
					Customer.builder()
							.fullName("hamza1")
							.email("hamza1@gmail.com")
							.build(),
					Customer.builder()
							.fullName("hamza2")
							.email("hamza2@gmail.com")
							.build()
			);
			customerRepository.saveAll(customers);

		};
	}
}
