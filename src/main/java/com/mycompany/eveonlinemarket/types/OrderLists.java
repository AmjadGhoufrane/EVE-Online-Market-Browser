package com.mycompany.eveonlinemarket.types;

import java.util.ArrayList;

public class OrderLists {
    private ArrayList<Order> buyOrders;
    private ArrayList<Order> sellOrders;

    public OrderLists(ArrayList b,ArrayList s) {
        this.buyOrders = b;
        this.sellOrders = s;
    }

    public ArrayList<Order> getBuyOrders() {
        return buyOrders;
    }

    public ArrayList<Order> getSellOrders() {
        return sellOrders;
    }

    public void addBuyOrder(Order o){
        this.buyOrders.add(o);
    }

    public void addSellOrder(Order o){
        this.sellOrders.add(o);
    }
}
