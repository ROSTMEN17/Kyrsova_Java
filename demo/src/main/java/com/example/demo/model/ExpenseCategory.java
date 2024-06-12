package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "expense_categories")
public class ExpenseCategory {
    @Id
    private String id;
    private String name;
    private String description;

    public ExpenseCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }
}