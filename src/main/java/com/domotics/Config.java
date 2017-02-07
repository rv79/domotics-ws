package com.domotics;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class Config {
    private String wsInit;
    private String wsCmd;

    public String getWsCmd() {
        return wsCmd;
    }

    public void setWsCmd(String wsCmd) {
        this.wsCmd = wsCmd;
    }

    public void setWsInit(String wsInit) {
        this.wsInit = wsInit;
    }

    public String getWsInit() {
        return this.wsInit;
    }
}