package com.customerData.entity;


public class Customer {

    private int id;

    private int contractId;

    private String geoZone;

    private String teamCode;

    private String projectCode;

    private int buildDuration;

    /**
     * Constructor
     */
    public Customer() {
    }

    public int getId() {
        return id;
    }

    public int getContractId() {
        return contractId;
    }

    public String getGeoZone() {
        return geoZone;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public int getBuildDuration() {
        return buildDuration;
    }

}
