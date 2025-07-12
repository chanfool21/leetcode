package designgurus.grokking75;

public class JumpGame2 {
    public int jump(int[] nums) {
        // ToDo: Write Your code Here.
        int n = nums.length;
        int minJumps = 0;
        int currentRange = 0;
        int maxRange = 0;

        for(int i = 0; i < n; i++) {
            if(i < maxRange) {
                return -1;
            }
            maxRange = Math.max(maxRange, i + nums[i]);
            if(i < n-1 && i == currentRange) {
                minJumps++;
                currentRange = maxRange;
            }
        }
        return minJumps;
    }

    public static void main(String[] args) {

    }
}
