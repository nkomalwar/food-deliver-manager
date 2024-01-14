package com.newyork.rooftop.fooddeliverymanager.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryBoy {
    Integer index;
    Integer freeTime;

    public DeliveryBoy(Integer index) {
        this.index = index;
        this.freeTime = 0;
    }
}