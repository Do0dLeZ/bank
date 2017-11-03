package com.bank.services.interfaces;

import com.bank.model.entity.Account;
import com.bank.model.entity.Currency;
import com.bank.model.enums.CurrencyEnum;

public interface IClientService {
    Double getTotalMoneyCountInCurrency(CurrencyEnum currencyEnum);

    void refillAccount(Account account, Double value);

    void transferFromAccToAcc(Account fromAcc, Account toAccount, Double value);

    void transferToClientAccount(Account fromAccount, int accountId, double value);

    Double convertAccValue(Account account, CurrencyEnum to);
}
