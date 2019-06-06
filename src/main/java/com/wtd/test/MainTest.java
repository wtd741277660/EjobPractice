package com.wtd.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("application-job-config.xml");
    }
}
