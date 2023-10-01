import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


//To-Do
public class CountAndSay {

    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }

        int cur = 1;
        String numString = "1";
        while(cur <= 4) {
            TreeMap<Integer, Integer> mp = new TreeMap<>();
            populateDigitToMap(mp, numString);
            formNewStringFromMap(numString, mp);
        }

        return numString;

    }

    void formNewStringFromMap(String numString, Map<Integer, Integer> mp) {
        int n = numString.length();
        for(int i = 0; i < n; i++) {
            if(mp.containsKey(numString.charAt(i) - '0'))
                mp.put((numString.charAt(i) - '0'), mp.get((numString.charAt(i) - '0')) + 1);
            else
                mp.put((numString.charAt(i) - '0'), 1);
        }
    }

    void populateDigitToMap(Map<Integer, Integer> mp, String numString) {

    }

    public static void main(String[] args) {

    }
}
