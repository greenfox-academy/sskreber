package com.greenfoxacademy.bankofsimba.services;

import com.greenfoxacademy.bankofsimba.models.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface BankAccountService { //az arraylist feltöltése lesz a dolga

    void add(BankAccount bankAccount);

    ArrayList<BankAccount> getAllAccount();

    void createAccount();

    void increaseBalance(BankAccount currentAccount);
}
