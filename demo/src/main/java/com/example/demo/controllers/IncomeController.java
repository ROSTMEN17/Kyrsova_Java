package com.example.demo.controllers;

import com.example.demo.model.Income;
import com.example.demo.service.IncomeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incomes")
@Tag(name = "Дохід", description = "API для операцій з доходами")
public class IncomeController {

    private final IncomeService incomeService;

    @Autowired
    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping
    @Operation(summary = "Отримуйте всі доходи", description = "Отримати список усіх доходів")
    public ResponseEntity<List<Income>> getAllIncomes() {
        List<Income> incomes = incomeService.getAllIncomes();
        return new ResponseEntity<>(incomes, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Додати новий дохід", description = "Створіть новий запис про дохід")
    public ResponseEntity<Income> addIncome(@RequestBody Income income) {
        Income newIncome = incomeService.addIncome(income);
        return new ResponseEntity<>(newIncome, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Оновити дохід", description = "Оновлення існуючого запису про дохід")
    public ResponseEntity<Income> updateIncome(
            @Parameter(description = "Income ID to update", required = true)
            @PathVariable String id,
            @RequestBody Income income) {
        Income updatedIncome = incomeService.updateIncome(id, income);
        return new ResponseEntity<>(updatedIncome, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Видалити дохід", description = "Видалення запису про дохід")
    public ResponseEntity<Void> deleteIncome(
            @Parameter(description = "Income ID to delete", required = true)
            @PathVariable String id) {
        incomeService.deleteIncome(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

