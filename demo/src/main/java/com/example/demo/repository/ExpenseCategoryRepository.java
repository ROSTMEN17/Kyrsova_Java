package com.example.demo.repository;

import com.example.demo.model.ExpenseCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseCategoryRepository extends MongoRepository<ExpenseCategory, String> {

}
