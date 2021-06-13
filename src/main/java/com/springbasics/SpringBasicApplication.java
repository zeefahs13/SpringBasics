package com.springbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springbasics.beancreation.Address;
import com.springbasics.beancreation.Customer;

@SpringBootApplication
public class SpringBasicApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context =	SpringApplication.run(SpringBasicApplication.class, args);
	Customer c = context.getBean(Customer.class);
	c.toString();
	}

}
