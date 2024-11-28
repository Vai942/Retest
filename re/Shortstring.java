package com.re;

import java.io.*;
import java.util.*;
 
 
class Result {
 
 
    public static int findShortestSubstring(String s) {
        int n = s.length();
 
        if (n <= 1) return 0;  // No need to delete anything if the string has 1 or fewer characters
 
 
        // HashMap to store the last index of each character
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int minLength = Integer.MAX_VALUE;  // To track the minimum length of the substring to delete
        int left = 0;  // Left pointer for sliding window
 
        // Traverse the string with the 'right' pointer
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
 
            // If the character is already in the map and its index is within the current window
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                // Calculate the length of the substring that could be removed
                minLength = Math.min(minLength, right - left + 1);
 
                // Move the left pointer to the next character after the previous occurrence of the current character
                left = charIndexMap.get(currentChar) + 1;
            }
 
 
            // Update the last seen index of the current character
            charIndexMap.put(currentChar, right);
        }
 
        // If no deletion is required (all characters are distinct), return 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
 
 
public class Shortstring {
    public static void main(String[] args) throws IOException {
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
 
 
        String s = bufferedReader.readLine();
 
 
        // Call the function to get the result
        int result = Result.findShortestSubstring(s);
 
 
        // Write the result to stdout
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
 
 
        bufferedReader.close();
        bufferedWriter.close();
    }
}