package com.example.demo;

import com.example.demo.model.IncomeCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncomeCategoryTest {

    @Test
    void testIncomeCategoryConstructorWithParameters() {
        // Arrange
        String name = "Salary";
        String description = "Regular income from salary";

        // Act
        IncomeCategory incomeCategory = new IncomeCategory(name, description);

        // Assert
        assertEquals(name, incomeCategory.getName());
        assertEquals(description, incomeCategory.getDescription());
    }

    @Test
    void testIncomeCategoryGettersAndSetters() {
        // Arrange
        IncomeCategory incomeCategory = new IncomeCategory();
        String id = "1";
        String name = "Bonus";
        String description = "Extra income from bonus";

        // Act
        incomeCategory.setId(id);
        incomeCategory.setName(name);
        incomeCategory.setDescription(description);

        // Assert
        assertEquals(id, incomeCategory.getId());
        assertEquals(name, incomeCategory.getName());
        assertEquals(description, incomeCategory.getDescription());
    }
}
