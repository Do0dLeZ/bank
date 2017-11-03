package com.bank.services.impl;

import com.bank.model.dao.IAccountRepository;
import com.bank.model.dao.ICurrencyRateRepository;
import com.bank.model.dao.ICurrencyRepository;
import com.bank.model.entity.Account;
import com.bank.model.entity.CustomUser;
import com.bank.model.enums.CurrencyEnum;
import com.bank.model.exceptions.NotEnoughCreditsException;
import com.bank.services.interfaces.IClientService;
import com.bank.security.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IUserService userService;

    @Autowired
    private ICurrencyRepository currencyRepository;

    @Autowired
    private ICurrencyRateRepository currencyRateRepository;

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    @Transactional(readOnly = true)
    public Double getTotalMoneyCountInCurrency(CurrencyEnum currencyEnum) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUser client = userService.getUserByLogin(user.getUsername());

        double count = 0;

        for (Account account : client.getAccounts()) {
            if (account.getCurrency().getCurrencyName() == currencyEnum)
                count += account.getValue();
            else {
                //Можно сделать синглтон для обновления курса валют, что бы за каждым запросом не таскаться по базе, а
                //санглтон раз в какоето время обновлял данные, ну или как-то так
                count += convertAccValue(account, currencyEnum);
            }
        }

        return count;
    }

    @Override
    @Transactional
    public void refillAccount(Account account, Double value) {
        account.setValue(account.getValue() + value);
    }

    @Override
    public void transferFromAccToAcc(Account fromAcc, Account toAccount, Double value) {
        if (fromAcc.getValue() - value < 0) {
            throw new NotEnoughCreditsException();
        } else {
            fromAcc.setValue(fromAcc.getValue() - value);
            if (toAccount.getCurrency() != fromAcc.getCurrency()) {

                toAccount.setValue( toAccount.getValue() +
                                    convertAccValue(fromAcc, toAccount.getCurrency().getCurrencyName()));

            } else toAccount.setValue(toAccount.getValue() - value);
        }
    }

    @Override
    public void transferToClientAccount(Account fromAccount, int accountId, double value) {
        transferFromAccToAcc(fromAccount, accountRepository.findOne(accountId), value);
    }

    @Override
    public Double convertAccValue(Account account, CurrencyEnum to) {
        return account.getValue() * currencyRateRepository.findCurrencyValueToday(
                account.getCurrency(),
                currencyRepository.findByCurrencyName(to));
    }
}
