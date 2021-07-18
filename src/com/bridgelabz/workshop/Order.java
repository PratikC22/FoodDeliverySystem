package com.bridgelabz.workshop;

import java.util.*;

public class Order {
    enum PAYMENT_METHODS{COD, CREDIT_CARD, DEBIT_CARD, NET_BANKING, UPI, WALLET}

    Map<FoodItem,Integer> hMap = new HashMap<>();

    private String customerName;
    private long mobileNumber;
    private String deliveryAddress;
    private int totalPrice;
    PAYMENT_METHODS paymentMethods;
    private java.util.Date dateAndTime;

    @Override
    public String toString() {
        return "Order : " +
               "customerName = '" + customerName + '\'' +
               ", mobileNumber = " + mobileNumber +
               ", deliveryAddress = '" + deliveryAddress + '\'' +
               ", totalPrice = " + totalPrice +
               ", paymentMethods = " + paymentMethods +
               ", dateAndTime = " + dateAndTime;
    }

    public int setTotalPrice() {
        totalPrice = 0;
        for (Map.Entry<FoodItem,Integer> i : hMap.entrySet()) {
            totalPrice += i.getKey().price * i.getValue();
        } return totalPrice;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void setPaymentMethods(PAYMENT_METHODS paymentMethods) {
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
}

