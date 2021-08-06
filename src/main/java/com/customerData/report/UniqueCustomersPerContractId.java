package com.customerData.report;

import com.customerData.entity.Customer;
import com.customerData.util.PrintUtil;

import java.util.List;

import static com.customerData.filter.FilterCustomer.distinctByKey;

/**
 * This will generate the Unique customers report per Contract Id.
 */
public class UniqueCustomersPerContractId implements IReport {

    /**
     * {@inheritDoc}
     */
    @Override
    public void generate(List<Customer> customers) {
        PrintUtil.printData("The number of unique customerId for each contractId");
        PrintUtil.printData(IReport.SEP_LINE);

        customers.stream()
                .filter(distinctByKey(Customer::getContractId))
                .mapToInt(Customer::getContractId)
                .forEach(contractId -> uniqueCustomers(customers, contractId));

        PrintUtil.printData(IReport.SEP_LINE);
    }

    /**
     * Filter the Customers per contract id.
     * @param customers List of customers
     * @param contractId ConractId
     * @return Number of matching unique Customers
     */
    final int uniqueCustomers(final List<Customer> customers, final int contractId) {
        int uniqueCustomers = (int) customers.stream()
                                            .filter(c -> c.getContractId() == contractId)
                                            .filter(distinctByKey(Customer::getId))
                                            .count();
        PrintUtil.printData( "|     "   + contractId + "      |       " + uniqueCustomers + "      |");
        return uniqueCustomers;
    }
}
