package makemytrip.service;

import makemytrip.enums.ExpenseType;
import makemytrip.models.Balance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseService {

    Map<String, Double> balanceMap;

    public ExpenseService() {
        this.balanceMap = new HashMap<>();
    }

    public void addExpense(List<String> arg) {
        System.out.println("Added expense");
    }

    public Balance getBalance(String userId) {

        return new Balance(userId, balanceMap.get(userId));
    }

    public List<Balance> getBalanceForAllUser() {
        List<Balance> result = new ArrayList<>();
        for(Map.Entry<String, Double>entry : balanceMap.entrySet()) {
            result.add(new Balance(entry.getKey(), entry.getValue()));
        }

        return result;
    }
}
