package com.customerData.report;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UniqueCustomersPerContractIdTest {

    private static UniqueCustomersPerContractId uniqueCustomersPerContractId;

    @BeforeAll
    public static void init(){
        uniqueCustomersPerContractId = new UniqueCustomersPerContractId();
    }

    @Test
    public void testUniqueCustomersPerContractId() {
        final String fileName = "SampleData.txt";
        // This shall generate 2 for 2346
        //        uniqueCustomersPerContractId.generate() = 2
    }
}
