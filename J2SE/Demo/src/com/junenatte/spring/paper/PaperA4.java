package com.junenatte.spring.paper;

import org.springframework.stereotype.Component;

@Component("paperA4")
public class PaperA4 implements IPaper {
    private String name;

    PaperA4() {
        name = "这是A4纸张";
    }

    @Override
    public String getPaperName() {
        return name;
    }
}
