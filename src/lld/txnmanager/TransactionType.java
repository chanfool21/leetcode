package lld.txnmanager;

public enum TransactionType {

    CREDIT("credit"), DEBIT("debit");
    String value;
    TransactionType(String value){
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
