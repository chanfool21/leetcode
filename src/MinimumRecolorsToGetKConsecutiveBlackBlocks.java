//https://leetcode.com/contest/biweekly-contest-85/problems/minimum-recolors-to-get-k-consecutive-black-blocks/

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public int minimumRecolors(String blocks, int k) {
        int res = Integer.MAX_VALUE;

        int curW = 0;
        int curB = 0;

        int n = blocks.length();
        int l = 0;
        int h = 0;
        while(h < k) {
            if(blocks.charAt(h) == 'W') {
                curW++;
            } else {
                curB++;
            }
            h++;
        }

        res = Math.min(res, curW);

        while (h < n) {
            if(blocks.charAt(l) == 'W') {
                curW--;
                l++;
            } else if(blocks.charAt(l) == 'B') {
                curB--;
                l++;
            }

            if(blocks.charAt(h) == 'W') {
                curW++;
                h++;
            }else if(blocks.charAt(h) == 'B') {
                curB++;
                h++;
            }
            res = Math.min(res, curW);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumRecolorsToGetKConsecutiveBlackBlocks().minimumRecolors("WBWBBBW", 2));
    }


}
