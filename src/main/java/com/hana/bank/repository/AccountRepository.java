package com.hana.bank.repository;

import com.hana.bank.dto.AccountDTO;
import com.hana.bank.dto.RewardRequestDTO;
import com.hana.bank.model.Account;
import com.hana.bank.model.Card;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountRepository {
    private final SqlSessionTemplate sql;
    public List<Account> getAllAccounts() {
        return sql.selectList("Account.getAllAccounts");
    }

    public Account getAccountByAccNum(String accNum) {
        return (Account) sql.selectList("Account.getAccountByAccNum", accNum).get(0);
    }

    public void registerAccount(String userID) {
        Account account = new Account(userID, "AT_01");
        sql.insert("Account.registerAccount", account);
        sql.insert("Account.registerAccount", new Account(userID, "AT_02"));
        sql.insert("Account.registerAccount", new Account(userID, "AT_03"));
        Card card = new Card(account.getAcc_num());
        sql.insert("Card.registerCard", card);
    }

    public List<Account> getAccountByID(String userId) {
        return sql.selectList("Account.getAccountByID", userId);
    }

    public AccountDTO getChallengeAccount(String user_id) {
        return (AccountDTO) sql.selectList("Account.getChallengeAccount", user_id).get(0);
    }

    public void updateReward(RewardRequestDTO rewardRequestDTO) {
        sql.update("Account.updateReward", rewardRequestDTO);
    }
}
