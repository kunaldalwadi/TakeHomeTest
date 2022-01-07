package com.example.kunal.takehometest;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String formatPhoneNumber(String phoneNumber) {

        if (phoneNumber.length() < 11) {
            return phoneNumber;
        }

        StringBuilder stringBuilder = new StringBuilder();
        String part1 = phoneNumber.substring(1, 4);
        String part2 = phoneNumber.substring(4, 7);
        String part3 = phoneNumber.substring(7);

        stringBuilder.append("+1(").append(part1).append(")").append(part2).append("-").append(part3);

        return stringBuilder.toString();
    }

    public static String formatDate(String dateString) {

        try {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat spf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date date = spf.parse(dateString);

            return DateFormat.getDateInstance(DateFormat.LONG).format(date);
        }
        catch (ParseException ex)
        {
            return dateString;
        }
    }

}
