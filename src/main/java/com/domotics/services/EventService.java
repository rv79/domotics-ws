package com.domotics.services;

import com.domotics.objects.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Service class for sending notification messages.
 */
@Service
public class EventService {
    private static final Logger logger = LoggerFactory
            .getLogger(EventService.class);

    // The SimpMessagingTemplate is used to send Stomp over WebSocket messages.
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    //@SendTo("/queue/event")
    public void notify(Event event) {
        logger.info("EventService.notify");
        //return event;

        this.messagingTemplate.convertAndSend("/queue/event",event);

    }

}
