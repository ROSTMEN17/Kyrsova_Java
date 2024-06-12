package com.example.demo.controllers;

import com.example.demo.model.ExpenseCategory;
import com.example.demo.service.ExpenseCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense-categories")
@Tag(name = "Категорії витрат", description = "API для операцій з категоріями витрат")
public class ExpenseCategoryController {

    private final ExpenseCategoryService expenseCategoryService;

    @Autowired
    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }

    @GetMapping
    @Operation(summary = "Отримайте всі категорії витрат", description = "Отримати список усіх категорій витрат")
    public ResponseEntity<List<ExpenseCategory>> getAllExpenseCategories() {
        List<ExpenseCategory> expenseCategories = expenseCategoryService.getAllExpenseCategories();
        return new ResponseEntity<>(expenseCategories, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Додайте нову категорію витрат", description = "Створіть нову категорію витрат")
    public ResponseEntity<ExpenseCategory> addExpenseCategory(@RequestBody ExpenseCategory expenseCategory) {
        ExpenseCategory newExpenseCategory = expenseCategoryService.addExpenseCategory(expenseCategory);
        return new ResponseEntity<>(newExpenseCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Оновлення категорії витрат", description = "Оновлення існуючої категорії витрат")
    public ResponseEntity<ExpenseCategory> updateExpenseCategory(
            @Parameter(description = "Expense category ID to update", required = true)
            @PathVariable String id,
            @RequestBody ExpenseCategory expenseCategory) {
        ExpenseCategory updatedExpenseCategory = expenseCategoryService.updateExpenseCategory(id, expenseCategory);
        return new ResponseEntity<>(updatedExpenseCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Видалити категорію витрат", description = "Видалити категорію витрат")
    public ResponseEntity<Void> deleteExpenseCategory(
            @Parameter(description = "Expense category ID to delete", required = true)
            @PathVariable String id) {
        expenseCategoryService.deleteExpenseCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
