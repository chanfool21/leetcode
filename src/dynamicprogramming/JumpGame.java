package dynamicprogramming;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int range = nums[0];

        int i = 1;
        while(i < n) {
            if(i <= range) {
                range = Math.max(i+nums[i], range);
            } else {
                return false;
            }
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[] {3,2,1,0,4}));
    }
}
