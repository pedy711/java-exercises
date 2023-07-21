package com.exercises.hired.ex1;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exercise1 {
    public static void main(String[] args) {
 /*Write a function that takes a list of numbers, numbers, and returns the largest number in the list.
        If there are no numbers in the list, return 0.
*/
        long[] list = {2, 15, 42, 4};
        System.out.println(solution(list));

    }

    private static int getLargestNumber(List<Integer> listOfNumbers) {
        Optional<Integer> max = listOfNumbers.stream().max((a, b) -> a - b);
        return max.orElse(0);
    }

    public static long solution(long[] numbers) {
        OptionalLong reduce = LongStream.of(numbers).reduce(Long::max);
        return reduce.orElse(0);
    }
}
