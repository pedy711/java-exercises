package com.exercises.codility.oddoccurencesinarray;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9, 7, 3, 3, 7};
        System.out.println(solution(A));
    }
    public static int solution(int[] A) {
        if(A.length < 2)
            return A[0];

        List<Integer> list = Arrays.stream(A)
                .boxed()
                .collect(Collectors.toList());
        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(value -> value, Collectors.counting()));

        List<Integer> collect1 = collect.entrySet().stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .map(Map.Entry::getKey).collect(Collectors.toList());

        if(!collect1.isEmpty() && collect1.size() == 1) {
            return collect1.get(0);
        } else
            return 0;


        // return collect.entrySet().stream().min(Map.Entry.comparingByValue()).orElseThrow().getKey();
    }
}