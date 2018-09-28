package com.kdev.preparebills;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

import java.util.List;

@XmlRootElement(name = "orders")

public class Orders {

    List<Order> orders;

    public List<Order> getOrders() {

        return orders;

    }

    @XmlElement(name = "order")

    public void setOrders(List<Order> orders) {

        this.orders = orders;

    }

    public void add(Order order) {

        if (this.orders == null) {

            this.orders = new ArrayList<Order>();

        }

        this.orders.add(order);

    }
    
    public void updateOrder(Order updatedOrder, int orderIndex) {
    	
    	this.orders.set(orderIndex, updatedOrder);
    	
    }

}
