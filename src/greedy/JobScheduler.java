package greedy;

import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z) {
        this.id = x;
        this.profit = z;
        this.deadline = y;
    }
}
public class JobScheduler {
    int[] JobSchedulingIncorrect(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return Integer.compare(o2.profit, o1.profit);
            }
        });

        Map<Integer, List<Job>> deadLineToJobMap = new HashMap<>();
        int profit = 0;
        int remainingSlot = 0;
        int occupiedSlot = 0;
        int maxTime = 0;
        for(int i = 0; i < n; i++) {
            int curDeadLine = arr[i].deadline;
            maxTime = Math.max(curDeadLine, maxTime);
            remainingSlot = maxTime - occupiedSlot;
            if(remainingSlot > 0) {
                if(deadLineToJobMap.containsKey(curDeadLine)) {
                    if(curDeadLine - deadLineToJobMap.get(curDeadLine).size() > 0) {
                        deadLineToJobMap.get(curDeadLine).add(arr[i]);
                        profit += arr[i].profit;
                        occupiedSlot++;
                    }
                } else {
                    List<Job> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    deadLineToJobMap.put(curDeadLine, temp);
                    profit += arr[i].profit;
                    occupiedSlot++;
                }
            }
        }

        int res[] = new int[2];
        res[0] = occupiedSlot;
        res[1] = profit;

        return res;
    }

    //m*n + nlogn -> m maximum deadline n number of job
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return Integer.compare(o2.profit, o1.profit);
            }
        });

        int maxDeadLine = 0;
        for(Job job: arr) {
            maxDeadLine = Math.max(maxDeadLine, job.deadline);
        }

        int slot[] = new int[maxDeadLine+1];

        for(int i = 1; i <= maxDeadLine; i++) {
            slot[i] = -1;
        }

        int totalProfit = 0;
        int totalJobs = 0;

        for(int i = 0; i < n; i++) {
            int curDeadLine = arr[i].deadline;

            for(int j = curDeadLine; j >= 1; j--) {
                if(slot[j] == -1) {
                    slot[j] = arr[i].id;
                    totalJobs++;
                    totalProfit+=arr[i].profit;
                    break;
                }
            }
        }

        int res[] = new int[2];
        res[0] = totalJobs;
        res[1] = totalProfit;
        return res;
    }

    public static void main(String[] args) {
        int n = 8;
        Job jobs[] = new Job[n];
        Job job1 = new Job(1,4,20);
        Job job2 = new Job(2,5,60);
        Job job3 = new Job(3,6,70);
        Job job4 = new Job(4,6,65);
        Job job5 = new Job(5,4,25);
        Job job6 = new Job(6,2,80);
        Job job7 = new Job(7,2,10);
        Job job8 = new Job(8,2,22);
        jobs[0] = job1;
        jobs[1] = job2;
        jobs[2] = job3;
        jobs[3] = job4;
        jobs[4] = job5;
        jobs[5] = job6;
        jobs[6] = job7;
        jobs[7] = job8;

        int res[] = new JobScheduler().JobScheduling(jobs, n);

        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }


}
