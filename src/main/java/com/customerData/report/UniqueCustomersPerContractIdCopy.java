package com.customerData.report;

import com.customerData.entity.Customer;
import com.customerData.util.PrintUtil;

import java.util.List;
import java.util.stream.Collectors;

import static com.customerData.filter.FilterCustomer.distinctByKey;

/**
 * This will generate the Unique customers report per Contract Id.
 */
public class UniqueCustomersPerContractIdCopy implements IReport {

    /**
     * {@inheritDoc}
     */
    @Override
    public void generate(List<Customer> customers) {
        PrintUtil.printData("The number of unique customerId for each contractId");
        PrintUtil.printData(IReport.SEP_LINE);

        List<Customer> customersByContractId = customers.stream()
                                                        .filter(distinctByKey(Customer::getContractId))
                                                        .collect(Collectors.toList());

        customersByContractId.forEach(c -> uniqueCustomerPerContractId(customers, c.getContractId()));
        PrintUtil.printData(IReport.SEP_LINE);
    }

    /**
     * Filter the Customers per contract id.
     * @param customers List of customers
     * @param contractId ConractId
     * @return Number of matching unique Customers
     */
    final int uniqueCustomerPerContractId(final List<Customer> customers, final int contractId) {
        int uniqueCustomers = (int) customers.stream()
                                            .filter(c -> c.getContractId() == contractId)
                                            .filter(distinctByKey(Customer::getId))
                                            .count();
        PrintUtil.printData( "|     "   + contractId + "      |       " + uniqueCustomers + "      |");
        return uniqueCustomers;
    }
}
