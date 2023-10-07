package com.exercises.amazon.hackerrank.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HasherWithThreads {

    /*
     * Complete the 'countNumWays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

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

        // Create an executor service to manage the threads.
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Create a list to store the futures returned by the threads.
        List<Future<Integer>> futures = new ArrayList<>();

        // Break the string into smaller substrings of length k.
        for (int i = 0; i < s.length() - k + 1; i++) {
            Callable<Integer> task = getIntegerCallable(s, k, i);

            // Submit the task to the executor service.
            Future<Integer> future = executorService.submit(task);

            // Add the future to the list of futures.
            futures.add(future);
        }

        // Wait for all the threads to finish executing.
        for (Future<Integer> future : futures) {
            try {
                possibleWaysNo += future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Shutdown the executor service.
        executorService.shutdown();

        return possibleWaysNo;
    }

    private static Callable<Integer> getIntegerCallable(String s, int k, int i) {
        String extractedStr = s.substring(i, i + k);

        // Create a Callable task to reverse the substring and calculate the number of possible ways to reverse the substring.
        return () -> {
            String reversedStr = new StringBuilder(extractedStr).reverse().toString();
            // Make the variable `newStr` final or effectively final.
            final String newStr = s.substring(0, i) + reversedStr + s.substring(i + k);

            // If the new string is lexicographically smaller than the original string, then increment the number of possible ways.
            if (newStr.compareTo(s) < 0) {
                return 1;
            } else {
                return 0;
            }
        };
    }


}

