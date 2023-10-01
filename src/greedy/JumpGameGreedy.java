package greedy;

public class JumpGameGreedy {
    public static boolean jumpGame(int[] nums) {

        // Replace this placeholder return statement with your code
        int curMax = 0;
        for(int i = 0; i < nums.length; i++) {
            if(curMax == nums.length-1) return true;
            if(i > curMax) {
                return false;
            } else {
                curMax = Math.max(curMax, i + nums[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(jumpGame(new int[] {2,3,1,1,4}));
    }
}
