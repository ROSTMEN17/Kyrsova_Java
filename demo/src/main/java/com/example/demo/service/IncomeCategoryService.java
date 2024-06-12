package com.example.demo.service;

import com.example.demo.model.IncomeCategory;
import com.example.demo.repository.IncomeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeCategoryService {

    private final IncomeCategoryRepository incomeCategoryRepository;

    @Autowired
    public IncomeCategoryService(IncomeCategoryRepository incomeCategoryRepository) {
        this.incomeCategoryRepository = incomeCategoryRepository;
    }

    // Додавання категорії доходів
    public IncomeCategory addIncomeCategory(IncomeCategory incomeCategory) {
        return incomeCategoryRepository.save(incomeCategory);
    }

    // Оновлення категорії доходів
    public IncomeCategory updateIncomeCategory(String id, IncomeCategory updatedIncomeCategory) {
        Optional<IncomeCategory> existingIncomeCategoryOptional = incomeCategoryRepository.findById(id);
        if (existingIncomeCategoryOptional.isPresent()) {
            IncomeCategory existingIncomeCategory = existingIncomeCategoryOptional.get();
            // Оновлюємо дані категорії доходів
            existingIncomeCategory.setName(updatedIncomeCategory.getName());
            existingIncomeCategory.setDescription(updatedIncomeCategory.getDescription());
            // Зберігаємо оновлену категорію доходів
            return incomeCategoryRepository.save(existingIncomeCategory);
        } else {
            // Якщо категорія доходів з таким ідентифікатором не знайдена, повертаємо null або генеруємо виняток
            return null;
        }
    }

    // Видалення категорії доходів за ідентифікатором
    public void deleteIncomeCategory(String id) {
        incomeCategoryRepository.deleteById(id);
    }

    // Отримання всіх категорій доходів
    public List<IncomeCategory> getAllIncomeCategories() {
        return incomeCategoryRepository.findAll();
    }

    // Отримання категорії доходів за ідентифікатором
    public Optional<IncomeCategory> getIncomeCategoryById(String id) {
        return incomeCategoryRepository.findById(id);
    }
}
