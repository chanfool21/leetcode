package lld.txnmanager;

public class CreditTransaction extends Transaction{
    CreditTransaction(String transactionId) {
        super(transactionId);
    }

    @Override
    TransactionResponse execute(Account account, Double amount) {
        account.amount += amount;
        return new TransactionResponse(String.valueOf(account.amount));
    }
}
