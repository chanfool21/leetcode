package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    void swap(int a[] , int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    void fnc(int a[] , int idx, int n, List<List<Integer>> result) {
        if(idx == n-1) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                temp.add(a[i]);
            }
            result.add(temp);
            return;
        }

        for(int i = idx; i < n; i++) {
            swap(a, idx, i);
            fnc(a, idx+1, n, result);
            swap(a, idx, i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        fnc(nums, 0, nums.length, result);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Permutations().permute(new int[] {1,2,3});
        for(List res: result) {
            res.forEach(ele -> System.out.print(ele + " "));
            System.out.println();
        }
    }
}
