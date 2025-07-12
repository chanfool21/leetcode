package designgurus.grokking75;

public class JumpGame1 {
    public boolean canJump(int[] nums) {
        // ToDo: Write Your Code Here.
        int n = nums.length;
        int maxRange = 0;
        for(int i = 0; i < n; i++) {
            if(maxRange < i) return false;
            maxRange = Math.max(maxRange, i + nums[i]);
            if(maxRange == n-1) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame1().canJump(new int[] {3, 2, 1, 0, 4}));

    }
}
