package com.newyork.rooftop.fooddeliverymanager.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer implements Comparable<Customer> {
    Integer orderTime;
    Integer travelTime;
    Integer customerNumber;

    public Customer(Integer orderTime, Integer travelTime, Integer customerNumber) {
        this.orderTime = orderTime;
        this.travelTime = travelTime;
        this.customerNumber = customerNumber;
    }
    @Override
    public int compareTo(Customer other) {
        return Integer.compare(this.orderTime, other.orderTime);
    }
}