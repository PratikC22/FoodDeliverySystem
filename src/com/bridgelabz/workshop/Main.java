package com.bridgelabz.workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    FoodManager foodManager = FoodManager.getInstance();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();

        main.showMenu();
    }

    void addFoodItem() {
        FoodItem foodItem = new FoodItem();

        System.out.println("Enter food name :");
        foodItem.name = sc.next().concat(sc.nextLine());

        System.out.println("Enter food type :");
        System.out.println("1.VEG, 2.NON_VEG ");
        int type = sc.nextInt();
        if (type == 1) {
            foodItem.type = FoodItem.Type.VEG;
        } else {
            foodItem.type = FoodItem.Type.NON_VEG;
        }

        System.out.println("Enter food category :");
        System.out.println("1.MAIN_COURSE, 2.STARTER, 3.SNACKS, 4.DESSERT, 5.JUICE");
        switch (sc.nextInt()) {
            case 1 -> foodItem.category = FoodItem.Category.MAIN_COURSE;
            case 2 -> foodItem.category = FoodItem.Category.STARTER;
            case 3 -> foodItem.category = FoodItem.Category.SNACKS;
            case 4 -> foodItem.category = FoodItem.Category.DESSERT;
            case 5 -> foodItem.category = FoodItem.Category.JUICE;
        }

        System.out.println("Enter food taste :");
        System.out.println("1.SPICY, 2.SWEET, 3.SOUR");
        switch (sc.nextInt()) {
            case 1 -> foodItem.taste = FoodItem.Taste.SPICY;
            case 2 -> foodItem.taste = FoodItem.Taste.SWEET;
            case 3 -> foodItem.taste = FoodItem.Taste.SOUR;
        }

        System.out.println("Enter preparation time :");
        foodItem.prepTime = sc.nextInt();

        System.out.println("Enter food price :");
        foodItem.price = sc.nextInt();

        foodManager.addFoodItems(foodItem);
    }

    void showMenu() {
        int choice = 0;
        while (choice != 10) {
            System.out.println("\n1.Add food item ");
            System.out.println("2.Show food item ");
            System.out.println("3.Update food item ");
            System.out.println("4.Remove a food item ");
            System.out.println("5.Place order ");
            System.out.println("10.Exit\n");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addFoodItem();
                    break;
                case 2:
                    foodManager.printAllFoodItems();
                    break;
                case 3:
                    updateFoodItem();
                    break;
                case 4:
                    foodManager.removeFoodItem();
                case 5:
                    placeOrder();
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Please enter valid input");
            }
        }
    }

    void updateFoodItem() {
        System.out.println("\n1.Change taste\n2.Change price\n3.Change preparation time\n4.Change category");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> updateTaste();
            case 2 -> updatePrice();
            case 3 -> updatePrepTime();
            case 4 -> updateCategory();
        }
    }

    void updateTaste() {
        System.out.println("Enter food name ");
        String itemName = sc.next().concat(sc.nextLine());
        FoodItem foodItem = foodManager.getFoodItem(itemName);
        System.out.println("Change taste to ");
        System.out.println("1.Spicy, 2.Sweet, 3.Sour");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> foodItem.taste = FoodItem.Taste.SPICY;
            case 2 -> foodItem.taste = FoodItem.Taste.SWEET;
            case 3 -> foodItem.taste = FoodItem.Taste.SOUR;
        }
    }

    private void updatePrice() {
        System.out.println("Enter food name ");
        String itemName = sc.next().concat(sc.nextLine());
        FoodItem foodItem = foodManager.getFoodItem(itemName);

        System.out.println("Enter new price ");
        foodItem.price = sc.nextInt();
    }

    private void updatePrepTime() {
        System.out.println("Enter food name ");
        String itemName = sc.next().concat(sc.nextLine());
        FoodItem foodItem = foodManager.getFoodItem(itemName);

        System.out.println("Enter new preparation time ");
        foodItem.prepTime = sc.nextInt();
    }

    private void updateCategory() {
        System.out.println("Enter food name ");
        String itemName = sc.next().concat(sc.nextLine());
        FoodItem foodItem = foodManager.getFoodItem(itemName);
        System.out.println("1.MAIN_COURSE, 2.STARTER, 3.SNACKS, 4.DESSERT, 5.JUICE");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> foodItem.category = FoodItem.Category.MAIN_COURSE;
            case 2 -> foodItem.category = FoodItem.Category.STARTER;
            case 3 -> foodItem.category = FoodItem.Category.SNACKS;
            case 4 -> foodItem.category = FoodItem.Category.DESSERT;
            case 5 -> foodItem.category = FoodItem.Category.JUICE;
        }
    }

    void placeOrder() {
        Order order = new Order();
        List<Order> orderList = new ArrayList<>();

        String name = "";
        while (!name.equals("quit")) {
            System.out.println("Please enter food name :");
            name = sc.next().concat(sc.nextLine());
            FoodItem foodItem = foodManager.getFoodItem(name);

            if (foodItem == null && !name.equalsIgnoreCase("quit")) {
                System.out.println("Please enter correct name");
            } else {
                System.out.println("Please enter food quantity :");
                int quantity = sc.nextInt();
                order.hMap.put(foodItem, quantity);
                System.out.println("Total amount payable : " + order.setTotalPrice());
            }

        }

        System.out.println("\nPlease enter customer name :");
        String customerName = sc.next().concat(sc.nextLine());
        order.setCustomerName(customerName);

        System.out.println("Please enter address :");
        order.setDeliveryAddress(sc.next().concat(sc.nextLine()));

        System.out.println("Please enter mobile number :");
        order.setMobileNumber(sc.nextLong());

        System.out.println("Select payment method :");
        System.out.println("1.COD, 2.CREDIT_CARD, 3.DEBIT_CARD, 4.NET_BANKING, 5.UPI, 6.WALLET");
        switch (sc.nextInt()) {
            case 1 -> order.setPaymentMethods(Order.PAYMENT_METHODS.COD);
            case 2 -> order.setPaymentMethods(Order.PAYMENT_METHODS.CREDIT_CARD);
            case 3 -> order.setPaymentMethods(Order.PAYMENT_METHODS.DEBIT_CARD);
            case 4 -> order.setPaymentMethods(Order.PAYMENT_METHODS.NET_BANKING);
            case 5 -> order.setPaymentMethods(Order.PAYMENT_METHODS.UPI);
            case 6 -> order.setPaymentMethods(Order.PAYMENT_METHODS.WALLET);
        }
        order.setDateAndTime(new java.util.Date(System.currentTimeMillis()));
        orderList.add(order);
        System.out.println(orderList);
    }
}

