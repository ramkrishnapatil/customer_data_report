package com.customerData.report;

import com.customerData.entity.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to generate all reports
 */
public class CustomerReport {

    /**
     * List of all Report services
     */
    private final List<IReport> reports;

    public CustomerReport() {
        reports = new ArrayList<>();
        reports.add(new UniqueCustomersPerContractId());
        reports.add(new UniqueCustomersPerGeoZone());
        reports.add(new AvgBuildDurationPerGeoZone());
        reports.add(new UniqueCustomersListPerGeoZone());
    }

    /**
     * Generate all reports
     */
    public void generateReports(List<Customer> customers) {
        reports.forEach(report -> report.generate(customers));
    }
}
