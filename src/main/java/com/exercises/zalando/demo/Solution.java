package com.exercises.zalando.demo;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        // int[] arr = new int[]{1, 3, 6, 4, 1, 2};
        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
    }
    public static int solution(int[] A) {
        Set<Integer> collect = IntStream.of(A).sorted().filter(i -> i > 0).boxed().collect(Collectors.toSet());
        int i1 = IntStream.of(A).sorted().filter(i -> i>0).min().orElseThrow();

        int selectedNumber = 0;
        do {
            if(collect.contains(selectedNumber))
                selectedNumber++;
        }while (i1 > selectedNumber);

        return selectedNumber;
    }
}