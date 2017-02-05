package com.domotics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Home on 30/01/2017.
 */

@Controller
public class MockController {
    @RequestMapping("/mock")
    public String Controller() {
        return "niko.json";
    }
}