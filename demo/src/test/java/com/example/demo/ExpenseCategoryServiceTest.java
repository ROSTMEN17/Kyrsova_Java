package com.example.demo;

import com.example.demo.model.ExpenseCategory;
import com.example.demo.repository.ExpenseCategoryRepository;
import com.example.demo.service.ExpenseCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ExpenseCategoryServiceTest {

    @Mock
    private ExpenseCategoryRepository expenseCategoryRepository;

    @InjectMocks
    private ExpenseCategoryService expenseCategoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllExpenseCategories() {
        // Arrange
        List<ExpenseCategory> categories = new ArrayList<>();
        categories.add(new ExpenseCategory("1", "Food", "Expenses related to food"));
        categories.add(new ExpenseCategory("2", "Transport", "Expenses related to transportation"));
        when(expenseCategoryRepository.findAll()).thenReturn(categories);

        // Act
        List<ExpenseCategory> result = expenseCategoryService.getAllExpenseCategories();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Food", result.get(0).getName());
        assertEquals("Transport", result.get(1).getName());
    }

    @Test
    void testGetExpenseCategoryById() {
        // Arrange
        ExpenseCategory category = new ExpenseCategory("1", "Food", "Expenses related to food");
        when(expenseCategoryRepository.findById("1")).thenReturn(Optional.of(category));

        // Act
        Optional<ExpenseCategory> result = expenseCategoryService.getExpenseCategoryById("1");

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Food", result.get().getName());
    }

    @Test
    void testAddExpenseCategory() {
        // Arrange
        ExpenseCategory category = new ExpenseCategory("1", "Food", "Expenses related to food");
        when(expenseCategoryRepository.save(category)).thenReturn(category);

        // Act
        ExpenseCategory result = expenseCategoryService.addExpenseCategory(category);

        // Assert
        assertEquals("Food", result.getName());
    }

    @Test
    void testUpdateExpenseCategory() {
        // Arrange
        ExpenseCategory category = new ExpenseCategory("1", "Food", "Expenses related to food");
        when(expenseCategoryRepository.existsById("1")).thenReturn(true);
        when(expenseCategoryRepository.save(category)).thenReturn(category);

        // Act
        ExpenseCategory result = expenseCategoryService.updateExpenseCategory("1", category);

        // Assert
        assertEquals("Food", result.getName());
    }

    @Test
    void testDeleteExpenseCategory() {
        // Arrange
        String categoryId = "1";

        // Act
        expenseCategoryService.deleteExpenseCategory(categoryId);

        // Assert
        verify(expenseCategoryRepository, times(1)).deleteById(categoryId);
    }
}
