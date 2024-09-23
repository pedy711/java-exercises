package com.exercises.year2023.codility.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(9));
    }
    public static int solution(int N) {
        // Implement your solution here
        List<Integer> zeroGroups = new ArrayList<>();

        String binaryString = Integer.toBinaryString(N);

        char[] charArray = binaryString.toCharArray();/**/

        long count = binaryString.chars().filter(c -> c == '0').count();
        if(count < 1)
            return 0;

        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '1' && i + 1 < charArray.length && charArray[i+1] != '1') {
                int counter = 0;
                boolean validBinaryGap = false;
                for (int j = i + 1; charArray[i + 1] != '1' && j < charArray.length; j++) {
                    if(charArray[j] == '0' )
                        counter++;

                    if(j+1 < charArray.length && charArray[j+1] == '1') {
                        validBinaryGap = true;
                        break;
                    }
                }
                if (validBinaryGap){
                    zeroGroups.add(counter);
                    validBinaryGap = false;
                }
                counter = 0;
            }
        }

        return zeroGroups.stream().reduce(Integer::max).orElse(0);
    }
}