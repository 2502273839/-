package com.example.demo.Util;

import javax.sound.midi.Soundbank;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static final String pattern = "yyyy-MM-dd HH:mm";

    private static final String pattern_day = "yyyy-MM-dd";

    public static String parseDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static String parseDateByDay(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern_day);
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) throws ParseException {
//        Date date = new Date();
//        String s = parseDateByDay(date);
//        long time = date.getTime();
//        System.out.println(time);
//        time = time - (time % (60 * 60 * 24 * 1000)) + 16 * 60 * 60 * 1000;
//        System.out.println(time);
//        DateFormat format = DateFormat.getDateInstance();
//        System.out.println(new Date(time));
//        System.out.println(parseDateByDay(date));
//        System.out.println(date);
//        Date date1 = addDayHour(date, 12);
//        System.out.println(date1);
//        System.out.println(new Date());
//        System.out.println(getDay(new Date()));
        String s = "2022-04-05";
        String ss = "08:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date parse = simpleDateFormat.parse(s + " " + ss);
        System.out.println(parse);
    }

    public static Date addDayHour(Date date, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, num);
        return calendar.getTime();
    }

    public static Date getDay(Date date) {
        long time = date.getTime();
        time = time - (time % (60 * 60 * 24 * 1000)) + 16 * 60 * 60 * 1000;
        return new Date(time);
    }

    public static Date formatDayAndHour(String day, String hour) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date parse = simpleDateFormat.parse(day + " " + hour);
        return parse;
    }
}
