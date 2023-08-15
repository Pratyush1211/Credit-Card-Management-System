package com.citi.creditcard;

import com.citi.creditcard.entity.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionControllerTest {

    @Autowired
    TestRestTemplate template;
//
//    @Test
//    public void getTransactionByMerchant(){
//        ResponseEntity template.exchange("/api/transaction",
//                HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<Transaction>>() {
//        });
//    }
}
