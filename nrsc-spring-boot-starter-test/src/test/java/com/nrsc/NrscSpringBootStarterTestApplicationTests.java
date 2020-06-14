package com.nrsc;

import com.yoyo.Hero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NrscSpringBootStarterTestApplicationTests {

    @Autowired
    private Hero hero;

    @Autowired
    private Hero2 hero2;

    @Test
    void contextLoads() {
        System.out.println(hero);
        System.out.println(hero2);
    }

}
