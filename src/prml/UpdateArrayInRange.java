package prml;

public class UpdateArrayInRange {

    int [] getUpdatedArrayAfterRangeUpdation(int a[], int range[][]) {
        int diff[] = createDifferenceArray(a);
        int firstIdx = a[0];
        int n = a.length;
        int row = range.length;
        //{{0,2,5}, {1,3,7}, {2,4,1}};
        for(int i = 0; i < row; i++) {
            int startIdx = range[i][0];
            int endIdx = range[i][1];
            int value = range[i][2];

            if(startIdx == 0) {
                firstIdx+=value;
                diff[startIdx] = 0;
            } else {
                diff[startIdx] += value;
            }

            if(endIdx <= n-2) {
                diff[endIdx + 1] -= value;
            }
        }

        int result [] = createResultArrayWithFirstIndexAndDifference(firstIdx, diff);
        return result;
    }

    private int [] createResultArrayWithFirstIndexAndDifference(int firstIdx, int diff[]) {
        int result[] = new int[diff.length];
        result[0] = firstIdx;

        for(int i = 1; i < diff.length; i++) {
            result[i] = diff[i] + result[i-1];
        }

        return result;
    }
    private int[] createDifferenceArray(int a[]) {
        int n = a.length;

        int diff[] = new int[n];
        diff[0] = 0;
        for(int i = 1; i < n; i++) {
            diff[i] = a[i] - a[i-1];
        }

        return diff;
    }
    public static void main(String[] args) {
        int a[] = new int[] {1, 2 ,3 ,4 ,5};
        int range[][] = new int[][] {{0,2,5}, {1,3,7}, {2,4,1}};

        int result[] = new UpdateArrayInRange().getUpdatedArrayAfterRangeUpdation(a, range);

        for(int val: result) {
            System.out.println(val);
        }
    }
}
