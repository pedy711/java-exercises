package com.exercises.amazon.hackerrank.main.test2;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'minimumTimeSpent' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY comedyReleaseTime
     *  2. INTEGER_ARRAY comedyDuration
     *  3. INTEGER_ARRAY dramaReleaseTime
     *  4. INTEGER_ARRAY dramaDuration
     */

    public static int minimumTimeSpent(List<Integer> comedyReleaseTime, List<Integer> comedyDuration, List<Integer> dramaReleaseTime, List<Integer> dramaDuration) {
    // Write your code here
        return 0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int comedyReleaseTimeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> comedyReleaseTime = IntStream.range(0, comedyReleaseTimeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int comedyDurationCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> comedyDuration = IntStream.range(0, comedyDurationCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int dramaReleaseTimeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> dramaReleaseTime = IntStream.range(0, dramaReleaseTimeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int dramaDurationCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> dramaDuration = IntStream.range(0, dramaDurationCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumTimeSpent(comedyReleaseTime, comedyDuration, dramaReleaseTime, dramaDuration);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
