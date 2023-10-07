package com.exercises.amazon.hackerrank.main;

public class Hasher {

    /*
     * Complete the 'countNumWays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    // This class is what I submitted to Amazon

    public static int countNumWays(String s, int k) {
        // Write your code here

        System.out.println("k is " + k);
        System.out.println("String s length is: " + s.length());
        System.out.println("String is: " + s);


        // Check if the input is valid.
        if (k > s.length() || s.length() < 2 || s.length() > Math.pow(10, 6) || k < 1 || k > Math.min(s.length(), 20)) {
            return 0;
        }

        // Initialize the number of possible ways to reverse k characters.
        int possibleWaysNo = 0;

        // Iterate over the string, starting at index 0.
        for (int i = 0; i < s.length() - k + 1; i++) {

            // Extract the substring of length k starting at index i.
            String extractedStr = s.substring(i, i + k);

            // Reverse the extracted substring.
            String reversedStr = new StringBuilder(extractedStr).reverse().toString();

            // Create a new string by replacing the extracted substring with the reversed substring.
            String newStr = s.substring(0, i) + reversedStr + s.substring(i + k);

            // If the new string is lexicographically smaller than the original string, then increment the number of possible ways.
            if (newStr.compareTo(s) < 0) {
                possibleWaysNo++;
            }
        }

        return possibleWaysNo;
    }


}




