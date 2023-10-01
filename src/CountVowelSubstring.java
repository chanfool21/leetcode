import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CountVowelSubstring {
    public int countVowelSubstrings(String word) {
        int count = 0;
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        HashSet<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        //Count all substring possible in first pass from 0->n
        int n = word.length();

        int i = 0;
        int j = 0;

        while(i<= j && j < n) {
            if (vowelSet.contains(word.charAt(j))) {
                if (vowelCount.containsKey(word.charAt(j))) {
                    vowelCount.put(word.charAt(j), vowelCount.get(word.charAt(j)) + 1);
                } else {
                    vowelCount.put(word.charAt(j), 1);
                }
            }

            if (vowelCount.size() == 5) {
                count++;
                while(i <=j && i < n && vowelCount.get(word.charAt(i)) >= 1) {
                    if(vowelCount.containsKey(word.charAt(i)))
                        vowelCount.put(word.charAt(i), vowelCount.get(word.charAt(i))-1);
                    i++;
                    count++;
                }
                if(i < n && vowelCount.get(word.charAt(i)) == 0) {
                    i--;
                    count--;
                    vowelCount.put(word.charAt(i), 1);
                }
            }
            j++;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(new CountVowelSubstring().countVowelSubstrings("aeiouu"));
    }
}

//for(int i = 0; i < n; i++) {
//            if(vowelSet.contains(word.charAt(i))) {
//                if(vowelCount.containsKey(word.charAt(i))) {
//                    vowelCount.put(word.charAt(i), vowelCount.get(word.charAt(i)) + 1);
//                } else {
//                    vowelCount.put(word.charAt(i), 1);
//                }
//            }
//
//            if(vowelCount.size() >= 5) {
//                count++;
//            }
//        }
//
//        if(count == 0) return 0;
//
//        //forward pass till unavoidable stop due to lack of vowels
//        for(int i = 0; i < n; i++) {
//            if(!vowelSet.contains(word.charAt(i))) {
//                count++;
//            } else {
//                if(vowelCount.get(word.charAt(i)) <= 1) {
//                    break;
//                } else {
//                    vowelCount.put(word.charAt(i), vowelCount.get(word.charAt(i))-1);
//                    count++;
//                }
//            }
//        }
//
//        //backward pass till unavoidable stop due to lack of vowels
//
//        for(int i = n-1; i >= 0; i--) {
//            if(!vowelSet.contains(word.charAt(i))) {
//                count++;
//            } else {
//                if(vowelCount.get(word.charAt(i)) <= 1) {
//                    break;
//                } else {
//                    vowelCount.put(word.charAt(i), vowelCount.get(word.charAt(i))-1);
//                    count++;
//                }
//            }
//        }