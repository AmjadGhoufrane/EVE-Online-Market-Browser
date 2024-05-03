package com.mycompany.eveonlinemarket;



public class Item {
    private int duration;
    private boolean isBuyOrder;
    private String issued;
    private long locationId;
    private int minVolume;
    private long orderId;
    private double price;
    private String range;
    private int systemId;
    private int typeId;
    private int volumeRemain;
    private int volumeTotal;

    private String name;

    public Item(String name, int duration, boolean isBuyOrder, String issued, long locationId, int minVolume, long orderId, double price, String range, int systemId, int typeId, int volumeRemain, int volumeTotal) {
        this.duration = duration;
        this.isBuyOrder = isBuyOrder;
        this.issued = issued;
        this.locationId = locationId;
        this.minVolume = minVolume;
        this.orderId = orderId;
        this.price = price;
        this.range = range;
        this.systemId = systemId;
        this.typeId = typeId;
        this.volumeRemain = volumeRemain;
        this.volumeTotal = volumeTotal;
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isBuyOrder() {
        return isBuyOrder;
    }

    public void setBuyOrder(boolean buyOrder) {
        isBuyOrder = buyOrder;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(int minVolume) {
        this.minVolume = minVolume;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getVolumeRemain() {
        return volumeRemain;
    }

    public void setVolumeRemain(int volumeRemain) {
        this.volumeRemain = volumeRemain;
    }

    public int getVolumeTotal() {
        return volumeTotal;
    }

    public void setVolumeTotal(int volumeTotal) {
        this.volumeTotal = volumeTotal;
    }

    @Override
    public String toString() {
        return name + ", " +
                duration + ", " +
                issued + ", " +
                minVolume + ", " +
                price + ", " +
                range + ", " +
                volumeRemain + ", " +
                volumeTotal;
    }
}