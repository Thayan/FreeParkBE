package com.example.FreePark.dto;

public class ParkingDTO {
    private int id;
    private String roadName;
    private String roadSuffix;
    private double longitude;
    private double latitude;
    private float costPerHour;
    private String freeAfter;
    private String payFrom;

    public ParkingDTO(int id, String roadName, String roadSuffix, double longitude, double latitude, float costPerHour, String freeAfter, String payFrom){
        this.id = id;
        this.roadName = roadName;
        this.roadSuffix = roadSuffix;
        this.longitude = longitude;
        this.latitude = latitude;
        this.costPerHour = costPerHour;
        this.freeAfter = freeAfter;
        this.payFrom = payFrom;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoadName() {
        return this.roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getRoadSuffix() {
        return this.roadSuffix;
    }

    public void setRoadSuffix(String roadSuffix) {
        this.roadSuffix = roadSuffix;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public float getCostPerHour() {
        return this.costPerHour;
    }

    public void setCostPerHour(float costPerHour) {
        this.costPerHour = costPerHour;
    }

    public String getFreeAfter() {
        return this.freeAfter;
    }

    public void setFreeAfter(String freeAfter) {
        this.freeAfter = freeAfter;
    }

    public String getPayFrom() {
        return this.payFrom;
    }

    public void setPayFrom(String payFrom) {
        this.payFrom = payFrom;
    }
}
