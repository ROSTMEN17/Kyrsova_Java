package com.example.demo.controllers;

import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    @Operation(summary = "Отримайте всі витрати", description = "Отримати список усіх витрат")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Додайте нову витрату", description = "Створіть новий запис про витрати")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Expense newExpense = expenseService.addExpense(expense);
        return new ResponseEntity<>(newExpense, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Оновити витрати", description = "Оновити існуючий запис про витрати")
    public ResponseEntity<Expense> updateExpense(
            @Parameter(description = "Expense ID to update", required = true)
            @PathVariable String id,
            @RequestBody Expense expense) {
        Expense updatedExpense = expenseService.updateExpense(id, expense);
        return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Видалити витрати", description = "Видалити запис про витрати")
    public ResponseEntity<Void> deleteExpense(
            @Parameter(description = "Expense ID to delete", required = true)
            @PathVariable String id) {
        expenseService.deleteExpense(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
