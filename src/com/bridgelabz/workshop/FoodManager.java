package com.bridgelabz.workshop;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class FoodManager {
    private static FoodManager instance;
    Set<FoodItem> foodList = new HashSet<>();

    private FoodManager() {
    }

    public static synchronized FoodManager getInstance() {
        if (instance == null) {
            instance = new FoodManager();
        }
        return instance;
    }

    void addFoodItems(FoodItem foodItem) {
        foodList.add(foodItem);
    }

    void removeFoodItem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter food name :");
        String name = sc.next().concat(sc.nextLine());
        FoodItem foodItem = getFoodItem(name);
        if (foodItem == null) {
            System.out.println("Food item not found");
        }
        foodList.remove(foodItem);
    }

    public int getFoodCount() {
        return foodList.size();
    }

    void printAllFoodItems() {
        Stream.of(foodList).forEach(System.out::println);
    }

    void printAllVegItems() {
        foodList.stream().filter(item -> item.type.equals(FoodItem.Type.VEG))
                .forEach(System.out::println);
    }

    void printAllNonVegItems() {
        foodList.stream().filter(item -> item.type.equals(FoodItem.Type.NON_VEG))
                .forEach(System.out::println);
    }

    public FoodItem getFoodItem(String name) {
        return foodList.stream().filter(item -> item.name.equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }
}

