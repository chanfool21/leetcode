package array;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int candy[] = new int[ratings.length];

        for(int i = 0; i < ratings.length; i++) {
            candy[i] = 1;
        }

        for(int i = 0; i < ratings.length; i++) {
            if(i == 0) {
                if(ratings[i] > ratings[i+1]) {
                    candy[i] = candy[i+1] + 1;
                }
            } else if(i == ratings.length - 1) {
                if(ratings[i] > ratings[i-1]) {
                    candy[i] = candy[i-1] + 1;
                }
            } else {
                if(ratings[i] > ratings[i-1] && ratings[i] > ratings[i+1]) {
                    candy[i] = 1 + Math.max(candy[i], candy[i+1]);
                } else if(ratings[i] > ratings[i-1]) {
                    candy[i] = 1 + candy[i-1];
                } else if(ratings[i] > ratings[i+1]) {
                    candy[i] = 1 + candy[i+1];
                }
            }
        }

        int candyCount = 0;
        candyCount = Arrays.stream(candy).sum();
        return candyCount;
    }

    public static void main(String[] args) {
        System.out.println(new Candy().candy(new int[] {1,0,2}));
    }
}
