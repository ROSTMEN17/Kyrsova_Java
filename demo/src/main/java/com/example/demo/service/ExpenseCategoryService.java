package com.example.demo.service;

import com.example.demo.model.ExpenseCategory;
import com.example.demo.repository.ExpenseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseCategoryService {

    private final ExpenseCategoryRepository expenseCategoryRepository;

    @Autowired
    public ExpenseCategoryService(ExpenseCategoryRepository expenseCategoryRepository) {
        this.expenseCategoryRepository = expenseCategoryRepository;
    }

    public List<ExpenseCategory> getAllExpenseCategories() {
        return expenseCategoryRepository.findAll();
    }

    public Optional<ExpenseCategory> getExpenseCategoryById(String id) {
        return expenseCategoryRepository.findById(id);
    }

    public ExpenseCategory addExpenseCategory(ExpenseCategory expenseCategory) {
        return expenseCategoryRepository.save(expenseCategory);
    }

    public ExpenseCategory updateExpenseCategory(String id, ExpenseCategory expenseCategory) {
        if (expenseCategoryRepository.existsById(id)) {
            return expenseCategoryRepository.save(expenseCategory);
        } else {
            return null; // or throw exception
        }
    }

    public void deleteExpenseCategory(String id) {
        expenseCategoryRepository.deleteById(id);
    }
}
