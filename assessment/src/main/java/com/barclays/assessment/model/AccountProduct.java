package com.barclays.assessment.model;

import javax.persistence.*;
import java.math.BigDecimal;

/*Author : Atul Kumar*/

@Entity
@Table(name = "ACCOUNTPRODUCT")
public class AccountProduct {
    @Id
    @Column
    String accountNumber;
    @Column
    String accountType;
    @Column
    String productName;
    @Column
    String productType;
    @Column
    BigDecimal amount;


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
