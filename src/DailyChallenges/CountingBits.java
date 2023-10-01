package DailyChallenges;

import java.util.Arrays;

public class CountingBits {
    int countSetBits(int n) {
        if (n == 0) return 0;
        int range = 31;
        int cnt = 0;
        for(int i = 0; i <= range; i++) {
            if((n & 1 << i) != 0) {
                cnt++;
            }
        }

        return cnt;
    }
    public int[] countBits(int n) {
        int a[] = new int[n+1];
        for(int i = 0; i <= n; i++) {
            a[i] = countSetBits(i);
        }

        return a;
    }

    public static void main(String[] args) {
        int a[] = new CountingBits().countBits(5);
        Arrays.stream(a).forEach(ele -> System.out.print(ele + " "));
    }
}
