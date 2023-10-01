import java.util.Arrays;

public class HIndex {

    boolean isVaidHIndex(int a[], int ele, int l, int h, int n) {
        if(l <= h) {
            int mid = (l+h)/2;

            if(a[mid] >= ele) {
                if(n-mid >= ele) return true;
                else return isVaidHIndex(a, ele, l, mid-1, n);
            } else {
                return isVaidHIndex(a, ele, mid+1, h, n);
            }
        } else {
            return false;
        }
    }

    public int hIndex(int[] citations) {
        int res = 0;
        Arrays.sort(citations);
        int n = citations.length;
        for(int i = 1; i <= n; i++) {

            if(isVaidHIndex(citations, i, 0, n-1, n))
                res = Math.max(res, i);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[] {3,0,6,1,5}));
    }
}
