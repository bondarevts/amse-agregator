package ru.amse.agregator.gui.model;


import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class Attraction {
    private String id = "";
    private String type = "";
    private String name  = "";
    private String description = "";
    private String coordinates = "";
    private String images = "";
    private String keywords = "";
    private String date_foundation = "";
    private String architect = "";
    private String cost = "";
    private String address = "";
    private String music = "";
    private String website = "";
    private String rooms = "";
    private String rating = "";
    private List<MenuItem> attractionList = new ArrayList<MenuItem>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDate_foundation() {
        return date_foundation;
    }

    public void setDate_foundation(String date_foundation) {
        this.date_foundation = date_foundation;
    }

    public String getArchitect() {
        return architect;
    }

    public void setArchitect(String architect) {
        this.architect = architect;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MenuItem> getAttractionList() {
        return attractionList;
    }

    public void setAttractionList(List<MenuItem> attractionList) {
        this.attractionList = attractionList;
    }
}