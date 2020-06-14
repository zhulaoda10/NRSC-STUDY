package com.yoyo;

import org.springframework.stereotype.Component;

@Component
public class Hero {

    private String name = "yoyo";
    private int age = 18;

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
