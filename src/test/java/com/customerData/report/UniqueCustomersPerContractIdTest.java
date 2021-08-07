package com.customerData.report;

import com.customerData.CustomerDataMainApp;
import com.customerData.entity.Customer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UniqueCustomersPerContractIdTest {

    private static UniqueCustomersPerContractId uniqueCustomersPerContractId;

    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final static PrintStream originalOut = System.out;

    @BeforeAll
    static void init() {
        uniqueCustomersPerContractId = new UniqueCustomersPerContractId();
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    static void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testUniqueCustomersPerContractId() {
        final String[] inputArgs = {"SampleDataValid.txt"};

        final List<Customer> customers = new CustomerDataMainApp().getCustomers(inputArgs);
        assertEquals(3, uniqueCustomersPerContractId.uniqueCustomers(customers, 2345));
        assertEquals(2, uniqueCustomersPerContractId.uniqueCustomers(customers, 2346));
        assertEquals(0, uniqueCustomersPerContractId.uniqueCustomers(customers, 2347));
    }

    @Test
    void uniqueCustomersPerContractId() {
        String[] data = {
                "2343225,2345,us_east,RedTeam,ProjectApple,3445s",
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s",
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s",
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221s",
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s"
                };

        List<Customer> customers = Arrays.stream(data).map(Customer::new).collect(Collectors.toList());

        assertEquals(3, uniqueCustomersPerContractId.uniqueCustomers(customers, 2345));
        assertEquals(2, uniqueCustomersPerContractId.uniqueCustomers(customers, 2346));
        assertEquals(0, uniqueCustomersPerContractId.uniqueCustomers(customers, 2347));

        assertTrue(outContent.toString().contains("|     2345      |       3      |"));
        assertTrue(outContent.toString().contains("|     2346      |       2      |"));
    }
}
