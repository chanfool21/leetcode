package Leetcode150.array;

public class JumpGame2 {
    public int jump(int[] a) {
        if(a[0] == 0 || a.length == 1) return 0;
        int totalJumps = 0;
        int maxJump = 0;
        int n = a.length;
        int curWindow = a[0];
        for(int i = 0; i < n; i++) {


            if(i <= curWindow && i + a[i] > maxJump) {
                maxJump = i+a[i];
            }

            if(i > curWindow) {
                curWindow = maxJump;
                totalJumps++;
            }
        }

        return totalJumps;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame2().jump(new int[] {2,3,1,1,4}));
    }
}
