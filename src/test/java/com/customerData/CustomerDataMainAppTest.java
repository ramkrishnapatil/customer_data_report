package com.customerData;

import com.customerData.entity.Customer;
import com.customerData.report.CustomerReport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerDataMainAppTest {

    @Test
    void testEmptyDataFile() {
        final String[] inputArgs = { "SampleDataEmpty.txt" };
        final List<Customer> customers = new CustomerDataMainApp().getCustomers(inputArgs);
        assertTrue(customers.isEmpty());
    }

    @Test
    void testInvalidDataFile() {
        final String[] inputArgs = {"SampleDataInvalid.txt"};
        final List<Customer> customers = new CustomerDataMainApp().getCustomers(inputArgs);
        new CustomerReport().generateReports(customers);
        assertEquals(2, customers.size());
    }

    @Test
    void testGenerateReports()  {
        final String[] inputArgs = {"SampleDataInvalid.txt"};
        final List<Customer> customers = new CustomerDataMainApp().getCustomers(inputArgs);
        Assertions.assertDoesNotThrow(() -> new CustomerReport().generateReports(customers));
    }
}
