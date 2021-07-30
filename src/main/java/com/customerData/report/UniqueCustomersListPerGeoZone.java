package com.customerData.report;

import com.customerData.entity.Customer;
import com.customerData.util.PrintUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.customerData.filter.FilterCustomer.distinctByKey;

/**
 * This will generate the list of unique customers per GeoZone.
 */
public class UniqueCustomersListPerGeoZone implements IReport {

    /**
     * {@inheritDoc}
     */
    @Override
    public void generate(List<Customer> customers) {

        PrintUtil.printData("The number of unique customerId for each geozone");
        PrintUtil.print(IReport.SEP_LINE);
        PrintUtil.printData(IReport.SEP_LINE);

        customers.stream()
                .filter(distinctByKey(Customer::getGeoZone))
                .forEach(c -> uniqueCustomers(customers, c.getGeoZone()));
        PrintUtil.print(IReport.SEP_LINE);
        PrintUtil.printData(IReport.SEP_LINE);
    }

    /**
     * Filter the Customers per GeoZone.
     * @param customers Customers
     * @param geoZone GeoZone
     * @return Number of matching unique Customers
     */
    final List<Customer> uniqueCustomers(final List<Customer> customers, final String geoZone) {
        List<Customer> uniqueCustomers =  customers.stream()
                                                    .filter(c -> c.getGeoZone().equals(geoZone))
                                                    .filter(distinctByKey(Customer::getId))
                                                    .collect(Collectors.toList());
        PrintUtil.print( "|     "   + geoZone + "      |");
        uniqueCustomers.forEach(c -> PrintUtil.print("       " + c.getId() + "      |"));
        PrintUtil.printData("");
        return Collections.unmodifiableList(uniqueCustomers);
    }
}