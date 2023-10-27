public class Array_Index_ElementEquality {

/*
Array Index & Element Equality
Given a sorted array arr of distinct integers, write a function indexEqualsValueSearch that returns the lowest index i for which arr[i] == i. Return -1 if there is no such index. Analyze the time and space complexities of your solution and explain its correctness.

Examples:

input: arr = [-8,0,2,5]
output: 2 # since arr[2] == 2

input: arr = [-1,0,3,6]
output: -1 # since no index in arr satisfies arr[i] == i.
Constraints:

[time limit] 5000ms

[input] array.integer arr

1 ≤ arr.length ≤ 100
[output] integer
 */

    static int indexEqualsValueSearch(int[] arr) {
        // your code goes here

        // base
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // logic

        int left = 0;
        int right = arr.length - 1;
        int minMid = -1;

        if (arr.length == 1 && arr[0] == 0) {
            return 0;
        }

        while (left <= right) {
            int mid = (right + left) / 2;
            if (mid == arr[mid]) {
                minMid = mid;
                // if you need first instance then retun mid.
                // return mid;
            }
            // decision to traverse
            if (mid > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }


        }
        return minMid;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{-8,0,2,5};
        System.out.println(indexEqualsValueSearch(arr));  // Output: true

    }
}
