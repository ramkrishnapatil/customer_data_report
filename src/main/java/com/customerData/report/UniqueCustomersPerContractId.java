package com.customerData.report;

import com.customerData.entity.Customer;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * This will generate the Unique customers reprot per Contract Id.
 */
public class UniqueCustomersPerContractId implements IReport<Integer> {

    @Override
    public Optional<Integer> generate(List<Customer> customers) {
        return Optional.empty();
    }
}
