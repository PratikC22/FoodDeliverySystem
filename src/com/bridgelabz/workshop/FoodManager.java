package com.bridgelabz.workshop;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class FoodManager {
    private static FoodManager instance;
    Set<FoodItem> foodList = new HashSet<>();

    private FoodManager() {}

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
        for (FoodItem i : foodList) {
            System.out.println(i);
        }
    }

    void printAllVegItems() {
        for (FoodItem i : foodList) {
            if (i.type.equals(FoodItem.Type.VEG))
                System.out.println(i);
        }
    }

    void printAllNonVegItems() {
        for (FoodItem i : foodList) {
            if (i.type.equals(FoodItem.Type.NON_VEG))
                System.out.println(i);
        }
    }

    public FoodItem getFoodItem(String name) {
        Iterator<FoodItem> iterator = foodList.iterator();
        for (FoodItem i : foodList) {
            if (iterator.hasNext()) {
                FoodItem foodItem = (FoodItem) iterator.next();
                if (foodItem.name.equalsIgnoreCase(name))
                    return foodItem;
            }
        }
        return null;
    }
}

