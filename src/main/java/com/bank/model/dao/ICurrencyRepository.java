package com.bank.model.dao;

import com.bank.model.entity.Currency;
import com.bank.model.enums.CurrencyEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICurrencyRepository extends JpaRepository<Currency, Integer> {
    Currency findByCurrencyName(CurrencyEnum currencyName);
}
