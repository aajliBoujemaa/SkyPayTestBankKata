package org.boujemaa.bankkata.controller;

import org.boujemaa.bankkata.model.Transaction;
import org.boujemaa.bankkata.service.AccountService;
import org.boujemaa.bankkata.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam int amount) {
        try {
            accountService.deposit(amount);
            return ResponseEntity.ok("Dépôt de " + amount + " effectué avec succès.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam int amount) {
        try {
            accountService.withdraw(amount);
            return ResponseEntity.ok("Retrait de " + amount + " effectué avec succès.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/statement")
    public List<Transaction> getStatement() {
        return accountService.getStatement();
    }
}