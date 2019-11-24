package com.nrsc.elegant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @author : Sun Chuan
 * @date : 2019/11/24 12:32
 * Description：
 */
@RestController
public class MessageSourceTestController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/")
    public String justTest(String lang) {
        //获取项目服务器所在的国家
        //Locale locale = LocaleContextHolder.getLocale();

        Locale locale = null;
        switch (lang) {
            case "en_US":
                locale = Locale.US;
                break;
            case "zh_CN":
                locale = Locale.CHINA;
                break;
            default:
                locale = Locale.CHINA;
        }
        //  Locale.forLanguageTag(langs)
        String hello = messageSource.getMessage("hello", null, locale);
        return hello;
    }
}



