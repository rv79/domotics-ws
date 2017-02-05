package com.domotics.controllers;

import com.domotics.Config;
import com.domotics.objects.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;


/**
 * Created by Home on 30/01/2017.
 */

@RestController
public class InitController {
    final static Logger logger = Logger.getLogger(InitController.class);

    private Config config;

    @Autowired
    public void setConfig(Config config) {
        this.config = config;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/init")
    public Item[] Controller() {
        logger.info("get /init request");
        logger.info(config.getWsInit());

        try {
            RestTemplate restTemplate = new RestTemplate();
            Item[] items = restTemplate.getForObject(config.getWsInit(), Item[].class);
            return items;
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return null;
    }
}
