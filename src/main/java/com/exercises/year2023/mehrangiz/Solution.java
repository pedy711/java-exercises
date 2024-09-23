package com.exercises.year2023.mehrangiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // not completed. This was Mehrangiz Interview test

    public static void main(String[] args) {
        // System.out.println(solution("abc", "bcd"));
        // System.out.println(solution("axxz", "yzwy"));
        // System.out.println(solution("bacad", "abada"));
        System.out.println(solution("amz", "amz"));
    }

    public static int solution(String P, String Q) {
        List<String> mutations = generateAllMutations(P, Q, P.length());
        System.out.println("The following are all mutations of P and Q with length " + P.length() + ": ");
        for (String mutation : mutations) {
            System.out.println(mutation);
        }
        return removeSimilarCharacters(mutations);
    }

    public static int removeSimilarCharacters(List<String> mutations) {
        // Create a hash map to store the frequency of each character in the mutations.
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for (String mutation : mutations) {
            for (int i = 0; i < mutation.length(); i++) {
                char c = mutation.charAt(i);
                charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
            }
        }

        // Create a new string to store the shortest string without similar characters.
        String shortestString = "";

        // Iterate over the hash map and add each character to the shortest string if its frequency is greater than 1.
        for (Character c : charFreq.keySet()) {
            if (charFreq.get(c) > 1) {
                shortestString += c;
            }
        }

        return shortestString.length();
    }

    public static List<String> generateAllMutations(String P, String Q, int N) {
        List<String> mutations = new ArrayList<>();

        // Recursively generate all mutations of P and Q.
        generateAllMutationsHelper(P, Q, N, new StringBuilder(), mutations);

        return mutations;
    }

    private static void generateAllMutationsHelper(String P, String Q, int N, StringBuilder mutation, List<String> mutations) {
        // If the length of the mutation is equal to N, add it to the list of mutations.
        if (mutation.length() == N) {
            mutations.add(mutation.toString());
            return;
        }

        // Add the next character from P to the mutation.
        mutation.append(P.charAt(mutation.length()));
        generateAllMutationsHelper(P, Q, N, mutation, mutations);

        // Remove the next character from P from the mutation.
        mutation.deleteCharAt(mutation.length() - 1);

        // Add the next character from Q to the mutation.
        mutation.append(Q.charAt(mutation.length()));
        generateAllMutationsHelper(P, Q, N, mutation, mutations);

        // Remove the next character from Q from the mutation.
        mutation.deleteCharAt(mutation.length() - 1);
    }
}
