package makemytrip.service;

import makemytrip.enums.ExpenseType;

import java.util.List;

public class ExpenseFactory {

    private ExpenseType getExpenseTypeFromInput(List<String> arg) throws Exception {
        if(arg.indexOf("EQUAL") != -1) {
            return ExpenseType.EQUAL;
        } else if(arg.indexOf("SHARE") != -1) {
            return ExpenseType.SHARE;
        } else if(arg.indexOf("EXACT") != -1) {
            return ExpenseType.EXACT;
        } else {
            System.out.println("Invalid expense type");
            throw new Exception("Invalid expense type");
        }
    }

    public ExpenseService getExpenseService(List<String> arg) throws Exception {
        try {
            ExpenseType expenseType = getExpenseTypeFromInput(arg);

            if (expenseType.equals(ExpenseType.EQUAL)) {
                return new EqualExpenseService();
            } else {
                return new ExpenseService();
            }
        } catch(Exception ex) {
            System.out.println("Skipping expense updation as got error while fetching expenseType from the input");
            throw ex;
        }
    }
}
