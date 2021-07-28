package com.customerData.report;

import com.customerData.entity.Customer;

import java.util.List;
import java.util.Optional;

/**
 * Report service.
 */
public interface IReport<T> {

    public Optional<T> generate(List<Customer> customers);
}
