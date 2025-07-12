package dynamicprogramming;

import java.util.Arrays;

public class ParititionSetIntoTwoSubsetsWithMinimumSumDifference {
    int fnc(int index, int arr[], int currentSum, int totalSum) {
        if(index == arr.length) {
            return Math.abs(currentSum - (totalSum - currentSum));
        }


        return Math.min(fnc(index+1, arr, currentSum+ arr[index], totalSum),
                fnc(index+1, arr, currentSum, totalSum));
    }

    public int minDifference(int[] arr, int n) {
        int totalSum = Arrays.stream(arr).sum();
        return fnc(0, arr, 0, totalSum);
    }

    public static void main(String[] args) {
        System.out.println(new ParititionSetIntoTwoSubsetsWithMinimumSumDifference().minDifference(new int[] {1, 7, 14, 5},4 ));
    }
}
