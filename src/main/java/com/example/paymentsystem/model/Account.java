package com.example.paymentsystem.model;

import com.example.paymentsystem.model.enums.AccountType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_num")
    private Long accountNum;
    private BigDecimal balance;
    @Column(name = "account_type")
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;

    @ManyToOne(targetEntity = Client.class)
    private Client client;

    @OneToMany(targetEntity = Payment.class, mappedBy = "sourceAcc")
    private List<Payment> sourceAccounts = new ArrayList<>();

    @OneToMany(targetEntity = Payment.class, mappedBy = "destAcc")
    private List<Payment> destAccounts = new ArrayList<>();

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Long accountNum) {
        this.accountNum = accountNum;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Payment> getSourceAccounts() {
        return sourceAccounts;
    }

    public void setSourceAccounts(List<Payment> sourceAccounts) {
        this.sourceAccounts = sourceAccounts;
    }

    public List<Payment> getDestAccounts() {
        return destAccounts;
    }

    public void setDestAccounts(List<Payment> destAccounts) {
        this.destAccounts = destAccounts;
    }
}
