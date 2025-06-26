package com.example.demo.application.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DateUtil {

    public static final String VN_DATE_FORMAT_PATTERN = "dd/MM/yyyy";
    public static final String INTERNAL_FORMAT_PATTERN = "yyyy-MM-dd";
    public static final String MONT_YEAR_FORMAT_PATTERN = "yyyy-MM";
    public static final String MONTH_YEAR_VN_FORMAT_PATTERN = "MM/yyyy";
    public static final String YEAR_FORMAT_PATTERN = "yyyy";

    public static String parseDateString(final Date date) {
        String res = "";
        try {
            res = new SimpleDateFormat(INTERNAL_FORMAT_PATTERN).format(date);
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
        }
        return res;
    }


    public static String parseDateVnString(final Date date) {
        String res = "";
        if (date == null) {
            return res;
        }
        try {
            res = new SimpleDateFormat(VN_DATE_FORMAT_PATTERN).format(date);
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
        }
        return res;
    }

    public static String parseDateVnString(final Long date) {
        String res = "";
        if (date == null) {
            return res;
        }
        try {
            res = new SimpleDateFormat(VN_DATE_FORMAT_PATTERN).format(new Date(date));
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
        }
        return res;
    }

    public static String parseDateToString(final Date date, final String pattern) {
        String res = "";
        try {
            if (date != null && StringUtils.isNotEmpty(pattern)) {
                res = new SimpleDateFormat(pattern).format(date);
            }
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
        }
        return res;
    }

    public static String parseDateYYMMString(final Date date) {
        String res = "";
        try {
            res = new SimpleDateFormat(MONT_YEAR_FORMAT_PATTERN).format(date);
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
        }
        return res;
    }

    public static Date parseStringToDate(final String dateStr) {
        try {
            if (StringUtils.isEmpty(dateStr)) {
                return null;
            }
            return new SimpleDateFormat(INTERNAL_FORMAT_PATTERN).parse(dateStr);
        } catch (final ParseException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static Date parseStringVnToDate(final String dateStr) {
        try {
            if (StringUtils.isEmpty(dateStr)) {
                return null;
            }
            return new SimpleDateFormat(VN_DATE_FORMAT_PATTERN).parse(dateStr);
        } catch (final ParseException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }


    public static Date parseStringToDate(final String dateStr, final String pattern) {
        try {
            if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(pattern)) {
                return null;
            }
            return new SimpleDateFormat(pattern).parse(dateStr);
        } catch (final ParseException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static Long parseDateEpochSecond(final Date date) {
        return date == null ? null :  date.toInstant().getEpochSecond();
    }

    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public static Date addMonths(Date date, int months)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    public static Date addYears(Date date, int years)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        return cal.getTime();
    }

    public static Date addYearsNoTime(Date date, int years)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date newDate()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static String addMonths(String date, int months)
    {
        String res = "";
        try {
            Date parseDate = new SimpleDateFormat(INTERNAL_FORMAT_PATTERN).parse(date);
            res = parseDateString(DateUtil.addMonths(parseDate, months));
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
        }
        return res;
    }

    public static Integer getYear(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    public static Double getYearBetweenDate(String fromDate, Date toDate, Integer scale) {
        Date startDate = null;
        if(StringUtils.isNotEmpty(fromDate) && fromDate.length() == 4) {
            startDate = DateUtil.parseStringToDate(fromDate, DateUtil.YEAR_FORMAT_PATTERN);
        } else if(StringUtils.isNotEmpty(fromDate) && fromDate.length() == 7 || StringUtils.isNotEmpty(fromDate) && fromDate.length() == 6) {
            startDate = DateUtil.parseStringToDate(fromDate, DateUtil.MONTH_YEAR_VN_FORMAT_PATTERN);
        } else if(StringUtils.isNotEmpty(fromDate)) {
            startDate = DateUtil.parseStringVnToDate(fromDate);
        }

        if(startDate != null) {
            long months = ChronoUnit.MONTHS.between(startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            return NumberUtil.roundFixed((double) months/12, scale);
        }
        return null;
    }
}
