package com.domotics;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class Config {
    private String wsInit;

    public void setWsInit(String wsInit) {
        this.wsInit = wsInit;
    }

    public String getWsInit() {
        return this.wsInit;
    }
}