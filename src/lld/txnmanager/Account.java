package lld.txnmanager;

public class Account {
    String id;
    String accountHolderName;
    Double amount;

    public Account(String id, String accountHolderName, Double amount) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
