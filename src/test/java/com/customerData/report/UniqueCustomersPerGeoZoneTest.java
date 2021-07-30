package com.customerData.report;

import com.customerData.CustomerDataMainApp;
import com.customerData.entity.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueCustomersPerGeoZoneTest {

    @Test
    void testAveragePerGeoZone() {
        final String[] inputArgs = {"SampleData.txt"};
        CustomerDataMainApp customerDataMainApp = new CustomerDataMainApp();
        List<Customer> customers = customerDataMainApp.getCustomers(inputArgs);
        UniqueCustomersPerGeoZone customersPerGeoZone = new UniqueCustomersPerGeoZone();

        assertEquals( 1, customersPerGeoZone.uniqueCustomers(customers, "us_east"));
        assertEquals( 2, customersPerGeoZone.uniqueCustomers(customers, "us_west"));
        assertEquals( 2, customersPerGeoZone.uniqueCustomers(customers, "eu_west"));
    }

    @Test
    void testAveragePerGeoZone1() {
        final String[] inputArgs = {"SampleDataValid.txt"};
        CustomerDataMainApp customerDataMainApp = new CustomerDataMainApp();
        List<Customer> customers = customerDataMainApp.getCustomers(inputArgs);
        UniqueCustomersPerGeoZone customersPerGeoZone = new UniqueCustomersPerGeoZone();

        assertEquals(1, customersPerGeoZone.uniqueCustomers(customers, "us_east"));
        assertEquals(2, customersPerGeoZone.uniqueCustomers(customers, "us_west"));
        assertEquals(2, customersPerGeoZone.uniqueCustomers(customers, "eu_west"));
    }
}
