package com.junenatte.spring.printer;

import com.junenatte.spring.box.IBox;
import com.junenatte.spring.paper.IPaper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasicPrinter extends IPrinter {
    public BasicPrinter(@Qualifier(value = "basicBox") IBox box, @Qualifier(value = "paperA4") IPaper paper) {
        this.box = box;
        this.paper = paper;
    }
}
