import java.util.Arrays;

public class SortColors {
    //0,1,2

    void swap(int a[], int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;

    }
    void fncUtil(int a[], int i, int l, int m, int h, int n) {
        //2,1,0,1,0,2: 0 -> l = 0, l -> m = 1, m -> n = 2
        while(i <= h) {
            if (a[i] == 0) {
                swap(a, i, l);
                l++;
                m++;
                i++;
            } else if (a[i] == 2) {
                swap(a, i, h);
                h--;
            } else if(a[i] == 1){
                swap(a, i, m);
                m++;
                i++;
            }
        }
    }
    void sortColors(int a[]) {
        //2,1,0,1,0,2: 0 -> l = 0, l -> m = 1, m -> n = 2
        int n = a.length;
        fncUtil(a, 0, 0, 0, n-1, n);
    }

    public static void main(String[] args) {
        int a[] = new int[] {1, 2 , 1, 0 , 1, 2};
        new SortColors().sortColors(a);
        Arrays.stream(a).forEach(ele -> {
            System.out.println(ele);
        });
    }
}
