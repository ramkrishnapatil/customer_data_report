package com.customerData.report;

import com.customerData.entity.Customer;
import com.customerData.util.PrintUtil;

import java.util.List;

import static com.customerData.filter.FilterCustomer.distinctByKey;

/**
 * This will generate the average build duration per geo zone.
 */
public class AvgBuildDurationPerGeoZone implements IReport {

    /**
     * Default average value.
     */
    private static final double DEFAULT_AVERAGE = 0.0;

    /**
     * {@inheritDoc}
     */
    @Override
    public void generate(List<Customer> customers) {

        PrintUtil.printData("The average build duration for each geozone");
        PrintUtil.printData(IReport.SEP_LINE);

        customers.stream()
                .filter(distinctByKey(Customer::getGeoZone))
                .forEach(c -> avgBuildDuration(customers, c.getGeoZone()));

        PrintUtil.printData(IReport.SEP_LINE);
    }

    /**
     * Calculate average for given GeoZone
     * @param customers List of customers
     * @param geoZone GeoZone
     * @return average otherwise DEFAULT_AVERAGE
     */
    final double avgBuildDuration(final List<Customer> customers, final String geoZone) {
        double average =  customers.stream()
                                    .filter(c -> c.getGeoZone().equals(geoZone))
                                    .mapToLong(c -> c.getBuildDuration().getSeconds())
                                    .average()
                                    .orElse(DEFAULT_AVERAGE);
        PrintUtil.printData( "|     "   + geoZone + "      |       " + String.format("%.2f", average) + "      |");
        return average;
    }
}