package com.citi.creditcard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CreditcardApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreditcardApplication.class);


	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(CreditcardApplication.class, args);

	}

}
