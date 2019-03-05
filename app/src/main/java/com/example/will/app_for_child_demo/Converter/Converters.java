package com.example.will.app_for_child_demo.Converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Converters {
    // to enable date type in child entity to be stored in DB
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    public static int daysBetween(Date d1, Date d2){
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static String getAge(Date d) {
        Date today = new Date();
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        cal1.setTime(d);
        cal2.setTime(today);
        int weeks = Converters.daysBetween(cal1.getTime(),cal2.getTime()) / 7;
        int months = weeks / 4;
        weeks %= 4;
        String age = String.valueOf(months) + " m " + String.valueOf(weeks) + " w";
        return age;
    }

    public static boolean ifPassedToday(Date d) {
        Date today = new Date();
        return d.getTime() > today.getTime();
    }

    public static boolean ifWithinThirtyDays(Date d) {
        Date today = new Date();
        int daysD = (int) (d.getTime() / (1000 * 60 * 60 * 24));
        int daysToday = (int) (today.getTime() / (1000 * 60 * 60 * 24));
//        System.out.println("today: " + String.valueOf(daysToday) + " target day: " + String.valueOf(daysD));
        return daysD < daysToday && daysD > daysToday - 30;
    }
}