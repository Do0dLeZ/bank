package com.bank.model.dao;

import com.bank.model.entity.Currency;
import com.bank.model.entity.CurrencyRate;
import com.bank.model.enums.CurrencyEnum;
import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface ICurrencyRateRepository extends JpaRepository<CurrencyRate, Integer> {
    @Query("SELECT c.value " +
            "FROM CurrencyRate c " +
            "WHERE c.from = :from AND c.to = :to " +
            "   AND c.atTime = (" +
            "       SELECT MAX(subc.atTime) " +
            "       FROM CurrencyRate subc " +
            "       WHERE subc.from = :from AND subc.to = :to)")
    Double findCurrencyValueToday(Currency from, Currency to);
}
