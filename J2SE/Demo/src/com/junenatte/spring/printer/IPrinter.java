package com.junenatte.spring.printer;

import com.junenatte.spring.box.IBox;
import com.junenatte.spring.paper.IPaper;

public abstract class IPrinter {
    IBox box;
    IPaper paper;

    public String getIntColor() {
        return box.getIntColor();
    }

    public String getPaperName() {
        return paper.getPaperName();
    }
}