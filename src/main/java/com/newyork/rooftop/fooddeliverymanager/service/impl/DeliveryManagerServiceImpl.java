package com.newyork.rooftop.fooddeliverymanager.service.impl;

import com.newyork.rooftop.fooddeliverymanager.DeliveryManagerService;
import com.newyork.rooftop.fooddeliverymanager.entities.Customer;
import com.newyork.rooftop.fooddeliverymanager.entities.DeliveryBoy;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;

@Service
public class DeliveryManagerServiceImpl implements DeliveryManagerService {
    PriorityQueue<Customer> customerQueue = new PriorityQueue<>();
    PriorityQueue<DeliveryBoy> deliveryBoyQueue = new PriorityQueue<>((db1, db2) -> db1.getFreeTime() < db2.getFreeTime() ? -1:1);

    @Override
    public void initWithDeliveryBoyCount(Integer deliverBoyCount) {
        for (int i = 1; i <= deliverBoyCount; i++) {
            deliveryBoyQueue.add(new DeliveryBoy(i));
        }
    }

    @Override
    public synchronized void addCustomer(Customer customer) {
        customerQueue.add(customer);
    }

    public synchronized void processCustomerQueue(){
        while (!customerQueue.isEmpty()) {
            Customer customer = customerQueue.poll();
            DeliveryBoy deliveryBoy = deliveryBoyQueue.poll();

            if (customer.getOrderTime() >= deliveryBoy.getFreeTime()) {
                System.out.println("C" + customer.getCustomerNumber() + " - D" + deliveryBoy.getIndex());
                deliveryBoy.setFreeTime(customer.getOrderTime() + customer.getTravelTime());
            } else {
                System.out.println("C" + customer.getCustomerNumber() + " - No Food :-(");
            }
            deliveryBoyQueue.add(deliveryBoy);
        }
    }

    public static void main(String[] args) {
        DeliveryManagerService deliveryManagerService = new DeliveryManagerServiceImpl();
        deliveryManagerService.initWithDeliveryBoyCount(2);

        // Input simulation
        deliveryManagerService.addCustomer(new Customer(1, 10, 1));
        deliveryManagerService.addCustomer(new Customer(4, 20, 2));
        deliveryManagerService.addCustomer(new Customer(15, 5, 3));
        deliveryManagerService.addCustomer(new Customer(22, 20, 4));
        deliveryManagerService.addCustomer(new Customer(24, 10, 5));
        deliveryManagerService.addCustomer(new Customer(25, 10, 6));

        //process
        deliveryManagerService.processCustomerQueue();
    }

}
