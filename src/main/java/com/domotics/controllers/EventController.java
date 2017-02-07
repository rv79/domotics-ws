package com.domotics.controllers;

import com.domotics.Config;
//import org.apache.log4j.Logger;
import com.domotics.objects.Event;
import com.domotics.objects.Item;
import com.domotics.services.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Herve on 01/02/2017.
 */

@Controller
public class EventController {
    private static final Logger logger = LoggerFactory
            .getLogger(EventController.class);

    private Config config;

    @Autowired
    public void setConfig(Config config) {
        this.config = config;
    }

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> Controller(@RequestBody Item item) {
        logger.info("EventController /event:"+item.getUid()+":"+item.getValue());
        // Call event service notification
        // <add>Pass service parameters to the notification service</add>
        eventService.notify(new Event(item));

        // Return an http 200 status code
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /*
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @SendTo("/queue/event")
    public Event Controller () {
        logger.info("EventController /event");

        return new Event();
    }
    */

}