package com.example.demo;


import com.example.demo.model.Expense;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpenseTest {

    @Test
    void testExpenseConstructor() {
        // Arrange
        String id = "1";
        double amount = 100.0;
        String category = "Food";

        // Act
        Expense expense = new Expense(id, amount, category);

        // Assert
        assertEquals(id, expense.getId());
        assertEquals(amount, expense.getAmount());
        assertEquals(category, expense.getCategory());
    }

    @Test
    void testExpenseGettersAndSetters() {
        // Arrange
        Expense expense = new Expense();
        String id = "2";
        double amount = 200.0;
        String category = "Transport";

        // Act
        expense.setId(id);
        expense.setAmount(amount);
        expense.setCategory(category);

        // Assert
        assertEquals(id, expense.getId());
        assertEquals(amount, expense.getAmount());
        assertEquals(category, expense.getCategory());
    }
}

