package com.re;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {
    /*
     * Complete the 'getMaxBeauty' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static long getMaxBeauty(List<Integer> arr) {
        int n = arr.size();

        // Step 1: Sort the array in descending order
        Collections.sort(arr, Collections.reverseOrder());

        // Step 2: Create a new array to hold the optimal arrangement
        List<Integer> arrangedArr = new ArrayList<>(Collections.nCopies(n, 0));

        // Step 3: Place the largest elements in even positions, and the smaller ones in odd positions
        int evenIndex = 0;
        int oddIndex = 1;

        // We place elements in the sorted array in descending order
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arrangedArr.set(evenIndex, arr.get(i));  // Place at even index
                evenIndex += 2;  // Move to the next even index
            } else {
                arrangedArr.set(oddIndex, arr.get(i));   // Place at odd index
                oddIndex += 2;  // Move to the next odd index
            }
        }

        // Step 4: Calculate the prefix sum array
        long[] psum = new long[n];
        psum[0] = arrangedArr.get(0);
        for (int i = 1; i < n; i++) {
            psum[i] = psum[i - 1] + arrangedArr.get(i);
        }

        // Step 5: Calculate the beauty using alternating sum
        long currentBeauty = 0;
        long maxBeauty = Long.MIN_VALUE; // Start with the smallest possible value
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                currentBeauty += psum[i]; // Add if i is even
            } else {
                currentBeauty -= psum[i]; // Subtract if i is odd
            }

            // Update the maximum beauty encountered
            maxBeauty = Math.max(maxBeauty, currentBeauty);
        }

        return maxBeauty;
    }
}

