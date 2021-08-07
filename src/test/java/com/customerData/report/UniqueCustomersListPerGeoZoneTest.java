package com.customerData.report;

import com.customerData.CustomerDataMainApp;
import com.customerData.entity.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UniqueCustomersListPerGeoZoneTest {

    @Test
    void testUniqueCustomersPerGeoZone() {
        final String[] inputArgs = {"SampleData.txt"};
        final List<Customer> customers = new CustomerDataMainApp().getCustomers(inputArgs);
        UniqueCustomersListPerGeoZone customersPerGeoZone = new UniqueCustomersListPerGeoZone();

        assertEquals(1, customersPerGeoZone.uniqueCustomers(customers, "us_east").size());
        assertEquals(2, customersPerGeoZone.uniqueCustomers(customers, "us_west").size());
        assertEquals(2, customersPerGeoZone.uniqueCustomers(customers, "eu_west").size());

        assertTrue(customersPerGeoZone.uniqueCustomers(customers, "us_east").stream().anyMatch(c -> c.getId() == 2343225));
        assertTrue(customersPerGeoZone.uniqueCustomers(customers, "us_west").stream().anyMatch(c -> c.getId() == 1233456));
    }
}
