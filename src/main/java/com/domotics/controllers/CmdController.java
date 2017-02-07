package com.domotics.controllers;

import com.domotics.Config;
import com.domotics.objects.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by herve on 07-Feb-17.
 */

@Controller
public class CmdController {
    private static final Logger logger = LoggerFactory
            .getLogger(EventController.class);

    private Config config;

    @Autowired
    public void setConfig(Config config) {
        this.config = config;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/cmd", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> Controller(@RequestBody Item item) {
        logger.info("CmdController /cmd: "+item.getUid()+":"+item.getValue());

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("uid", item.getUid());
        params.add("value", String.valueOf(item.getValue()));

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(config.getWsCmd()).queryParams(params).build();

        logger.info("CmdController /cmd: "+uriComponents);

        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put(String.valueOf(uriComponents), null, "");
        } catch (Exception e) {
            throw e;
            //logger.error(e.toString());
            //new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Return an http 200 status code
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
