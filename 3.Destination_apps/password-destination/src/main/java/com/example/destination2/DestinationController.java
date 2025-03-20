package com.example.destination2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class DestinationController {

    private static final Logger log = LoggerFactory.getLogger(DestinationController.class);

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        log.info("password destination controller was called");
        return new ResponseEntity<>("hello from password destination app, current time: " + LocalDateTime.now(), HttpStatus.OK);
    }

    @GetMapping("/")
    public String redirectToNewPage() {
        return "redirect:/hello";
    }

}
