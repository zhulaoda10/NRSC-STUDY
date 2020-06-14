package com.nrsc.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/***
 * 将配置文件中配置的nrsc.hello.prefix 和 nrsc.hello.suffix传入到该bean
 */
@ConfigurationProperties(prefix = "nrsc.hello")
public class HelloProperties {

    private String prefix;

    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
