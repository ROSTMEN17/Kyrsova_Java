package com.example.demo.repository;

import com.example.demo.model.IncomeCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeCategoryRepository extends MongoRepository<IncomeCategory, String> {
    // Можна додати додаткові методи для роботи з даними про категорії доходів, якщо потрібно
}
