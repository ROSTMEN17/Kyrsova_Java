package com.example.demo;

import com.example.demo.model.IncomeCategory;
import com.example.demo.repository.IncomeCategoryRepository;
import com.example.demo.service.IncomeCategoryService;
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

public class IncomeCategoryServiceTest {

    @Mock
    private IncomeCategoryRepository incomeCategoryRepository;

    @InjectMocks
    private IncomeCategoryService incomeCategoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddIncomeCategory() {
        // Arrange
        IncomeCategory incomeCategory = new IncomeCategory("1", "Salary", "Regular salary income");
        when(incomeCategoryRepository.save(incomeCategory)).thenReturn(incomeCategory);

        // Act
        IncomeCategory result = incomeCategoryService.addIncomeCategory(incomeCategory);

        // Assert
        assertEquals(incomeCategory, result);
    }

    @Test
    void testUpdateIncomeCategory() {
        // Arrange
        String id = "1";
        IncomeCategory existingIncomeCategory = new IncomeCategory(id, "Salary", "Regular salary income");
        IncomeCategory updatedIncomeCategory = new IncomeCategory("1", "Bonus", "Extra income from bonus");
        when(incomeCategoryRepository.findById(id)).thenReturn(Optional.of(existingIncomeCategory));
        when(incomeCategoryRepository.save(existingIncomeCategory)).thenReturn(updatedIncomeCategory);

        // Act
        IncomeCategory result = incomeCategoryService.updateIncomeCategory(id, updatedIncomeCategory);

        // Assert
        assertEquals(updatedIncomeCategory, result);
        assertEquals(updatedIncomeCategory.getName(), existingIncomeCategory.getName());
        assertEquals(updatedIncomeCategory.getDescription(), existingIncomeCategory.getDescription());
    }

    @Test
    void testDeleteIncomeCategory() {
        // Arrange
        String id = "1";

        // Act
        incomeCategoryService.deleteIncomeCategory(id);

        // Assert
        verify(incomeCategoryRepository, times(1)).deleteById(id);
    }

    @Test
    void testGetAllIncomeCategories() {
        // Arrange
        List<IncomeCategory> incomeCategories = new ArrayList<>();
        incomeCategories.add(new IncomeCategory("1", "Salary", "Regular salary income"));
        incomeCategories.add(new IncomeCategory("2", "Bonus", "Extra income from bonus"));
        when(incomeCategoryRepository.findAll()).thenReturn(incomeCategories);

        // Act
        List<IncomeCategory> result = incomeCategoryService.getAllIncomeCategories();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    void testGetIncomeCategoryById() {
        // Arrange
        String id = "1";
        IncomeCategory incomeCategory = new IncomeCategory(id, "Salary", "Regular salary income");
        when(incomeCategoryRepository.findById(id)).thenReturn(Optional.of(incomeCategory));

        // Act
        Optional<IncomeCategory> result = incomeCategoryService.getIncomeCategoryById(id);

        // Assert
        assertEquals(incomeCategory, result.orElse(null));
    }
}
