package makemytrip.service;

import makemytrip.enums.ExpenseType;

import java.util.List;

public class EqualExpenseService extends ExpenseService{

    @Override
    public void addExpense(List<String> arg) {
        String userId = arg.get(0);
        Double amount = Double.parseDouble(arg.get(1));
        Integer partition = Integer.parseInt(arg.get(2));
        List<String> participantList = arg.subList(3, arg.indexOf("EQUAL"));

        Double eachAmount = amount / partition;
        for (String participantId : participantList) {
            if (balanceMap.containsKey(participantId)) {
                balanceMap.put(participantId, balanceMap.get(participantId) + eachAmount);
            } else {
                balanceMap.put(participantId, eachAmount);
            }
        }
    }
}
