package com.example.demo;

import com.example.demo.model.Income;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncomeTest {

    @Test
    void testIncomeConstructor() {
        // Arrange
        String id = "1";
        double amount = 5000.0;

        // Act
        Income income = new Income(id, amount);

        // Assert
        assertEquals(id, income.getId());
        assertEquals(amount, income.getAmount());
    }

    @Test
    void testIncomeGettersAndSetters() {
        // Arrange
        Income income = new Income();
        String id = "2";
        double amount = 3000.0;

        // Act
        income.setId(id);
        income.setAmount(amount);

        // Assert
        assertEquals(id, income.getId());
        assertEquals(amount, income.getAmount());
    }
}
