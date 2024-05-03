package com.mycompany.eveonlinemarket;

public class typeItem {
    private int typeID;
    private int groupID;
    private String typeName;
    private String description;
    private double mass;
    private double volume;
    private double capacity;
    private int portionSize;
    private int raceID;
    private double basePrice;
    private int published;
    private int marketGroupID;
    private int iconID;
    private int soundID;
    private int graphicID;

    public typeItem(int typeID, int groupID, String typeName, String description, double mass, double volume, double capacity, int portionSize, int raceID, double basePrice, int published, int marketGroupID, int iconID, int soundID, int graphicID) {
        this.typeID = typeID;
        this.groupID = groupID;
        this.typeName = typeName;
        this.description = description;
        this.mass = mass;
        this.volume = volume;
        this.capacity = capacity;
        this.portionSize = portionSize;
        this.raceID = raceID;
        this.basePrice = basePrice;
        this.published = published;
        this.marketGroupID = marketGroupID;
        this.iconID = iconID;
        this.soundID = soundID;
        this.graphicID = graphicID;
    }
}
