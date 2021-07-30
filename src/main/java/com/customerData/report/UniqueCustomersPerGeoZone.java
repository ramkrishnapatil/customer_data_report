package com.customerData.report;

import com.customerData.entity.Customer;
import com.customerData.util.PrintUtil;

import java.util.List;

import static com.customerData.filter.FilterCustomer.distinctByKey;

/**
 * This will generate the Unique customers per GeoZone.
 */
public class UniqueCustomersPerGeoZone implements IReport {

    /**
     * {@inheritDoc}
     */
    @Override
    public void generate(List<Customer> customers) {
        PrintUtil.printData("The number of unique customerId for each geozone");
        PrintUtil.printData(IReport.SEP_LINE);
        customers.stream()
                .filter(distinctByKey(Customer::getGeoZone))
                .forEach(c -> uniqueCustomers(customers, c.getGeoZone()));

        PrintUtil.printData(IReport.SEP_LINE);
    }

    /**
     * Filter the Customers per GeoZone.
     * @param customers Customers
     * @param geoZone GeoZone
     * @return Number of matching unique Customers
     */
    final int uniqueCustomers(final List<Customer> customers, final String geoZone) {
        int uniqueCustomers = (int) customers.stream()
                                            .filter(c -> c.getGeoZone().equals(geoZone))
                                            .filter(distinctByKey(Customer::getId))
                                            .count();
        PrintUtil.printData( "|     "   + geoZone + "      |       " + uniqueCustomers + "      |");
        return uniqueCustomers;
    }
}