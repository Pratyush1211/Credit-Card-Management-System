package com.citi.creditcard;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.citi.creditcard.entity.Transaction;
import com.citi.creditcard.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
public class TransactionRepositoryTest {

    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp() {
        transactionRepository = mock(TransactionRepository.class);
    }

    @Test
    public void testFindDistinctCityValues() {
        List<String> expectedCities = new ArrayList<>();
        expectedCities.add("City1");
        expectedCities.add("City2");
        when(transactionRepository.findDistinctCityValues()).thenReturn(expectedCities);

        List<String> result = transactionRepository.findDistinctCityValues();

        assertEquals(expectedCities, result);
    }

    @Test
    public void testFindByCity() {
        String cityName = "City1";
        Pageable pageable = mock(Pageable.class);
        Page<Transaction> transactionsPage = mock(Page.class);
        when(transactionRepository.findByCity(cityName, pageable)).thenReturn(transactionsPage);

        Page<Transaction> result = transactionRepository.findByCity(cityName, pageable);

        assertEquals(transactionsPage, result);
    }

    @Test
    public void testFindDistinctStateValues() {
        List<String> expectedStates = new ArrayList<>();
        expectedStates.add("State1");
        expectedStates.add("State2");
        when(transactionRepository.findDistinctStateValues()).thenReturn(expectedStates);

        List<String> result = transactionRepository.findDistinctStateValues();

        assertEquals(expectedStates, result);
    }

    @Test
    public void testFindByState() {
        String stateName = "State1";
        Pageable pageable = mock(Pageable.class);
        Page<Transaction> transactionsPage = mock(Page.class);
        when(transactionRepository.findByState(stateName, pageable)).thenReturn(transactionsPage);

        Page<Transaction> result = transactionRepository.findByState(stateName, pageable);

        assertEquals(transactionsPage, result);
    }

    @Test
    public void testFindDistinctMerchantValues() {
        List<String> expectedMerchants = new ArrayList<>();
        expectedMerchants.add("Merchant1");
        expectedMerchants.add("Merchant2");
        when(transactionRepository.findDistinctMerchantValues()).thenReturn(expectedMerchants);

        List<String> result = transactionRepository.findDistinctMerchantValues();

        assertEquals(expectedMerchants, result);
    }

    @Test
    public void testFindByMerchant() {
        String merchantName = "Merchant1";
        Pageable pageable = mock(Pageable.class);
        Page<Transaction> transactionsPage = mock(Page.class);
        when(transactionRepository.findByMerchant(merchantName, pageable)).thenReturn(transactionsPage);

        Page<Transaction> result = transactionRepository.findByMerchant(merchantName, pageable);

        assertEquals(transactionsPage, result);
    }
}

