package com.bank.model.entity;

import com.bank.ERoles;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class CustomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private ERoles role;

    @Column(name = "name", nullable = false, length = 50)
    private String name = "";

    @Column(name = "surname", nullable = false, length = 50)
    private String surname = "";

    @Column(name = "day_of_birth")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date birthDay;

    @Column(name = "email", length = 75)
    private String email;

    @Column(name = "phone", length = 14)
    private String phoneNumber;

    @OneToMany(targetEntity = Account.class, mappedBy = "customUser", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(targetEntity = Transaction.class, mappedBy = "customUser", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    public CustomUser() {
    }

    public CustomUser(String login, String password, ERoles role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public void addAccount(Account account) {
        account.setCustomUser(this);
        accounts.add(account);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public ERoles getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(ERoles role) {
        this.role = role;
    }
}
