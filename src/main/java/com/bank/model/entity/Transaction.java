package com.bank.model.entity;

import com.bank.model.enums.AccountOperationEnum;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "value", nullable = false, scale = 2)
    private Double value;

    @Column(name = "notes", length = 400)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private CustomUser customUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_account_id", nullable = false)
    private Account account;

    @Column(name = "operation", nullable = false)
    private AccountOperationEnum operation;

    public Transaction() {
    }

    protected Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    protected Double getValue() {
        return value;
    }

    protected void setValue(Double value) {
        this.value = value;
    }

    protected String getNotes() {
        return notes;
    }

    protected void setNotes(String notes) {
        this.notes = notes;
    }
}
