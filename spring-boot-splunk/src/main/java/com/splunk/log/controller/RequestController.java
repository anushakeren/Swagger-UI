package com.splunk.log.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RequestController {

    private static final Log LOGGER = LogFactory.getLog(RequestController.class);

    @GetMapping
    public String hello(@RequestParam(name = "name", defaultValue = "World") String name) {
        LOGGER.info("name="+name);
        return "Hello, " + name;
    }
}
