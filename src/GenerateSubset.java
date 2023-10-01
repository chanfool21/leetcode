import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateSubset {

    void generateSubsetUtil(List<Integer> arr, int cur, List<Integer> curList, List<List<Integer>> result) {
        if(cur == arr.size()) {
            return;
        }

        curList.add(arr.get(cur));
        List<Integer> tempList = new ArrayList<>();
        tempList.addAll(curList);
        result.add(tempList);
        generateSubsetUtil(arr, cur+1, curList, result);
        int n = curList.size();
        curList.remove(n-1);
        generateSubsetUtil(arr, cur+1, curList, result);
    }
    List<List<Integer>> generateSubsets(List<Integer> arr) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        generateSubsetUtil(arr, 0, curList, result);
        return result;
    }

    public static void main(String[] args) {
        int a[] = new int[] {2,4};
        List<Integer> input = Arrays.stream(a).boxed().collect(Collectors.toList());
        System.out.println(new GenerateSubset().generateSubsets(input));
    }
}
