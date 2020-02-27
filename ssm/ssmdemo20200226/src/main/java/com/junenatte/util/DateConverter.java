package com.junenatte.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    SimpleDateFormat[] sdfs = new SimpleDateFormat[]{
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"),
            new SimpleDateFormat("dd-MM-yyyy")
    };

    public Date convert(String s) {
        for (SimpleDateFormat sdf : sdfs) {
            try {
                return sdf.parse(s);
            } catch (ParseException ignored) {
            }
        }
        return new Date();
    }
}
