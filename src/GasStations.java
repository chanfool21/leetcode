public class GasStations {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalSurplus = 0;
        // Calculate currentSurplus for the interval where gas[i] - cost[i] >= 0, once it dips to negative, add this to totalSurplus
        // as this doesnt achieve the complete circuit but might help at the end in realizing about the past path taken, when we end up
        // on last index and we add curSurplus + totalSurplus achieved from past gas stations
        int totalGas = 0;
        int totalCost = 0;
        int resIndex = 0;

        for(int i = 0; i < n; i++) {
            totalCost+=cost[i];
            totalGas+=gas[i];
        }

        if(totalCost > totalGas) {
            return -1;
        }

        int curSurplus = 0;
        for(int i = 0; i < n; i++) {

            curSurplus += gas[i]-cost[i];

            if(curSurplus < 0) {
                resIndex = i+1;
                totalSurplus +=curSurplus;
                curSurplus = 0;
            }
        }

        if(totalSurplus + curSurplus >= 0) {
            return resIndex;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        System.out.println(new GasStations().canCompleteCircuit(new int[] {2,3,4}, new int[] {3,4,3}));
    }
}
