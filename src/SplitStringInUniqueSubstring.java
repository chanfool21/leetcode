import java.util.HashSet;

public class SplitStringInUniqueSubstring {

    int fnc(int index, String str, HashSet<String> set, String currenString) {
        if (index == str.length()) {
            return 0;
        } else {
            int res1 = Integer.MIN_VALUE/2, res2= Integer.MIN_VALUE/2;
            currenString += str.charAt(index);
            if (!set.contains(currenString)) {
                set.add(currenString);
                res1 = 1 + fnc(index + 1, str, set, "");
                set.remove(currenString);
            }
            res2 = fnc(index + 1, str, set, currenString);
            return Math.max(res1, res2);
        }
    }
    public int maxUniqueSplit(String s) {
        return fnc(0, s, new HashSet<>(), "");
    }
    public static void main(String[] args) {
        System.out.println(new SplitStringInUniqueSubstring().maxUniqueSplit("aba"));
    }
}
