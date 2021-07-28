package com.customerData.entity;


import com.customerData.util.PrintUtil;

import java.time.Duration;

public class Customer {

    private int id;

    private int contractId;

    private String geoZone;

    private String teamCode;

    private String projectCode;

    private Duration buildDuration;

    private static final String DURATION_PT = "PT";

    /**
     * Constructor
     */
    public Customer(final String line) {
        final String[] attributes = line.split(",");
        try {
            id = Integer.parseInt(attributes[CustomerField.ID.ordinal()].trim());
            contractId = Integer.parseInt(attributes[CustomerField.CONTRACT_ID.ordinal()].trim());
            geoZone = attributes[CustomerField.GEO_ZONE.ordinal()].trim();
            teamCode = attributes[CustomerField.TEAM_CODE.ordinal()].trim();
            projectCode = attributes[CustomerField.PROJECT_CODE.ordinal()].trim();
            buildDuration = Duration.parse(DURATION_PT + attributes[CustomerField.BUILD_DURATION.ordinal()].trim());
        } catch (NumberFormatException nFE) {
            PrintUtil.printData("record has invalid ids : " + line + " \n with exception: " + nFE.getMessage());
        }
        catch (final Exception e) {
            PrintUtil.printData("record not loaded due to invalid syntax: " + line + " \n with exception: " + e.getMessage());
        }
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

    public Duration getBuildDuration() {
        return buildDuration;
    }

}
