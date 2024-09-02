package com.hana.bank.repository;

import com.hana.bank.dto.AccountTransactionWithCode;
import com.hana.bank.model.AccountTransaction;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountTransactionRepository {
    private final SqlSessionTemplate sql;
    public List<AccountTransaction> getAllAccountTransactionsByAccNum(String accNum) {
        return sql.selectList("AccountTransaction.getAllAccountTransactionsByAccNum", accNum);
    }

    public List<AccountTransactionWithCode> getAllAccountTransactionByAccNumWithCode(String accNum) {
        return sql.selectList("AccountTransaction.getAllAccountTransactionByAccNumWithCode", accNum);
    }
}
