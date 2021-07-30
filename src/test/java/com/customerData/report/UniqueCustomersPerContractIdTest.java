package com.customerData.report;

import com.customerData.CustomerDataMainApp;
import com.customerData.entity.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueCustomersPerContractIdTest {

    private static UniqueCustomersPerContractId uniqueCustomersPerContractId;

    @BeforeAll
    static void init() {
        uniqueCustomersPerContractId = new UniqueCustomersPerContractId();
    }

    @Test
    void testUniqueCustomersPerContractId() {
        final String[] inputArgs = {"SampleDataValid.txt"};
        final List<Customer> customers = new CustomerDataMainApp().getCustomers(inputArgs);
        assertEquals(3, uniqueCustomersPerContractId.uniqueCustomers(customers, 2345));
        assertEquals(2, uniqueCustomersPerContractId.uniqueCustomers(customers, 2346));
        assertEquals(0, uniqueCustomersPerContractId.uniqueCustomers(customers, 2347));
    }
}
