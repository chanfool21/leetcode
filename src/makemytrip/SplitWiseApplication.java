package makemytrip;

import makemytrip.models.Balance;
import makemytrip.models.User;
import makemytrip.service.SplitPaymentService;
import makemytrip.service.UserService;
import makemytrip.service.impl.SplitPaymentServiceImpl;
import makemytrip.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class SplitWiseApplication {


    public static void main(String[] args) throws Exception {
        User user1 = new User("123", "Chanchal1", 8604, "chan123mishra");
        User user2 = new User("1234", "Chanchal2", 8604, "chan123mishra");
        User user3 = new User("1235", "Chanchal3", 8604, "chan123mishra");
        UserService userService = new UserServiceImpl();
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);

        SplitPaymentService splitPaymentService = new SplitPaymentServiceImpl();
        List<String> arg = new ArrayList<>();
        arg.add("123");
        arg.add("750");
        arg.add("2");
        arg.add("1234");
        arg.add("1235");
        arg.add("EQUAL");
        splitPaymentService.addExpense(arg);
        List<Balance> allUserBalances = splitPaymentService.getBalancesForAllUsers();
        allUserBalances.forEach(userBalance -> {
            System.out.println(userBalance.getUserId() + ", " + userBalance.getAmount());
        });
    }
}
