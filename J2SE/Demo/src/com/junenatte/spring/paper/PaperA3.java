package com.junenatte.spring.paper;

import org.springframework.stereotype.Component;

@Component("paperA3")
public class PaperA3 implements IPaper {
    private String name;

    PaperA3() {
        name = "这是A3纸张";
    }

    @Override
    public String getPaperName() {
        return name;
    }
}
