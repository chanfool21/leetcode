package microsoft_leetcode_assesments;

public class FlipAndInvertImage {

    void swap(int [][]a, int i1, int j1, int i2, int j2) {
        int temp = a[i1][j1];
        a[i1][j1] = a[i2][j2];
        a[i2][j2] = temp;
    }
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length;
        int n = image[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < (n/2); j++) {
                swap(image, i, j, i, n-j-1);
            }
        }


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(image[i][j] == 0) {
                    image[i][j] = 1;
                } else {
                    image[i][j] = 0;
                }
            }
        }

        return image;
    }
    public static void main(String[] args) {
        int image[][] = new int[][] {{1,1,0}, {1,0,1}, {0,0,0}};
        int m = image.length;
        int n = image[0].length;
        int result[][] = new FlipAndInvertImage().flipAndInvertImage(image);
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
