package com.junenatte.util;

import com.junenatte.bean.Point;

import org.springframework.core.convert.converter.Converter;

public class PointConverter implements Converter<String, Point> {
    public Point convert(String s) {
        String[] strs = s.split("[,]");
        if (strs.length != 2) {
            return null;
        }
        Point p = new Point();
        p.setPointx(strs[0]);
        p.setPointy(strs[1]);
        return p;
    }
}
