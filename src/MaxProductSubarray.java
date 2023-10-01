public class MaxProductSubarray {
    public int maxProduct(int[] a) {
        int maxPos = 1;
        int maxNeg = 1;

        int maxProduct = Integer.MIN_VALUE;

        for(int i = 0; i < a.length; i++) {
            if(a[0] == 0) {
                maxPos = 1;
                maxNeg = 1;
            } else {
                if(a[i] > 0) {
                    maxPos *= a[i];
                    maxNeg *= a[i];
                } else {
                    if(maxNeg * a[i] <= 0) {
                        maxPos = 1;
                        maxNeg = maxNeg * a[i];
                    } else {
                        int temp = maxPos;
                        maxPos = maxNeg * a[i];
                        maxNeg = temp * a[i];
                    }
                }
            }

            maxProduct = Math.max(maxProduct, Math.max(maxPos, maxNeg));
        }


        if(maxProduct == 1) {
            int res = Integer.MIN_VALUE;
            for(int i = 0; i < a.length; i++) {
                if(a[i] >= 0)
                res = Math.max(res, a[i]);
            }
            return res;
        }

        return maxProduct;
    }

    public int maxProduct1(int[] a) {
        int n = a.length;

        int maxProduct = a[0];

        int curPos = a[0];
        int curNeg = a[0];

        for(int i = 1; i < n; i++) {
            if(a[i] == 0) {
                curNeg = 0;
                curPos = 0;
            } else if(a[i] < 0) {
                int temp = curNeg;
                curNeg = curPos;
                curPos = temp;
            }
            curPos = Math.max(a[i], curPos * a[i]);
            curNeg = Math.min(a[i], curNeg * a[i]);
            maxProduct = Math.max(maxProduct, Math.max(curPos, curNeg));
        }

        return maxProduct;
    }
    public static void main(String[] args) {
        System.out.println(new MaxProductSubarray().maxProduct1(new int[] {-2,0,-1}));
    }
}
