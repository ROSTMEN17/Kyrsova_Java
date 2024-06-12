package com.example.demo.service;

import com.example.demo.model.Income;
import com.example.demo.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    @Autowired
    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public Income addIncome(Income income) {
        return incomeRepository.save(income);
    }

    public Income updateIncome(String id, Income updatedIncome) {
        Optional<Income> existingIncomeOptional = incomeRepository.findById(id);
        if (existingIncomeOptional.isPresent()) {
            Income existingIncome = existingIncomeOptional.get();
            existingIncome.setAmount(updatedIncome.getAmount());
            return incomeRepository.save(existingIncome);
        } else {
            return null;
        }
    }

    public void deleteIncome(String id) {
        incomeRepository.deleteById(id);
    }

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    public Optional<Income> getIncomeById(String id) {
        return incomeRepository.findById(id);
    }
}
