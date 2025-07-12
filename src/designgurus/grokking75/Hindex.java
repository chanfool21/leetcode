package designgurus.grokking75;

import java.util.Arrays;

public class Hindex {
    public int hIndex(int[] citations) {
        // ToDo: Write Your Code Here.
        Arrays.sort(citations);
        int n = citations.length;

//        for(int i = n-1; i >= 0; i--) {
//            int check = binarySearch(citations, 0, n-1, citations[i]);
//            if(check != -1 && ((n-check) >= citations[i])) {
//                return citations[i];
//            }
//        }


        for(int i = n; i >= 1; i--) {
            int check = binarySearch(citations, 0, n-1, i);
            if((n-check) >= i) {
                return i;
            }
        }
        return 0;
    }
    int binarySearch(int a[], int l, int h, int ele) {
        if(l > h) return l;
        else {
            int m = (l+h)/2;
            if(a[m] == ele) {
                if(m > 0 && a[m-1] == ele) {
                    return binarySearch(a, l, m-1, ele);
                } else {
                    return m;
                }
            } else if(m > 0 && a[m-1] < ele && a[m] > ele) {
                return m;
            }
            else if(a[m] > ele) {
                return binarySearch(a, l, m-1, ele);
            } else {
                return binarySearch(a, m+1, h, ele);
            }
        }
    }
    public static void main(String[] args) {
        //10 10 10 10 10
        // 5
//        int idx = new Hindex().binarySearch(new int[] {2 , 4, 5, 6, 8}, 0, 4, 1);
//        System.out.println(idx);
//        idx = new Hindex().binarySearch(new int[] {2 , 4, 5, 6, 8}, 0, 4, 7);
//        System.out.println(idx);
        System.out.println(new Hindex().hIndex(new int[] {0,1,2,3,4}));
    }
}
