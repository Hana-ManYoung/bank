package com.hana.bank.service;

import com.hana.bank.model.Account;
import com.hana.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    public Account getAccountByAccNum(String accNum) {
        return accountRepository.getAccountByAccNum(accNum);
    }

    public void registerAccount(String userID) {
        accountRepository.registerAccount(userID);
    }

    public Account getAccountByUserID(String userId) {
        return accountRepository.getAccountByID(userId);
    }
}
