package tesco.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MatchingScoreUtil {
    public static int getMatchingScore(String productName, String searchParam) {

        String []tokens = productName.split(" ");
        Set<String> set = Arrays.stream(tokens).collect(Collectors.toSet());
        int score = 0;
        if(set.contains(searchParam)) {
            score = searchParam.length()*100/productName.length();
        }

        return score;
    }
}
