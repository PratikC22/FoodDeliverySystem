package com.bridgelabz.workshop;

import java.util.Objects;

public class FoodItem {
    enum Taste {SPICY, SWEET, SOUR}

    enum Category {MAIN_COURSE, STARTER, SNACKS, DESSERT, JUICE}

    enum Type {VEG, NON_VEG}

    String name;
    Type type;
    Category category;
    Taste taste;
    int prepTime;
    int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodItem foodItem)) return false;
        return prepTime == foodItem.prepTime && price == foodItem.price && name.equals(foodItem.name) && type == foodItem.type && category == foodItem.category && taste == foodItem.taste;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, category, taste, prepTime, price);
    }

    @Override
    public String toString() {
        return "FoodItem : " +
               "name = " + name +
               ", type = " + type +
               ", category = " + category +
               ", taste = " + taste +
               ", prepTime = " + prepTime +
               ", price = " + price;
    }
}