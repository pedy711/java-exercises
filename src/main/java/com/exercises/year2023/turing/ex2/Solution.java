package com.exercises.year2023.turing.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,2,3};
        System.out.println(solution(nums));
    }
    private static int solution(int[] k) {
        int numOfMatches = 0;
        for (int i = 0; i < k.length; i++) {
            for (int j = i; j < k.length; j++) {
                if(i < j && k[i] == k[j])
                    numOfMatches++;
            }
        }
        return numOfMatches;
    }
}
