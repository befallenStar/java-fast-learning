package com.junenatte.spring.box;

import org.springframework.stereotype.Component;

@Component("colorBox")
public class ColorBox implements IBox {
    private String name;

    ColorBox() {
        name = "彩色墨盒";
    }

    public String getName() {
        return name;
    }

    @Override
    public String getIntColor() {
        return "颜色太多了";
    }
}
