package com.example.demo;

import com.example.demo.controllers.ExpenseController;
import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;
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
class ExpenseControllerTest {

    @Mock
    private ExpenseService expenseService;

    @InjectMocks
    private ExpenseController expenseController;

    private List<Expense> mockExpenses;

    @BeforeEach
    void setUp() {
        // Mocking some expenses for testing
        mockExpenses = new ArrayList<>();
        mockExpenses.add(new Expense("1", 100.0, "Expense 1")); // Changed int to double
        mockExpenses.add(new Expense("2", 200.0, "Expense 2")); // Changed int to double
    }

    @Test
    void testGetAllExpenses() {
        // Arrange
        when(expenseService.getAllExpenses()).thenReturn(mockExpenses);

        // Act
        ResponseEntity<List<Expense>> response = expenseController.getAllExpenses();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockExpenses, response.getBody());
        verify(expenseService, times(1)).getAllExpenses();
    }

    @Test
    void testAddExpense() {
        // Arrange
        Expense newExpense = new Expense("3", 300.0, "New Expense"); // Changed int to double
        when(expenseService.addExpense(any(Expense.class))).thenReturn(newExpense);

        // Act
        ResponseEntity<Expense> response = expenseController.addExpense(newExpense);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newExpense, response.getBody());
        verify(expenseService, times(1)).addExpense(any(Expense.class));
    }

    // Similarly, you can write tests for update and delete methods
}


