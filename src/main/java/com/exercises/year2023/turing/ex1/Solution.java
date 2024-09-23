package com.exercises.year2023.turing.ex1;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(5));
    }
    private static List<String> solution(int a) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            if (i%3 == 0 && i%5 == 0) {
                ans.add("Dream Team");
            }
            else if (i%3 == 0) {
                ans.add("Team Three");
            } else if(i%5 == 0) {
                ans.add("Team Five");
            } else
                ans.add("-1");
        }

        return ans;
    }
}
