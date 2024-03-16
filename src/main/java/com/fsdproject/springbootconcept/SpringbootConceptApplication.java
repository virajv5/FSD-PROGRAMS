package com.fsdproject.springbootconcept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class SpringbootConceptApplication {

    @RequestMapping("/")
    String hello(){
        return "Hello World";
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringbootConceptApplication.class, args);
    }

}
