package com.customerData.report;

import com.customerData.CustomerDataMainApp;
import com.customerData.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UniqueCustomersPerContractIdTest {

    private static UniqueCustomersPerContractId uniqueCustomersPerContractId;
    private static List<Customer> customerList;

    @BeforeAll
    public static void init() {
        final String[] inputArgs = {"SampleData.txt"};
        CustomerDataMainApp customerDataMainApp = new CustomerDataMainApp();
        customerList = customerDataMainApp.createCustomers(inputArgs);
        uniqueCustomersPerContractId = new UniqueCustomersPerContractId();
    }

    @Test
    void testUniqueCustomersPerContractId() {
        Assertions.assertEquals(uniqueCustomersPerContractId.generate(customerList).orElse(0), 2);
    }
}
