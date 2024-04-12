package com.mycompany.eveonlinemarket;

public class Itemtype {
    private int typeId;
    private String name;

    public Itemtype(int typeId, String name) {
        this.typeId = typeId;
        this.name = name;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getName() {
        return name;
    }
}