package merge_intervals;

import java.util.*;

public class TaskScheduler {

    class TaskMeta{
        Character taskIdentifier;
        int remainingTaskCount;
        int nextSpawnTime;

        TaskMeta(Character taskIdentifier, int remainingTaskCount) {
            this.taskIdentifier = taskIdentifier;
            this.remainingTaskCount = remainingTaskCount;
        }
        TaskMeta(Character taskIdentifier, int remainingTaskCount, int nextSpawnTime) {
            this.taskIdentifier = taskIdentifier;
            this.remainingTaskCount = remainingTaskCount;
            this.nextSpawnTime = nextSpawnTime;
        }
    }


    public int leastInterval(char[] tasks, int n) {
        if(tasks.length == 0) return 0;
        Map<Character, Integer> taskFrequencyMap = new HashMap();
        for(int i = 0; i < tasks.length; i++) {
            taskFrequencyMap.put(tasks[i], taskFrequencyMap.getOrDefault(tasks[i], 0) + 1);
        }

        PriorityQueue<TaskMeta> pq = new PriorityQueue<>(new Comparator<TaskMeta>() {
            @Override
            public int compare(TaskMeta o1, TaskMeta o2) {
                return o2.remainingTaskCount -o1.remainingTaskCount;
            }
        });

        for(Map.Entry<Character, Integer> freqEntry: taskFrequencyMap.entrySet()) {
            TaskMeta taskMeta = new TaskMeta(freqEntry.getKey(), freqEntry.getValue());
            pq.add(taskMeta);
        }

        Queue<TaskMeta> queue = new LinkedList<>();
        int totalTaskExecutionTime = 0;
        int currentTime = 0;
        while(!queue.isEmpty() || !pq.isEmpty()) {
            if(!pq.isEmpty()) {
                TaskMeta currentTask = pq.poll();
                currentTask.nextSpawnTime = currentTime + n;
                currentTask.remainingTaskCount -= 1;
                if (currentTask.remainingTaskCount > 0)
                    queue.add(currentTask);
            }
            if(!queue.isEmpty() && queue.peek().nextSpawnTime == currentTime) {
                pq.add(queue.poll());
            }
            currentTime++;
        }

        totalTaskExecutionTime = currentTime;
        return totalTaskExecutionTime;
    }

    public static void main(String[] args) {
        System.out.println(new TaskScheduler().leastInterval(new char[] {'A','A','A', 'B','B','B'},3 ));
    }
}
