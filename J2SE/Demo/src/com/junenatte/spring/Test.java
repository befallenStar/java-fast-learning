package com.junenatte.spring;

import com.junenatte.spring.printer.BasicPrinter;
import com.junenatte.spring.printer.BetterPrinter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/junenatte/spring/spring-context.xml");
        BasicPrinter printer = context.getBean(BasicPrinter.class);
        System.out.println(printer.getIntColor());
        System.out.println(printer.getPaperName());
        BetterPrinter betterPrinter = context.getBean(BetterPrinter.class);
        System.out.println(betterPrinter.getIntColor());
        System.out.println(betterPrinter.getPaperName());
    }
}
