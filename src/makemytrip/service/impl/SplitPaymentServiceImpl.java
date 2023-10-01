package makemytrip.service.impl;

import makemytrip.enums.ExpenseType;
import makemytrip.models.Balance;
import makemytrip.service.ExpenseFactory;
import makemytrip.service.ExpenseService;
import makemytrip.service.SplitPaymentService;

import java.util.List;

public class SplitPaymentServiceImpl implements SplitPaymentService {

    ExpenseService defaultExpenseService;
    ExpenseFactory expenseFactory;
    public SplitPaymentServiceImpl() {
        expenseFactory = new ExpenseFactory();
    }

    @Override
    public void addExpense(List<String> arg) throws Exception {
        defaultExpenseService = expenseFactory.getExpenseService(arg);
        defaultExpenseService.addExpense(arg);
    }

    @Override
    public Balance getBalance(String userId) {
        return defaultExpenseService.getBalance(userId);
    }

    @Override
    public List<Balance> getBalancesForAllUsers() {
        return defaultExpenseService.getBalanceForAllUser();
    }

}



