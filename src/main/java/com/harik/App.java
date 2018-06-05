package com.harik;

/**
 * Hello world!
 *
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App
{
    public static void main(String[] args) {
        SpringApplication bootApplication = new SpringApplication(App.class);
        bootApplication.run();
    }
}
