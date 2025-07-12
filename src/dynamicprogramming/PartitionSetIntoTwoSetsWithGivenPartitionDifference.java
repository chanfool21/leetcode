package dynamicprogramming;

import java.util.Arrays;

public class PartitionSetIntoTwoSetsWithGivenPartitionDifference {

    int mod = (int) 1e9 + 7;
    int fnc(int arr[], int index, int sum, int dp[][]) {
        if(sum == 0) return 1;
        else if(index >= arr.length || sum < 0) return 0;

        if(dp[index][sum] != -1) return dp[index][sum];
        return dp[index][sum] = (fnc(arr, index + 1, sum - arr[index], dp) % mod +
                fnc(arr, index + 1, sum, dp) % mod)% mod;
    }
    public int countPartitions(int n, int diff, int[] arr) {
        int sum = Arrays.stream(arr).sum();

        int result = (diff+sum);
        if(result%2 != 0) return 0;
        result = result/2;
        int dp[][] = new int[n][result+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return fnc(arr, 0, result, dp);
    }

    public static void main(String[] args) {
        int arr[] = new int[] {7,9,13,4,14,2,20,14,5,15,4};
        int diff = 90;
        int n = arr.length;
        System.out.println(new PartitionSetIntoTwoSetsWithGivenPartitionDifference().countPartitions(n, diff, arr));
    }
}
