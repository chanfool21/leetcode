package greedy;

import java.util.Arrays;

public class BoatsToSave {
    public int numRescueBoats(int[] a, int w) {
        int n = a.length;
        int l = 0;
        int h = n-1;
        int count = 0;
        Arrays.sort(a);
        while(l < h) {
            if((a[l] + a[h]) <= w) {
                l++;
                h--;
            } else {
                h--;
            }

            count++;
        }

        if(l == h) {
            count+=1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new BoatsToSave().numRescueBoats(new int[] {3,2,2,1},3));
    }
}
