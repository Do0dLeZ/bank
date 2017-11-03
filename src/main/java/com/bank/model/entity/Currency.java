package com.bank.model.entity;

import com.bank.model.enums.CurrencyEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private CurrencyEnum currencyName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "currency_code", nullable = false)
    private Integer currencyCode;

    @OneToMany(mappedBy = "from", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CurrencyRate> rates = new ArrayList<>();

    @OneToMany(mappedBy = "currency", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "to", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CurrencyRate> ratesTo = new ArrayList<>();

    public Currency() {
    }

    public void addRate(CurrencyRate rate){
        rate.setFrom(this);
        rates.add(rate);
    }

    public void addAccount(Account account){
        account.setCurrency(this);
        accounts.add(account);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CurrencyEnum getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(CurrencyEnum currencyName) {
        this.currencyName = currencyName;
    }

    public Integer getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(Integer currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<CurrencyRate> getRates() {
        return rates;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
