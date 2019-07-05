package com.junenatte.spring.printer;

import com.junenatte.spring.box.IBox;
import com.junenatte.spring.paper.IPaper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BetterPrinter extends IPrinter {
    public BetterPrinter(@Qualifier(value = "colorBox") IBox box, @Qualifier(value = "paperA3") IPaper paper) {
        this.box = box;
        this.paper = paper;
    }
}