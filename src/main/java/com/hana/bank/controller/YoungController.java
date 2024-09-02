package com.hana.bank.controller;

import com.hana.bank.dto.AccountCardDTO;
import com.hana.bank.dto.AccountTransactionWithCode;
import com.hana.bank.model.Account;
import com.hana.bank.model.AccountTransaction;
import com.hana.bank.model.Card;
import com.hana.bank.model.CardTransaction;
import com.hana.bank.service.AccountService;
import com.hana.bank.service.AccountTransactionService;
import com.hana.bank.service.CardService;
import com.hana.bank.service.CardTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class YoungController {
    private final AccountService accountService;
    private final AccountTransactionService accountTransactionService;
    private final CardService cardService;
    private final CardTransactionService cardTransactionService;

    @GetMapping("/profile/{user_id}")
    public AccountCardDTO getProfile(@PathVariable String user_id) {
        Account account = accountService.getAccountByUserID(user_id);
        Card card = cardService.getCardByAccNum(account.getAcc_num());
        List<AccountTransactionWithCode> accountTransactions = accountTransactionService.getAllAccountTransactionByAccNumWithCode(account.getAcc_num());
        List<CardTransaction> cardTransactions = cardTransactionService.getAllCardTransactionsByCardNum(card.getCard_num());
        return new AccountCardDTO(accountTransactions, account, cardTransactions, card);
    }
}
