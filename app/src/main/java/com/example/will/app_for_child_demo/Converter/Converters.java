package com.example.will.app_for_child_demo.Converter;

import android.arch.persistence.room.TypeConverter;

import java.sql.Date;


// to enable date type in child entity to be stored in DB
public class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}