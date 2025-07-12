package stack;

import java.util.*;

public class ExclusiveTimeOfFunctions {
    class FunctionNode {
        int fnId;
        int startTime;

        public FunctionNode(int fnId, int startTime) {
            this.fnId = fnId;
            this.startTime = startTime;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        Map<Integer, Integer> fnToExecTimeMap = new HashMap<>();
        Stack<FunctionNode> stack = new Stack<>();
        for(String log: logs) {
            String logarr[] = log.split(":");
            if(logarr.length < 3) {
                continue;
            }
            String type = logarr[1];
            int fnId = Integer.parseInt(logarr[0]);
            int timeStamp = Integer.parseInt(logarr[2]);

            if(type.equals("start")) {
                if(stack.isEmpty()) {
                    stack.add(new FunctionNode(fnId, timeStamp));
                    fnToExecTimeMap.put(fnId, fnToExecTimeMap.getOrDefault(fnId, 0));
                } else {
                    FunctionNode currentFunctionNode = stack.peek();
                    fnToExecTimeMap.put(currentFunctionNode.fnId, fnToExecTimeMap.getOrDefault(currentFunctionNode.fnId, 0) + timeStamp - currentFunctionNode.startTime);
                    stack.add(new FunctionNode(fnId, timeStamp));
                    fnToExecTimeMap.put(fnId, fnToExecTimeMap.getOrDefault(fnId, 0));
                }
            } else {
                if(!stack.isEmpty()) {
                    FunctionNode currentFunctionNode = stack.peek();
                    if (currentFunctionNode.fnId == fnId) {
                        fnToExecTimeMap.put(fnId, fnToExecTimeMap.get(fnId) + (timeStamp - currentFunctionNode.startTime) + 1);
                        stack.pop();
                        if (!stack.isEmpty()) {
                            FunctionNode newPeekNode = stack.pop();
                            newPeekNode.startTime = timeStamp + 1;
                            stack.add(newPeekNode);
                        }
                    }
                }
            }
        }

        int res[] = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = fnToExecTimeMap.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> logs = Arrays.asList(new String[]{"0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"});
        int res[] = new ExclusiveTimeOfFunctions().exclusiveTime(2, logs);
        Arrays.stream(res).forEach(ele -> System.out.println(ele));
    }
}
