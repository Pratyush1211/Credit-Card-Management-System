package com.citi.creditcard.dto_test;

import com.citi.creditcard.dto.MerchantInfoDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MerchantInfoDTOTest {

    @Test
    public void testMerchantInfoDTO() {
        // Create a sample MerchantInfoDTO
        MerchantInfoDTO merchantInfoDTO = new MerchantInfoDTO();
        merchantInfoDTO.setMerchant("ABC Mart");
        merchantInfoDTO.setTotal_amount(2000.0);
        merchantInfoDTO.setTransactionCount(15);

        // Verify the values
        assertEquals("ABC Mart", merchantInfoDTO.getMerchant());
        assertEquals(2000.0, merchantInfoDTO.getTotal_amount(), 0.01); // The third parameter is the delta for double comparison
        assertEquals(15, merchantInfoDTO.getTransactionCount());
    }
}

