package com.citi.creditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CreditcardApplication {

	private static final Logger logger = LoggerFactory.getLogger(CreditcardApplication.class);

	/*public void doSomething() {
		logger.info("This is an info message");
		logger.debug("This is a debug message");
		logger.error("This is an error message");
	}*/
	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(CreditcardApplication.class, args);

	}

}
