package com.test.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

    @Autowired
    private HelloService helloService;

    @Autowired
    private URLService urlService;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConsoleApplication.class);
        app.run(args);
    }

    @Override
    public void run(String... args) {
        if (args.length > 0) {
            System.out.println(helloService.getMessage(args[0]));
        } else {
            System.out.println(helloService.getMessage());
        }
        try {
            urlService.makeGetRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
