package com.hana.bank.controller;

import com.hana.bank.model.Account;
import com.hana.bank.model.AccountTransaction;
import com.hana.bank.model.Card;
import com.hana.bank.model.CardTransaction;
import com.hana.bank.service.AccountService;
import com.hana.bank.service.AccountTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bank")
@RestController
@RequiredArgsConstructor
public class BankController {
    private final AccountService accountService;
    private final AccountTransactionService accountTransactionService;

    @GetMapping("/account/all")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/account/{accNum}")
    public Account getAccountByAccNum(@PathVariable String accNum) {
        return accountService.getAccountByAccNum(accNum);
    }

    @GetMapping("/transaction/{accNum}")
    public List<AccountTransaction> getAllAccountTransactionsByAccNum(@PathVariable String accNum) {
        return accountTransactionService.getAllAccountTransactionsByAccNum(accNum);
    }

    @PostMapping("/account/register")
    public ResponseEntity<String> registerAccount(@RequestBody String userID) {
        accountService.registerAccount(userID);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @GetMapping("/accountNum/{user_id}")
    public Account getAccountByID(@PathVariable String user_id) {
        return accountService.getAccountByUserID(user_id);
    }
}
