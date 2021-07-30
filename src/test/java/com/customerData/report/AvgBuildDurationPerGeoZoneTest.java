package com.customerData.report;

import com.customerData.CustomerDataMainApp;
import com.customerData.entity.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AvgBuildDurationPerGeoZoneTest {

    private static final double DELTA = 0.1;

    @Test
    void testAveragePerGeoZone1() {
        final String[] inputArgs = {"SampleDataValid.txt"};
        final List<Customer> customers = new CustomerDataMainApp().getCustomers(inputArgs);
        AvgBuildDurationPerGeoZone avgDuration = new AvgBuildDurationPerGeoZone();

        assertEquals(3445.0, avgDuration.avgBuildDuration(customers, "us_east"), DELTA);
        assertEquals(2217.67, avgDuration.avgBuildDuration(customers, "us_west"), DELTA);
        assertEquals(4222.0, avgDuration.avgBuildDuration(customers, "eu_west"), DELTA);
    }

    @Test
    void testAveragePerGeoZone2() {
        final String[] inputArgs = {"SampleData.txt"};
        final List<Customer> customers = new CustomerDataMainApp().getCustomers(inputArgs);
        AvgBuildDurationPerGeoZone avgDuration = new AvgBuildDurationPerGeoZone();

        assertEquals(3445.0, avgDuration.avgBuildDuration(customers, "us_east"), DELTA);
        assertEquals(2216.0, avgDuration.avgBuildDuration(customers, "us_west"), DELTA);
        assertEquals(4222, avgDuration.avgBuildDuration(customers, "eu_west"), DELTA);
    }


}
