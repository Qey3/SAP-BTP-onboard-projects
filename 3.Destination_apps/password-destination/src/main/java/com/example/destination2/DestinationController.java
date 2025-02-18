package com.example.destination2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class DestinationController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("hello from password destination app, current time: " + LocalDateTime.now(), HttpStatus.OK);
    }

    @GetMapping("/")
    public String redirectToNewPage() {
        return "redirect:/hello";
    }

}
