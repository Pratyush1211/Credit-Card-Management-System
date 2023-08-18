package com.citi.creditcard.dto_test;

import com.citi.creditcard.dto.CategoryInfoDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryInfoDTOTest {

    @Test
    public void testCategoryInfoDTO() {
        // Create a sample CategoryInfoDTO
        CategoryInfoDTO categoryInfoDTO = new CategoryInfoDTO();
        categoryInfoDTO.setCategory("Groceries");
        categoryInfoDTO.setTotal_amount(500.0);
        categoryInfoDTO.setTransactionCount(20);

        // Verify the values
        assertEquals("Groceries", categoryInfoDTO.getCategory());
        assertEquals(500.0, categoryInfoDTO.getTotal_amount(), 0.01); // The third parameter is the delta for double comparison
        assertEquals(20, categoryInfoDTO.getTransactionCount());
    }
}

