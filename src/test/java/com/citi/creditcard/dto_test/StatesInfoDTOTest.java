package com.citi.creditcard.dto_test;

//package com.citi.creditcard.dto;

import com.citi.creditcard.dto.StatesInfoDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatesInfoDTOTest {

    @Test
    public void testStatesInfoDTO() {
        // Create a sample StatesInfoDTO
        StatesInfoDTO statesInfoDTO = new StatesInfoDTO();
        statesInfoDTO.setState("New York");
        statesInfoDTO.setTotal_amount(2000.0);
        statesInfoDTO.setTransactionCount(20);

        // Verify the values
        assertEquals("New York", statesInfoDTO.getState());
        assertEquals(2000.0, statesInfoDTO.getTotal_amount(), 0.01); // The third parameter is the delta for double comparison
        assertEquals(20, statesInfoDTO.getTransactionCount());
    }
}

