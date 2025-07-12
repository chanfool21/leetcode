package stack;

public class TrappingRainWaterWithoutStack {
    public int trap(int[] a) {
        int n = a.length;

        int leftGreatestTillNow = a[0];
        int rightGreatestTillNow = a[n-1];

        int result = 0;


        int l = 0;
        int h = n-1;

        while(l <= h) {
            if(leftGreatestTillNow < rightGreatestTillNow) {
                int delta = leftGreatestTillNow - a[l];
                if(delta > 0) {
                    result += delta;
                }
                leftGreatestTillNow = Math.max(leftGreatestTillNow, a[l]);
                l++;
            } else {
                int delta = (rightGreatestTillNow - a[h]);
                if(delta > 0) {
                    result += delta;
                }
                rightGreatestTillNow = Math.max(rightGreatestTillNow, a[h]);
                h--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWaterWithoutStack().trap(new int[] {4,2,0,3,2,5}));
    }
}
