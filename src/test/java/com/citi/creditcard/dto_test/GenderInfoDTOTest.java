package com.citi.creditcard.dto_test;
//package com.citi.creditcard.dto;
import com.citi.creditcard.dto.GenderInfoDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenderInfoDTOTest {

    @Test
    public void testGenderInfoDTO() {
        // Create a sample GenderInfoDTO
        GenderInfoDTO genderInfoDTO = new GenderInfoDTO();
        genderInfoDTO.setGender("Male");
        genderInfoDTO.setTotal_amount(1500.0);
        genderInfoDTO.setTransactionCount(15);

        // Verify the values
        assertEquals("Male", genderInfoDTO.getGender());
        assertEquals(1500.0, genderInfoDTO.getTotal_amount(), 0.01); // The third parameter is the delta for double comparison
        assertEquals(15, genderInfoDTO.getTransactionCount());
    }
}

