package com.exercises.klarna;

import java.util.Scanner;

class Challenge {
    // Complete this function to return either
    // "Hello, [name]!" or "Hello there!"
    // based on the input
    public static void main(String[] args) {
     }

    private static void displayMenu() {
        System.out.println("Classic: strawberry, banana, pineapple, mango, peach, honey");
        System.out.println("Freezie: blackberry, blueberry, black currant, grape juice, frozen yogurt");
        System.out.println("Greenie: green apple, lime, avocado, spinach, ice, apple juice");
        System.out.println("Just Desserts: banana, ice cream, chocolate, peanut, cherry");
    }

    private static int getUserChoice(Scanner scanner) {
        int choice = 0;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine();
        }
        return choice;
    }

    public static String sayHello(String name) {
        // You can print to STDOUT for debugging if you need to:
        if(name != null && !name.isEmpty()) {
            return "Hello, " + name + "!";
        } else
            return "Hello there!";

        // but you need to return the correct value in order to pass the challeng
    }
}