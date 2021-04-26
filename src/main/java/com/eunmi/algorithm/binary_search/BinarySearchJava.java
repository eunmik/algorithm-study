package com.eunmi.algorithm.binary_search;

// Java implementation of recursive Binary Search
public class BinarySearchJava {

    // Returns index of x if it is present in arr[l..
    // r], else return -1
    int binarySearch(int[] arr, int start, int end, int target)
    {
        /*
         * [2,3,4,10,40]
         * [step 1] start = 0, end = 4, target =10
         * mid = 0 + (4-0) /2 = 2
         * arr[2] = 4
         * [step 2] start = 3, end = 4, target =10
         * mid = 3 + (4-3)/2 = 3
         * arr[mid] = 10
         * */
        if (end >= start) { //start가 end보다 크다면 탐색하고자 하는 범위에 데이터가 없는 것이다.
            int mid = start + (end - start) / 2; //(start + end) /2

            // If the element is present at the
            // middle itself
            if (arr[mid] == target)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > target)
                return binarySearch(arr, start, mid - 1, target);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, end, target);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    // Driver method to test above
    public static void main(String args[])
    {
        BinarySearchJava ob = new BinarySearchJava();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
/* This code is contributed by Rajat Mishra */
}
