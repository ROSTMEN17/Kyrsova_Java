package com.example.demo;

import com.example.demo.controllers.IncomeCategoryController;
import com.example.demo.model.IncomeCategory;
import com.example.demo.service.IncomeCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class IncomeCategoryControllerTest {

    @Mock
    private IncomeCategoryService incomeCategoryService;

    @InjectMocks
    private IncomeCategoryController incomeCategoryController;

    private List<IncomeCategory> mockIncomeCategories;

    @BeforeEach
    void setUp() {
        // Ініціалізація моків
        MockitoAnnotations.openMocks(this);

        // Ініціалізація mockIncomeCategories для кожного тесту
        mockIncomeCategories = new ArrayList<>();
        mockIncomeCategories.add(new IncomeCategory("1", "Salary"));
        mockIncomeCategories.add(new IncomeCategory("2", "Investment"));
    }

    @Test
    void testGetAllIncomeCategories() {
        // Arrange
        when(incomeCategoryService.getAllIncomeCategories()).thenReturn(mockIncomeCategories);

        // Act
        ResponseEntity<List<IncomeCategory>> response = incomeCategoryController.getAllIncomeCategories();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockIncomeCategories, response.getBody());
        verify(incomeCategoryService, times(1)).getAllIncomeCategories();
    }

    @Test
    void testAddIncomeCategory() {
        // Arrange
        IncomeCategory newIncomeCategory = new IncomeCategory("3", "Freelancing");
        when(incomeCategoryService.addIncomeCategory(any(IncomeCategory.class))).thenReturn(newIncomeCategory);

        // Act
        ResponseEntity<IncomeCategory> response = incomeCategoryController.addIncomeCategory(newIncomeCategory);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newIncomeCategory, response.getBody());
        verify(incomeCategoryService, times(1)).addIncomeCategory(any(IncomeCategory.class));
    }
}
