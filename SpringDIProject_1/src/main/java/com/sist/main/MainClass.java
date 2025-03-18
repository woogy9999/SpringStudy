package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        
        ApplicationContext app = new ClassPathXmlApplicationContext("app1.xml");

        Sawon sa1 = (Sawon) app.getBean("sa1");
        sa1.print();

        Sawon sa2 = (Sawon) app.getBean("sa2");
        sa2.print();

        Sawon sa3 = (Sawon) app.getBean("sa3");
        sa3.print();

        Sawon sa4 = (Sawon) app.getBean("sa4");
        sa4.print();

        Sawon sa5 = (Sawon) app.getBean("sa5");
        sa5.print();

        Sawon sa6 = (Sawon) app.getBean("sa6");
        sa6.print();
    }
}