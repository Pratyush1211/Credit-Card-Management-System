package com.citi.creditcard;

import com.citi.creditcard.dto.MerchantInfoDTO;
import com.citi.creditcard.entity.Transaction;
import com.citi.creditcard.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "spring.main.allow-bean-definition-overriding=true") // Needed to override the mocked bean
public class TransactionControllerTest {



    private String baseUrl;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private TransactionService transactionService;

    @BeforeEach
    public void setUp() {
        baseUrl = "http://localhost:8080" + "/api/transactions/";
    }

    @Test
    public void testGetMerchantInfo_AllMerchants() {
        List<String> expectedMerchants = new ArrayList<>();
        expectedMerchants.add("Merchant1");
        expectedMerchants.add("Merchant2");
        when(transactionService.getAllDistinctMerchants()).thenReturn(expectedMerchants);

        ResponseEntity<Object> response = restTemplate.getForEntity(baseUrl + "merchants", Object.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        // You may want to further validate the response's structure and contents
    }

    @Test
    public void testGetMerchantInfo_SpecificMerchant() {
        String merchantName = "Merchant1";
        MerchantInfoDTO merchantInfoDTO = new MerchantInfoDTO();
        when(transactionService.getTotalAmountByMerchant(merchantName)).thenReturn(merchantInfoDTO);

        ResponseEntity<Object> response = restTemplate.getForEntity(baseUrl + "merchants?merchant=" + merchantName, Object.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

    }
    @Test
    public void testGetTransactionsByMerchantWithPagination() {
        String merchantName = "Bahringer-Larson";
        int page = 0;
        int size = 10;

        List<Transaction> expectedTransactions = new ArrayList<>();
        // Add your expected transactions here

        PageRequest pageable2 = PageRequest.of(page, size);
        Page<Transaction> pageTransaction = new PageImpl<>(expectedTransactions, pageable2, expectedTransactions.size());

        when(transactionService.getAllByMerchant(merchantName, pageable2)).thenReturn(pageTransaction);

        ResponseEntity<Object> response = restTemplate.getForEntity(baseUrl + "by-merchant/" + merchantName +
                "?page=" + page + "&size=" + size, Object.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

    }
    @Test
    public void testGetTransactionBySpendingAmt() {
        double low = 10.00;
        double high = 40.00;

        List<Transaction> expectedTransactions = new ArrayList<>();


        when(transactionService.getAllBySpendingAmount(low, high)).thenReturn(expectedTransactions);

        ResponseEntity<Object> response = restTemplate.getForEntity(baseUrl + "/spending?low=" + low + "&high=" + high, Object.class);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertNotNull(response.getBody());

    }
    @Test
    public void testGetCityInfo() {
        String city = "New York";

        List<String> expectedCities = new ArrayList<>();
        // Add your expected cities here

        when(transactionService.getAllDistinctCity()).thenReturn(expectedCities);

        ResponseEntity<Object> response = restTemplate.getForEntity(baseUrl + "cities", Object.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

    }

    @Test
    public void testGetTransactionsByCityWithPagination() {
        String city = "Achille";
        int page = 0;
        int size = 10;

        List<Transaction> expectedTransactions = new ArrayList<>();
        // Add your expected transactions here

        PageRequest pageable = PageRequest.of(page, size);
        PageImpl<Transaction> pageTransaction = new PageImpl<>(expectedTransactions, pageable, expectedTransactions.size());

        when(transactionService.getAllByCity(city, pageable)).thenReturn(pageTransaction);

        ResponseEntity<Object> response = restTemplate.getForEntity(baseUrl + "by-cities/" + city +
                "?page=" + page + "&size=" + size, Object.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

    }
    @Test
    public void testGetTransactionsByStatesWithPagination() {
        String state = "OK";
        int page = 0;
        int size = 10;

        List<Transaction> expectedTransactions = new ArrayList<>();
        // Add your expected transactions here

        PageRequest pageable = PageRequest.of(page, size);
        PageImpl<Transaction> pageTransaction = new PageImpl<>(expectedTransactions, pageable, expectedTransactions.size());

        when(transactionService.getAllByState(state, pageable)).thenReturn(pageTransaction);

        ResponseEntity<Object> response = restTemplate.getForEntity(baseUrl + "by-states/" + state +
                "?page=" + page + "&size=" + size, Object.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        // You may want to further validate the response's structure and contents
    }

    @Test
    public void testGetTransactionsByGenderWithPagination() {
        String gender = "M";
        int page = 0;
        int size = 10;

        List<Transaction> expectedTransactions = new ArrayList<>();
        // Add your expected transactions here

        PageRequest pageable = PageRequest.of(page, size);
        PageImpl<Transaction> pageTransaction = new PageImpl<>(expectedTransactions, pageable, expectedTransactions.size());

        when(transactionService.getAllByGender(gender, pageable)).thenReturn(pageTransaction);

        ResponseEntity<Object> response = restTemplate.getForEntity(baseUrl + "by-gender/" + gender +
                "?page=" + page + "&size=" + size, Object.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        // You may want to further validate the response's structure and contents
    }
    @Test
    public void testGetStates() {
        List<String> expectedStates = new ArrayList<>();
        // Add your expected states here

        when(transactionService.getAllDistinctStates()).thenReturn(expectedStates);

        ResponseEntity<Object> response = restTemplate.getForEntity(baseUrl + "states", Object.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        // You may want to further validate the response's structure and contents
    }

    @Test
    public void testGetSpendingCategories() {
        List<String> expectedCategories = new ArrayList<>();
        // Add your expected categories here

        when(transactionService.getAllDistinctSpendingCategories()).thenReturn(expectedCategories);

        ResponseEntity<Object> response = restTemplate.getForEntity(baseUrl + "categories", Object.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }


}
