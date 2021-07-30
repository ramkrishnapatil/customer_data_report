package com.customerData.filter;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Utility to filter the data by distinct desired key.
 */
public final class FilterCustomer {

    private FilterCustomer() {
    }

    /**
     * Filter by a specific attribute.
     */
    public static <T> Predicate<T> distinctByKey(Function<T, Object> function) {
        Set<Object> seen = new HashSet<>();
        return t -> seen.add(function.apply(t));
    }
}
