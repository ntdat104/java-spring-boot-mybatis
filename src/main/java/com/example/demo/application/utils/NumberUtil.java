package com.example.demo.application.utils;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

@Slf4j
public class NumberUtil {
    public static Double roundFixed(Double value) {
        if (value == null) return null;
        try {
            double roundOff  = (double) Math.round(value * 100.0) / 100.0;
            return roundOff;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static Double roundFixed(Double value, Double defaultValue) {
        if (value == null) return defaultValue;
        try {
            double roundOff  = (double) Math.round(value * 100.0) / 100.0;
            return roundOff;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return defaultValue;
        }
    }

    public static Double roundFixed(Double value, Integer scale) {
        if (value == null) return null;
        try {
            BigDecimal bd = new BigDecimal(value).setScale(scale, RoundingMode.HALF_UP);
            return bd.doubleValue();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static Double roundNoScale(Double value) {
        if (value == null) return null;
        try {
            BigDecimal bd = new BigDecimal(value).setScale(0, RoundingMode.HALF_UP);
            return bd.doubleValue();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static Double roundDown(Double value) {
        if (value == null) return null;
        try {
            BigDecimal bd = new BigDecimal(value).setScale(0, RoundingMode.DOWN);
            return bd.doubleValue();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static Double roundUp(Double value) {
        if (value == null) return null;
        try {
            BigDecimal bd = new BigDecimal(value).setScale(0, RoundingMode.UP);
            return bd.doubleValue();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }


    public static Double round(Double value) {
        if (value == null) return null;
        try {
            BigDecimal bd = new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN);
            return bd.doubleValue();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static String formatPrice(final Double value) {
        if (value == null) return "0";

        final NumberFormat currencyFormat = createCurrencyFormat();
        String price = currencyFormat.format(value);
        return price;
    }

    public static NumberFormat createCurrencyFormat() {
        final NumberFormat currencyFormat = (DecimalFormat) NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
        // don't allow multiple references
        if (currencyFormat instanceof DecimalFormat) {
            //always 123,123,344.500
            DecimalFormat decimalFormat = (DecimalFormat) currencyFormat;
            final DecimalFormatSymbols symbols = decimalFormat.getDecimalFormatSymbols();
            symbols.setGroupingSeparator(',');
            symbols.setDecimalSeparator('.');
            symbols.setCurrencySymbol(""); // put đ or vnd if need
            decimalFormat.setDecimalFormatSymbols(symbols);
            decimalFormat.setPositivePrefix("");
            decimalFormat.setPositiveSuffix(""); // put đ or vnd if need
            return decimalFormat;
        }
        return currencyFormat;
    }
}
