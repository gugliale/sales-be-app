package com.griesi.sales.utils;

public class TaxUtils {

    public static double roundingUp(double value) {

        return Math.ceil(value * 20) / 20;

    }

    public static double round(double value) {

        return Math.round(value * 100.0) / 100.0;

    }

}
