package com.barclays.assessment.model;
import javax.persistence.*;

/*Author : Atul Kumar*/

@Entity
@Table(name="Account")
public class Account {
    @Id
    String accountId;
    @Column
    String accountType;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
