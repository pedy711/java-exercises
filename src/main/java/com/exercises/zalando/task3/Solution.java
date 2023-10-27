package com.exercises.zalando.task3;

import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("AAAAAAABBBBB"));;
    }
    public static String solution(String S) {
        // Implement your solution here
        S = S.toUpperCase();
        String distinctChars = S.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

/*        String upperCase = distinctStr.toUpperCase();*/
        if(containsOnlyAllowedCharacters(distinctChars) && distinctChars.length() > 1){
            boolean changed = true;

            while(changed){
                int lastLength = S.length();
                S = removeOccurrencesStrings(S);
                if(lastLength == S.length())
                    changed = false;
            }

        }

        return S;
    }

    public static boolean containsOnlyAllowedCharacters(String str) {
        return str.matches("^[A-D]+$");
    }

    public static String removeOccurrencesStrings(String input) {
        String pattern = "AB|BA|CD|DC";

        return input.replaceAll(pattern, "");
    }
}