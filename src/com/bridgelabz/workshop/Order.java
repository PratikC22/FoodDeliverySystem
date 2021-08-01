package com.bridgelabz.workshop;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order {
    enum PaymentMethods {COD, CREDIT_CARD, DEBIT_CARD, NET_BANKING, UPI, WALLET}

    enum OrderStatus {WAITING, CANCELLED, ORDER_PREPARED, ORDER_DELIVERED,}

    Map<FoodItem, Integer> hMap = new HashMap<>();

    private int orderID;
    private String customerName;
    private long mobileNumber;
    private String deliveryAddress;
    private int totalPrice;
    private PaymentMethods paymentMethods;
    private OrderStatus orderStatus = OrderStatus.WAITING;
    private java.util.Date dateAndTime;

    @Override
    public String toString() {
        return "\nOrder : " + "\n" +
               "customerName = " + customerName + "\n" +
               "mobileNumber = " + mobileNumber + "\n" +
               "deliveryAddress = " + deliveryAddress + "\n" +
               "totalPrice = " + totalPrice + "\n" +
               "paymentMethods = " + paymentMethods + "\n" +
               "orderStatus = " + orderStatus + "\n" +
               "dateAndTime = " + dateAndTime + "\n";
    }

    public int setTotalPrice() {
        totalPrice = 0;
        totalPrice = hMap.entrySet().stream().map(entry -> entry.getKey().price * entry.getValue())
                .reduce(0, Integer::sum);
        return totalPrice;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void setPaymentMethods(PaymentMethods paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}

