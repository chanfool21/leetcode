package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrintNumber {

    static void printTillN(int n) {
        if(n == 0) {
            return;
        }

        printTillN(n-1);
        System.out.println(n);
    }

    static void printRange(int i, int n) {
        if(i > n) return;
        System.out.println(i);
        printRange(i+1, n);
    }

    static int sumtillN(int n) {
        if(n == 0) return 0;

        return n + sumtillN(n-1);
    }

    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    static void reverseArrayUtil(int l, int h, int a[]) {
        if(l >= h) return;

        swap(a, l, h);
        reverseArrayUtil(l+1, h-1, a);

    }
    static int []reverseArray(int a[]) {
        reverseArrayUtil( 0, a.length-1, a);
        Arrays.stream(a).forEach(ele -> System.out.println(ele));
        return a;
    }

    static void printSubsequenceUtil(int a[] ,int start, int end, LinkedList<Integer> curList) {
        if(start == end) {
            curList.forEach(ele -> System.out.print(ele + " "));
            System.out.println();
            return;
        }

        curList.add(a[start]);
        printSubsequenceUtil(a, start+1, end, curList);
        curList.removeLast();
        printSubsequenceUtil(a, start+1, end, curList);
    }
    static void printAllSubsequences(int a[]) {
        LinkedList<Integer> curList = new LinkedList<>();
        printSubsequenceUtil(a, 0, a.length, curList);
    }
    public static void main(String[] args) {
        //printTillN(4);
        //printRange(3, 8);
        //System.out.println(sumtillN(4));
        //reverseArray(new int[] {1,2,3,4});
        printAllSubsequences(new int []{1,2,3,4});
    }
}
