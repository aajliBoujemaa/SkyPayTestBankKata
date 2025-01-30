package org.boujemaa.bankkata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private int amount;
    private int balance;
    private LocalDate date;

    public Transaction(String type, int amount, int balance, LocalDate date) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.date = date;
    }

    public Transaction() {
    }
}
