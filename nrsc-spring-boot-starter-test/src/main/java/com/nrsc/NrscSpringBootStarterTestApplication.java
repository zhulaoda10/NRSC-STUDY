package com.nrsc;

import com.nrsc.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.nrsc", "com.yoyo"})
@RestController
public class NrscSpringBootStarterTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(NrscSpringBootStarterTestApplication.class, args);
    }
    @Autowired
    private HelloService helloService;

    @GetMapping("/say/hello/to/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return helloService.sayHello(name);
    }
}
