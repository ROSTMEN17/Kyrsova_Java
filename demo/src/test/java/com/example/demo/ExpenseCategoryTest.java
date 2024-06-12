package com.example.demo;

import com.example.demo.model.ExpenseCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpenseCategoryTest {

    @Test
    void testExpenseCategoryConstructorWithParameters() {
        // Arrange
        String name = "Groceries";
        String description = "Expenses related to groceries";

        // Act
        ExpenseCategory expenseCategory = new ExpenseCategory(name, description);

        // Assert
        assertEquals(name, expenseCategory.getName());
        assertEquals(description, expenseCategory.getDescription());
    }

    @Test
    void testExpenseCategoryGettersAndSetters() {
        // Arrange
        ExpenseCategory expenseCategory = new ExpenseCategory();
        String id = "1";
        String name = "Transportation";
        String description = "Expenses related to transportation";

        // Act
        expenseCategory.setId(id);
        expenseCategory.setName(name);
        expenseCategory.setDescription(description);

        // Assert
        assertEquals(id, expenseCategory.getId());
        assertEquals(name, expenseCategory.getName());
        assertEquals(description, expenseCategory.getDescription());
    }
}
