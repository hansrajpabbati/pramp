/*
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.



Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
Example 2:

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
* */
public class Capacity_To_Ship_Packages_Within_D_Days_1011 {

    public static boolean capacityCalculater(int[] weights, int cap, int days ){
        int currWeight = 0;
        int currDays = 1;
        for(int w : weights){
            currWeight = currWeight + w;
            if(currWeight > cap){
                currDays++;
                // in case where after adding last value w go above capacity
                // remove last added w
                currWeight = w;
            }
        }

        if(currDays <= days) {
            return true;
        }
        return false;

    }

    public static int shipWithinDays(int[] weights, int days) {

        // case
        int maxWeight = 0;
        int totalWeight =0;

        // This helps to get max weight and total weight in array
        for(int w: weights) {
            totalWeight = totalWeight + w;
            maxWeight = Math.max(maxWeight,w);
        }

        int l = maxWeight;
        int r = totalWeight;

        // mid = (10 + 55)/2 = 32

        while(l < r) {
            // mid is my new capacity
            int mid = (l+r)/2;

            // this if condition need to check new capacity is enought to ship all pakages in given days variable.
            if(capacityCalculater(weights,mid,days)){
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;

    }

    public static void main(String[] args) {

        int[] weights1 = new int[]{1,2,3,4,5,6,7,8,9,10};
        int days1 = 5;
        int days2 = 4;
        System.out.println(shipWithinDays(weights1, days1));
        System.out.println(shipWithinDays(weights1, days2));


    }
}