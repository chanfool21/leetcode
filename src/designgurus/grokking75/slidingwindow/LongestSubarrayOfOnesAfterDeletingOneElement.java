package designgurus.grokking75.slidingwindow;

public class LongestSubarrayOfOnesAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        // ToDo: Write Your Code Here.

        int maxLength = 0;

        int nonOneCount = 0;
        int l = 0;
        int r = 0;

        int n = nums.length;

        while(r < n) {
            if(nums[r] != 1) {
                nonOneCount++;
            }

            if(nonOneCount > 1) {
                while(nonOneCount > 1 && l < r) {
                    if(nums[l] != 1) {
                        nonOneCount--;
                    }
                    l++;
                }
            }

            if(nonOneCount <= 1) {
                maxLength = Math.max(maxLength, (r-l - nonOneCount + 1));
            }
            r++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubarrayOfOnesAfterDeletingOneElement().longestSubarray(new int[] {1, 0, 1, 1, 0, 1}));
    }
}
