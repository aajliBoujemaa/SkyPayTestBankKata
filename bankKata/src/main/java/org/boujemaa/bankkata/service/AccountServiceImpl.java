package org.boujemaa.bankkata.service;

import org.boujemaa.bankkata.model.Transaction;
import org.boujemaa.bankkata.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private int balance;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant du dépôt doit être positif.");
        }
        balance += amount;
        transactionRepository.save(new Transaction("dépôt", amount, balance, LocalDate.now()));
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant du retrait doit être positif.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Fonds insuffisants pour ce retrait.");
        }
        balance -= amount;
        transactionRepository.save(new Transaction("retrait", -amount, balance, LocalDate.now()));
    }

    @Override
    public void printStatement() {
        List<Transaction> transactions = transactionRepository.findAll();
        System.out.println("Date       | Type     | Montant | Solde");
        System.out.println("----------------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
    public List<Transaction> getStatement() {
        return transactionRepository.findAll();
    }
}