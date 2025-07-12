package designgurus.grokking75.slidingwindow;

public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        // ToDo: Write Your Code Here.
        int maxOnes = 0;

        int zeroS = 0;
        int oneS = 0;

        int n = nums.length;
        int l = 0;
        int r = 0;

        while(r < n) {
            if(nums[r] == 0) {
                zeroS++;
            } else {
                oneS++;
            }

            if(zeroS > k) {
                while(l < r && zeroS > k) {
                    if(nums[l] == 0) {
                        zeroS--;
                    } else {
                        oneS--;
                    }
                    l++;
                }
            }

            if(zeroS <= k) {
                maxOnes = Math.max(maxOnes, (zeroS+oneS));
            }
            r++;
        }
        return maxOnes;
    }

    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOnes3().longestOnes(new int[] {1, 0, 1, 1, 0, 0, 1, 1}, 1));
    }
}
