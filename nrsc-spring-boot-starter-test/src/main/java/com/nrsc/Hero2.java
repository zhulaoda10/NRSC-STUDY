package com.nrsc;

import org.springframework.stereotype.Component;

@Component

public class Hero2 {

    private String name = "nrsc";
    private String age = "20";

    @Override
    public String toString() {
        return "Hero2{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
