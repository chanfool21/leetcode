package twopointers;

public class RemoveDuplicateFromSortedArray2 {
    public int removeDuplicates(int[] a) {
        int l = 0;
        int n = a.length;

        int r = 0;
        int count = 1;

        while(r < n) {
                count = 1;
                while(r+1 < n && a[r] == a[r+1]) {
                    count++;
                    r++;
                }

                count = Math.min(2, count);
                while(count > 0) {
                    a[l] = a[r];
                    l++;
                    count--;
                }
                r++;
        }

        return l;
    }

    public static void main(String[] args) {
        int a[] = new int[] {1,1,1,2,2,3};
        int k = new RemoveDuplicateFromSortedArray2().removeDuplicates(a);

        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
        System.out.println("k = " + k);
    }
}
