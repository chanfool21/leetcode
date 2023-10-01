package makemytrip.models;

public class Balance {
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    String userId;
    Double amount;

    public Balance(String userId, Double amount) {
        this.userId = userId;
        this.amount = amount;
    }
}
