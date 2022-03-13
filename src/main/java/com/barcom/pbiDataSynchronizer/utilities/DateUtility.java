package com.barcom.pbiDataSynchronizer.utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DateUtility {

    public static LocalDateTime convertStringToDate(String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateString, formatter);
    }

    public static LocalDateTime getStartOfDay(LocalDateTime date){
        return date.toLocalDate().atStartOfDay();
    }

    public static LocalDateTime getEndOfDay(LocalDateTime date){
        return LocalTime.MAX.atDate(date.toLocalDate());
    }


    public static String convertDateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }


    public static String convertDateToString(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }

    public static String convertDateToStringShortWithDots(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(formatter);
    }


    public static String convertDateToStringWithQuotes(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("''yyyy-MM-dd HH:mm:ss''");
        return date.format(formatter);

    }
}
