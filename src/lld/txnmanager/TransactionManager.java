package lld.txnmanager;

import java.util.*;

public class TransactionManager {
    Map<String, Account> accountIdToAccountMap;

    TransactionManager() {
        this.accountIdToAccountMap = new HashMap<>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> responseList = new ArrayList<>();
        TransactionManager txnManager = new TransactionManager();
        Map<String, Account> accountMap = txnManager.accountIdToAccountMap;
        while(true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Operations end");
                break;
            }

            String inputArray[] = input.split(" ");
            String transactionType = inputArray[0];
            Transaction transaction = null;
            String uniqueTxnId = UUID.randomUUID().toString();
            if(transactionType.equalsIgnoreCase(TransactionType.CREDIT.getValue())) {
                transaction = new CreditTransaction(uniqueTxnId);
            } else {
                transaction = new DebitTransaction(uniqueTxnId);
            }

            String accountId = inputArray[1];
            String transactionAmount = inputArray[2];
            Boolean newAccount = false;
            Account currentAccount = null;
            if(!accountMap.containsKey(accountId)) {
                newAccount = true;
                currentAccount = new Account(accountId, accountId, 0.0);
                accountMap.put(accountId, currentAccount);
            } else {
                currentAccount = accountMap.get(accountId);
            }

            TransactionResponse transactionResponse = transaction.execute(currentAccount, Double.valueOf(transactionAmount));

            if(transaction instanceof CreditTransaction && newAccount == true) {
                responseList.add("true");
            } else {
                responseList.add(transactionResponse.message);
            }

        }

        for(String responseMessage: responseList) {
            System.out.println(responseMessage);
        }
    }
}
