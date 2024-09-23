package com.exercises.year2023.klarna.challenge1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Smoothie {
    // Define the menu items and their ingredients
    private static final String[][] MENU = {
            {"Classic", "strawberry", "banana", "pineapple", "mango", "peach", "honey"},
            {"Freezie", "blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt"},
            {"Greenie", "green apple", "lime", "avocado", "spinach", "ice", "apple juice"},
            {"Just Desserts", "banana", "ice cream", "chocolate", "peanut", "cherry"}
    };

    public static String ingredients(String order) {
        String result;
        if(order != null && !order.isBlank()) {
            String[] parts = order.split(",");
            if (parts.length < 1) {
                throw new IllegalArgumentException("Invalid input");
            }

            String menuItem = parts[0];
            Set<String> restrictions = new HashSet<>();

            for (int i = 1; i < parts.length; i++) {
                String ingredient = parts[i].trim();
                if (ingredient.startsWith("-")) {
                    restrictions.add(ingredient.substring(1)); // Remove the '-' sign
                } else {
                    throw new IllegalArgumentException("Invalid input");
                }
            }

            String[] menuIngredients = null;
            for (String[] item : MENU) {
                if (item[0].equals(menuItem)) {
                    menuIngredients = Arrays.copyOfRange(item, 1, item.length);
                    break;
                }
            }

            if (menuIngredients == null) {
                throw new IllegalArgumentException("Invalid menu item");
            }

            Set<String> validIngredients = new HashSet<>(Arrays.asList(menuIngredients));
            validIngredients.removeAll(restrictions);

/*        if (!validIngredients.containsAll(restrictions)) {
            throw new IllegalArgumentException("Invalid input");
        }*/

            result = validIngredients.stream()
                    .sorted()
                    .reduce((a, b) -> a + "," + b)
                    .orElse("");

        } else {
            throw new IllegalArgumentException("Order came in either faulty or empty!");
        }


        return result;
    }
}