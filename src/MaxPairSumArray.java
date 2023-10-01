import java.util.*;

public class MaxPairSumArray {

    int getMaximumDigit(int num) {
        int maxDigit = Integer.MIN_VALUE;

        while(num > 0) {
            maxDigit = Math.max(maxDigit, num%10);
            num = num/10;
        }
        return maxDigit;
    }
    public int maxSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int maxD = getMaximumDigit(nums[i]);
            if(map.containsKey(maxD)) {
                map.get(maxD).add(nums[i]);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                map.put(maxD, temp);
            }
        }

        boolean flag = false;
        int maxSum = Integer.MIN_VALUE;
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> value = entry.getValue();

            if(value.size() >= 2) {
                flag = true;
                Collections.sort(value, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if(o2 >= o1) {
                            return 1;
                        }  else {
                            return -1;
                        }
                    }
                });
                maxSum = Math.max(maxSum, value.get(0) + value.get(1));
            }
        }

        if(flag == true)
            return maxSum;
        else
            return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MaxPairSumArray().maxSum(new int[] {84,91,18,59,27,9,81,33,17,58}));
    }
}
