package DailyChallenges;
//https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/description/?envType=daily-question&envId=2023-10-02
public class RemoveColoredPiecesIfBothNeighborsHaveSameColor {

    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int l = 0;
        int r = 0;

        int countA = 0;
        int countB = 0;
        while(r < n) {
            while(r < n && colors.charAt(r) == 'A') {
                r++;
                if(r-l >= 3) {
                    countA++;
                }
            }
            l = r;
            while(r < n && colors.charAt(r) == 'B') {
                r++;
                if(r-l >= 3) {
                    countB++;
                }
            }
            l = r;
        }

        if(countA > countB) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new RemoveColoredPiecesIfBothNeighborsHaveSameColor().winnerOfGame("AAAAABBBBBBAAAAA"));
    }

}
