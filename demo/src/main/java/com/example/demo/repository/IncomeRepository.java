package com.example.demo.repository;

import com.example.demo.model.Income;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IncomeRepository extends MongoRepository<Income, String> {

    // Можна додати інші методи для пошуку за іншими критеріями, наприклад, за датою

}
