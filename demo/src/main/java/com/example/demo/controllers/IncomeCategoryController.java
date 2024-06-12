package com.example.demo.controllers;

import com.example.demo.model.IncomeCategory;
import com.example.demo.service.IncomeCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/income-categories")
@Tag(name = "Категорії доходів", description = "API для операцій з категоріями доходів")
public class IncomeCategoryController {

    private final IncomeCategoryService incomeCategoryService;

    @Autowired
    public IncomeCategoryController(IncomeCategoryService incomeCategoryService) {
        this.incomeCategoryService = incomeCategoryService;
    }

    @GetMapping
    @Operation(summary = "Отримайте всі категорії доходів", description = "Отримати список всіх категорій доходів")
    public ResponseEntity<List<IncomeCategory>> getAllIncomeCategories() {
        List<IncomeCategory> incomeCategories = incomeCategoryService.getAllIncomeCategories();
        return new ResponseEntity<>(incomeCategories, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Додати нову категорію доходу", description = "Створіть нову категорію доходу")
    public ResponseEntity<IncomeCategory> addIncomeCategory(@RequestBody IncomeCategory incomeCategory) {
        IncomeCategory newIncomeCategory = incomeCategoryService.addIncomeCategory(incomeCategory);
        return new ResponseEntity<>(newIncomeCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Оновлення категорії доходу", description = "Оновлення існуючої категорії доходу")
    public ResponseEntity<IncomeCategory> updateIncomeCategory(
            @Parameter(description = "Income category ID to update", required = true)
            @PathVariable String id,
            @RequestBody IncomeCategory incomeCategory) {
        IncomeCategory updatedIncomeCategory = incomeCategoryService.updateIncomeCategory(id, incomeCategory);
        return new ResponseEntity<>(updatedIncomeCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Видалити категорію доходу", description = "Видалити категорію доходу")
    public ResponseEntity<Void> deleteIncomeCategory(
            @Parameter(description = "Income category ID to delete", required = true)
            @PathVariable String id) {
        incomeCategoryService.deleteIncomeCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
