package com.example.demo;

import com.example.demo.model.Expense;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.service.ExpenseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseService expenseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllExpenses() {
        // Arrange
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense("1", 100.0, "Food"));
        expenses.add(new Expense("2", 50.0, "Transport"));
        when(expenseRepository.findAll()).thenReturn(expenses);

        // Act
        List<Expense> result = expenseService.getAllExpenses();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    void testGetExpenseById() {
        // Arrange
        Expense expense = new Expense("1", 100.0, "Food");
        when(expenseRepository.findById("1")).thenReturn(Optional.of(expense));

        // Act
        Optional<Expense> result = expenseService.getExpenseById("1");

        // Assert
        assertEquals(expense, result.orElse(null));
    }

    @Test
    void testAddExpense() {
        // Arrange
        Expense expense = new Expense("1", 100.0, "Food");
        when(expenseRepository.save(expense)).thenReturn(expense);

        // Act
        Expense result = expenseService.addExpense(expense);

        // Assert
        assertEquals(expense, result);
    }

    @Test
    void testUpdateExpense() {
        // Arrange
        Expense expense = new Expense("1", 100.0, "Food");
        when(expenseRepository.existsById("1")).thenReturn(true);
        when(expenseRepository.save(expense)).thenReturn(expense);

        // Act
        Expense result = expenseService.updateExpense("1", expense);

        // Assert
        assertEquals(expense, result);
    }

    @Test
    void testDeleteExpense() {
        // Arrange
        String expenseId = "1";

        // Act
        expenseService.deleteExpense(expenseId);

        // Assert
        verify(expenseRepository, times(1)).deleteById(expenseId);
    }
}
