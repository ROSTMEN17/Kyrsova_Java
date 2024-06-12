package com.example.demo;

import com.example.demo.model.Income;
import com.example.demo.repository.IncomeRepository;
import com.example.demo.service.IncomeService;
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

public class IncomeServiceTest {

    @Mock
    private IncomeRepository incomeRepository;

    @InjectMocks
    private IncomeService incomeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddIncome() {
        // Arrange
        Income income = new Income("1", 5000.0);
        when(incomeRepository.save(income)).thenReturn(income);

        // Act
        Income result = incomeService.addIncome(income);

        // Assert
        assertEquals(income, result);
    }

    @Test
    void testUpdateIncome() {
        // Arrange
        String id = "1";
        Income existingIncome = new Income(id, 5000.0);
        Income updatedIncome = new Income(id, 6000.0);
        when(incomeRepository.findById(id)).thenReturn(Optional.of(existingIncome));
        when(incomeRepository.save(existingIncome)).thenReturn(updatedIncome);

        // Act
        Income result = incomeService.updateIncome(id, updatedIncome);

        // Assert
        assertEquals(updatedIncome, result);
        assertEquals(updatedIncome.getAmount(), existingIncome.getAmount());
    }

    @Test
    void testDeleteIncome() {
        // Arrange
        String id = "1";

        // Act
        incomeService.deleteIncome(id);

        // Assert
        verify(incomeRepository, times(1)).deleteById(id);
    }

    @Test
    void testGetAllIncomes() {
        // Arrange
        List<Income> incomes = new ArrayList<>();
        incomes.add(new Income("1", 5000.0));
        incomes.add(new Income("2", 6000.0));
        when(incomeRepository.findAll()).thenReturn(incomes);

        // Act
        List<Income> result = incomeService.getAllIncomes();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    void testGetIncomeById() {
        // Arrange
        String id = "1";
        Income income = new Income(id, 5000.0);
        when(incomeRepository.findById(id)).thenReturn(Optional.of(income));

        // Act
        Optional<Income> result = incomeService.getIncomeById(id);

        // Assert
        assertEquals(income, result.orElse(null));
    }
}
