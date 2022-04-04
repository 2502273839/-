package com.example.demo.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final String pattern = "yyyy-MM-dd HH:mm";

    public static String parseDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) {
        System.out.println(parseDate(new Date()));
    }
}
