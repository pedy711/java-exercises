package com.exercises.year2023.zalando.task2;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(5, 10, 2));
    }
    public static String solution(int AA, int AB, int BB) {
        // Implement your solution here
        Map<String, Integer> map = new HashMap<>();
        map.put("AA", AA);
        map.put("AB", AB);
        map.put("BB", BB);
        System.out.println(map);
        Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMap);

        List<String> sortedArr = new ArrayList<>(sortedMap.keySet());

        System.out.println(sortedArr);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sortedMap.get(sortedArr.get(0)); i++) {
            if(sortedMap.get(sortedArr.get(0)) > 0) {
                result.append(sortedArr.get(0));
                int value0 = sortedMap.get(sortedArr.get(0)) - 1;
                sortedMap.put(sortedArr.get(0), value0);
            }

            if(sortedMap.get(sortedArr.get(1)) > 0) {
                result.append(sortedArr.get(1));
                int value1 = sortedMap.get(sortedArr.get(1)) - 1;
                sortedMap.put(sortedArr.get(1), value1);
            }

            if(sortedMap.get(sortedArr.get(2)) > 0) {
                result.append(sortedArr.get(2));
                int value2 = sortedMap.get(sortedArr.get(2)) - 1;
                sortedMap.put(sortedArr.get(2), value2);
            }
            /*result.append(sortedArr.get(0));
            for (int j = 0; j < sortedMap.get(sortedArr.get(1)); j++) {
                result.append(sortedArr.get(0));
                for (int k = 0; k < sortedMap.get(sortedArr.get(2)); k++) {
                    result.append(sortedArr.get(0));
                }
            }*/
        }

        return result.toString();
    }
}
