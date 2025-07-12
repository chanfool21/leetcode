package adhoc;

public class RemovingMaxAndMinFromArray {
    public int minimumDeletions(int[] nums) {
        int minIdx = 0;
        int maxIdx = 0;
        int minVal = nums[0];
        int maxVal = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(minVal > nums[i]) {
                minVal = nums[i];
                minIdx = i;
            }

            if(maxVal < nums[i]) {
                maxVal = nums[i];
                maxIdx = i;
            }
        }

        int res = 0;
        int n = nums.length;
        boolean pickMin = false;
//        minIdx = Math.min(minIdx, (n-minIdx));
//        maxIdx = Math.min(maxIdx, (n-maxIdx));
        if(Math.min(minIdx+1, (n-minIdx)) < Math.min(maxIdx+1, (n-maxIdx))) {
            pickMin = true;
            res = Math.min(minIdx+1, (n-minIdx));
        } else {
            pickMin= false;
            res = Math.min(maxIdx+1, (n-maxIdx));
        }

        if(pickMin) {
            res += Math.min(Math.abs(maxIdx - minIdx), Math.min(maxIdx+1, (n-maxIdx)));
        } else {
            res += Math.min(Math.abs(maxIdx - minIdx), Math.min(minIdx+1, (n-minIdx)));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new RemovingMaxAndMinFromArray().minimumDeletions(new int[] {72956,-44432,78333,31358,-96449,-24776}));
    }
}
