package com.domotics.controllers;

import com.domotics.Config;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Herve on 01/02/2017.
 */

@RestController
public class EventController {
    final static Logger logger = Logger.getLogger(EventController.class);
    private Config config;

    @Autowired
    public void setConfig(Config config) {
        this.config = config;
    }

    @RequestMapping("/event")
    public String Controller() {
        return "event";
    }
}