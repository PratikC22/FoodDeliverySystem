package com.bridgelabz.workshop;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class OrderManager {
    private static OrderManager instance;
    Set<Order> orderSet = new HashSet<>();
    static Scanner sc = new Scanner(System.in);

    private OrderManager() {
    }

    public static synchronized OrderManager getInstance() {
        if (instance == null)
            instance = new OrderManager();
        return instance;
    }

    public void add(Order order) {
        orderSet.add(order);
    }

    public void viewAllOrder() {
        Stream.of(orderSet).forEach(System.out::println);
    }

    public void printAllWaitingOrders() {
        orderSet.stream().filter(x -> x.getOrderStatus() == Order.OrderStatus.WAITING)
                .forEach(System.out::println);
    }

    public void printAllPreparedOrders() {
        orderSet.stream().filter(x -> x.getOrderStatus() == Order.OrderStatus.ORDER_PREPARED)
                .forEach(System.out::println);
    }

    public void printAllDeliveredOrders() {
        orderSet.stream().filter(x -> x.getOrderStatus() == Order.OrderStatus.ORDER_DELIVERED)
                .forEach(System.out::println);
    }

    public void printAllCancelledOrders() {
        orderSet.stream().filter(x -> x.getOrderStatus() == Order.OrderStatus.CANCELLED)
                .forEach(System.out::println);
    }

    public void cancelOrder() {
        System.out.println("Enter orderID");
        int orderID = sc.nextInt();
        Order order = getOrder(orderID);
        if (order == null) {
            System.out.println("Order not found");
        } else {
            order.setOrderStatus(Order.OrderStatus.CANCELLED);
            System.out.println("Order cancelled successfully.");
        }
    }

    public void updateOrderStatus() {
        System.out.println("Enter orderID");
        int orderID = sc.nextInt();
        Order order = getOrder(orderID);
        System.out.println("1.Order prepared, 2.Order delivered");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> order.setOrderStatus(Order.OrderStatus.ORDER_PREPARED);
            case 2 -> order.setOrderStatus(Order.OrderStatus.ORDER_DELIVERED);
        }
        System.out.println("Status changed successfully.");
    }

    public Order getOrder(int orderID) {
        Order order = orderSet.stream().filter(x -> x.getOrderID() == orderID)
                .findFirst().orElse(null);
        if (order == null) {
            System.out.println("Order not found");
        }
        return order;
    }
}
