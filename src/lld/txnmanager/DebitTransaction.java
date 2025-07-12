package lld.txnmanager;

public class DebitTransaction extends Transaction{
    DebitTransaction(String transactionId) {
        super(transactionId);
    }

    @Override
    TransactionResponse execute(Account account, Double amount) {
        if(account.amount < amount) {
            return new TransactionResponse("false");
        } else {
            account.amount -= amount;
            return new TransactionResponse(String.valueOf(account.amount));
        }
    }
}
