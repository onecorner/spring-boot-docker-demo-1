package com.example.springbootdockerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootDockerDemoApplication {

    @RestController
    @RequestMapping("/api")
    public static class RestDemo {

        @GetMapping("/test")
        public String test() {
            return "hello world";
        }

        @GetMapping("/fail")
        public void failTest() {
            System.out.println(1 / 0);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDockerDemoApplication.class, args);
    }

}
