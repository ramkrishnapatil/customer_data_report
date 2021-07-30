package com.customerData.report;

import com.customerData.entity.Customer;

import java.util.List;

/**
 * Report interface.
 */
public interface IReport {

    String SEP_LINE = "-------------------------------------------";

    /**
     * Generate the report for given customers
     * @param customers
     */
    void generate(List<Customer> customers);
}
