package com.hana.bank.service;

import com.hana.bank.dto.AccountTransactionWithCode;
import com.hana.bank.model.AccountTransaction;
import com.hana.bank.repository.AccountTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountTransactionService {
    private final AccountTransactionRepository accountTransactionRepository;
    public List<AccountTransaction> getAllAccountTransactionsByAccNum (String accNum) {
        return accountTransactionRepository.getAllAccountTransactionsByAccNum(accNum);
    }

    public List<AccountTransactionWithCode> getAllAccountTransactionByAccNumWithCode(String accNum) {
        return accountTransactionRepository.getAllAccountTransactionByAccNumWithCode(accNum);
    }
}
