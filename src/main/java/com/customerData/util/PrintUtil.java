package com.customerData.util;

/**
 * The class is used to print the data.
 * This is wrapper to System.print. It will make easy to direct the output in future if application
 * decides to use any library(e.g. LOG4J).
 */
public final class PrintUtil {
    public static void print(String printString) {
        System.out.print(printString);
    }

    public static void printData(String printString) {
        System.out.println(printString);
    }
}
