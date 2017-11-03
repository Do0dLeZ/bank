package com.bank.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "currency_rate")
public class CurrencyRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_id", nullable = false)
    private Currency from;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_id", nullable = false)
    private Currency to;

    @Column(name = "at_time", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date atTime = new Date();

    @Column(name = "value", nullable = false, precision = 8, scale = 5)
    private Double value;

    public CurrencyRate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Currency getFrom() {
        return from;
    }

    public void setFrom(Currency from) {
        this.from = from;
    }

    public Currency getTo() {
        return to;
    }

    public void setTo(Currency to) {
        this.to = to;
    }

    public Date getAtTime() {
        return atTime;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void changeTime(Date time) {
        this.atTime = time;
    }
}
