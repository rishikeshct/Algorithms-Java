package Greedy;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};

        //Time Exceeded
        System.out.println(GasStationFunc(gas, cost));

        System.out.println(GasStationGreedy(gas, cost));
    }

    private static int GasStationGreedy(int[] gas, int[] cost) {

        int gasTotal = 0;
        int distanceTotal = 0;

        for (int i = 0; i < gas.length; i++) {
            gasTotal += gas[i];
        }

        for (int i = 0; i < cost.length; i++) {
            distanceTotal+= cost[i];
        }

        if (gasTotal < distanceTotal) {
            return -1;
        }

        int res = 0;
        int total = 0;
        for (int i= 0 ;i < cost.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                res = i+1;
            }
        }
        return res;
    }

    private static int GasStationFunc(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++) {
            int fuel = gas[i];
            int j;
            for (j = i + 1; j < i + gas.length + 1; j++) {
                int remaining = fuel - cost[(j - 1)%gas.length];
                if (remaining < 0) {
                    break;
                }
                fuel = remaining + gas[j % gas.length];
                if (fuel <= 0) {
                    break;
                }
            }
            if (j == i + gas.length + 1 ) {
                return i;
            }
        }
        return  -1;
    }
}
