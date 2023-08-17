package com.citi.creditcard;
import com.citi.creditcard.dto.CitiesInfoDTO;
import com.citi.creditcard.dto.MerchantInfoDTO;
import com.citi.creditcard.entity.Transaction;
import com.citi.creditcard.repository.TransactionDALMongoTemplate;
import com.citi.creditcard.repository.TransactionRepository;
import com.citi.creditcard.services.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionDALMongoTemplate transactionDALMongoTemplate;

    @InjectMocks
    private TransactionService transactionService;

    // ... Other fields and setup ...

    @Test
    public void testGetTotalAmountByCities() {
        String city = "City1";
        CitiesInfoDTO expectedCityInfo = new CitiesInfoDTO(); // Create your expected DTO

        when(transactionDALMongoTemplate.findCityTransactionDetails(city)).thenReturn(expectedCityInfo);

        CitiesInfoDTO citiesInfoDTO = transactionService.getTotalAmountByCities(city);

        assertEquals(expectedCityInfo, citiesInfoDTO);
    }


}
