package com.hana.bank.repository;

import com.hana.bank.model.Card;
import com.hana.bank.model.CardTransaction;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CardTransactionRepository {
    private final SqlSessionTemplate sql;
    public List<CardTransaction> getAllCardTransactionsByCardNum(String cardNum) {
        return sql.selectList("CardTransaction.getAllCardTransactionsByCardNum", cardNum);
    }

}
