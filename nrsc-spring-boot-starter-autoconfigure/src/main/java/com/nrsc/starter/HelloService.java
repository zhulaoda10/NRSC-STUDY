package com.nrsc.starter;

public class HelloService {
    /***
     * 将HelloProperties作为本类的一个属性
     * 主要用来测试@ConfigurationProperties 和 @EnableConfigurationProperties搭配通过配置文件往bean中传入属性
     */
    private HelloProperties helloProperties;

    /***get、set方法*/
    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    /***真正要提供的方法*/
    public String sayHello(String name) {
        return helloProperties.getPrefix() + "-" + name + "-" + helloProperties.getSuffix();
    }
}
