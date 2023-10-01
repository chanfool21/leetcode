package dynamicprogramming;

public class NumberofUniqueBST {
    int fnc(int a[], int l, int h, int dp[][]) {
        if(l == h) {
            return 1;
        }

        if(l > h) {
            return 1;
        } else if(dp[l][h] != -1) {
            return dp[l][h];
        } else {
            int res = 0;

            for(int i = l; i <= h; i++) {
                res += fnc(a, l, i-1, dp)*fnc(a, i+1, h, dp);
            }
            dp[l][h] = res;
            return dp[l][h];
        }
    }
    public int numTrees(int n) {
        int a[] = new int[n];
        if(n == 0) {
            return 0;
        }
        for(int i = 1; i <= n; i++) {
            a[i-1] = i;
        }

        int dp[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return fnc(a, 0, n-1, dp);
    }

    public static void main(String[] args) {
        System.out.println(new NumberofUniqueBST().numTrees(19));
    }
}
