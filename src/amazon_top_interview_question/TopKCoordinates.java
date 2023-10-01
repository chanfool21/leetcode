package amazon_top_interview_question;

import java.util.Comparator;
import java.util.PriorityQueue;

class Coordinate {
    public Coordinate(int x, int y, Double dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    int x;
    int y;
    Double dist;
}
public class TopKCoordinates {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Coordinate> pq = new PriorityQueue<>(new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                if(o1.dist < o2.dist) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        int m = points.length;
        int i = 0;
        while(pq.size() < k) {
            Double dist = Math.sqrt((Double.parseDouble(String.valueOf(points[i][0])) * Double.parseDouble(String.valueOf(points[i][0]))) + (Double.parseDouble(String.valueOf(points[i][1])) * Double.parseDouble(String.valueOf(points[i][1]))) );
            pq.add(new Coordinate(points[i][0], points[i][1], dist));
            i++;
        }

        while(i < m) {
            Double dist = Math.sqrt((Double.parseDouble(String.valueOf(points[i][0])) * Double.parseDouble(String.valueOf(points[i][0]))) + (Double.parseDouble(String.valueOf(points[i][1])) * Double.parseDouble(String.valueOf(points[i][1]))) );
            if(!pq.isEmpty() && pq.peek().dist > dist) {
                pq.poll();
                pq.add(new Coordinate(points[i][0], points[i][1], dist));
            } else if(pq.isEmpty()) {
                pq.add(new Coordinate(points[i][0], points[i][1], dist));
            }

            i++;

        }

        int ctr = 0;
        int res[][] = new int[k][2];
        while(ctr < k) {
            Coordinate coord = pq.poll();
            res[ctr][0] = coord.x;
            res[ctr][1] = coord.y;
            ctr++;
        }

        return res;
    }

    public static void main(String[] args) {

        int [][] coordinates = new int[][]{{1,3}, {2,2}};
        int res[][] = new TopKCoordinates().kClosest(coordinates, 1);

        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " , " + res[i][1]);
        }
    }
}
