package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
@Slf4j
public class PingController {

    @RequestMapping(path = "/ping")
    public @ResponseBody String ping() {
        log.info("GET called on /ping resource");
        return "pong";
    }
}
