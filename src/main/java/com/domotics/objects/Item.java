package com.domotics.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Home on 30/01/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @JsonProperty("provider")
    private String provider;

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("itemID")
    private int itemID;

    @JsonProperty("itemName")
    private String itemName;

    @JsonProperty("locationID")
    private int locationID;

    @JsonProperty("locationName")
    private String locationName;

    @JsonProperty("typeID")
    private int typeID;

    @JsonProperty("value")
    private float value;

    public Item() {
    }

    public String getUid() {
        return uid;
    }

    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public int getLocationID() {
        return locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public int getTypeID() {
        return typeID;
    }

    public float getValue() {
        return value;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
