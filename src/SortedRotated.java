public class SortedRotated {
    public int fnc(int a[], int l, int h, int k) {
        if(l <= h) {
            int m = (l+h)/2;
            if(a[m] == k) {
                return m;
            }

            if(a[l] < a[m]) {
                if(a[l] <= k && k < a[m]) {
                    return fnc(a, l , m-1, k);
                } else {
                    return fnc(a, m+1, h, k);
                }
            } else {
                if(a[m+1] <= k && a[h] >= k) {
                    return fnc(a, m+1, h, k);
                } else {
                    return fnc(a, l, m-1, k);
                }
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        return fnc(nums, 0, nums.length-1, target);
    }

    public static void main(String[] args) {
        System.out.println(new SortedRotated().search(new int[] {4,5,6,7,0,1,2}, 0));
    }
}
