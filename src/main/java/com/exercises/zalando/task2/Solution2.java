package com.exercises.zalando.task2;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(solution(0, 0, 10));
    }
    public static String solution(int AA, int AB, int BB) {
        StringBuilder result = new StringBuilder();
        while (AA > 0 && BB > 0) {
            if (AA > BB) {
                result.append("AA");
                result.append("BB");
                AA -= 2;
                BB -= 1;
            } else {
                result.append("BB");
                result.append("AA");
                BB -= 2;
                AA -= 1;
            }
        }

        while (AA > 0 && !result.toString().endsWith("A")) {
            result.append("AA");
            AA--;
        }
        while (BB > 0 && !result.toString().endsWith("B")) {
            result.append("BB");
            BB--;
        }

        if(result.toString().endsWith("AA")){
            result.reverse();
        }

        while (AB > 0) {
            result.append("AB");
            AB--;
        }

        return result.toString();
    }
}

