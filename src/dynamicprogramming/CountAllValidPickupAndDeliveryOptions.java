package dynamicprogramming;

//Combinatrics logic, ref:https://www.youtube.com/watch?v=p1tvA-eQFqk
//lets suppose we have 3 orders and where we have already placed 2 orders in their places
// Lets suppose we know the way to place 2 orders are 6, which are also as per expected order where pickup i should be before delivery i

//  ___PxDx__PxDx__PxDx__PxDx__
// there are 4 places field for last 2 orders, then remaining place to fill P3 will be 5, since we can add one before first PxDx
// when we fill P3 at first place, one more place opens between P3 and first PxDx and first place before P3 is also available now
// so _P3_PxDx_PxDx_PxDx_PxDx_, but we cant place D3 before P3, so possible places for D3 in this area are 5
// when we place P3 next to First PxDx, i.e PxDxP3_PxDx_PxDx_PxDx_, number of places reduce to 4
// similarly for last position if we place P3, there will be only one place for D3, i.e. PxDxPxDxPxDxPxDxP3_
// in short,total cases possible here are 5 + 4 + 3 + 2 + 1, and initial 5 was formed by calculating already placed events + 1
// i.e when 2 orders were placed, number of events are 4 (p1,d1,p2,d2). And total ways we can put P3 D3 are 5+4+3+2+1
// which is general formula : (n * (n+1))/2, here n = already placed events
// Final formula becomes = pastWays * (alreadyplacedevents + 1) * (alreadyplacedevents+ 1 + 1) / 2;, here n = alreadyplacedevents  +1

public class CountAllValidPickupAndDeliveryOptions {
    int mod = Double.valueOf( Math.pow(10, 9)).intValue() + 7;
    long fnc(int n) {
        if(n == 0) return 1;

        int preplacedevent = 2 * (n-1); // 2n - 2 + 1 => 2n - 1
        int currentPlacementChoice = preplacedevent + 1;
        //(currentPlacementChoice * (currentPlacementChoice + 1) / 2)  = (2n -1) * (2n-1 + 1) / 2 => (2n-1) * 2n/2 = (2n-1) *n
        return ((2*n - 1)*(n) * fnc( n-1))%mod;
    }
    public int countOrders(int n) {
        if(n == 0) return 1;
        long res = fnc(n)%mod;

        long dp[] = new long [n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            dp[i] = ((2*i-1)*i*dp[i-1]);
        }
        return Integer.parseInt(String.valueOf(dp[n]%mod));
        //return Integer.parseInt(String.valueOf(res));
    }

    public static void main(String[] args) {
        System.out.println(new CountAllValidPickupAndDeliveryOptions().countOrders(8));
    }
}
