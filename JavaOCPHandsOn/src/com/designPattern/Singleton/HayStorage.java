package com.designPattern.Singleton;

public class HayStorage {
    private int quantity =5;
    private HayStorage(){}

    private static final HayStorage hayStorgae = new HayStorage();

    public static HayStorage getInstance(){
        return hayStorgae;
    }

    public synchronized void addHay(int amount){
        quantity += amount;
    }

    public synchronized boolean removeHay(int amount){
        if(quantity < amount) return false;
        quantity -= amount;
        return true;
    }
    public synchronized int getHayQuantity(){
        return quantity;
    }
}
