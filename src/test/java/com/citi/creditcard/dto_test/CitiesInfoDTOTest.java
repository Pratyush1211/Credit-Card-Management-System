package com.citi.creditcard.dto_test;
import com.citi.creditcard.dto.CitiesInfoDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CitiesInfoDTOTest {

    @Test
    public void testCitiesInfoDTO() {
        // Create a sample CitiesInfoDTO
        CitiesInfoDTO citiesInfoDTO = new CitiesInfoDTO();
        citiesInfoDTO.setCity("New York");
        citiesInfoDTO.setTotal_amount(1500.0);
        citiesInfoDTO.setTransactionCount(10);

        // Verify the values
        assertEquals("New York", citiesInfoDTO.getCity());
        assertEquals(1500.0, citiesInfoDTO.getTotal_amount(), 0.01); // The third parameter is the delta for double comparison
        assertEquals(10, citiesInfoDTO.getTransactionCount());
    }
}

