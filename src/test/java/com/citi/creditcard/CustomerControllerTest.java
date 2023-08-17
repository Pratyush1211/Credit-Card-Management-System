package com.citi.creditcard;

import com.citi.creditcard.entity.Customer;
import com.citi.creditcard.services.CustomerService;
import com.citi.creditcard.utility.SuccessResponseHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {
    private String baseUrl;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private CustomerService customerService;

    @BeforeEach
    public void setup() {
        baseUrl = "http://localhost:8080" + "/api/customers/";
    }

    @Test
    public void testGetCustomer() {
        Customer mockCustomer = new Customer();
        mockCustomer.setCustomerId(190);
        //mockCustomer.setFirstName("John");

        when(customerService.getCustomer(190)).thenReturn(mockCustomer);

        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:8080" + "/api/customers/190",
                String.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testAddCustomer() {
        Customer mockCustomer = new Customer();
        mockCustomer.setCustomerId(2);
        mockCustomer.setFirstName("Jane");

        /*when(customerService.addCustomer(any(Customer.class))).thenReturn(mockCustomer);

        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:8080" + "/api/customers",
                mockCustomer,
                String.class
        );

        assertEquals(HttpStatus.CREATED, response.getStatusCode());*/
        //Customer customerToAdd = new Customer(); // Create a sample customer to add

        // Mock the behavior of customerService.addCustomer()
        Customer addedCustomer = new Customer();
        addedCustomer.setCustomerId(2);

        // Create a sample added customer
        when(customerService.addCustomer(eq(addedCustomer))).thenReturn(mockCustomer);

        // Perform the POST request using TestRestTemplate
        ResponseEntity<Object> response = restTemplate.postForEntity("/api/customers", mockCustomer, Object.class);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());


    }

    @Test
    public void testDeleteCustomer() {
        Customer mockCustomer = new Customer();
        mockCustomer.setCustomerId(3);
        mockCustomer.setFirstName("Alice");

        when(customerService.deleteCustomer(3)).thenReturn(mockCustomer);

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8080" + "/api/customers/3",
                org.springframework.http.HttpMethod.DELETE,
                null,
                String.class
        );
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }




}
