package com.example.demo;

import com.example.demo.controllers.ExpenseCategoryController;
import com.example.demo.model.ExpenseCategory;
import com.example.demo.service.ExpenseCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ExpenseCategoryControllerTest {

    @Mock
    private ExpenseCategoryService expenseCategoryService;

    @InjectMocks
    private ExpenseCategoryController expenseCategoryController;

    private List<ExpenseCategory> mockExpenseCategories;

    @BeforeEach
    void setUp() {
        // Mocking some expense categories for testing
        mockExpenseCategories = new ArrayList<>();
        mockExpenseCategories.add(new ExpenseCategory("1", "Category 1"));
        mockExpenseCategories.add(new ExpenseCategory("2", "Category 2"));
    }

    @Test
    void testGetAllExpenseCategories() {
        // Arrange
        when(expenseCategoryService.getAllExpenseCategories()).thenReturn(mockExpenseCategories);

        // Act
        ResponseEntity<List<ExpenseCategory>> response = expenseCategoryController.getAllExpenseCategories();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockExpenseCategories, response.getBody());
        verify(expenseCategoryService, times(1)).getAllExpenseCategories();
    }

    @Test
    void testAddExpenseCategory() {
        // Arrange
        ExpenseCategory newExpenseCategory = new ExpenseCategory("3", "New Category");
        when(expenseCategoryService.addExpenseCategory(any(ExpenseCategory.class))).thenReturn(newExpenseCategory);

        // Act
        ResponseEntity<ExpenseCategory> response = expenseCategoryController.addExpenseCategory(newExpenseCategory);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newExpenseCategory, response.getBody());
        verify(expenseCategoryService, times(1)).addExpenseCategory(any(ExpenseCategory.class));
    }

    // Similarly, you can write tests for update and delete methods
}

