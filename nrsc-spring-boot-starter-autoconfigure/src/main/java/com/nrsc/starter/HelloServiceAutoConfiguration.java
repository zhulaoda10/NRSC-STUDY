package com.nrsc.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication //web应用才生效
@EnableConfigurationProperties(HelloProperties.class) //指定HelloProperties生效
public class HelloServiceAutoConfiguration {

    @Autowired
    HelloProperties helloProperties;

    @Bean
    //当配置文件里有nrsc.hello.match时，下面的bean会注入到IOC容器，如果没有配置的话，启动就会报错
    @ConditionalOnProperty(prefix = "nrsc.hello", name = "match", matchIfMissing = false)
    public HelloService helloService() {
        HelloService service = new HelloService();
        service.setHelloProperties(helloProperties);
        return service;
    }
}
