package com.newyork.rooftop.fooddeliverymanager;

import com.newyork.rooftop.fooddeliverymanager.entities.Customer;

public interface DeliveryManagerService {
    void addCustomer(Customer customer);
    void processCustomerQueue();
    void initWithDeliveryBoyCount(Integer deliverBoyCount);
}
