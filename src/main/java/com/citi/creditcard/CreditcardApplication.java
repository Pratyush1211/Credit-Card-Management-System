package com.citi.creditcard;

import com.citi.creditcard.services.TransactionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class CreditcardApplication {


	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(CreditcardApplication.class, args);

		TransactionService transactionService = applicationContext.getBean(TransactionService.class);



		System.out.println(transactionService.findByMerchant("Abbott-Rogahn"));


	}

}
