package com.junenatte.spring.box;

import org.springframework.stereotype.Component;

@Component("basicBox")
public class BasicBox implements IBox {
    private String name;

    BasicBox() {
        name = "黑白墨盒";
    }

    public String getName() {
        return name;
    }

    @Override
    public String getIntColor() {
        return "0xfffff";
    }
}
