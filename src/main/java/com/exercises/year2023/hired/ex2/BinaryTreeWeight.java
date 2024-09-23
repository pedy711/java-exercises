package com.exercises.year2023.hired.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class BinaryTreeWeight {
    /*
    Suppose you're given a binary tree represented as an array. For example, [3,6,2,9,-1,10]
    represents the following binary tree (where -1 is a non-existent node):

    Write a function that determines whether the left or right branch of the tree is larger.
    The size of each branch is the sum of the node values. The function should return
    the string "Right" if the right side is larger and "Left" if the left side is larger.
    If the tree has 0 nodes or if the size of the branches are equal, return the empty string.

    Example Input:

    [3, 6, 2, 9, -1, 10]

    example answer: Left
    */

    public static void main(String[] args) {
        /*long[] arr = {1};*/
        long[] arr = {3, 6, 2, 9, -1, 10};
        /*long[] arr = {1, 10, 5, 1, 0, 6};*/
        /*long[] arr = {};*/
        System.out.println(solution(arr));
    }
    public static String solution(long[] arr) {
        // Type your solution here
        List<Long> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());

        List<Long> leftHalf = new ArrayList<>();
        List<Long> rightHalf = new ArrayList<>();

        if(arrList.isEmpty() || arrList.size() < 2)
            return "";

        traverseBinaryTree(arrList, 1, leftHalf, rightHalf);

        Long leftSum = leftHalf.stream().reduce(Long::sum).orElse(0L);
        Long rightSum = rightHalf.stream().reduce(Long::sum).orElse(0L);
        if(leftSum.equals(rightSum)) {
            return "";
        } else if (leftSum > rightSum)
            return "Left";
        else
            return "Right";


        /*LongStream stream1 = Arrays.stream(arr);
        LongStream stream2 = Arrays.stream(arr);

        LongPredicate predicate = e -> e == -1;

        LongStream leftSide = stream1.filter(predicate.negate());
        LongStream rightSide = stream2.filter(predicate);



        return null;*/
    }

    private static int traverseBinaryTree(List<Long> arrList, int level, List<Long> leftHalf, List<Long> rightHalf) {
        int numberOfNodesInLevel = level * 2;
        int arrListGlobalIndex = numberOfNodesInLevel - 1;

        for(int i = 0; i < numberOfNodesInLevel; i++) {
            if(arrListGlobalIndex >= arrList.size() || arrList.get(arrListGlobalIndex) == -1) {
                arrListGlobalIndex++;
                continue;
            }
            else if(i < (numberOfNodesInLevel / 2)) {
                leftHalf.add(arrList.get(arrListGlobalIndex));
            } else
                rightHalf.add(arrList.get(arrListGlobalIndex));

            arrListGlobalIndex++;
            if(arrListGlobalIndex >= arrList.size())
                return arrListGlobalIndex;
        }

        return traverseBinaryTree(arrList, ++level, leftHalf, rightHalf);
    }
}


