package com.customerData;

import com.customerData.entity.Customer;
import com.customerData.report.IReport;
import com.customerData.report.UniqueCustomersPerContractId;
import com.customerData.util.PrintUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerDataMainApp {

    /**
     * Main method
     * @param args 0 - User Input, 1 - File Input
     */
    public static void main(final String[] args) {
        CustomerDataMainApp customerDataMainApp = new CustomerDataMainApp();
        final List<Customer> customers = customerDataMainApp.createCustomers(args);
        customerDataMainApp.generateReport(customers);
    }

    public List<Customer> createCustomers(final String[] args) {
        Stream<String> data = input(args);
        List<Customer> customers = data.map(Customer::new).collect(Collectors.toList());
        return Collections.unmodifiableList(customers);
    }

    /**
     * Generate the reports.
     * @param customers list of customers
     */
    public final void generateReport(final List<Customer> customers) {
        final IReport<Integer> customersPerContractId = new UniqueCustomersPerContractId();
        PrintUtil.printData(customersPerContractId.generate(customers).orElse(0).toString());
    }

    private Stream<String> input(final String[] args) {
        switch (args.length) {
            case 0:
                return stdinStream();
            case 1:
                return fileStream(args[0]);
            default:
                PrintUtil.printData("For file Input: run as java -jar <app>.jar <filename with path> ");
                PrintUtil.printData("For console input: run as java -jar <app>.jar");
                return Stream.empty();
        }
    }

    /**
     * Converts stdin data into stream.
     */
    private Stream<String> stdinStream() {
        return new BufferedReader(new InputStreamReader(System.in)).lines();
    }

    /**
     * Reads the input file.
     */
    private Stream<String> fileStream(String fileName) {
        try {
            return Files.lines(Paths.get(getClass().getClassLoader().getResource(fileName).toURI()));
        } catch (IOException | NullPointerException e) {
            PrintUtil.printData("File read error: " + e.getMessage());
            PrintUtil.printData("File Input: run as java -jar <app>.jar <filename with path> ");
            PrintUtil.printData("Console input: run as java -jar <app>.jar");
            return Stream.empty();
        }
        catch (Exception e) {
            PrintUtil.printData("File read exception: " + e.getMessage());
            return Stream.empty();
        }
    }
}
