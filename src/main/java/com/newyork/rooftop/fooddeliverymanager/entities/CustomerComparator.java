package com.newyork.rooftop.fooddeliverymanager.entities;

import java.util.Comparator;

public class CustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer customerOne, Customer customerTwo) {
        return Integer.compare(customerOne.orderTime, customerTwo.orderTime);
    }
}

