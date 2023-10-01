package makemytrip.service;

import makemytrip.models.Balance;

import java.util.List;

public interface SplitPaymentService {
    void addExpense(List<String> arg) throws Exception;
    Balance getBalance(String userId);
    List<Balance> getBalancesForAllUsers();
}
