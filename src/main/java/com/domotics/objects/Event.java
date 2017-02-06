package com.domotics.objects;

//import ch.qos.logback.core.net.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
//import jdk.nashorn.internal.objects.NativeJSON;
//import org.json.JSONObject;

/**
 * Created by Herve on 05/02/2017.
 */
public class Event {
    private Item item;
    private ObjectMapper objectMapper = new ObjectMapper();

    public Event () {
    }

    public Event (Item itemParam) {
        this.item = itemParam;
    }

    //method called by websocket method ConvertAndSend
    public String getContent() throws IOException {
        return objectMapper.writeValueAsString(item);
    }

}
