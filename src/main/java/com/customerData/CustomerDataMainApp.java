package com.customerData;

import com.customerData.entity.Customer;
import com.customerData.report.CustomerReport;
import com.customerData.util.PrintUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Main application to read the data, create customers and generate the report
 */
public class CustomerDataMainApp {

    /**
     * Main method
     * @param args 0 - User Input, 1 - File Input
     */
    public static void main(final String[] args) {
        final List<Customer> customers = new CustomerDataMainApp().getCustomers(args);
        new CustomerReport().generateReports(customers);
    }

    /**
     * Create customers
     * @param args input stream
     * @return Customer list
     */
    public List<Customer> getCustomers(final String[] args) {
        Stream<String> data = input(args);
        List<Customer> customers = data.map(Customer::new)
                                    .filter(Customer::valid)
                                    .collect(Collectors.toList());
        return Collections.unmodifiableList(customers);
    }

    private Stream<String> input(final String[] args) {
        switch (args.length) {
            case 0:
                return fileStream("SampleData.txt");
            case 1:
                return fileStream(args[0]);
            default:
                printUsage();
                return Stream.empty();
        }
    }

    /**
     * Reads the input file.
     */
    private Stream<String> fileStream(String fileName) {
        try {
            return Files.lines(Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).toURI()));
        } catch (IOException | NullPointerException e) {
            PrintUtil.printData("File read error: " + e.getMessage());
            printUsage();
            return Stream.empty();
        }
        catch (Exception e) {
            e.printStackTrace();
            PrintUtil.printData("File read exception: " + e.getMessage());
            return Stream.empty();
        }
    }

    /**
     * Usage
     */
    private void printUsage() {
        PrintUtil.printData("Run as : ./gradlew run  OR ./gradlew run --args=\"<FILE_NAME>\"");
    }
}
